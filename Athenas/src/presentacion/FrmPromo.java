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
import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.ImageIcon;

public class FrmPromo extends JInternalFrame {
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblCdigo;
	private JLabel lblRaznSocial;
	private JLabel lblRepresentante;
	private JLabel lblEmail;
	private JLabel lblTelfono;
	private JTextField txtValor;
	private JTextField txtProducto;
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
	private JRadioButton rdbtnPorProducto;
	private JLabel lblSexo;
	private JRadioButton rdbtnPorcentual;
	private JRadioButton rdbtnFijo;
	private JButton btnBuscarProd;
	private DatePicker dpInicial;
	private DatePicker dpFinal;

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
					FrmPromo frame = new FrmPromo();
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
	public FrmPromo() {
		setMinimumSize(new Dimension(1100, 600));
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(new MigLayout("", "[450:n][500px:n,grow]", "[][grow]"));
		
		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBorder(new TitledBorder(null, "Promoci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		getContentPane().add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[150px:n,grow][grow]", "[50px:n][50px:n][50px:n][50px:n][50px:n,grow][50px:n,grow][]"));
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Serif", Font.PLAIN, 14));
		lblCdigo.setPreferredSize(new Dimension(100, 16));
		panel.add(lblCdigo, "cell 0 0,alignx center");
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		panel.add(txtCodigo, "cell 1 0,alignx leading");
		txtCodigo.setColumns(10);
		
		lblRaznSocial = new JLabel("Producto");
		lblRaznSocial.setFont(new Font("Serif", Font.PLAIN, 14));
		lblRaznSocial.setPreferredSize(new Dimension(100, 16));
		panel.add(lblRaznSocial, "cell 0 1,alignx center");
		
		txtProducto = new JTextField();
		txtProducto.setEnabled(false);
		panel.add(txtProducto, "flowx,cell 1 1,alignx leading");
		txtProducto.setColumns(15);
		
		lblRepresentante = new JLabel("Tipo");
		lblRepresentante.setFont(new Font("Serif", Font.PLAIN, 14));
		lblRepresentante.setPreferredSize(new Dimension(100, 16));
		panel.add(lblRepresentante, "cell 0 2,alignx center");
		
		rdbtnPorcentual = new JRadioButton("Porcentual");
		rdbtnPorcentual.setEnabled(false);
		rdbtnPorcentual.setPreferredSize(new Dimension(100, 18));
		panel.add(rdbtnPorcentual, "flowx,cell 1 2,alignx leading");
		
		lblEmail = new JLabel("Valor");
		lblEmail.setFont(new Font("Serif", Font.PLAIN, 14));
		lblEmail.setPreferredSize(new Dimension(100, 16));
		panel.add(lblEmail, "cell 0 3,alignx center");
		
		txtValor = new JTextField();
		txtValor.setEnabled(false);
		panel.add(txtValor, "cell 1 3,alignx leading");
		txtValor.setColumns(20);
		
		lblTelfono = new JLabel("Fecha inicial");
		lblTelfono.setFont(new Font("Serif", Font.PLAIN, 14));
		lblTelfono.setPreferredSize(new Dimension(100, 16));
		panel.add(lblTelfono, "cell 0 4,alignx center");
		
		dpInicial = new DatePicker();
		dpInicial.getComponentToggleCalendarButton().setText("");
		dpInicial.getComponentToggleCalendarButton().setIcon(new ImageIcon(FrmPromo.class.getResource("/img/icon-calendario-black.png")));
		dpInicial.setBackground(SystemColor.control);
		dpInicial.setEnabled(false);
		dpInicial.getComponentToggleCalendarButton().setBounds(156, -2, 41, 28);
		dpInicial.getComponentDateTextField().setBounds(0, 0, 159, 25);
		dpInicial.setPreferredSize(new Dimension(203, 28));
		panel.add(dpInicial, "cell 1 4,alignx leading,aligny center");
		dpInicial.setLayout(null);
		
		lblSexo = new JLabel("Fecha final");
		lblSexo.setPreferredSize(new Dimension(100, 16));
		lblSexo.setFont(new Font("Serif", Font.PLAIN, 14));
		panel.add(lblSexo, "cell 0 5,alignx center");
		
		dpFinal = new DatePicker();
		dpFinal.getComponentToggleCalendarButton().setIcon(new ImageIcon(FrmPromo.class.getResource("/img/icon-calendario-black.png")));
		dpFinal.getComponentToggleCalendarButton().setText("");
		dpFinal.setBackground(SystemColor.control);
		dpFinal.setEnabled(false);
		dpFinal.getComponentToggleCalendarButton().setBounds(156, -2, 41, 28);
		dpFinal.getComponentDateTextField().setBounds(0, 0, 159, 25);
		dpFinal.setPreferredSize(new Dimension(203, 28));
		panel.add(dpFinal, "cell 1 5,alignx leading,aligny center");
		dpFinal.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.control);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(50);
		flowLayout.setVgap(10);
		panel.add(panel_3, "cell 0 6 2 1,grow");
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setHorizontalAlignment(SwingConstants.LEADING);
		btnGuardar.setIcon(new ImageIcon(FrmPromo.class.getResource("/img/icon-guardar-white.png")));
		btnGuardar.setEnabled(false);
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBackground(new Color(128, 128, 0));
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnGuardar.setPreferredSize(new Dimension(110, 35));
		panel_3.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(FrmPromo.class.getResource("/img/icon-cancelar-white.png")));
		btnCancelar.setEnabled(false);
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(128, 128, 0));
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCancelar.setPreferredSize(new Dimension(110, 35));
		panel_3.add(btnCancelar);
		
		rdbtnFijo = new JRadioButton("Fijo");
		rdbtnFijo.setEnabled(false);
		panel.add(rdbtnFijo, "cell 1 2,alignx leading");
		
		btnBuscarProd = new JButton("");
		btnBuscarProd.setIcon(new ImageIcon(FrmPromo.class.getResource("/img/icon-buscar-black.png")));
		btnBuscarProd.setEnabled(false);
		panel.add(btnBuscarProd, "cell 1 1");
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBorder(new TitledBorder(null, "Listado de promociones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		getContentPane().add(panel_1, "cell 1 0 1 2,grow");
		panel_1.setLayout(new MigLayout("", "[100px:n][grow][grow]", "[][][grow][]"));
		
		lblBuscar = new JLabel("Buscar ");
		lblBuscar.setFont(new Font("Serif", Font.PLAIN, 16));
		panel_1.add(lblBuscar, "cell 0 0,alignx center");
		
		txtBuscar = new JTextField();
		panel_1.add(txtBuscar, "cell 1 0,growx");
		txtBuscar.setColumns(20);
		
		btnResetear = new JButton("");
		btnResetear.setMinimumSize(new Dimension(25, 25));
		btnResetear.setIcon(new ImageIcon(FrmPromo.class.getResource("/img/icon-resetear-white.png")));
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
		
		rdbtnPorProducto = new JRadioButton("Por Producto");
		rdbtnPorProducto.setFont(new Font("Serif", Font.PLAIN, 16));
		panel_6.add(rdbtnPorProducto, "cell 1 0,alignx left,aligny top");
		
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
		panel_2.setLayout(new MigLayout("", "[grow]", "[]"));
		
		panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.control);
		panel_4.setBorder(new LineBorder(SystemColor.controlShadow, 2));
		panel_2.add(panel_4, "cell 0 0,grow");
		panel_4.setLayout(new MigLayout("", "[grow][grow][grow]", "[]"));
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(FrmPromo.class.getResource("/img/icon-nuevo-white.png")));
		panel_4.add(btnNuevo, "cell 0 0,alignx center");
		btnNuevo.setForeground(new Color(255, 255, 255));
		btnNuevo.setBackground(new Color(138, 43, 226));
		btnNuevo.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNuevo.setPreferredSize(new Dimension(100, 35));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(FrmPromo.class.getResource("/img/icon-modificar-white.png")));
		panel_4.add(btnModificar, "cell 1 0,alignx center");
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setBackground(new Color(138, 43, 226));
		btnModificar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnModificar.setPreferredSize(new Dimension(100, 35));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmPromo.class.getResource("/img/icon-eliminar-white.png")));
		panel_4.add(btnEliminar, "cell 2 0,alignx center");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(138, 43, 226));
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEliminar.setPreferredSize(new Dimension(100, 35));
		setBounds(0, 0, 1100, 600);
		
		modelo = new DefaultTableModel();
		tblProveedor.setModel(modelo);
		
		btnImprimir = new JButton("");
		btnImprimir.setIcon(new ImageIcon(FrmPromo.class.getResource("/img/icon-imprimir-white.png")));
		panel_1.add(btnImprimir, "cell 2 3,alignx trailing");
		btnImprimir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnImprimir.setForeground(new Color(255, 255, 255));
		btnImprimir.setBackground(new Color(128, 128, 0));
		btnImprimir.setPreferredSize(new Dimension(100, 30));
		modelo.addColumn("C�digo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Telefono");
		modelo.addColumn("DNI");
		modelo.addColumn("Sexo");
		
		
		btnG = new ButtonGroup();
		btnG.add(rdbtnPorCodigo);
		btnG.add(rdbtnPorProducto);

	}

}
