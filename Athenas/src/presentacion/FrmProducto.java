package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.Comunes;
import util.ProductoTableModel;
import util.Reporte;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import conexion.Conexion;
import entidades.CategoriaProducto;
import entidades.Producto;
import entidades.Trabajador;
import negocio.NegocioCategoria;
import negocio.NegocioProducto;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class FrmProducto extends JInternalFrame implements KeyListener, ActionListener {
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblCdigo;
	private JLabel lblRaznSocial;
	private JLabel lblRepresentante;
	private JLabel lblEmail;
	private JLabel lblTelfono;
	private JTextField txtStockActual;
	private JTextField txtPreVenta;
	private JTextField txtPreCompra;
	private JTextField txtDescripcion;
	private JTextField txtCodigo;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JPanel panel_3;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JPanel panel_4;
	private JPanel panel_5;
	private JScrollPane scrollPane;
	private JTable tblProducto;
	private JTextField txtBuscar;
	private JButton btnResetear;
	private JButton btnImprimir;
	private JPanel panel_6;
	private JRadioButton rdbtnPorCodigo;
	private JLabel lblBuscar;

	private ProductoTableModel modelo;
	private ButtonGroup btnG;
	private JRadioButton rdbtnPorDesc;
	private JLabel lblSexo;
	private JTextField txtStockMin;
	private JLabel lblCategora;
	private JLabel lblImagen;
	private JTextField txtImg;
	private JButton btnBuscarImg;
	private JLabel lblImg;
	private JComboBox<CategoriaProducto> cboCategoria;

	private NegocioProducto nProd = new NegocioProducto();
	private NegocioCategoria nCat = new NegocioCategoria();
	private DefaultComboBoxModel<CategoriaProducto> cboModel = new DefaultComboBoxModel<CategoriaProducto>();
	private File archivoImg = null;
	private String opGuardar = "";
	Comunes comon = new Comunes();
	private JButton btnEliminarImgen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProducto frame = new FrmProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmProducto() {
		setTitle("Mantenimiento | Productos");
		setMinimumSize(new Dimension(1100, 600));
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(new MigLayout("", "[450:n][500px:n,grow]", "[][grow]"));

		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBorder(new TitledBorder(null, "Producto", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		getContentPane().add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[150px:n,grow][grow]",
				"[30px:n][30px:n][30px:n][30px:n][30px:n][30px:n][30px:n][50px:n][][]"));

		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Serif", Font.PLAIN, 14));
		lblCdigo.setPreferredSize(new Dimension(100, 16));
		panel.add(lblCdigo, "cell 0 0,alignx center");

		txtCodigo = new JTextField();
		txtCodigo.setBackground(SystemColor.control);
		txtCodigo.setEditable(false);
		panel.add(txtCodigo, "cell 1 0,alignx leading");
		txtCodigo.setColumns(10);

		lblRaznSocial = new JLabel("Descripci\u00F3n");
		lblRaznSocial.setFont(new Font("Serif", Font.PLAIN, 14));
		lblRaznSocial.setPreferredSize(new Dimension(100, 16));
		panel.add(lblRaznSocial, "cell 0 1,alignx center");

		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setBackground(SystemColor.control);
		panel.add(txtDescripcion, "cell 1 1,alignx leading");
		txtDescripcion.setColumns(20);

		lblRepresentante = new JLabel("Precio de compra");
		lblRepresentante.setFont(new Font("Serif", Font.PLAIN, 14));
		lblRepresentante.setPreferredSize(new Dimension(100, 16));
		panel.add(lblRepresentante, "cell 0 2,alignx center");

		txtPreCompra = new JTextField();
		txtPreCompra.setEditable(false);
		txtPreCompra.setBackground(SystemColor.control);
		panel.add(txtPreCompra, "cell 1 2,alignx leading");
		txtPreCompra.setColumns(20);

		lblEmail = new JLabel("Precio de venta");
		lblEmail.setFont(new Font("Serif", Font.PLAIN, 14));
		lblEmail.setPreferredSize(new Dimension(100, 16));
		panel.add(lblEmail, "cell 0 3,alignx center");

		txtPreVenta = new JTextField();
		txtPreVenta.setEditable(false);
		txtPreVenta.setBackground(SystemColor.control);
		panel.add(txtPreVenta, "cell 1 3,alignx leading");
		txtPreVenta.setColumns(20);

		lblTelfono = new JLabel("Stock actual");
		lblTelfono.setFont(new Font("Serif", Font.PLAIN, 14));
		lblTelfono.setPreferredSize(new Dimension(100, 16));
		panel.add(lblTelfono, "cell 0 4,alignx center");

		txtStockActual = new JTextField();
		txtStockActual.setEditable(false);
		txtStockActual.setBackground(SystemColor.control);
		panel.add(txtStockActual, "cell 1 4,alignx leading");
		txtStockActual.setColumns(10);

		lblSexo = new JLabel("Stock m\u00EDnimo");
		lblSexo.setPreferredSize(new Dimension(100, 16));
		lblSexo.setFont(new Font("Serif", Font.PLAIN, 14));
		panel.add(lblSexo, "cell 0 5,alignx center");

		txtStockMin = new JTextField();
		txtStockMin.setEditable(false);
		txtStockMin.setBackground(SystemColor.control);
		txtStockMin.setColumns(10);
		panel.add(txtStockMin, "cell 1 5,alignx leading");

		lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setPreferredSize(new Dimension(100, 16));
		lblCategora.setFont(new Font("Serif", Font.PLAIN, 14));
		panel.add(lblCategora, "cell 0 6,alignx center");

		cboCategoria = new JComboBox<CategoriaProducto>();
		cboCategoria.setEnabled(false);
		cboCategoria.setBackground(SystemColor.control);
		cboCategoria.setPreferredSize(new Dimension(150, 26));

		panel.add(cboCategoria, "flowx,cell 1 6,alignx leading");

		lblImagen = new JLabel("Imagen");
		lblImagen.setPreferredSize(new Dimension(100, 16));
		lblImagen.setFont(new Font("Serif", Font.PLAIN, 14));
		panel.add(lblImagen, "cell 0 7,alignx center");

		txtImg = new JTextField();
		txtImg.setEditable(false);
		txtImg.setBackground(SystemColor.control);
		panel.add(txtImg, "flowx,cell 1 7,alignx leading");
		txtImg.setColumns(18);

		lblImg = new JLabel("No tiene im\u00E1gen");
		lblImg.setMinimumSize(new Dimension(100, 100));
		lblImg.setMaximumSize(new Dimension(100, 100));
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblImg.setPreferredSize(new Dimension(100, 100));
		panel.add(lblImg, "cell 0 8 2 1,alignx center,aligny center");

		panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.control);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(50);
		flowLayout.setVgap(10);
		panel.add(panel_3, "cell 0 9 2 1,grow");

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setIcon(new ImageIcon(FrmProducto.class.getResource("/img/icon-guardar-white.png")));
		btnGuardar.setEnabled(false);
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBackground(new Color(128, 128, 0));
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnGuardar.setPreferredSize(new Dimension(110, 35));
		panel_3.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setIcon(new ImageIcon(FrmProducto.class.getResource("/img/icon-cancelar-white.png")));
		btnCancelar.setEnabled(false);
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(128, 128, 0));
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCancelar.setPreferredSize(new Dimension(110, 35));
		panel_3.add(btnCancelar);

		btnBuscarImg = new JButton("...");
		btnBuscarImg.addActionListener(this);
		btnBuscarImg.setEnabled(false);
		panel.add(btnBuscarImg, "cell 1 7");

		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBorder(new TitledBorder(null, "Listado de productos", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		getContentPane().add(panel_1, "cell 1 0 1 2,grow");
		panel_1.setLayout(new MigLayout("", "[][grow][grow]", "[][][grow][]"));

		lblBuscar = new JLabel("Buscar ");
		lblBuscar.setFont(new Font("Serif", Font.PLAIN, 16));
		panel_1.add(lblBuscar, "cell 0 0,alignx center");

		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		panel_1.add(txtBuscar, "cell 1 0,growx");
		txtBuscar.setColumns(20);

		btnResetear = new JButton("");
		btnResetear.addActionListener(this);
		btnResetear.setMinimumSize(new Dimension(30, 25));
		btnResetear.setIcon(new ImageIcon(FrmProducto.class.getResource("/img/icon-resetear-white.png")));
		btnResetear.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnResetear.setForeground(new Color(255, 255, 255));
		btnResetear.setBackground(new Color(128, 128, 0));
		btnResetear.setPreferredSize(new Dimension(60, 30));
		panel_1.add(btnResetear, "cell 2 0,alignx leading");

		panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.control);
		panel_1.add(panel_6, "cell 1 1,grow");
		panel_6.setLayout(new MigLayout("", "[100px:n][117px,grow]", "[19px]"));

		rdbtnPorCodigo = new JRadioButton("Por c\u00F3digo");
		rdbtnPorCodigo.setFont(new Font("Serif", Font.PLAIN, 16));
		panel_6.add(rdbtnPorCodigo, "cell 0 0,alignx left,aligny top");

		rdbtnPorDesc = new JRadioButton("Por Descripci\u00F3n");
		rdbtnPorDesc.setFont(new Font("Serif", Font.PLAIN, 16));
		panel_6.add(rdbtnPorDesc, "cell 1 0,alignx left");

		panel_5 = new JPanel();
		panel_1.add(panel_5, "cell 0 2 3 1,grow");
		panel_5.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.control);
		panel_5.add(scrollPane, BorderLayout.CENTER);

		tblProducto = new JTable();
		tblProducto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tblProducto.setRowHeight(20);
		tblProducto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblProducto);

		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.control);
		panel_2.setBorder(null);
		getContentPane().add(panel_2, "cell 0 1,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[50px:n]"));

		panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.control);
		panel_4.setBorder(new LineBorder(SystemColor.controlShadow, 2));
		panel_2.add(panel_4, "cell 0 0,grow");
		panel_4.setLayout(new MigLayout("", "[grow][grow][grow]", "[]"));

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(FrmProducto.class.getResource("/img/icon-nuevo-white.png")));
		panel_4.add(btnNuevo, "cell 0 0,alignx center");
		btnNuevo.setForeground(new Color(255, 255, 255));
		btnNuevo.setBackground(new Color(138, 43, 226));
		btnNuevo.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNuevo.setPreferredSize(new Dimension(100, 35));

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(FrmProducto.class.getResource("/img/icon-modificar-white.png")));
		panel_4.add(btnModificar, "cell 1 0,alignx center");
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setBackground(new Color(138, 43, 226));
		btnModificar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnModificar.setPreferredSize(new Dimension(100, 35));

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(FrmProducto.class.getResource("/img/icon-eliminar-white.png")));
		panel_4.add(btnEliminar, "cell 2 0,alignx center");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(138, 43, 226));
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEliminar.setPreferredSize(new Dimension(100, 35));
		setBounds(0, 0, 1100, 600);

		modelo = new ProductoTableModel();
		tblProducto.setModel(modelo);

		btnImprimir = new JButton("");
		btnImprimir.addActionListener(this);
		
		btnEliminarImgen = new JButton("Eliminar im\u00E1gen");
		btnEliminarImgen.addActionListener(this);
		btnEliminarImgen.setPreferredSize(new Dimension(100, 30));
		btnEliminarImgen.setForeground(Color.WHITE);
		btnEliminarImgen.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEliminarImgen.setBackground(new Color(128, 128, 0));
		panel_1.add(btnEliminarImgen, "cell 0 3");
		btnImprimir.setIcon(new ImageIcon(FrmProducto.class.getResource("/img/icon-imprimir-white.png")));
		panel_1.add(btnImprimir, "cell 2 3,alignx trailing");
		btnImprimir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnImprimir.setForeground(new Color(255, 255, 255));
		btnImprimir.setBackground(new Color(128, 128, 0));
		btnImprimir.setPreferredSize(new Dimension(100, 30));

		btnG = new ButtonGroup();
		btnG.add(rdbtnPorCodigo);
		btnG.add(rdbtnPorDesc);

		rdbtnPorCodigo.setSelected(true);

		miInit();
	}

	private void miInit() {
		tblProducto.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!tblProducto.getSelectionModel().isSelectionEmpty()) {
					int fila = tblProducto.getSelectedRow();
					LlenaDatos(modelo.getProducto(fila));
				}
			}
		});

		modelo.setData(nProd.listar());
		LlenaCbo();
		cboCategoria.setModel(cboModel);

		if (FrmPrincipal.currentUser != null && FrmPrincipal.currentUser.getUsuario() != null) {
			if (FrmPrincipal.currentUser.getRol().equalsIgnoreCase("Vendedor")) {
				btnImprimir.setVisible(false);
			}
		}
	}

	private void LlenaDatos(Producto obj) {
		txtCodigo.setText(obj.getID());
		txtDescripcion.setText(obj.getDescripcion());
		txtPreCompra.setText(obj.getPreCompra() + "");
		txtPreVenta.setText(obj.getPreVenta() + "");
		txtStockActual.setText(obj.getStockAcual() + "");
		txtStockMin.setText(obj.getStockMin() + "");
		cboModel.setSelectedItem(obj.getCate());
		if (obj.getImg() == null) {
			lblImg.setIcon(null);
			lblImg.setText("Sin im�gen");
		} else {
			try {
				ByteArrayInputStream imgIS = new ByteArrayInputStream(obj.getImg());
				Image img = ImageIO.read(imgIS);

				if (img != null) {
					img = img.getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_DEFAULT);
					lblImg.setText("");
					lblImg.setIcon(new ImageIcon(img));
				}
				imgIS.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void LlenaCbo() {
		ArrayList<CategoriaProducto> lista = nCat.Listar();
		cboModel.removeAllElements();
		for (CategoriaProducto item : lista) {
			cboModel.addElement(item);
		}
	}

	private void Habilita(boolean estado) {
		comon.habTextField(txtDescripcion, estado);
		comon.habTextField(txtPreCompra, estado);
		comon.habTextField(txtPreVenta, estado);
		comon.habTextField(txtStockActual, estado);
		comon.habTextField(txtStockMin, estado);
		cboCategoria.setEnabled(estado);
		btnBuscarImg.setEnabled(estado);

		btnBuscarImg.setEnabled(estado);
		btnGuardar.setEnabled(estado);
		btnCancelar.setEnabled(estado);
	}

	private void ReseteaCampos() {
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtPreCompra.setText("");
		txtPreVenta.setText("");
		txtStockActual.setText("");
		txtStockMin.setText("");
		lblImg.setText("");
		lblImg.setIcon(null);
		txtImg.setText("");
		cboCategoria.setSelectedIndex(0);
		archivoImg = null;
	}

	private Producto leerProducto() {
		Producto obj = new Producto();
		obj.setID(txtCodigo.getText());
		obj.setDescripcion(txtDescripcion.getText());
		obj.setPreCompra(Double.parseDouble(txtPreCompra.getText().replaceAll(",", ".")));
		obj.setPreVenta(Double.parseDouble(txtPreVenta.getText().replaceAll(",", ".")));
		obj.setStockAcual(Integer.parseInt(txtStockActual.getText()));
		obj.setStockMin(Integer.parseInt(txtStockMin.getText()));
		obj.setCate((CategoriaProducto) cboModel.getSelectedItem());
		if (archivoImg != null) {
			try {
				obj.setOs(new FileInputStream(archivoImg));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return obj;
	}

	private void LeerImg() {
		JFileChooser open = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Im�genes(jpg,gif,png)", "jpg", "gif", "png");
		open.setFileFilter(filter);
		int opcion = open.showOpenDialog(this);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			archivoImg = open.getSelectedFile();
			if (archivoImg.length() < (1024 * 512)) {
				txtImg.setText(archivoImg.getAbsolutePath());
				Image img = new ImageIcon(archivoImg.getAbsolutePath()).getImage();
				img = img.getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_DEFAULT);
				lblImg.setIcon(new ImageIcon(img));
			} else {
				JOptionPane.showMessageDialog(this, "Imagen seleccionada demasiado grande");
				archivoImg = null;
				lblImg.setIcon(null);
				lblImg.setText("Sin im�gen");
				txtImg.setText("");
			}

		}
	}

	private boolean ValidaDAtos() {
		boolean datosOK = false;

		if (txtDescripcion.getText().length() < 1) {
			JOptionPane.showInternalMessageDialog(this, "Descripci�n no puede estar vac�a");
			txtDescripcion.grabFocus();
		} else if (!comon.ValidaDouble(txtPreCompra.getText())) {
			JOptionPane.showInternalMessageDialog(this, "Precio de compra incorrecto");
			txtPreCompra.grabFocus();
		} else if (!comon.ValidaDouble(txtPreVenta.getText())) {
			JOptionPane.showInternalMessageDialog(this, "Precio de venta incorrecto");
			txtPreVenta.grabFocus();
		} else if (!comon.ValidaEntero(txtStockActual.getText())) {
			JOptionPane.showInternalMessageDialog(this, "Stock actual incorrecto");
			txtStockActual.grabFocus();
		} else if (!comon.ValidaEntero(txtStockMin.getText())) {
			JOptionPane.showInternalMessageDialog(this, "Stock m�nimo incorrecto");
			txtStockMin.grabFocus();
		} else if (Double.parseDouble(txtPreCompra.getText().replaceAll(",", ".")) < 0
				|| Double.parseDouble(txtPreVenta.getText().replaceAll(",", ".")) < 0
				|| Integer.parseInt(txtStockActual.getText()) < 0 || Integer.parseInt(txtStockMin.getText()) < 0) {
			JOptionPane.showInternalMessageDialog(this, "No se permite ingresar valores negtivos");
		} else if (Double.parseDouble(txtPreCompra.getText().replaceAll(",", ".")) > Double
				.parseDouble(txtPreVenta.getText().replaceAll(",", "."))) {
			JOptionPane.showInternalMessageDialog(this, "Precio de compra execede el precio de venta");
		} else {
			datosOK = true;
		}

		return datosOK;
	}

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtBuscar) {
			keyReleasedTxtBuscar(arg0);
		}
	}

	public void keyTyped(KeyEvent arg0) {
	}

	protected void keyReleasedTxtBuscar(KeyEvent arg0) {
		ArrayList<Producto> busqueda = new ArrayList<Producto>();
		String patron = txtBuscar.getText();
		if (rdbtnPorCodigo.isSelected()) {
			busqueda = nProd.getProductosByID(patron);
		} else if (rdbtnPorDesc.isSelected()) {
			busqueda = nProd.getProductosByDescripcion(patron);
		}
		modelo.setData(busqueda);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminarImgen) {
			actionPerformedBtnEliminarImgen(arg0);
		}
		if (arg0.getSource() == btnImprimir) {
			actionPerformedBtnImprimir(arg0);
		}
		if (arg0.getSource() == btnBuscarImg) {
			actionPerformedBtnBuscarImg(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(arg0);
		}
		if (arg0.getSource() == btnResetear) {
			actionPerformedBtnResetear(arg0);
		}
	}

	protected void actionPerformedBtnResetear(ActionEvent arg0) {
		txtBuscar.setText("");
		modelo.setData(nProd.listar());
	}

	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnEliminarImgen.setEnabled(false);

		Habilita(true);
		ReseteaCampos();
		txtCodigo.setText(nProd.nextCod());
		opGuardar = "Nuevo";
		tblProducto.setEnabled(false);
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		if (!txtCodigo.getText().equals("")) {
			btnNuevo.setEnabled(false);
			btnEliminar.setEnabled(false);
			btnEliminarImgen.setEnabled(false);
			Habilita(true);
			opGuardar = "Modificar";
		} else {
			JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro para realzar esta acci�n",
					"Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		ReseteaCampos();
		Habilita(false);
		btnNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
		btnEliminarImgen.setEnabled(true);
		tblProducto.setEnabled(true);

		if (!tblProducto.getSelectionModel().isSelectionEmpty()) {
			int fila = tblProducto.getSelectedRow();
			LlenaDatos(modelo.getProducto(fila));
		}
	}

	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		if (ValidaDAtos()) {
			if (opGuardar.equals("Nuevo")) {
				nProd.InsertarProducto(leerProducto());
				ReseteaCampos();
				txtCodigo.setText(nProd.nextCod());
			} else if (opGuardar.equals("Modificar")) {
				nProd.ModificarProducto(leerProducto());
			}
			modelo.setData(nProd.listar());
		}

	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		if (!tblProducto.getSelectionModel().isSelectionEmpty()) {
			int confirmar = JOptionPane.showInternalConfirmDialog(this, "�Desea eliminar este regitro?", "Precauci�n",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (confirmar == JOptionPane.YES_OPTION) {
				String cod = txtCodigo.getText();
				nProd.EliminarProducto(cod);
				modelo.setData(nProd.listar());
				ReseteaCampos();
				JOptionPane.showInternalMessageDialog(this, "Registro eliminado", "Confirmaci�n",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro para realzar esta acci�n",
					"Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}

	protected void actionPerformedBtnBuscarImg(ActionEvent arg0) {
		LeerImg();
	}

	protected void actionPerformedBtnImprimir(ActionEvent arg0) {
		Reporte.CreaReporte("/reportes/ListaProductos.jasper");
	}
	protected void actionPerformedBtnEliminarImgen(ActionEvent arg0) {
		if(!txtCodigo.equals("")){
			nProd.EliminarImg(txtCodigo.getText());
			int fila = tblProducto.getSelectedRow();
			modelo.setData(nProd.listar());
			lblImg.setIcon(null);
			archivoImg = null;
		}
		else {
			JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro para realzar esta acci�n",
					"Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}
}
