package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.Comunes;
import util.Reporte;
import util.TrabajadorTableModel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import conexion.Conexion;
import entidades.Proveedor;
import entidades.Trabajador;
import negocio.NegocioTrabajador;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
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
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class FrmTrabajador extends JInternalFrame implements KeyListener, ActionListener {
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
	private JTable tblTrabajador;
	private JTextField txtBuscar;
	private JButton btnResetear;
	private JButton btnImprimir;
	private JPanel panel_6;
	private JRadioButton rdbtnPorCodigo;
	private JLabel lblBuscar;

	private TrabajadorTableModel modelo;
	private ButtonGroup btnG;
	private ButtonGroup btnGSex;
	private JRadioButton rdbtnPorNombre;
	private JLabel lblSexo;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private JLabel lblCorreo;
	private JLabel lblDireccin;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel lblCargo;
	private JTextField txtCorreo;
	private JTextField txtDireccion;
	private JTextField txtUsuario;
	private JTextField txtContrasenia;
	private JComboBox cboCargo;

	private String opGuardar = "";
	private NegocioTrabajador nTrab = new NegocioTrabajador();
	Comunes comon = new Comunes();

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
					FrmTrabajador frame = new FrmTrabajador();
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
	public FrmTrabajador() {
		setMinimumSize(new Dimension(1100, 600));
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(new MigLayout("", "[450:n][500px:n,grow]", "[][grow]"));

		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBorder(new TitledBorder(null, "Trabajador", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		getContentPane().add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[150px:n,grow][grow]",
				"[30px:n][30px:n][30px:n][30px:n][30px:n][30px:n][30px:n][30px:n][30px:n][30px:n][30px:n][]"));

		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Serif", Font.PLAIN, 14));
		lblCdigo.setPreferredSize(new Dimension(100, 16));
		panel.add(lblCdigo, "cell 0 0,alignx center");

		txtCodigo = new JTextField();
		txtCodigo.setBackground(SystemColor.control);
		txtCodigo.setEditable(false);
		panel.add(txtCodigo, "cell 1 0,alignx leading");
		txtCodigo.setColumns(10);

		lblRaznSocial = new JLabel("Nombre");
		lblRaznSocial.setFont(new Font("Serif", Font.PLAIN, 14));
		lblRaznSocial.setPreferredSize(new Dimension(100, 16));
		panel.add(lblRaznSocial, "cell 0 1,alignx center");

		txtNombre = new JTextField();
		txtNombre.setBackground(SystemColor.control);
		txtNombre.setEditable(false);
		panel.add(txtNombre, "cell 1 1,alignx leading");
		txtNombre.setColumns(20);

		lblRepresentante = new JLabel("Apellido");
		lblRepresentante.setFont(new Font("Serif", Font.PLAIN, 14));
		lblRepresentante.setPreferredSize(new Dimension(100, 16));
		panel.add(lblRepresentante, "cell 0 2,alignx center");

		txtApellido = new JTextField();
		txtApellido.setBackground(SystemColor.control);
		txtApellido.setEditable(false);
		panel.add(txtApellido, "cell 1 2,alignx leading");
		txtApellido.setColumns(20);

		lblEmail = new JLabel("Tel\u00E9fono");
		lblEmail.setBackground(SystemColor.control);
		lblEmail.setFont(new Font("Serif", Font.PLAIN, 14));
		lblEmail.setPreferredSize(new Dimension(100, 16));
		panel.add(lblEmail, "cell 0 3,alignx center");

		txtTelefono = new JTextField();
		txtTelefono.setBackground(SystemColor.control);
		txtTelefono.setEditable(false);
		panel.add(txtTelefono, "cell 1 3,alignx leading");
		txtTelefono.setColumns(20);

		lblTelfono = new JLabel("DNI");
		lblTelfono.setFont(new Font("Serif", Font.PLAIN, 14));
		lblTelfono.setPreferredSize(new Dimension(100, 16));
		panel.add(lblTelfono, "cell 0 4,alignx center");

		txtDni = new JTextField();
		txtDni.setBackground(SystemColor.control);
		txtDni.setEditable(false);
		panel.add(txtDni, "cell 1 4,alignx leading");
		txtDni.setColumns(12);

		lblSexo = new JLabel("Sexo");
		lblSexo.setPreferredSize(new Dimension(100, 16));
		lblSexo.setFont(new Font("Serif", Font.PLAIN, 14));
		panel.add(lblSexo, "cell 0 5,alignx center");

		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setEnabled(false);
		rdbtnMasculino.setPreferredSize(new Dimension(100, 18));
		panel.add(rdbtnMasculino, "flowx,cell 1 5,alignx leading");

		lblCorreo = new JLabel("Correo");
		lblCorreo.setPreferredSize(new Dimension(100, 16));
		lblCorreo.setFont(new Font("Serif", Font.PLAIN, 14));
		panel.add(lblCorreo, "cell 0 6,alignx center");

		txtCorreo = new JTextField();
		txtCorreo.setBackground(SystemColor.control);
		txtCorreo.setEditable(false);
		txtCorreo.setColumns(20);
		panel.add(txtCorreo, "cell 1 6,alignx leading");

		lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setPreferredSize(new Dimension(100, 16));
		lblDireccin.setFont(new Font("Serif", Font.PLAIN, 14));
		panel.add(lblDireccin, "cell 0 7,alignx center");

		txtDireccion = new JTextField();
		txtDireccion.setBackground(SystemColor.control);
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(20);
		panel.add(txtDireccion, "cell 1 7,alignx leading");

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setPreferredSize(new Dimension(100, 16));
		lblUsuario.setFont(new Font("Serif", Font.PLAIN, 14));
		panel.add(lblUsuario, "cell 0 8,alignx center");

		txtUsuario = new JTextField();
		txtUsuario.setBackground(SystemColor.control);
		txtUsuario.setEditable(false);
		txtUsuario.setColumns(15);
		panel.add(txtUsuario, "cell 1 8,alignx leading");

		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setPreferredSize(new Dimension(100, 16));
		lblContrasea.setFont(new Font("Serif", Font.PLAIN, 14));
		panel.add(lblContrasea, "cell 0 9,alignx center");

		txtContrasenia = new JTextField();
		txtContrasenia.setBackground(SystemColor.control);
		txtContrasenia.setEditable(false);
		txtContrasenia.setColumns(15);
		panel.add(txtContrasenia, "cell 1 9,alignx leading");

		lblCargo = new JLabel("Cargo");
		lblCargo.setPreferredSize(new Dimension(100, 16));
		lblCargo.setFont(new Font("Serif", Font.PLAIN, 14));
		panel.add(lblCargo, "cell 0 10,alignx center");

		cboCargo = new JComboBox();
		cboCargo.setEnabled(false);
		cboCargo.setPreferredSize(new Dimension(150, 26));
		panel.add(cboCargo, "cell 1 10,alignx leading");

		panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.control);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(50);
		flowLayout.setVgap(10);
		panel.add(panel_3, "cell 0 11 2 1,grow");

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setIcon(new ImageIcon(FrmTrabajador.class.getResource("/img/icon-guardar-white.png")));
		btnGuardar.setEnabled(false);
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBackground(new Color(128, 128, 0));
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnGuardar.setPreferredSize(new Dimension(110, 35));
		panel_3.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setIcon(new ImageIcon(FrmTrabajador.class.getResource("/img/icon-cancelar-white.png")));
		btnCancelar.setEnabled(false);
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(128, 128, 0));
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCancelar.setPreferredSize(new Dimension(110, 35));
		panel_3.add(btnCancelar);

		rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setEnabled(false);
		panel.add(rdbtnFemenino, "cell 1 5,alignx leading");

		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBorder(new TitledBorder(null, "Listado de trabajadores", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(59, 59, 59)));
		getContentPane().add(panel_1, "cell 1 0 1 2,grow");
		panel_1.setLayout(new MigLayout("", "[100px:n][grow][grow]", "[][][grow][]"));

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
		btnResetear.setIcon(new ImageIcon(FrmTrabajador.class.getResource("/img/icon-resetear-white.png")));
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

		rdbtnPorNombre = new JRadioButton("Por Nombre");
		rdbtnPorNombre.setFont(new Font("Serif", Font.PLAIN, 16));
		panel_6.add(rdbtnPorNombre, "cell 1 0,alignx left,aligny top");

		panel_5 = new JPanel();
		panel_1.add(panel_5, "cell 0 2 3 1,grow");
		panel_5.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.control);
		panel_5.add(scrollPane, BorderLayout.CENTER);

		tblTrabajador = new JTable();
		tblTrabajador.setRowHeight(20);
		tblTrabajador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblTrabajador.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scrollPane.setViewportView(tblTrabajador);

		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.control);
		panel_2.setBorder(null);
		getContentPane().add(panel_2, "cell 0 1,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[]"));

		panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.control);
		panel_4.setBorder(new LineBorder(SystemColor.controlShadow, 2));
		panel_2.add(panel_4, "cell 0 0,grow");
		panel_4.setLayout(new MigLayout("", "[grow][grow][grow]", "[]"));

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(FrmTrabajador.class.getResource("/img/icon-nuevo-white.png")));
		panel_4.add(btnNuevo, "cell 0 0,alignx center");
		btnNuevo.setForeground(new Color(255, 255, 255));
		btnNuevo.setBackground(new Color(138, 43, 226));
		btnNuevo.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNuevo.setPreferredSize(new Dimension(100, 35));

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(FrmTrabajador.class.getResource("/img/icon-modificar-white.png")));
		panel_4.add(btnModificar, "cell 1 0,alignx center");
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setBackground(new Color(138, 43, 226));
		btnModificar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnModificar.setPreferredSize(new Dimension(100, 35));

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(FrmTrabajador.class.getResource("/img/icon-eliminar-white.png")));
		panel_4.add(btnEliminar, "cell 2 0,alignx center");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(138, 43, 226));
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEliminar.setPreferredSize(new Dimension(100, 35));
		setBounds(0, 0, 1100, 600);

		modelo = new TrabajadorTableModel();
		tblTrabajador.setModel(modelo);

		btnImprimir = new JButton("");
		btnImprimir.addActionListener(this);
		btnImprimir.setIcon(new ImageIcon(FrmTrabajador.class.getResource("/img/icon-imprimir-white.png")));
		panel_1.add(btnImprimir, "cell 2 3,alignx trailing");
		btnImprimir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnImprimir.setForeground(new Color(255, 255, 255));
		btnImprimir.setBackground(new Color(128, 128, 0));
		btnImprimir.setPreferredSize(new Dimension(100, 30));

		btnG = new ButtonGroup();
		btnG.add(rdbtnPorCodigo);
		btnG.add(rdbtnPorNombre);

		btnGSex = new ButtonGroup();
		btnGSex.add(rdbtnFemenino);
		btnGSex.add(rdbtnMasculino);

		rdbtnMasculino.setSelected(true);
		rdbtnPorCodigo.setSelected(true);

		cboCargo.addItem("Administrador");
		cboCargo.addItem("Vendedor");

		miInit();
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
		ArrayList<Trabajador> busqueda = new ArrayList<Trabajador>();
		String patron = txtBuscar.getText();
		if (rdbtnPorCodigo.isSelected()) {
			busqueda = nTrab.getTrabajadoresBYID(patron);
		} else if (rdbtnPorNombre.isSelected()) {
			busqueda = nTrab.getTrabajadoresBYNombre(patron);
		}
		modelo.setData(busqueda);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnImprimir) {
			actionPerformedBtnImprimir(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
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
		modelo.setData(nTrab.Listar());
	}

	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);

		Habilita(true);
		ReseteaCampos();
		txtCodigo.setText(nTrab.nextCod());
		opGuardar = "Nuevo";
		tblTrabajador.setEnabled(false);
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		if (!txtCodigo.getText().equals("")) {
			btnNuevo.setEnabled(false);
			btnEliminar.setEnabled(false);

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
		tblTrabajador.setEnabled(true);

		if (!tblTrabajador.getSelectionModel().isSelectionEmpty()) {
			int fila = tblTrabajador.getSelectedRow();
			LlenaDatos(modelo.getTrabajador(fila));
		}
	}

	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		if (ValidaDatos()) {
			if (opGuardar.equals("Nuevo")) {
				nTrab.InsertarTrabajador(leerTrabajador());
				ReseteaCampos();
				txtCodigo.setText(nTrab.nextCod());
			} else if (opGuardar.equals("Modificar")) {
				nTrab.ModificarTrabajador(leerTrabajador());
			}
			modelo.setData(nTrab.Listar());
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		if (!tblTrabajador.getSelectionModel().isSelectionEmpty()) {
			int confirmar = JOptionPane.showInternalConfirmDialog(this, "�Desea eliminar este regitro?", "Precauci�n",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (confirmar == JOptionPane.YES_OPTION) {
				String cod = txtCodigo.getText();
				nTrab.EliminarTrabajador(cod);
				modelo.setData(nTrab.Listar());
				ReseteaCampos();
				JOptionPane.showInternalMessageDialog(this, "Registro eliminado", "Confirmaci�n",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro para realzar esta acci�n",
					"Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}

	protected void actionPerformedBtnImprimir(ActionEvent arg0) {
		Reporte.CreaReporte("/reportes/ListaTrabajadores.jasper");
	}

	private void miInit() {

		modelo.setData(nTrab.Listar());

		tblTrabajador.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!tblTrabajador.getSelectionModel().isSelectionEmpty()) {
					int fila = tblTrabajador.getSelectedRow();
					LlenaDatos(modelo.getTrabajador(fila));
				}
			}
		});
	}

	private void LlenaDatos(Trabajador t) {
		txtCodigo.setText(t.getID());
		txtNombre.setText(t.getNombre());
		txtApellido.setText(t.getApellido());
		txtTelefono.setText(t.getTelf());
		txtDni.setText(t.getDNI());
		txtCorreo.setText(t.getEmail());
		txtDireccion.setText(t.getDireccion());
		txtUsuario.setText(t.getUsuario());
		txtContrasenia.setText(t.getPassword());
		cboCargo.setSelectedItem(t.getRol());

		if (t.getSexo().equalsIgnoreCase("M")) {
			rdbtnMasculino.setSelected(true);
		} else {
			rdbtnFemenino.setSelected(true);
		}
	}

	private void Habilita(boolean estado) {
		comon.habTextField(txtNombre, estado);
		comon.habTextField(txtApellido, estado);
		comon.habTextField(txtTelefono, estado);
		comon.habTextField(txtDni, estado);
		comon.habTextField(txtCorreo, estado);
		comon.habTextField(txtDireccion, estado);
		comon.habTextField(txtUsuario, estado);
		comon.habTextField(txtContrasenia, estado);

		rdbtnFemenino.setEnabled(estado);
		rdbtnMasculino.setEnabled(estado);
		cboCargo.setEnabled(estado);
		btnGuardar.setEnabled(estado);
		btnCancelar.setEnabled(estado);
	}

	private void ReseteaCampos() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtDni.setText("");
		txtCorreo.setText("");
		txtDireccion.setText("");
		txtUsuario.setText("");
		txtContrasenia.setText("");

		rdbtnMasculino.setSelected(true);
		cboCargo.setSelectedIndex(0);
	}

	private Trabajador leerTrabajador() {
		Trabajador t = new Trabajador();
		t.setID(txtCodigo.getText());
		t.setNombre(txtNombre.getText());
		t.setApellido(txtApellido.getText());
		t.setTelf(txtTelefono.getText());
		t.setDNI(txtDni.getText());
		t.setEmail(txtCorreo.getText());
		t.setDireccion(txtDireccion.getText());
		t.setUsuario(txtUsuario.getText());
		t.setPassword(txtContrasenia.getText());
		t.setRol(cboCargo.getSelectedItem().toString());

		if (rdbtnFemenino.isSelected()) {
			t.setSexo("F");
		} else if (rdbtnMasculino.isSelected()) {
			t.setSexo("M");
		}

		return t;
	}

	private boolean ValidaDatos() {
		boolean datosOk = false;

		if (!comon.ValidaTexto(txtNombre.getText())) {
			JOptionPane.showInternalMessageDialog(this, "Error en ingreso de Nombre");
			txtNombre.grabFocus();
		} else if (!comon.ValidaTexto(txtApellido.getText())) {
			JOptionPane.showInternalMessageDialog(this, "Error en ingreso de Apellido");
			txtApellido.grabFocus();
		} else if (!comon.ValidaEntero(txtTelefono.getText()) || txtTelefono.getText().length() < 7) {
			JOptionPane.showInternalMessageDialog(this, "Error en ingreso de Tel�fono");
			txtTelefono.grabFocus();
		} else if (!comon.ValidaEntero(txtDni.getText()) || txtDni.getText().length() < 8) {
			JOptionPane.showInternalMessageDialog(this, "Error en ingreso de DNI");
			txtDni.grabFocus();
		} else if (!comon.ValidaEmail(txtCorreo.getText())) {
			JOptionPane.showInternalMessageDialog(this, "Formato de email err�neo");
			txtCorreo.grabFocus();
		} else if (txtDireccion.getText().length() < 1) {
			JOptionPane.showInternalMessageDialog(this, "La direcci�n no puede estar vac�a");
			txtDireccion.grabFocus();
		} else if (txtUsuario.getText().length() < 1) {
			JOptionPane.showInternalMessageDialog(this, "El usuario no puede estar vac�o");
			txtUsuario.grabFocus();
		} else if (txtContrasenia.getText().length() < 1) {
			JOptionPane.showInternalMessageDialog(this, "La contrase�a no puede estar vac�a");
			txtContrasenia.grabFocus();
		} else {
			datosOk = true;
		}

		return datosOk;
	}
}
