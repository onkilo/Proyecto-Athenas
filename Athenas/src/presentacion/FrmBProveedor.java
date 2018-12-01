package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import util.ProveedorTableModel;

import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import entidades.Cliente;
import entidades.Proveedor;
import negocio.NegocioProveedor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class FrmBProveedor extends JDialog implements KeyListener, ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBuscar;
	private JTable tblProveedor;

	private ButtonGroup btnG;
	private JRadioButton rdbtPorCodigo;
	private JRadioButton rdbtPorRazon;
	private JButton btnResetear;
	private JLabel lblBuscar;
	private JScrollPane scrollPane;
	private ProveedorTableModel modelo;
	private NegocioProveedor nProv = new NegocioProveedor();
	private FrmDetComp vent;

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
			FrmBProveedor dialog = new FrmBProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmBProveedor() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 750, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(
				new TitledBorder(null, "Buscar proveedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[100px:n][250px:n][grow]", "[][][grow]"));

		lblBuscar = new JLabel("Buscar");
		contentPanel.add(lblBuscar, "cell 0 0,alignx center");

		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		contentPanel.add(txtBuscar, "cell 1 0,alignx leading");
		txtBuscar.setColumns(20);

		btnResetear = new JButton("Resetear");
		btnResetear.addActionListener(this);
		btnResetear.setFont(new Font("Serif", Font.BOLD, 14));
		btnResetear.setForeground(new Color(255, 255, 255));
		btnResetear.setBackground(new Color(128, 128, 0));
		contentPanel.add(btnResetear, "cell 2 0,alignx leading");

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		contentPanel.add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[89px][grow]", "[22px]"));

		rdbtPorCodigo = new JRadioButton("Por c\u00F3digo");
		rdbtPorCodigo.setFont(new Font("Serif", Font.PLAIN, 16));
		panel.add(rdbtPorCodigo, "cell 0 0,alignx left,aligny top");

		rdbtPorRazon = new JRadioButton("Por Razon social");
		rdbtPorRazon.setFont(new Font("Serif", Font.PLAIN, 16));
		panel.add(rdbtPorRazon, "cell 1 0");

		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		contentPanel.add(panel, "cell 0 2 3 1,grow");
		panel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.control);
		panel.add(scrollPane, BorderLayout.CENTER);

		tblProveedor = new JTable();
		tblProveedor.setRowHeight(20);
		tblProveedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblProveedor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tblProveedor.addMouseListener(this);
		scrollPane.setViewportView(tblProveedor);
		
		modelo = new ProveedorTableModel();
		tblProveedor.setModel(modelo);
		
		btnG = new ButtonGroup();
		btnG.add(rdbtPorRazon);
		btnG.add(rdbtPorCodigo);
		
		rdbtPorCodigo.setSelected(true);
	}
	
	public FrmBProveedor(FrmDetComp vent){
		this();
		this.vent = vent;
		setLocationRelativeTo(this.vent);
		modelo.setData(nProv.Listar());
	}

	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscar) {
			keyReleasedTextField(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTextField(KeyEvent e) {
		ArrayList<Proveedor> busqueda = new ArrayList<Proveedor>();
		String patron = txtBuscar.getText();
		if (rdbtPorCodigo.isSelected()) {
			busqueda = nProv.getProveedoresByID(patron);
		} else if (rdbtPorRazon.isSelected()) {
			busqueda = nProv.getProveedoresByRzSocial(patron);
		}
		modelo.setData(busqueda);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnResetear) {
			actionPerformedBtnResetear(e);
		}
	}
	protected void actionPerformedBtnResetear(ActionEvent e) {
		txtBuscar.setText("");
		modelo.setData(nProv.Listar());
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblProveedor) {
			mouseClickedTblProveedor(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTblProveedor(MouseEvent e) {
		if(e.getClickCount() ==2){
			if(this.vent != null){
				int fila = tblProveedor.getSelectedRow();
				Proveedor prov = modelo.getProveedor(fila);
				this.vent.CargarProveedor(prov);
				this.dispose();
			}
		}
	}
}
