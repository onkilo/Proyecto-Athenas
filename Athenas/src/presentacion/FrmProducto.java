package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class FrmProducto extends JInternalFrame {
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblCdigo;
	private JLabel lblRaznSocial;
	private JLabel lblRepresentante;
	private JLabel lblEmail;
	private JLabel lblTelfono;
	private JTextField txtDni;
	private JTextField txtTelefono;
	private JTextField txtApellido;
	private JTextField txtNombre;
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
	private JTable tblProveedor;
	private JTextField txtBuscar;
	private JButton btnResetear;
	private JButton btnImprimir;
	private JPanel panel_6;
	private JRadioButton rdbtnPorCodigo;
	private JLabel lblBuscar;
	
	private DefaultTableModel modelo;
	private ButtonGroup btnG;
	private JRadioButton rdbtnPorDesc;
	private JLabel lblSexo;
	private JTextField textField;
	private JLabel lblCategora;
	private JLabel lblImagen;
	private JTextField txtImg;
	private JButton btnBuscarImg;
	private JLabel lblImg;
	private JComboBox cboCategoria;
	private JButton btnNuevaCat;

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
		setMinimumSize(new Dimension(1100, 600));
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(new MigLayout("", "[450:n][500px:n,grow]", "[][grow]"));
		
		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBorder(new TitledBorder(null, "Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		getContentPane().add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[150px:n,grow][grow]", "[30px:n][30px:n][30px:n][30px:n][30px:n][30px:n][30px:n][50px:n][][]"));
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Serif", Font.PLAIN, 14));
		lblCdigo.setPreferredSize(new Dimension(100, 16));
		panel.add(lblCdigo, "cell 0 0,alignx center");
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		panel.add(txtCodigo, "cell 1 0,alignx leading");
		txtCodigo.setColumns(10);
		
		lblRaznSocial = new JLabel("Descripci\u00F3n");
		lblRaznSocial.setFont(new Font("Serif", Font.PLAIN, 14));
		lblRaznSocial.setPreferredSize(new Dimension(100, 16));
		panel.add(lblRaznSocial, "cell 0 1,alignx center");
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		panel.add(txtNombre, "cell 1 1,alignx leading");
		txtNombre.setColumns(20);
		
		lblRepresentante = new JLabel("Precio de compra");
		lblRepresentante.setFont(new Font("Serif", Font.PLAIN, 14));
		lblRepresentante.setPreferredSize(new Dimension(100, 16));
		panel.add(lblRepresentante, "cell 0 2,alignx center");
		
		txtApellido = new JTextField();
		txtApellido.setEnabled(false);
		panel.add(txtApellido, "cell 1 2,alignx leading");
		txtApellido.setColumns(20);
		
		lblEmail = new JLabel("Precio de venta");
		lblEmail.setFont(new Font("Serif", Font.PLAIN, 14));
		lblEmail.setPreferredSize(new Dimension(100, 16));
		panel.add(lblEmail, "cell 0 3,alignx center");
		
		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		panel.add(txtTelefono, "cell 1 3,alignx leading");
		txtTelefono.setColumns(20);
		
		lblTelfono = new JLabel("Stock actual");
		lblTelfono.setFont(new Font("Serif", Font.PLAIN, 14));
		lblTelfono.setPreferredSize(new Dimension(100, 16));
		panel.add(lblTelfono, "cell 0 4,alignx center");
		
		txtDni = new JTextField();
		txtDni.setEnabled(false);
		panel.add(txtDni, "cell 1 4,alignx leading");
		txtDni.setColumns(10);
		
		lblSexo = new JLabel("Stock m\u00EDnimo");
		lblSexo.setPreferredSize(new Dimension(100, 16));
		lblSexo.setFont(new Font("Serif", Font.PLAIN, 14));
		panel.add(lblSexo, "cell 0 5,alignx center");
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		panel.add(textField, "cell 1 5,alignx leading");
		
		lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setPreferredSize(new Dimension(100, 16));
		lblCategora.setFont(new Font("Serif", Font.PLAIN, 14));
		panel.add(lblCategora, "cell 0 6,alignx center");
		
		cboCategoria = new JComboBox();
		cboCategoria.setEnabled(false);
		cboCategoria.setBackground(SystemColor.control);
		cboCategoria.setPreferredSize(new Dimension(150, 26));

		panel.add(cboCategoria, "flowx,cell 1 6,alignx leading");
		
		lblImagen = new JLabel("Imagen");
		lblImagen.setPreferredSize(new Dimension(100, 16));
		lblImagen.setFont(new Font("Serif", Font.PLAIN, 14));
		panel.add(lblImagen, "cell 0 7,alignx center");
		
		txtImg = new JTextField();
		txtImg.setEnabled(false);
		panel.add(txtImg, "flowx,cell 1 7,alignx leading");
		txtImg.setColumns(18);
		
		lblImg = new JLabel("No tiene im\u00E1gen");
		lblImg.setMinimumSize(new Dimension(100, 100));
		lblImg.setMaximumSize(new Dimension(100, 100));
		lblImg.setEnabled(false);
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
		btnGuardar.setIcon(new ImageIcon(FrmProducto.class.getResource("/img/icon-guardar-white.png")));
		btnGuardar.setEnabled(false);
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBackground(new Color(128, 128, 0));
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnGuardar.setPreferredSize(new Dimension(110, 35));
		panel_3.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(FrmProducto.class.getResource("/img/icon-cancelar-white.png")));
		btnCancelar.setEnabled(false);
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(128, 128, 0));
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCancelar.setPreferredSize(new Dimension(110, 35));
		panel_3.add(btnCancelar);
		
		btnBuscarImg = new JButton("...");
		btnBuscarImg.setEnabled(false);
		panel.add(btnBuscarImg, "cell 1 7");
		
		btnNuevaCat = new JButton("+");
		btnNuevaCat.setEnabled(false);
		panel.add(btnNuevaCat, "cell 1 6");
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBorder(new TitledBorder(null, "Listado de productos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		getContentPane().add(panel_1, "cell 1 0 1 2,grow");
		panel_1.setLayout(new MigLayout("", "[100px:n][grow][grow]", "[][][grow][]"));
		
		lblBuscar = new JLabel("Buscar ");
		lblBuscar.setFont(new Font("Serif", Font.PLAIN, 16));
		panel_1.add(lblBuscar, "cell 0 0,alignx center");
		
		txtBuscar = new JTextField();
		panel_1.add(txtBuscar, "cell 1 0,growx");
		txtBuscar.setColumns(20);
		
		btnResetear = new JButton("");
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
		
		tblProveedor = new JTable();
		scrollPane.setViewportView(tblProveedor);
		
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
		btnNuevo.setIcon(new ImageIcon(FrmProducto.class.getResource("/img/icon-nuevo-white.png")));
		panel_4.add(btnNuevo, "cell 0 0,alignx center");
		btnNuevo.setForeground(new Color(255, 255, 255));
		btnNuevo.setBackground(new Color(138, 43, 226));
		btnNuevo.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNuevo.setPreferredSize(new Dimension(100, 35));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(FrmProducto.class.getResource("/img/icon-modificar-white.png")));
		panel_4.add(btnModificar, "cell 1 0,alignx center");
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setBackground(new Color(138, 43, 226));
		btnModificar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnModificar.setPreferredSize(new Dimension(100, 35));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmProducto.class.getResource("/img/icon-eliminar-white.png")));
		panel_4.add(btnEliminar, "cell 2 0,alignx center");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(138, 43, 226));
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEliminar.setPreferredSize(new Dimension(100, 35));
		setBounds(0, 0, 1100, 600);
		
		modelo = new DefaultTableModel();
		tblProveedor.setModel(modelo);
		
		btnImprimir = new JButton("");
		btnImprimir.setIcon(new ImageIcon(FrmProducto.class.getResource("/img/icon-imprimir-white.png")));
		panel_1.add(btnImprimir, "cell 2 3,alignx trailing");
		btnImprimir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnImprimir.setForeground(new Color(255, 255, 255));
		btnImprimir.setBackground(new Color(128, 128, 0));
		btnImprimir.setPreferredSize(new Dimension(100, 30));
		modelo.addColumn("C�digo");
		modelo.addColumn("Descipci�n");
		modelo.addColumn("Precio compra");
		modelo.addColumn("Precio venta");
		modelo.addColumn("Stock actual");
		modelo.addColumn("Stock m�nimo");
		modelo.addColumn("Categor�a");
		
		
		btnG = new ButtonGroup();
		btnG.add(rdbtnPorCodigo);
		btnG.add(rdbtnPorDesc);

	}

}
