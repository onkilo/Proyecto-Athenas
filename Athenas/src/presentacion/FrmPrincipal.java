package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;

import conexion.Conexion;
import entidades.Trabajador;

import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JDesktopPane;

public class FrmPrincipal extends JFrame implements ActionListener, ChangeListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArhivo;
	private JMenuItem mntmSalir;
	private JMenuItem mntmCerrarSesin;
	private JMenu mnMantenimiento;
	private JMenu mnOperaciones;
	private JMenu mnReportes;
	private JMenu mnAdministrador;
	private JMenuItem mntmProducto;
	private JMenuItem mntmProveedor;
	private JMenuItem mntmPromocin;
	private JMenuItem mntmCliente;
	private JMenuItem mntmVentas;
	private JMenuItem mntmCompras;
	private JMenuItem mntmTrabajadores;
	private JDesktopPane pnEscritorio;
	
	//Persona logeada
	public static Trabajador currentUser = new Trabajador();
	
	//Ventanas de casa opcion de menu
	FrmProveedor prov = null;
	FrmCliente cli = null;
	FrmProducto prod = null;
	FrmPromo prom = null;
	FrmTrabajador trab = null;
	FrmCompras com = null;
	FrmVentas vent = null;
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
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setTitle("Bodega - Athenas");
		setMinimumSize(new Dimension(1024, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 700);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArhivo = new JMenu("Archivo");
		mnArhivo.setFont(new Font("Serif", Font.PLAIN, 15));
		mnArhivo.addChangeListener(this);
		mnArhivo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-archivo-black.png")));
		menuBar.add(mnArhivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmSalir.addChangeListener(this);
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-salir-black.png")));
		mntmSalir.addActionListener(this);
		mnArhivo.add(mntmSalir);
		
		mntmCerrarSesin = new JMenuItem("Cerrar sesi\u00F3n");
		mntmCerrarSesin.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmCerrarSesin.addChangeListener(this);
		mntmCerrarSesin.setOpaque(true);
		mntmCerrarSesin.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-logout-black.png")));
		mntmCerrarSesin.addActionListener(this);
		mnArhivo.add(mntmCerrarSesin);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(new Font("Serif", Font.PLAIN, 15));
		mnMantenimiento.addChangeListener(this);
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-mantenimiento-black.png")));
		menuBar.add(mnMantenimiento);
		
		mntmProducto = new JMenuItem("Producto");
		mntmProducto.addActionListener(this);
		mntmProducto.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmProducto.addChangeListener(this);
		mntmProducto.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-productos-black.png")));
		mnMantenimiento.add(mntmProducto);
		
		mntmProveedor = new JMenuItem("Proveedor");
		mntmProveedor.addActionListener(this);
		mntmProveedor.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmProveedor.addChangeListener(this);
		mntmProveedor.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-proveedor-black.png")));
		mnMantenimiento.add(mntmProveedor);
		
		mntmPromocin = new JMenuItem("Promoci\u00F3n");
		mntmPromocin.addActionListener(this);
		mntmPromocin.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmPromocin.addChangeListener(this);
		mntmPromocin.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-promocion-black.png")));
		mnMantenimiento.add(mntmPromocin);
		
		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(this);
		mntmCliente.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmCliente.addChangeListener(this);
		mntmCliente.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-cliente-black.png")));
		mnMantenimiento.add(mntmCliente);
		
		mnOperaciones = new JMenu("Operaciones");
		mnOperaciones.setFont(new Font("Serif", Font.PLAIN, 15));
		mnOperaciones.addChangeListener(this);
		mnOperaciones.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-operaciones-black.png")));
		menuBar.add(mnOperaciones);
		
		mntmVentas = new JMenuItem("Ventas");
		mntmVentas.addActionListener(this);
		mntmVentas.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmVentas.addChangeListener(this);
		mntmVentas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-venta-black.png")));
		mnOperaciones.add(mntmVentas);
		
		mntmCompras = new JMenuItem("Compras");
		mntmCompras.addActionListener(this);
		mntmCompras.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmCompras.addChangeListener(this);
		mntmCompras.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-compra-black.png")));
		mnOperaciones.add(mntmCompras);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setFont(new Font("Serif", Font.PLAIN, 15));
		mnReportes.addChangeListener(this);
		mnReportes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-reportes-black.png")));
		menuBar.add(mnReportes);
		
		mnAdministrador = new JMenu("Administrador");
		mnAdministrador.setFont(new Font("Serif", Font.PLAIN, 15));
		mnAdministrador.addChangeListener(this);
		mnAdministrador.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-administrador-black.png")));
		menuBar.add(mnAdministrador);
		
		mntmTrabajadores = new JMenuItem("Trabajadores");
		mntmTrabajadores.addActionListener(this);
		mntmTrabajadores.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmTrabajadores.addChangeListener(this);
		mntmTrabajadores.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-trabajador-black.png")));
		mnAdministrador.add(mntmTrabajadores);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pnEscritorio = new JDesktopPane();
		pnEscritorio.setBorder(null);
		contentPane.add(pnEscritorio, BorderLayout.CENTER);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		Conexion.Conectar();
		CheckPrivilegios();
	}

	
	private void CambiaIcono(ChangeEvent e, String categoria){
		JMenuItem item = (JMenuItem) e.getSource();
		String ruta1 = "/img/icon-" + categoria + "-white.png";
		String ruta2= "/img/icon-" + categoria + "-black.png";
		if(item.isSelected() || item.isArmed()){
			item.setIcon(new ImageIcon(FrmPrincipal.class.getResource(ruta1)));
		}else{
			item.setIcon(new ImageIcon(FrmPrincipal.class.getResource(ruta2)));
		}
	}
	
	private void CheckPrivilegios(){
		if(FrmPrincipal.currentUser != null && currentUser.getUsuario() != null){
			if(FrmPrincipal.currentUser.getRol().equalsIgnoreCase("Vendedor")){
				mnAdministrador.setVisible(false);
				mnReportes.setVisible(false);
			}
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmCompras) {
			actionPerformedMntmCompras(e);
		}
		if (e.getSource() == mntmVentas) {
			actionPerformedMntmVentas(e);
		}
		if (e.getSource() == mntmTrabajadores) {
			actionPerformedMntmTrabajadores(e);
		}
		if (e.getSource() == mntmPromocin) {
			actionPerformedMntmPromocin(e);
		}
		if (e.getSource() == mntmProducto) {
			actionPerformedMntmProducto(e);
		}
		if (e.getSource() == mntmCliente) {
			actionPerformedMntmCliente(e);
		}
		if (e.getSource() == mntmProveedor) {
			actionPerformedMntmProveedor(e);
		}
		if (e.getSource() == mntmCerrarSesin) {
			actionPerformedMntmCerrarSesin(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	protected void actionPerformedMntmCerrarSesin(ActionEvent e) {
		this.dispose();
		FrmLogin login = new FrmLogin();
		login.setVisible(true);
	}
	public void stateChanged(ChangeEvent arg0) {
		if (arg0.getSource() == mntmTrabajadores) {
			stateChangedMntmTrabajadores(arg0);
		}
		if (arg0.getSource() == mnAdministrador) {
			stateChangedMnAdministrador(arg0);
		}
		if (arg0.getSource() == mnReportes) {
			stateChangedMnReportes(arg0);
		}
		if (arg0.getSource() == mntmCompras) {
			stateChangedMntmCompras(arg0);
		}
		if (arg0.getSource() == mntmVentas) {
			stateChangedMntmVentas(arg0);
		}
		if (arg0.getSource() == mnOperaciones) {
			stateChangedMnOperaciones(arg0);
		}
		if (arg0.getSource() == mntmCliente) {
			stateChangedMntmCliente(arg0);
		}
		if (arg0.getSource() == mntmPromocin) {
			stateChangedMntmPromocin(arg0);
		}
		if (arg0.getSource() == mntmProveedor) {
			stateChangedMntmProveedor(arg0);
		}
		if (arg0.getSource() == mntmProducto) {
			stateChangedMntmProducto(arg0);
		}
		if (arg0.getSource() == mnMantenimiento) {
			stateChangedMnMantenimiento(arg0);
		}
		if (arg0.getSource() == mnArhivo) {
			stateChangedMnArhivo(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			stateChangedMntmSalir(arg0);
		}
		if (arg0.getSource() == mntmCerrarSesin) {
			stateChangedMntmCerrarSesin(arg0);
		}
	}
	protected void stateChangedMntmCerrarSesin(ChangeEvent e) {
		CambiaIcono(e, "logout");
	}
	protected void stateChangedMntmSalir(ChangeEvent e) {
		CambiaIcono(e, "salir");
	}
	protected void stateChangedMnArhivo(ChangeEvent e) {
		CambiaIcono(e, "archivo");
	}
	protected void stateChangedMnMantenimiento(ChangeEvent e) {
		CambiaIcono(e, "mantenimiento");
	}
	protected void stateChangedMntmProducto(ChangeEvent e) {
		CambiaIcono(e, "productos");
	}
	protected void stateChangedMntmProveedor(ChangeEvent e) {
		CambiaIcono(e, "proveedor");
	}
	protected void stateChangedMntmPromocin(ChangeEvent e) {
		CambiaIcono(e, "promocion");
	}
	protected void stateChangedMntmCliente(ChangeEvent e) {
		CambiaIcono(e, "cliente");
	}
	protected void stateChangedMnOperaciones(ChangeEvent e) {
		CambiaIcono(e, "operaciones");
	}
	protected void stateChangedMntmVentas(ChangeEvent e) {
		CambiaIcono(e, "venta");
	}
	protected void stateChangedMntmCompras(ChangeEvent e) {
		CambiaIcono(e, "compra");
	}
	protected void stateChangedMnReportes(ChangeEvent e) {
		CambiaIcono(e, "reportes");
	}
	protected void stateChangedMnAdministrador(ChangeEvent e) {
		CambiaIcono(e, "administrador");
	}
	protected void stateChangedMntmTrabajadores(ChangeEvent e) {
		CambiaIcono(e, "trabajador");
	}
	protected void actionPerformedMntmProveedor(ActionEvent e) {
		prov = new FrmProveedor();
		pnEscritorio.add(prov);
		prov.setVisible(true);
	}
	protected void actionPerformedMntmCliente(ActionEvent e) {
		cli = new FrmCliente();
		pnEscritorio.add(cli);
		cli.setVisible(true);
	}
	protected void actionPerformedMntmProducto(ActionEvent e) {
		prod = new FrmProducto();
		pnEscritorio.add(prod);
		prod.setVisible(true);
	}
	protected void actionPerformedMntmPromocin(ActionEvent e) {
		prom = new FrmPromo();
		pnEscritorio.add(prom);
		prom.setVisible(true);
	}
	protected void actionPerformedMntmTrabajadores(ActionEvent e) {
		trab = new FrmTrabajador();
		pnEscritorio.add(trab);
		trab.setVisible(true);
	}
	protected void actionPerformedMntmVentas(ActionEvent e) {
		vent = new FrmVentas();
		pnEscritorio.add(vent);
		vent.setVisible(true);
	}
	protected void actionPerformedMntmCompras(ActionEvent e) {
		com = new FrmCompras();
		pnEscritorio.add(com);
		com.setVisible(true);
	}
}
