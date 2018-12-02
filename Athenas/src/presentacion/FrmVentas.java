package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.Reporte;
import util.VentaTableModel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import conexion.Conexion;
import entidades.Trabajador;
import entidades.Venta;
import negocio.NegocioVenta;

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
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class FrmVentas extends JInternalFrame implements KeyListener, ActionListener {
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_5;
	private JScrollPane scrollPane;
	private JTable tblVentas;
	private JTextField txtBuscar;
	private JButton btnResetear;
	private JButton btnImprimir;
	private JPanel panel_6;
	private JRadioButton rdbtnPorCodigo;
	private JLabel lblBuscar;
	
	private VentaTableModel modelo;
	private ButtonGroup btnG;
	private JRadioButton rdbtnPorCli;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JPanel panel_2;
	private JLabel lblCantidadDeVentas;
	private JTextField txtCant;
	
	private NegocioVenta nVent = new NegocioVenta();

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
					FrmVentas frame = new FrmVentas();
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
	public FrmVentas() {
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
		panel.setLayout(new MigLayout("", "[150px:n][grow]", "[50px:n][50px:n][50px:n][50px:n][50px:n][50px:n][]"));
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.control);
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel.add(panel_2, "cell 0 1 2 1,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[50px:n][50px:n][50px:n]"));
		
		btnNuevo = new JButton("Nueva venta");
		btnNuevo.addActionListener(this);
		btnNuevo.setHorizontalAlignment(SwingConstants.LEADING);
		btnNuevo.setIcon(new ImageIcon(FrmVentas.class.getResource("/img/icon-nuevo-white.png")));
		btnNuevo.setFont(new Font("Serif", Font.BOLD, 14));
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setBackground(new Color(138, 43, 226));
		panel_2.add(btnNuevo, "cell 0 0,alignx center");
		btnNuevo.setPreferredSize(new Dimension(150, 40));
		
		btnModificar = new JButton("Modificar venta");
		btnModificar.addActionListener(this);
		btnModificar.setHorizontalAlignment(SwingConstants.LEADING);
		btnModificar.setIcon(new ImageIcon(FrmVentas.class.getResource("/img/icon-modificar-white.png")));
		btnModificar.setFont(new Font("Serif", Font.BOLD, 14));
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(new Color(138, 43, 226));
		panel_2.add(btnModificar, "cell 0 1,alignx center");
		btnModificar.setPreferredSize(new Dimension(150, 40));
		
		btnEliminar = new JButton("Eliminar venta");
		btnEliminar.addActionListener(this);
		btnEliminar.setHorizontalAlignment(SwingConstants.LEADING);
		btnEliminar.setIcon(new ImageIcon(FrmVentas.class.getResource("/img/icon-eliminar-white.png")));
		btnEliminar.setFont(new Font("Serif", Font.BOLD, 14));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(138, 43, 226));
		panel_2.add(btnEliminar, "cell 0 2,alignx center");
		btnEliminar.setPreferredSize(new Dimension(150, 40));
		
		lblCantidadDeVentas = new JLabel("Cantidad de ventas");
		lblCantidadDeVentas.setFont(new Font("Serif", Font.BOLD, 14));
		panel.add(lblCantidadDeVentas, "cell 0 5,alignx center");
		
		txtCant = new JTextField();
		panel.add(txtCant, "cell 1 5,alignx leading");
		txtCant.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBorder(new TitledBorder(null, "Listado de ventas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		getContentPane().add(panel_1, "cell 1 0,grow");
		panel_1.setLayout(new MigLayout("", "[100px:n][grow][grow]", "[][][grow][]"));
		
		lblBuscar = new JLabel("Buscar ");
		lblBuscar.setFont(new Font("Serif", Font.PLAIN, 16));
		panel_1.add(lblBuscar, "cell 0 0,alignx center");
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		panel_1.add(txtBuscar, "cell 1 0,growx");
		txtBuscar.setColumns(20);
		
		btnResetear = new JButton("");
		btnResetear.setMinimumSize(new Dimension(25, 25));
		btnResetear.setIcon(new ImageIcon(FrmVentas.class.getResource("/img/icon-resetear-white.png")));
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
		
		rdbtnPorCli = new JRadioButton("Por Cliente");
		rdbtnPorCli.setFont(new Font("Serif", Font.PLAIN, 16));
		panel_6.add(rdbtnPorCli, "cell 1 0,alignx left,aligny top");
		
		panel_5 = new JPanel();
		panel_1.add(panel_5, "cell 0 2 3 1,grow");
		panel_5.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.control);
		panel_5.add(scrollPane, BorderLayout.CENTER);
		
		tblVentas = new JTable();
		tblVentas.setRowHeight(20);
		tblVentas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblVentas.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scrollPane.setViewportView(tblVentas);
		setBounds(0, 0, 1100, 600);
		
		modelo = new VentaTableModel();
		tblVentas.setModel(modelo);
		
		btnImprimir = new JButton("");
		btnImprimir.addActionListener(this);
		btnImprimir.setIcon(new ImageIcon(FrmVentas.class.getResource("/img/icon-imprimir-white.png")));
		panel_1.add(btnImprimir, "cell 2 3,alignx trailing");
		btnImprimir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnImprimir.setForeground(new Color(255, 255, 255));
		btnImprimir.setBackground(new Color(128, 128, 0));
		btnImprimir.setPreferredSize(new Dimension(100, 30));

		
		btnG = new ButtonGroup();
		btnG.add(rdbtnPorCodigo);
		btnG.add(rdbtnPorCli);
		
		modelo.setData(nVent.Listar());
		txtCant.setText(modelo.getRowCount() + "");
		
		rdbtnPorCodigo.setSelected(true);

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
		ArrayList<Venta> busqueda = new ArrayList<Venta>();
		String patron = txtBuscar.getText();
		if (rdbtnPorCodigo.isSelected()) {
			busqueda = nVent.getVentasByID(patron);
		} else if (rdbtnPorCli.isSelected()) {
			busqueda = nVent.getVentasByCliente(patron);
		}
		modelo.setData(busqueda);
		txtCant.setText(modelo.getRowCount() + "");
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnImprimir) {
			actionPerformedBtnImprimir(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
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
		modelo.setData(nVent.Listar());
		txtCant.setText(modelo.getRowCount() + "");
	}
	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		FrmDetVentas formDet = new FrmDetVentas();
		formDet.setLocationRelativeTo(this);
		formDet.setVisible(true);
		formDet.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
				modelo.setData(nVent.Listar());
			}
		});
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		if(!tblVentas.getSelectionModel().isSelectionEmpty()){
			int fila = tblVentas.getSelectedRow();
			Venta venta = modelo.getVenta(fila);
			FrmDetVentas formDet = new FrmDetVentas(venta);
			formDet.setLocationRelativeTo(this);
			formDet.setVisible(true);
			formDet.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					super.windowClosed(e);
					modelo.setData(nVent.Listar());
				}
			});
		}else{
			JOptionPane.showInternalMessageDialog(this, "Debe selecionar un registro para realizar esta operaci�n", "Seleci�n Err�nea", JOptionPane.WARNING_MESSAGE);
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		if(!tblVentas.getSelectionModel().isSelectionEmpty()){
			int confirmar =JOptionPane.showInternalConfirmDialog(this, "�Desea eliminar este registro?", "Confirmaci�n", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(confirmar == JOptionPane.YES_OPTION){
				int fila = tblVentas.getSelectedRow();
				Venta venta = modelo.getVenta(fila);
				nVent.EliminarVenta(venta);
				JOptionPane.showInternalMessageDialog(this, "Registro eliminado satisfactoriamente", "Eliminaci�n", JOptionPane.INFORMATION_MESSAGE);
				modelo.setData(nVent.Listar());
			}
			
		}
		else{
			JOptionPane.showInternalMessageDialog(this, "Debe selecionar un registro para realizar esta operaci�n", "Seleci�n Err�nea", JOptionPane.WARNING_MESSAGE);
		}
	}
	protected void actionPerformedBtnImprimir(ActionEvent arg0) {
		if(!tblVentas.getSelectionModel().isSelectionEmpty()){
			int fila = tblVentas.getSelectedRow();
			Venta venta = modelo.getVenta(fila);
			Map<String, Object> param = new HashMap<>();
			param.put("CodVenta", venta.getCodVenta());
			Reporte.CreaReporte("/reportes/CDP.jasper", param);
		}
	}
	
}
