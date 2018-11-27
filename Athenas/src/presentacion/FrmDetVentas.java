package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import util.DetVentaTableModel;

import java.awt.SystemColor;
import java.time.LocalDate;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import com.github.lgooddatepicker.components.DatePicker;

import entidades.Cliente;
import entidades.Producto;
import entidades.Venta;
import negocio.NegocioDetVenta;
import negocio.NegocioVenta;

import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;

public class FrmDetVentas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblTotal;
	private JTextField txtTotal;
	private JLabel lblCdigo;
	private JLabel lblFecha;
	private JTextField txtCodigo;
	private DatePicker dpFecha;
	private JLabel lblBodegaAthenas;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JTextField txtDni;
	private JTextField txtCliNombre;
	private JButton btnBuscarCliente;
	private JLabel lblTelfono;
	private JTextField txtCliTel;
	private JLabel lblVendedor;
	private JTextField txtVendedor;
	private JLabel lblRuc;
	private JPanel panel_2;
	private JLabel lblProducto;
	private JTextField txtPodDesc;
	private JButton btnBuscarProd;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblStock;
	private JTextField txtStock;
	private JLabel lblDescuento;
	private JTextField txtDescuento;
	private JButton btnAgregar;
	private JButton btnEliminarDetalle;
	private JButton btnModificarDetalle;
	private JButton btnCancelarVenta;
	private JButton btnRegistrarVenta;
	private JButton btnImprimirVenta;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JScrollPane scrollPane;
	private JTable tblDetalle;
	private JTextField textField_11;
	private JLabel lblIgvS;
	private JTextField txtDescuentoTotal;
	private JLabel lblDescuentoS;
	private JLabel lblSubtotalS;
	private JTextField txtSubtotal;
	
	private NegocioVenta nVent = new NegocioVenta();
	private NegocioDetVenta nDet = new NegocioDetVenta();
	private Producto prod = null;
	private Cliente cli = null;
	private DetVentaTableModel modelo;

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
			FrmDetVentas dialog = new FrmDetVentas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmDetVentas() {
		setModal(true);
		setBounds(100, 100, 850, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(7, 6, 322, 254);
		panel.setBorder(new TitledBorder(null, "Venta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
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
		
		txtCodigo = new JTextField();
		txtCodigo.setBackground(SystemColor.control);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(114, 111, 122, 28);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(33, 156, 50, 25);
		lblFecha.setPreferredSize(new Dimension(50, 25));
		lblFecha.setFont(new Font("Serif", Font.BOLD, 14));
		panel.add(lblFecha);
		
		dpFecha = new DatePicker();
		dpFecha.getComponentDateTextField().setBackground(SystemColor.control);
		dpFecha.getComponentDateTextField().setEditable(false);
		dpFecha.getComponentDateTextField().setDisabledTextColor(Color.BLACK);
		dpFecha.getComponentToggleCalendarButton().setIcon(new ImageIcon(FrmDetVentas.class.getResource("/img/icon-calendario-black.png")));
		dpFecha.getComponentToggleCalendarButton().setText("");
		dpFecha.setBackground(SystemColor.control);
		dpFecha.setBounds(114, 155, 202, 28);
		dpFecha.getComponentToggleCalendarButton().setPreferredSize(new Dimension(41, 28));
		dpFecha.getComponentDateTextField().setPreferredSize(new Dimension(159, 25));
		dpFecha.getComponentToggleCalendarButton().setBounds(155, -2, 41, 28);
		dpFecha.getComponentDateTextField().setBounds(0, 0, 159, 25);
		dpFecha.setPreferredSize(new Dimension(203, 28));
		panel.add(dpFecha);
		dpFecha.setLayout(null);
		
		lblRuc = new JLabel("R.U.C. : 0000000000");
		lblRuc.setBounds(31, 53, 249, 50);
		lblRuc.setFont(new Font("Serif", Font.BOLD, 14));
		lblRuc.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblRuc);
		
		lblVendedor = new JLabel("Vendedor");
		lblVendedor.setBounds(32, 205, 59, 25);
		lblVendedor.setPreferredSize(new Dimension(50, 25));
		lblVendedor.setFont(new Font("Serif", Font.BOLD, 14));
		panel.add(lblVendedor);
		
		txtVendedor = new JTextField();
		txtVendedor.setBackground(SystemColor.control);
		txtVendedor.setEditable(false);
		txtVendedor.setBounds(114, 204, 191, 28);
		panel.add(txtVendedor);
		txtVendedor.setColumns(15);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(332, 7, 495, 117);
		panel_1.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(21, 30, 50, 19);
		lblDni.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDni.setPreferredSize(new Dimension(50, 16));
		panel_1.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBackground(SystemColor.control);
		txtDni.setEditable(false);
		txtDni.setBounds(83, 26, 122, 28);
		panel_1.add(txtDni);
		txtDni.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(21, 75, 50, 19);
		lblNombre.setFont(new Font("Serif", Font.PLAIN, 14));
		lblNombre.setPreferredSize(new Dimension(50, 16));
		panel_1.add(lblNombre);
		
		btnBuscarCliente = new JButton("...");
		btnBuscarCliente.setBounds(217, 26, 37, 28);
		panel_1.add(btnBuscarCliente);
		
		lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(309, 75, 50, 19);
		lblTelfono.setFont(new Font("Serif", Font.PLAIN, 14));
		lblTelfono.setPreferredSize(new Dimension(50, 16));
		panel_1.add(lblTelfono);
		
		txtCliNombre = new JTextField();
		txtCliNombre.setBackground(SystemColor.control);
		txtCliNombre.setEditable(false);
		txtCliNombre.setBounds(83, 71, 198, 28);
		panel_1.add(txtCliNombre);
		txtCliNombre.setColumns(20);
		
		txtCliTel = new JTextField();
		txtCliTel.setBackground(SystemColor.control);
		txtCliTel.setEditable(false);
		txtCliTel.setBounds(371, 71, 106, 28);
		panel_1.add(txtCliTel);
		txtCliTel.setColumns(10);
		
		panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.control);
		panel_3.setBounds(7, 267, 820, 388);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.control);
		panel_4.setBounds(7, 7, 602, 284);
		panel_4.setBorder(new TitledBorder(null, "Detalle", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.control);
		panel_4.add(scrollPane, BorderLayout.CENTER);
		
		tblDetalle = new JTable();
		tblDetalle.setRowHeight(20);
		tblDetalle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblDetalle);
		
		panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.control);
		panel_5.setBorder(new LineBorder(new Color(180, 180, 180), 2));
		panel_5.setBounds(614, 16, 200, 254);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		btnEliminarDetalle = new JButton("Eliminar detalle");
		btnEliminarDetalle.setBackground(new Color(75, 0, 130));
		btnEliminarDetalle.setForeground(Color.WHITE);
		btnEliminarDetalle.setFont(new Font("Serif", Font.BOLD, 14));
		btnEliminarDetalle.setBounds(34, 17, 134, 35);
		panel_5.add(btnEliminarDetalle);
		
		btnModificarDetalle = new JButton("Modificar detalle");
		btnModificarDetalle.setBackground(new Color(75, 0, 130));
		btnModificarDetalle.setForeground(Color.WHITE);
		btnModificarDetalle.setFont(new Font("Serif", Font.BOLD, 14));
		btnModificarDetalle.setBounds(34, 52, 134, 35);
		panel_5.add(btnModificarDetalle);
		
		btnCancelarVenta = new JButton("Cancelar venta");
		btnCancelarVenta.setBackground(new Color(75, 0, 130));
		btnCancelarVenta.setForeground(Color.WHITE);
		btnCancelarVenta.setFont(new Font("Serif", Font.BOLD, 14));
		btnCancelarVenta.setBounds(34, 160, 134, 35);
		panel_5.add(btnCancelarVenta);
		
		btnRegistrarVenta = new JButton("Registrar venta");
		btnRegistrarVenta.setBackground(new Color(75, 0, 130));
		btnRegistrarVenta.setForeground(Color.WHITE);
		btnRegistrarVenta.setFont(new Font("Serif", Font.BOLD, 14));
		btnRegistrarVenta.setBounds(34, 120, 134, 35);
		panel_5.add(btnRegistrarVenta);
		
		btnImprimirVenta = new JButton("Imprimir venta");
		btnImprimirVenta.setBackground(new Color(75, 0, 130));
		btnImprimirVenta.setForeground(Color.WHITE);
		btnImprimirVenta.setFont(new Font("Serif", Font.BOLD, 14));
		btnImprimirVenta.setBounds(34, 198, 134, 35);
		panel_5.add(btnImprimirVenta);
		
		lblTotal = new JLabel("Total S/. ");
		lblTotal.setBounds(400, 358, 90, 19);
		lblTotal.setFont(new Font("Serif", Font.BOLD, 14));
		panel_3.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(487, 354, 122, 28);
		panel_3.add(txtTotal);
		txtTotal.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(235, 354, 122, 28);
		panel_3.add(textField_11);
		
		lblIgvS = new JLabel("IGV S/. ");
		lblIgvS.setFont(new Font("Serif", Font.BOLD, 14));
		lblIgvS.setBounds(148, 358, 90, 19);
		panel_3.add(lblIgvS);
		
		txtDescuentoTotal = new JTextField();
		txtDescuentoTotal.setColumns(10);
		txtDescuentoTotal.setBounds(487, 303, 122, 28);
		panel_3.add(txtDescuentoTotal);
		
		lblDescuentoS = new JLabel("Descuento S/. ");
		lblDescuentoS.setFont(new Font("Serif", Font.BOLD, 14));
		lblDescuentoS.setBounds(400, 307, 90, 19);
		panel_3.add(lblDescuentoS);
		
		lblSubtotalS = new JLabel("Subtotal S/. ");
		lblSubtotalS.setFont(new Font("Serif", Font.BOLD, 14));
		lblSubtotalS.setBounds(148, 311, 90, 19);
		panel_3.add(lblSubtotalS);
		
		txtSubtotal = new JTextField();
		txtSubtotal.setColumns(10);
		txtSubtotal.setBounds(235, 307, 122, 28);
		panel_3.add(txtSubtotal);
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.control);
		panel_2.setBorder(new TitledBorder(null, "Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_2.setBounds(334, 128, 493, 132);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		lblProducto = new JLabel("Producto");
		lblProducto.setPreferredSize(new Dimension(50, 16));
		lblProducto.setFont(new Font("Serif", Font.PLAIN, 14));
		lblProducto.setBounds(18, 26, 74, 19);
		panel_2.add(lblProducto);
		
		txtPodDesc = new JTextField();
		txtPodDesc.setBackground(SystemColor.control);
		txtPodDesc.setEditable(false);
		txtPodDesc.setColumns(10);
		txtPodDesc.setBounds(82, 22, 146, 28);
		panel_2.add(txtPodDesc);
		
		btnBuscarProd = new JButton("...");
		btnBuscarProd.setBounds(228, 22, 37, 28);
		panel_2.add(btnBuscarProd);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setPreferredSize(new Dimension(50, 16));
		lblPrecio.setFont(new Font("Serif", Font.PLAIN, 14));
		lblPrecio.setBounds(291, 26, 74, 19);
		panel_2.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBackground(SystemColor.control);
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(372, 22, 99, 28);
		panel_2.add(txtPrecio);
		
		lblStock = new JLabel("Stock");
		lblStock.setPreferredSize(new Dimension(50, 16));
		lblStock.setFont(new Font("Serif", Font.PLAIN, 14));
		lblStock.setBounds(18, 57, 74, 19);
		panel_2.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setBackground(SystemColor.control);
		txtStock.setEditable(false);
		txtStock.setColumns(10);
		txtStock.setBounds(82, 57, 90, 28);
		panel_2.add(txtStock);
		
		lblDescuento = new JLabel("Descuento");
		lblDescuento.setPreferredSize(new Dimension(50, 16));
		lblDescuento.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDescuento.setBounds(291, 57, 74, 19);
		panel_2.add(lblDescuento);
		
		txtDescuento = new JTextField();
		txtDescuento.setBackground(SystemColor.control);
		txtDescuento.setEditable(false);
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(372, 53, 99, 28);
		panel_2.add(txtDescuento);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setFont(new Font("Serif", Font.BOLD, 14));
		btnAgregar.setBackground(new Color(128, 128, 0));
		btnAgregar.setBounds(239, 88, 105, 30);
		panel_2.add(btnAgregar);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setPreferredSize(new Dimension(50, 16));
		lblCantidad.setFont(new Font("Serif", Font.PLAIN, 14));
		lblCantidad.setBounds(18, 96, 74, 19);
		panel_2.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(82, 90, 90, 28);
		panel_2.add(txtCantidad);
		
		modelo = new DetVentaTableModel();
		tblDetalle.setModel(modelo);
		
		dpFecha.setDate(LocalDate.now());
		
		txtCodigo.setText(nVent.nextCod());
		
		if (FrmPrincipal.currentUser != null)
			txtVendedor.setText(FrmPrincipal.currentUser.getNombre() + " " + FrmPrincipal.currentUser.getApellido());
	}
	
	public FrmDetVentas(Venta venta){
		
	}
	
	private void miInit(){
		
	}
	
	public void CagarProducto(Producto prod){
		this.prod = prod;
		txtPodDesc.setText(prod.getDescripcion());
		txtPrecio.setText(prod.getPreVenta() + "");
		txtStock.setText(prod.getStockAcual() + "");
	}
	
	public void CargarCliente(Cliente cli){
		this.cli = cli;
		txtDni.setText(cli.getDni());
		txtCliNombre.setText(cli.getNombre() + " " + cli.getApellido());
		txtCliTel.setText(cli.getTelefono());
	}
}
