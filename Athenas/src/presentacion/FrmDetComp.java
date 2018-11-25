package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import com.github.lgooddatepicker.components.DatePicker;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmDetComp extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblTotal;
	private JTextField textField;
	private JLabel lblCdigo;
	private JLabel lblFecha;
	private JTextField textField_1;
	private DatePicker datePicker;
	private JLabel lblBodegaAthenas;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton button;
	private JLabel lblTelfono;
	private JTextField textField_4;
	private JLabel lblVendedor;
	private JTextField textField_8;
	private JLabel lblRuc;
	private JPanel panel_2;
	private JLabel lblProducto;
	private JTextField textField_5;
	private JButton button_1;
	private JLabel lblPrecio;
	private JTextField textField_6;
	private JButton btnAgregar;
	private JButton btnEliminarProducto;
	private JButton btnModificarDetalle;
	private JButton btnCancelarDetalle;
	private JButton btnRegistrarDetalle;
	private JButton btnImprimirVenta;
	private JLabel lblCantidad;
	private JTextField textField_10;
	private JLabel lblDireccin;
	private JTextField textField_11;
	private JScrollPane scrollPane;
	private JTable tblDetalle;

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
			FrmDetComp dialog = new FrmDetComp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmDetComp() {
		setModal(true);
		setBounds(100, 100, 879, 647);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(7, 6, 322, 254);
		panel.setBorder(new TitledBorder(null, "Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblBodegaAthenas = new JLabel("Bodega Athenas\r\n");
		lblBodegaAthenas.setBounds(33, 17, 258, 24);
		lblBodegaAthenas.setFont(new Font("Serif", Font.BOLD, 18));
		lblBodegaAthenas.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblBodegaAthenas);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(33, 115, 50, 19);
		lblCdigo.setPreferredSize(new Dimension(50, 16));
		lblCdigo.setFont(new Font("Serif", Font.BOLD, 14));
		panel.add(lblCdigo);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.control);
		textField_1.setEditable(false);
		textField_1.setBounds(114, 111, 122, 28);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(33, 156, 50, 25);
		lblFecha.setPreferredSize(new Dimension(50, 25));
		lblFecha.setFont(new Font("Serif", Font.BOLD, 14));
		panel.add(lblFecha);
		
		datePicker = new DatePicker();
		datePicker.setBackground(SystemColor.control);
		datePicker.setBounds(114, 155, 152, 28);
		datePicker.setEnabled(false);
		datePicker.getComponentToggleCalendarButton().setPreferredSize(new Dimension(41, 28));
		datePicker.getComponentDateTextField().setPreferredSize(new Dimension(159, 25));
		datePicker.getComponentToggleCalendarButton().setBounds(98, -2, 41, 28);
		datePicker.getComponentDateTextField().setBounds(0, 0, 100, 25);
		datePicker.setPreferredSize(new Dimension(203, 28));
		panel.add(datePicker);
		datePicker.setLayout(null);
		
		lblRuc = new JLabel("R.U.C. : 0000000000");
		lblRuc.setBounds(31, 53, 249, 50);
		lblRuc.setFont(new Font("Serif", Font.BOLD, 14));
		lblRuc.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblRuc);
		
		lblVendedor = new JLabel("Trabajador");
		lblVendedor.setBounds(32, 205, 70, 25);
		lblVendedor.setPreferredSize(new Dimension(50, 25));
		lblVendedor.setFont(new Font("Serif", Font.BOLD, 14));
		panel.add(lblVendedor);
		
		textField_8 = new JTextField();
		textField_8.setBackground(SystemColor.control);
		textField_8.setEditable(false);
		textField_8.setBounds(114, 204, 191, 28);
		panel.add(textField_8);
		textField_8.setColumns(15);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(332, 7, 525, 117);
		panel_1.setBorder(new TitledBorder(null, "Proveedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		lblDni = new JLabel("C\u00F3digo");
		lblDni.setBounds(21, 30, 50, 19);
		lblDni.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDni.setPreferredSize(new Dimension(50, 16));
		panel_1.add(lblDni);
		
		textField_2 = new JTextField();
		textField_2.setBackground(SystemColor.control);
		textField_2.setEditable(false);
		textField_2.setBounds(110, 26, 122, 28);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		lblNombre = new JLabel("Raz\u00F3n social");
		lblNombre.setBounds(21, 75, 77, 19);
		lblNombre.setFont(new Font("Serif", Font.PLAIN, 14));
		lblNombre.setPreferredSize(new Dimension(50, 16));
		panel_1.add(lblNombre);
		
		button = new JButton("...");
		button.setBounds(244, 26, 37, 28);
		panel_1.add(button);
		
		lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(343, 75, 50, 19);
		lblTelfono.setFont(new Font("Serif", Font.PLAIN, 14));
		lblTelfono.setPreferredSize(new Dimension(50, 16));
		panel_1.add(lblTelfono);
		
		textField_3 = new JTextField();
		textField_3.setBackground(SystemColor.control);
		textField_3.setEditable(false);
		textField_3.setBounds(110, 71, 187, 28);
		panel_1.add(textField_3);
		textField_3.setColumns(20);
		
		textField_4 = new JTextField();
		textField_4.setBackground(SystemColor.control);
		textField_4.setEditable(false);
		textField_4.setBounds(405, 71, 106, 28);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setPreferredSize(new Dimension(50, 16));
		lblDireccin.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDireccin.setBounds(293, 30, 66, 19);
		panel_1.add(lblDireccin);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBackground(SystemColor.menu);
		textField_11.setBounds(371, 26, 140, 28);
		panel_1.add(textField_11);
		
		panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.control);
		panel_3.setBounds(7, 267, 850, 335);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.control);
		panel_4.setBounds(7, 7, 621, 286);
		panel_4.setBorder(new TitledBorder(null, "Detalle", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.control);
		panel_4.add(scrollPane, BorderLayout.CENTER);
		
		tblDetalle = new JTable();
		scrollPane.setViewportView(tblDetalle);
		
		panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.control);
		panel_5.setBorder(new LineBorder(new Color(180, 180, 180), 2));
		panel_5.setBounds(640, 16, 200, 254);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		btnEliminarProducto = new JButton("Eliminar detalle");
		btnEliminarProducto.setBackground(new Color(75, 0, 130));
		btnEliminarProducto.setForeground(Color.WHITE);
		btnEliminarProducto.setFont(new Font("Serif", Font.BOLD, 14));
		btnEliminarProducto.setBounds(34, 17, 141, 35);
		panel_5.add(btnEliminarProducto);
		
		btnModificarDetalle = new JButton("Modificar detalle");
		btnModificarDetalle.setBackground(new Color(75, 0, 130));
		btnModificarDetalle.setForeground(Color.WHITE);
		btnModificarDetalle.setFont(new Font("Serif", Font.BOLD, 14));
		btnModificarDetalle.setBounds(34, 52, 141, 35);
		panel_5.add(btnModificarDetalle);
		
		btnCancelarDetalle = new JButton("Cancelar pedido");
		btnCancelarDetalle.setBackground(new Color(75, 0, 130));
		btnCancelarDetalle.setForeground(Color.WHITE);
		btnCancelarDetalle.setFont(new Font("Serif", Font.BOLD, 14));
		btnCancelarDetalle.setBounds(34, 160, 141, 35);
		panel_5.add(btnCancelarDetalle);
		
		btnRegistrarDetalle = new JButton("Registrar pedido");
		btnRegistrarDetalle.setBackground(new Color(75, 0, 130));
		btnRegistrarDetalle.setForeground(Color.WHITE);
		btnRegistrarDetalle.setFont(new Font("Serif", Font.BOLD, 14));
		btnRegistrarDetalle.setBounds(34, 120, 141, 35);
		panel_5.add(btnRegistrarDetalle);
		
		btnImprimirVenta = new JButton("Imprimir pedido");
		btnImprimirVenta.setBackground(new Color(75, 0, 130));
		btnImprimirVenta.setForeground(Color.WHITE);
		btnImprimirVenta.setFont(new Font("Serif", Font.BOLD, 14));
		btnImprimirVenta.setBounds(34, 198, 141, 35);
		panel_5.add(btnImprimirVenta);
		
		lblTotal = new JLabel("Total S/. ");
		lblTotal.setBounds(439, 299, 55, 19);
		lblTotal.setFont(new Font("Serif", Font.BOLD, 14));
		panel_3.add(lblTotal);
		
		textField = new JTextField();
		textField.setBounds(506, 295, 122, 28);
		panel_3.add(textField);
		textField.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.control);
		panel_2.setBorder(new TitledBorder(null, "Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_2.setBounds(334, 128, 523, 132);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		lblProducto = new JLabel("Producto");
		lblProducto.setPreferredSize(new Dimension(50, 16));
		lblProducto.setFont(new Font("Serif", Font.PLAIN, 14));
		lblProducto.setBounds(18, 34, 74, 19);
		panel_2.add(lblProducto);
		
		textField_5 = new JTextField();
		textField_5.setBackground(SystemColor.control);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(82, 30, 146, 28);
		panel_2.add(textField_5);
		
		button_1 = new JButton("...");
		button_1.setBounds(227, 30, 37, 28);
		panel_2.add(button_1);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setPreferredSize(new Dimension(50, 16));
		lblPrecio.setFont(new Font("Serif", Font.PLAIN, 14));
		lblPrecio.setBounds(332, 34, 74, 19);
		panel_2.add(lblPrecio);
		
		textField_6 = new JTextField();
		textField_6.setBackground(SystemColor.control);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(387, 30, 99, 28);
		panel_2.add(textField_6);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setFont(new Font("Serif", Font.BOLD, 14));
		btnAgregar.setBackground(new Color(128, 128, 0));
		btnAgregar.setBounds(260, 74, 105, 30);
		panel_2.add(btnAgregar);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setPreferredSize(new Dimension(50, 16));
		lblCantidad.setFont(new Font("Serif", Font.PLAIN, 14));
		lblCantidad.setBounds(18, 80, 74, 19);
		panel_2.add(lblCantidad);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(82, 76, 90, 28);
		panel_2.add(textField_10);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
	}
}
