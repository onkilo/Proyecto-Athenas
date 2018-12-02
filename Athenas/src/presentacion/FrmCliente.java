package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JRSaveContributor;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.view.save.JRPdfSaveContributor;
import util.ClienteTableModel;
import util.Comunes;
import util.Reporte;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import conexion.Conexion;
import entidades.Cliente;
import negocio.NegocioCliente;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.InputMethodListener;
import java.util.ArrayList;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrmCliente extends JInternalFrame implements KeyListener, ActionListener {
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
	private JTable tblCliente;
	private JTextField txtBuscar;
	private JButton btnResetear;
	private JButton btnImprimir;
	private JPanel panel_6;
	private JRadioButton rdbtnPorCodigo;
	private JLabel lblBuscar;

	private ClienteTableModel modelo;
	private ButtonGroup btnGBuscar;
	private ButtonGroup btnGSexo;
	private JRadioButton rdbtnPorNombre;
	private JLabel lblSexo;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;

	private String opGuardar = null;
	private NegocioCliente nCliente = new NegocioCliente();
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
					FrmCliente frame = new FrmCliente();
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
	public FrmCliente() {
		setTitle("Mantenimiento | Clientes");
		setMinimumSize(new Dimension(1100, 600));
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(new MigLayout("", "[450:n][500px:n,grow]", "[][grow]"));

		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBorder(
				new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		getContentPane().add(panel, "cell 0 0,grow");
		panel.setLayout(
				new MigLayout("", "[150px:n,grow][grow]", "[50px:n][50px:n][50px:n][50px:n][50px:n][50px:n][]"));

		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Serif", Font.PLAIN, 14));
		lblCdigo.setPreferredSize(new Dimension(100, 16));
		panel.add(lblCdigo, "cell 0 0,alignx center");

		txtCodigo = new JTextField();
		txtCodigo.setBackground(SystemColor.control);
		panel.add(txtCodigo, "cell 1 0,alignx leading");
		txtCodigo.setColumns(10);

		lblRaznSocial = new JLabel("Nombre");
		lblRaznSocial.setFont(new Font("Serif", Font.PLAIN, 14));
		lblRaznSocial.setPreferredSize(new Dimension(100, 16));
		panel.add(lblRaznSocial, "cell 0 1,alignx center");

		txtNombre = new JTextField();
		txtNombre.setBackground(SystemColor.control);
		panel.add(txtNombre, "cell 1 1,alignx leading");
		txtNombre.setColumns(20);

		lblRepresentante = new JLabel("Apellido");
		lblRepresentante.setFont(new Font("Serif", Font.PLAIN, 14));
		lblRepresentante.setPreferredSize(new Dimension(100, 16));
		panel.add(lblRepresentante, "cell 0 2,alignx center");

		txtApellido = new JTextField();
		txtApellido.setBackground(SystemColor.control);
		panel.add(txtApellido, "cell 1 2,alignx leading");
		txtApellido.setColumns(20);

		lblEmail = new JLabel("Tel\u00E9fono");
		lblEmail.setFont(new Font("Serif", Font.PLAIN, 14));
		lblEmail.setPreferredSize(new Dimension(100, 16));
		panel.add(lblEmail, "cell 0 3,alignx center");

		txtTelefono = new JTextField();
		txtTelefono.setBackground(SystemColor.control);
		panel.add(txtTelefono, "cell 1 3,alignx leading");
		txtTelefono.setColumns(20);

		lblTelfono = new JLabel("DNI");
		lblTelfono.setFont(new Font("Serif", Font.PLAIN, 14));
		lblTelfono.setPreferredSize(new Dimension(100, 16));
		panel.add(lblTelfono, "cell 0 4,alignx center");

		txtDni = new JTextField();
		txtDni.setBackground(SystemColor.control);
		panel.add(txtDni, "cell 1 4,alignx leading");
		txtDni.setColumns(10);

		lblSexo = new JLabel("Sexo");
		lblSexo.setPreferredSize(new Dimension(100, 16));
		lblSexo.setFont(new Font("Serif", Font.PLAIN, 14));
		panel.add(lblSexo, "cell 0 5,alignx center");

		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setEnabled(false);
		rdbtnMasculino.setPreferredSize(new Dimension(100, 18));
		panel.add(rdbtnMasculino, "flowx,cell 1 5,alignx leading");

		panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.control);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(50);
		flowLayout.setVgap(10);
		panel.add(panel_3, "cell 0 6 2 1,grow");

		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon-guardar-white.png")));
		btnGuardar.addActionListener(this);
		btnGuardar.setEnabled(false);
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBackground(new Color(128, 128, 0));
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnGuardar.setPreferredSize(new Dimension(110, 35));
		panel_3.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon-cancelar-white.png")));
		btnCancelar.addActionListener(this);
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
		panel_1.setBorder(new TitledBorder(null, "Listado de clientes", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
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
		btnResetear.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon-resetear-white.png")));
		btnResetear.setMinimumSize(new Dimension(30, 25));
		btnResetear.addActionListener(this);
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

		tblCliente = new JTable();
		tblCliente.setRowHeight(20);
		tblCliente.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tblCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblCliente);

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
		btnNuevo.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon-nuevo-white.png")));
		btnNuevo.addActionListener(this);
		panel_4.add(btnNuevo, "cell 0 0,alignx center");
		btnNuevo.setForeground(new Color(255, 255, 255));
		btnNuevo.setBackground(new Color(138, 43, 226));
		btnNuevo.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNuevo.setPreferredSize(new Dimension(100, 35));

		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon-modificar-white.png")));
		btnModificar.addActionListener(this);
		panel_4.add(btnModificar, "cell 1 0,alignx center");
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setBackground(new Color(138, 43, 226));
		btnModificar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnModificar.setPreferredSize(new Dimension(100, 35));

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon-eliminar-white.png")));
		btnEliminar.addActionListener(this);
		panel_4.add(btnEliminar, "cell 2 0,alignx center");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(138, 43, 226));
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEliminar.setPreferredSize(new Dimension(100, 35));
		setBounds(0, 0, 1100, 600);

		btnImprimir = new JButton("");
		btnImprimir.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon-imprimir-white.png")));
		btnImprimir.addActionListener(this);
		panel_1.add(btnImprimir, "cell 2 3,alignx trailing");
		btnImprimir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnImprimir.setForeground(new Color(255, 255, 255));
		btnImprimir.setBackground(new Color(128, 128, 0));
		btnImprimir.setPreferredSize(new Dimension(100, 30));

		btnGBuscar = new ButtonGroup();
		btnGBuscar.add(rdbtnPorCodigo);
		btnGBuscar.add(rdbtnPorNombre);

		btnGSexo = new ButtonGroup();
		btnGSexo.add(rdbtnMasculino);
		btnGSexo.add(rdbtnFemenino);

		modelo = new ClienteTableModel();
		tblCliente.setModel(modelo);
		modelo.setData(nCliente.Listar());

		tblCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblCliente.getColumnModel().getColumn(1).setPreferredWidth(250);
		tblCliente.getColumnModel().getColumn(2).setPreferredWidth(70);
		tblCliente.getColumnModel().getColumn(3).setPreferredWidth(70);
		tblCliente.getColumnModel().getColumn(4).setPreferredWidth(70);

		tblCliente.getTableHeader().setReorderingAllowed(false);

		tblCliente.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!tblCliente.getSelectionModel().isSelectionEmpty()) {
					SeleccionCliente();
				}

			}
		});

		rdbtnPorCodigo.setSelected(true);
		rdbtnMasculino.setSelected(true);
		Habilita(false);
		
		if (FrmPrincipal.currentUser != null && FrmPrincipal.currentUser.getUsuario() != null) {
			if (FrmPrincipal.currentUser.getRol().equalsIgnoreCase("Vendedor")) {
				btnImprimir.setVisible(false);
			}
		}
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
		ArrayList<Cliente> busqueda = new ArrayList<Cliente>();
		String patron = txtBuscar.getText();
		if (rdbtnPorCodigo.isSelected()) {
			busqueda = nCliente.getClientesByID(patron);
		} else if (rdbtnPorNombre.isSelected()) {
			busqueda = nCliente.getClientesByNombre(patron);
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
		modelo.setData(nCliente.Listar());
	}

	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);

		Habilita(true);
		ReseteaCampos();
		txtCodigo.setText(nCliente.nextCod());
		opGuardar = "Nuevo";
		tblCliente.setEnabled(false);
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
		tblCliente.setEnabled(true);

		if (!tblCliente.getSelectionModel().isSelectionEmpty()) {
			int fila = tblCliente.getSelectedRow();
			LlenaDatos(modelo.getCliente(fila));
		}
	}

	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		if(ValidaDatos()){
			if (opGuardar.equals("Nuevo")) {
				nCliente.InsertarCliente(LeerCliente());
				ReseteaCampos();
				txtCodigo.setText(nCliente.nextCod());
			} else if (opGuardar.equals("Modificar")) {
				nCliente.ModificarCliente(LeerCliente());
			}
			modelo.setData(nCliente.Listar());
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		if (!tblCliente.getSelectionModel().isSelectionEmpty()) {
			int confirmar = JOptionPane.showInternalConfirmDialog(this, "�Desea eliminar este regitros?", "Precauci�n",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (confirmar == JOptionPane.YES_OPTION) {
				String cod = txtCodigo.getText();
				nCliente.EliminarCliente(cod);
				modelo.setData(nCliente.Listar());
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
		Reporte.CreaReporte("/reportes/ListaClientes.jasper");
	}
	
	private void LlenaDatos(Cliente c) {
		txtCodigo.setText(c.getID());
		txtNombre.setText(c.getNombre());
		txtApellido.setText(c.getApellido());
		txtTelefono.setText(c.getTelefono());
		txtDni.setText(c.getDni());
		if (c.getSexo().equalsIgnoreCase("M")) {
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
		rdbtnFemenino.setEnabled(estado);
		rdbtnMasculino.setEnabled(estado);

		btnGuardar.setEnabled(estado);
		btnCancelar.setEnabled(estado);
	}

	private void SeleccionCliente() {
		int fila = tblCliente.getSelectedRow();
		LlenaDatos(modelo.getCliente(fila));
	}

	private void ReseteaCampos() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtDni.setText("");
		rdbtnMasculino.setSelected(true);
	}

	private Cliente LeerCliente() {
		Cliente c = new Cliente();
		c.setID(txtCodigo.getText());
		c.setNombre(txtNombre.getText());
		c.setApellido(txtApellido.getText());
		c.setTelefono(txtTelefono.getText());
		c.setDni(txtDni.getText());
		if (rdbtnMasculino.isSelected())
			c.setSexo("M");
		else
			c.setSexo("F");

		return c;
	}
	
	private boolean ValidaDatos(){
		boolean datosOk = false;
		
		if(!comon.ValidaTexto(txtNombre.getText())){
			JOptionPane.showInternalMessageDialog(this, "Error en ingreso de Nombre");
			txtNombre.grabFocus();
		}
		else if (!comon.ValidaTexto(txtApellido.getText())){
			JOptionPane.showInternalMessageDialog(this, "Error en ingreso de Apellido");
			txtApellido.grabFocus();
		}
		else if(!comon.ValidaEntero(txtTelefono.getText()) || txtTelefono.getText().length()<7){
			JOptionPane.showInternalMessageDialog(this, "Error en ingreso de Tel�fono");
			txtTelefono.grabFocus();
		}
		else if(!comon.ValidaEntero(txtDni.getText()) || txtDni.getText().length()<8){
			JOptionPane.showInternalMessageDialog(this, "Error en ingreso de DNI");
			txtDni.grabFocus();
		}
		else{
			datosOk = true;
		}
		return datosOk;
	}
}
