package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JPasswordField txtPass;
	private JCheckBox cxbMostrarPass;
	private JButton btnIngresar;
	private JButton btnCancelar;
	private JLabel lblSistemaAthenas;
	private JLabel lblLima;
	
	private char hiddenChar = '0';
	private int intentos = 0;

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
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 387);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 632, 67);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblSistemaAthenas = new JLabel("Sistema Athenas - Ingreso");
		lblSistemaAthenas.setFont(new Font("Serif", Font.BOLD, 25));
		lblSistemaAthenas.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaAthenas.setForeground(Color.WHITE);
		lblSistemaAthenas.setBounds(6, 6, 315, 55);
		panel.add(lblSistemaAthenas);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(0, 292, 632, 67);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblLima = new JLabel("2018 \u00A9 Lima -Per\u00FA");
		lblLima.setHorizontalAlignment(SwingConstants.CENTER);
		lblLima.setFont(new Font("Serif", Font.PLAIN, 25));
		lblLima.setForeground(Color.WHITE);
		lblLima.setBounds(6, 6, 610, 55);
		panel_1.add(lblLima);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Serif", Font.BOLD, 16));
		lblUsuario.setBounds(96, 94, 112, 28);
		contentPane.add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Serif", Font.BOLD, 16));
		lblContrasea.setBounds(96, 134, 112, 28);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(218, 93, 197, 28);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(218, 135, 197, 28);
		contentPane.add(txtPass);
		
		cxbMostrarPass = new JCheckBox("Mostrar contrase\u00F1a");
		cxbMostrarPass.addActionListener(this);
		cxbMostrarPass.setFont(new Font("Serif", Font.PLAIN, 14));
		cxbMostrarPass.setBounds(228, 174, 144, 18);
		contentPane.add(cxbMostrarPass);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBackground(new Color(128, 128, 0));
		btnIngresar.setFont(new Font("Serif", Font.BOLD, 16));
		btnIngresar.setBounds(125, 215, 100, 35);
		contentPane.add(btnIngresar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(128, 128, 0));
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Serif", Font.BOLD, 16));
		btnCancelar.setBounds(311, 215, 100, 35);
		contentPane.add(btnCancelar);
		
		setLocationRelativeTo(null);
		
		hiddenChar = txtPass.getEchoChar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cxbMostrarPass) {
			actionPerformedChckbxMostrarContrasea(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		System.exit(0);
	}
	protected void actionPerformedChckbxMostrarContrasea(ActionEvent arg0) {
		if(cxbMostrarPass.isSelected()){
			txtPass.setEchoChar((char) 0);
		}
		else{
			txtPass.setEchoChar(hiddenChar);
		}
	}
}
