package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Cliente;
import negocio.NegocioCliente;
import util.Comunes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAddCliente extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel label;
	private JTextField txtCodigo;
	private JLabel label_1;
	private JTextField txtNombre;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JRadioButton rdbtMasculino;
	private JRadioButton rdbtFemenino;
	private JButton btnAceptar;
	private JButton btnCancelar;

	
	private NegocioCliente nCli = new NegocioCliente();
	Comunes comon = new Comunes();
	FrmDetVentas vent;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			FrmAddCliente dialog = new FrmAddCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmAddCliente() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 462, 504);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		label = new JLabel("C\u00F3digo");
		label.setPreferredSize(new Dimension(100, 16));
		label.setFont(new Font("Serif", Font.PLAIN, 14));
		label.setBounds(49, 29, 100, 19);
		contentPanel.add(label);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBackground(SystemColor.control);
		txtCodigo.setBounds(172, 26, 122, 28);
		contentPanel.add(txtCodigo);
		
		label_1 = new JLabel("Nombre");
		label_1.setPreferredSize(new Dimension(100, 16));
		label_1.setFont(new Font("Serif", Font.PLAIN, 14));
		label_1.setBounds(49, 86, 100, 19);
		contentPanel.add(label_1);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(20);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(172, 83, 232, 28);
		contentPanel.add(txtNombre);
		
		label_2 = new JLabel("Apellido");
		label_2.setPreferredSize(new Dimension(100, 16));
		label_2.setFont(new Font("Serif", Font.PLAIN, 14));
		label_2.setBounds(49, 151, 100, 19);
		contentPanel.add(label_2);
		
		label_3 = new JLabel("Tel\u00E9fono");
		label_3.setPreferredSize(new Dimension(100, 16));
		label_3.setFont(new Font("Serif", Font.PLAIN, 14));
		label_3.setBounds(49, 215, 100, 19);
		contentPanel.add(label_3);
		
		label_4 = new JLabel("DNI");
		label_4.setPreferredSize(new Dimension(100, 16));
		label_4.setFont(new Font("Serif", Font.PLAIN, 14));
		label_4.setBounds(49, 280, 100, 19);
		contentPanel.add(label_4);
		
		label_5 = new JLabel("Sexo");
		label_5.setPreferredSize(new Dimension(100, 16));
		label_5.setFont(new Font("Serif", Font.PLAIN, 14));
		label_5.setBounds(49, 340, 100, 19);
		contentPanel.add(label_5);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(20);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBounds(172, 148, 232, 28);
		contentPanel.add(txtApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(20);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBounds(172, 212, 232, 28);
		contentPanel.add(txtTelefono);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBackground(Color.WHITE);
		txtDni.setBounds(172, 277, 122, 28);
		contentPanel.add(txtDni);
		
		rdbtMasculino = new JRadioButton("Masculino");
		rdbtMasculino.setSelected(true);
		rdbtMasculino.setPreferredSize(new Dimension(100, 18));
		rdbtMasculino.setBounds(168, 341, 100, 18);
		contentPanel.add(rdbtMasculino);
		
		rdbtFemenino = new JRadioButton("Femenino");
		rdbtFemenino.setBounds(280, 341, 78, 18);
		contentPanel.add(rdbtFemenino);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setPreferredSize(new Dimension(110, 35));
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAceptar.setBackground(new Color(128, 128, 0));
		btnAceptar.setBounds(65, 401, 110, 35);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setPreferredSize(new Dimension(110, 35));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCancelar.setBackground(new Color(128, 128, 0));
		btnCancelar.setBounds(248, 401, 110, 35);
		contentPanel.add(btnCancelar);
		
		txtCodigo.setText(nCli.nextCod());
	}
	
	
	public FrmAddCliente(FrmDetVentas vent){
		this();
		this.vent = vent;
	}
	
	private boolean ValidaDatos(){
		boolean datosOk = false;
		
		if(!comon.ValidaTexto(txtNombre.getText())){
			JOptionPane.showMessageDialog(this, "Error en ingreso de Nombre");
			txtNombre.grabFocus();
		}
		else if (!comon.ValidaTexto(txtApellido.getText())){
			JOptionPane.showMessageDialog(this, "Error en ingreso de Apellido");
			txtApellido.grabFocus();
		}
		else if(!comon.ValidaEntero(txtTelefono.getText()) || txtTelefono.getText().length()<7){
			JOptionPane.showMessageDialog(this, "Error en ingreso de Tel�fono");
			txtTelefono.grabFocus();
		}
		else if(!comon.ValidaEntero(txtDni.getText()) || txtDni.getText().length()<8){
			JOptionPane.showMessageDialog(this, "Error en ingreso de DNI");
			txtDni.grabFocus();
		}
		else{
			datosOk = true;
		}
		return datosOk;
	}
	
	private Cliente LeerCliente() {
		Cliente c = new Cliente();
		c.setID(txtCodigo.getText());
		c.setNombre(txtNombre.getText());
		c.setApellido(txtApellido.getText());
		c.setTelefono(txtTelefono.getText());
		c.setDni(txtDni.getText());
		if (rdbtMasculino.isSelected())
			c.setSexo("M");
		else
			c.setSexo("F");

		return c;
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		if(ValidaDatos()){
			Cliente obj = LeerCliente();
			nCli.InsertarCliente(obj);
			this.vent.CargarCliente(obj);
			this.dispose();
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		this.dispose();
	}
}
