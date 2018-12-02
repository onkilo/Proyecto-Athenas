package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import conexion.Conexion;
import entidades.Trabajador;
import util.Reporte;

import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import util.PanelImagen;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class FrmPrincipal extends JFrame implements ActionListener, ChangeListener, MouseListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArhivo;
	private JMenuItem mntmSalir;
	private JMenuItem mntmCerrarSesin;
	private JMenu mnMantenimiento;
	private JMenu mnOperaciones;
	private JMenu mnReportes;
	private JMenu mnAdministrador;
	private JMenu mntmProducto;
	private JMenuItem mntmProveedor;
	private JMenuItem mntmPromocin;
	private JMenuItem mntmCliente;
	private JMenuItem mntmVentas;
	private JMenuItem mntmCompras;
	private JMenuItem mntmTrabajador;
	private PanelImagen pnEscritorio;

	// Persona logeada
	public static Trabajador currentUser = new Trabajador();

	// Ventanas de casa opcion de menu
	FrmProveedor prov = null;
	FrmCliente cli = null;
	FrmProducto prod = null;
	FrmPromo prom = null;
	FrmTrabajador trab = null;
	FrmCompras com = null;
	FrmVentas vent = null;
	FrmCategoria cat = null;

	private JMenuItem mntmCategorias;
	private JMenuItem mntmProductos;
	private JMenu mntmPromociones;
	private JMenuItem mntmClientes;
	private JMenuItem mntmProveedores;
	private JMenuItem mntmRepTrab;
	private JMenuItem mntmPromocionesActuales;
	private JMenuItem mntmPromocionesVencidas;
	private JLabel lblAthenas;
	private JLabel lblAthenas_1;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/img/icon-logo.png")));
		setTitle("Bodega - Athenas");
		setMinimumSize(new Dimension(1100, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);

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

		mntmProducto = new JMenu("Producto");
		mntmProducto.addMouseListener(this);
		mntmProducto.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmProducto.addChangeListener(this);
		mntmProducto.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-productos-black.png")));
		mnMantenimiento.add(mntmProducto);

		mntmCategorias = new JMenuItem("Categorias");
		mntmCategorias.addActionListener(this);
		mntmCategorias.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmProducto.add(mntmCategorias);

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

		mntmCompras = new JMenuItem("Pedidos");
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

		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mntmProductos.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmProductos.addChangeListener(this);
		mntmProductos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-listados-black.png")));
		mnReportes.add(mntmProductos);

		mntmPromociones = new JMenu("Promociones");
		mntmPromociones.addMouseListener(this);
		mntmPromociones.addChangeListener(this);
		mntmPromociones.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-listados-black.png")));
		mntmPromociones.setFont(new Font("Serif", Font.PLAIN, 15));
		mnReportes.add(mntmPromociones);

		mntmPromocionesActuales = new JMenuItem("Promociones Actuales");
		mntmPromocionesActuales.addActionListener(this);
		mntmPromocionesActuales.addChangeListener(this);
		mntmPromocionesActuales.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-listados-black.png")));
		mntmPromocionesActuales.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmPromociones.add(mntmPromocionesActuales);

		mntmPromocionesVencidas = new JMenuItem("Promociones Vencidas");
		mntmPromocionesVencidas.addActionListener(this);
		mntmPromocionesVencidas.addChangeListener(this);
		mntmPromocionesVencidas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-listados-black.png")));
		mntmPromocionesVencidas.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmPromociones.add(mntmPromocionesVencidas);

		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mntmClientes.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmClientes.addChangeListener(this);
		mntmClientes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-listados-black.png")));
		mnReportes.add(mntmClientes);

		mntmProveedores = new JMenuItem("Proveedores");
		mntmProveedores.addActionListener(this);
		mntmProveedores.addChangeListener(this);
		mntmProveedores.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmProveedores.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-listados-black.png")));
		mnReportes.add(mntmProveedores);

		mntmRepTrab = new JMenuItem("Trabajadores");
		mntmRepTrab.addActionListener(this);
		mntmRepTrab.addChangeListener(this);
		mntmRepTrab.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmRepTrab.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-listados-black.png")));
		mnReportes.add(mntmRepTrab);

		mnAdministrador = new JMenu("Administrador");
		mnAdministrador.setFont(new Font("Serif", Font.PLAIN, 15));
		mnAdministrador.addChangeListener(this);
		mnAdministrador.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-administrador-black.png")));
		menuBar.add(mnAdministrador);

		mntmTrabajador = new JMenuItem("Trabajadores");
		mntmTrabajador.addActionListener(this);
		mntmTrabajador.setFont(new Font("Serif", Font.PLAIN, 15));
		mntmTrabajador.addChangeListener(this);
		mntmTrabajador.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon-trabajador-black.png")));
		mnAdministrador.add(mntmTrabajador);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pnEscritorio = new PanelImagen("/img/fondo.jpg");
		pnEscritorio.setBorder(null);
		contentPane.add(pnEscritorio, BorderLayout.CENTER);
		
		lblAthenas_1 = new JLabel("Athenas");
		lblAthenas_1.setForeground(new Color(47, 79, 79));
		lblAthenas_1.setFont(new Font("Segoe Print", Font.BOLD, 76));
		lblAthenas_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthenas_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAthenas_1.setBounds(96, 152, 344, 68);
		pnEscritorio.add(lblAthenas_1);

		lblAthenas = new JLabel("");
		lblAthenas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAthenas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/cartel-fondo-madera.png")));
		lblAthenas.setBorder(null);
		lblAthenas.setBackground(new Color(0, 100, 0));
		lblAthenas.setForeground(SystemColor.activeCaption);
		lblAthenas.setFont(new Font("Edwardian Script ITC", Font.BOLD, 80));
		lblAthenas.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthenas.setBounds(2, 0, 600, 237);
		pnEscritorio.add(lblAthenas);

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		Conexion.Conectar();
		CheckPrivilegios();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowOpened(e);
				if (FrmPrincipal.currentUser == null || currentUser.getUsuario() == null) {
					int ingreso = JOptionPane.showConfirmDialog(null,
							"Ha ingresado al sistema sin usar el login. \nAlgunos m�dulos no funcionar�n correctamente\n"
									+ " \n�Desea ingresar usando el login?",
							"Ingreso err�neo", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

					if (ingreso == JOptionPane.YES_OPTION) {
						getGUI().dispose();
						FrmLogin login = new FrmLogin();
						login.setVisible(true);
					}
				}

			}
		});

	}

	private void CambiaIcono(ChangeEvent e, String categoria) {
		JMenuItem item = (JMenuItem) e.getSource();
		String ruta1 = "/img/icon-" + categoria + "-white.png";
		String ruta2 = "/img/icon-" + categoria + "-black.png";
		if (item.isSelected() || item.isArmed()) {
			item.setIcon(new ImageIcon(FrmPrincipal.class.getResource(ruta1)));
		} else {
			item.setIcon(new ImageIcon(FrmPrincipal.class.getResource(ruta2)));
		}
	}

	private JFrame getGUI() {
		return this;
	}

	private void CheckPrivilegios() {
		if (FrmPrincipal.currentUser != null && currentUser.getUsuario() != null) {
			if (FrmPrincipal.currentUser.getRol().equalsIgnoreCase("Vendedor")) {
				mnAdministrador.setVisible(false);
				mnReportes.setVisible(false);
				mntmPromocin.setVisible(false);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmCategorias) {
			actionPerformedMntmCategorias(e);
		}
		if (e.getSource() == mntmPromocionesVencidas) {
			actionPerformedMntmPromocionesVencidas(e);
		}
		if (e.getSource() == mntmPromocionesActuales) {
			actionPerformedMntmPromocionesActuales(e);
		}
		if (e.getSource() == mntmRepTrab) {
			Reporte.CreaReporte("/reportes/ListaTrabajadores.jasper");
		}
		if (e.getSource() == mntmClientes) {
			actionPerformedMntmClientes(e);
		}
		if (e.getSource() == mntmProductos) {
			actionPerformedMntmProductos(e);
		}
		if (e.getSource() == mntmProveedores) {
			actionPerformedMntmProveedores(e);
		}
		if (e.getSource() == mntmCompras) {
			actionPerformedMntmCompras(e);
		}
		if (e.getSource() == mntmVentas) {
			actionPerformedMntmVentas(e);
		}
		if (e.getSource() == mntmTrabajador) {
			actionPerformedMntmTrabajadores(e);
		}
		if (e.getSource() == mntmPromocin) {
			actionPerformedMntmPromocin(e);
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
		if (arg0.getSource() == mntmTrabajador) {
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
		if (arg0.getSource() == mntmProductos || arg0.getSource() == mntmProveedores
				|| arg0.getSource() == mntmPromociones || arg0.getSource() == mntmPromocionesActuales
				|| arg0.getSource() == mntmPromocionesVencidas || arg0.getSource() == mntmClientes
				|| arg0.getSource() == mntmRepTrab) {
			CambiaIcono(arg0, "listados");
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
		if (prov != null) {
			prov.toFront();
		} else {
			prov = new FrmProveedor();
			pnEscritorio.add(prov);
			prov.setVisible(true);
			prov.addInternalFrameListener(new InternalFrameAdapter() {
				@Override
				public void internalFrameClosed(InternalFrameEvent e) {
					super.internalFrameClosed(e);
					prov = null;
				}
			});
		}

	}

	protected void actionPerformedMntmCliente(ActionEvent e) {
		if (cli != null) {
			cli.toFront();
		} else {
			cli = new FrmCliente();
			pnEscritorio.add(cli);
			cli.setVisible(true);
			cli.addInternalFrameListener(new InternalFrameAdapter() {
				@Override
				public void internalFrameClosed(InternalFrameEvent e) {
					super.internalFrameClosed(e);
					cli = null;
				}
			});
		}
	}

	protected void actionPerformedMntmPromocin(ActionEvent e) {
		if (prom != null) {
			prom.toFront();
		} else {
			prom = new FrmPromo();
			pnEscritorio.add(prom);
			prom.setVisible(true);
			prom.addInternalFrameListener(new InternalFrameAdapter() {
				@Override
				public void internalFrameClosed(InternalFrameEvent e) {
					super.internalFrameClosed(e);
					prom = null;
				}
			});
		}
	}

	protected void actionPerformedMntmTrabajadores(ActionEvent e) {
		if (trab != null) {
			trab.toFront();
		} else {
			trab = new FrmTrabajador();
			pnEscritorio.add(trab);
			trab.setVisible(true);
			trab.addInternalFrameListener(new InternalFrameAdapter() {
				@Override
				public void internalFrameClosed(InternalFrameEvent e) {
					super.internalFrameClosed(e);
					trab = null;
				}
			});
		}
	}

	protected void actionPerformedMntmVentas(ActionEvent e) {
		if (vent != null) {
			vent.toFront();
		} else {
			vent = new FrmVentas();
			pnEscritorio.add(vent);
			vent.setVisible(true);
			vent.addInternalFrameListener(new InternalFrameAdapter() {
				@Override
				public void internalFrameClosed(InternalFrameEvent e) {
					super.internalFrameClosed(e);
					vent = null;
				}
			});
		}
	}

	protected void actionPerformedMntmCompras(ActionEvent e) {
		if (com != null) {
			com.toFront();
		} else {
			com = new FrmCompras();
			pnEscritorio.add(com);
			com.setVisible(true);
			com.addInternalFrameListener(new InternalFrameAdapter() {
				@Override
				public void internalFrameClosed(InternalFrameEvent e) {
					super.internalFrameClosed(e);
					com = null;
				}
			});
		}
	}

	protected void actionPerformedMntmCategorias(ActionEvent e) {
		cat = new FrmCategoria();
		cat.setLocationRelativeTo(this);
		cat.setVisible(true);

	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == mntmPromociones) {
			mouseClickedMntmPromociones(arg0);
		}
		if (arg0.getSource() == mntmProducto) {
			mouseClickedMntmProducto(arg0);
		}
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseClickedMntmProducto(MouseEvent arg0) {
		if (prod != null) {
			prod.toFront();
		} else {
			prod = new FrmProducto();
			pnEscritorio.add(prod);
			prod.setVisible(true);
			prod.addInternalFrameListener(new InternalFrameAdapter() {
				@Override
				public void internalFrameClosed(InternalFrameEvent e) {
					super.internalFrameClosed(e);
					prod = null;
				}
			});
		}
	}

	protected void actionPerformedMntmProveedores(ActionEvent e) {
		Reporte.CreaReporte("/reportes/ListaProveedores.jasper");
	}

	protected void actionPerformedMntmProductos(ActionEvent e) {
		Reporte.CreaReporte("/reportes/ListaProductos.jasper");
	}

	protected void actionPerformedMntmClientes(ActionEvent e) {
		Reporte.CreaReporte("/reportes/ListaClientes.jasper");
	}

	protected void actionPerformedMntmPromocionesActuales(ActionEvent e) {
		Reporte.CreaReporte("/reportes/ListaPromosActual.jasper");
	}

	protected void actionPerformedMntmPromocionesVencidas(ActionEvent e) {
		Reporte.CreaReporte("/reportes/ListaPromosVencidas.jasper");
	}

	protected void mouseClickedMntmPromociones(MouseEvent arg0) {
		Reporte.CreaReporte("/reportes/ListaPromos.jasper");
	}
}
