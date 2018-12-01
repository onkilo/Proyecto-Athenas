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
import javax.swing.ImageIcon;

public class FrmCompras extends JInternalFrame {
	private JPanel panel;
	private JPanel panel_1;
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
	private JRadioButton rdbtnPorProv;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JPanel panel_2;
	private JLabel lblCantidadDeVentas;
	private JTextField txtCant;
	private JPanel panel_3;
	private JRadioButton rdbtnReg;
	private JRadioButton rdbtnRec;
	private JRadioButton rdbtnTodas;
	private JButton btnRecibir;

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
					FrmCompras frame = new FrmCompras();
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
	public FrmCompras() {
		setMinimumSize(new Dimension(1100, 600));
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(new MigLayout("", "[300:n][500px:n,grow]", "[grow]"));
		
		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBorder(null);
		getContentPane().add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[150px:n,grow][grow]", "[20px:n][50px:n][150px:n][50px:n][50px:n][]"));
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.control);
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel.add(panel_2, "cell 0 1 2 1,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[50px:n][50px:n][50px:n][50px:n]"));
		
		btnNuevo = new JButton("Nuevo pedido");
		btnNuevo.setFont(new Font("Serif", Font.BOLD, 14));
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setBackground(new Color(138, 43, 226));
		panel_2.add(btnNuevo, "cell 0 0,alignx center");
		btnNuevo.setPreferredSize(new Dimension(150, 40));
		
		btnModificar = new JButton("Modificar pedido");
		btnModificar.setFont(new Font("Serif", Font.BOLD, 14));
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(new Color(138, 43, 226));
		panel_2.add(btnModificar, "cell 0 1,alignx center");
		btnModificar.setPreferredSize(new Dimension(150, 40));
		
		btnEliminar = new JButton("Eliminar pedido");
		btnEliminar.setFont(new Font("Serif", Font.BOLD, 14));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(138, 43, 226));
		panel_2.add(btnEliminar, "cell 0 2,alignx center");
		btnEliminar.setPreferredSize(new Dimension(150, 40));
		
		btnRecibir = new JButton("Recibir pedido");
		btnRecibir.setPreferredSize(new Dimension(150, 40));
		btnRecibir.setForeground(Color.WHITE);
		btnRecibir.setFont(new Font("Serif", Font.BOLD, 14));
		btnRecibir.setBackground(new Color(138, 43, 226));
		panel_2.add(btnRecibir, "cell 0 3,alignx center");
		
		panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.control);
		panel_3.setBorder(new TitledBorder(null, "Filtros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_3, "cell 0 2 2 1,alignx center,growy");
		panel_3.setLayout(new MigLayout("", "[]", "[grow][grow][grow]"));
		
		rdbtnReg = new JRadioButton("Solo registrados");
		panel_3.add(rdbtnReg, "cell 0 0");
		
		rdbtnRec = new JRadioButton("Solo recibidos");
		panel_3.add(rdbtnRec, "cell 0 1");
		
		rdbtnTodas = new JRadioButton("Registrados y recibidos");
		panel_3.add(rdbtnTodas, "cell 0 2");
		
		lblCantidadDeVentas = new JLabel("Cantidad de pedidos");
		lblCantidadDeVentas.setFont(new Font("Serif", Font.BOLD, 14));
		panel.add(lblCantidadDeVentas, "cell 0 3,alignx center");
		
		txtCant = new JTextField();
		panel.add(txtCant, "cell 1 3,alignx leading");
		txtCant.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBorder(new TitledBorder(null, "Listado de pedidos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		getContentPane().add(panel_1, "cell 1 0,grow");
		panel_1.setLayout(new MigLayout("", "[100px:n][grow][grow]", "[][][grow][]"));
		
		lblBuscar = new JLabel("Buscar ");
		lblBuscar.setFont(new Font("Serif", Font.PLAIN, 16));
		panel_1.add(lblBuscar, "cell 0 0,alignx center");
		
		txtBuscar = new JTextField();
		panel_1.add(txtBuscar, "cell 1 0,growx");
		txtBuscar.setColumns(20);
		
		btnResetear = new JButton("");
		btnResetear.setMinimumSize(new Dimension(25, 25));
		btnResetear.setIcon(new ImageIcon(FrmCompras.class.getResource("/img/icon-resetear-white.png")));
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
		rdbtnPorCodigo.setBackground(SystemColor.control);
		rdbtnPorCodigo.setFont(new Font("Serif", Font.PLAIN, 16));
		panel_6.add(rdbtnPorCodigo, "cell 0 0,alignx left,aligny top");
		
		rdbtnPorProv = new JRadioButton("Por Proveedor");
		rdbtnPorProv.setBackground(SystemColor.control);
		rdbtnPorProv.setFont(new Font("Serif", Font.PLAIN, 16));
		panel_6.add(rdbtnPorProv, "cell 1 0,alignx left,aligny top");
		
		panel_5 = new JPanel();
		panel_1.add(panel_5, "cell 0 2 3 1,grow");
		panel_5.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.control);
		panel_5.add(scrollPane, BorderLayout.CENTER);
		
		tblProveedor = new JTable();
		scrollPane.setViewportView(tblProveedor);
		setBounds(0, 0, 1100, 600);
		
		modelo = new DefaultTableModel();
		tblProveedor.setModel(modelo);
		
		btnImprimir = new JButton("");
		btnImprimir.setIcon(new ImageIcon(FrmCompras.class.getResource("/img/icon-imprimir-white.png")));
		panel_1.add(btnImprimir, "cell 2 3,alignx trailing");
		btnImprimir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnImprimir.setForeground(new Color(255, 255, 255));
		btnImprimir.setBackground(new Color(128, 128, 0));
		btnImprimir.setPreferredSize(new Dimension(100, 30));
		modelo.addColumn("Código");
		modelo.addColumn("Proveedor");
		modelo.addColumn("Trabajador");
		modelo.addColumn("Fecha");
		modelo.addColumn("IGV");
		modelo.addColumn("Total");
		modelo.addColumn("Estado");
		
		btnG = new ButtonGroup();
		btnG.add(rdbtnPorCodigo);
		btnG.add(rdbtnPorProv);

	}

}
