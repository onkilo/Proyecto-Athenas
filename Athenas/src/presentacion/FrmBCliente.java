package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import util.ClienteTableModel;

import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import entidades.Cliente;
import negocio.NegocioCliente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmBCliente extends JDialog implements KeyListener, ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBuscar;
	private JTable tblCliente;

	private ButtonGroup btnG;
	private JRadioButton rdbtPorCodigo;
	private JRadioButton rdbtPorNombre;
	private JButton btnResetear;
	private JLabel lblBuscar;
	private JScrollPane scrollPane;
	
	private ClienteTableModel modelo;
	private NegocioCliente nCliente = new NegocioCliente();
	private FrmDetVentas vent;

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
			FrmBCliente dialog = new FrmBCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmBCliente() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 750, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(
				new TitledBorder(null, "Buscar producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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

		rdbtPorNombre = new JRadioButton("Por Nombre");
		rdbtPorNombre.setFont(new Font("Serif", Font.PLAIN, 16));
		panel.add(rdbtPorNombre, "cell 1 0");

		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		contentPanel.add(panel, "cell 0 2 3 1,grow");
		panel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.control);
		panel.add(scrollPane, BorderLayout.CENTER);

		tblCliente = new JTable();
		tblCliente.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tblCliente.addMouseListener(this);
		tblCliente.setRowHeight(20);
		tblCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblCliente);
		
		btnG = new ButtonGroup();
		btnG.add(rdbtPorNombre);
		btnG.add(rdbtPorCodigo);
		
		rdbtPorCodigo.setSelected(true);
		
		modelo = new ClienteTableModel();
		tblCliente.setModel(modelo);
		
		modelo.setData(nCliente.Listar());
	}
	
	public FrmBCliente (FrmDetVentas vent){
		this();
		this.vent = vent;
		setLocationRelativeTo(vent);
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
		ArrayList<Cliente> busqueda = new ArrayList<Cliente>();
		String patron = txtBuscar.getText();
		if (rdbtPorCodigo.isSelected()) {
			busqueda = nCliente.getClientesByID(patron);
		} else if (rdbtPorNombre.isSelected()) {
			busqueda = nCliente.getClientesByNombre(patron);
		}

		modelo.setData(busqueda);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnResetear) {
			actionPerformedBtnResetear(arg0);
		}
	}
	protected void actionPerformedBtnResetear(ActionEvent arg0) {
		txtBuscar.setText("");
		modelo.setData(nCliente.Listar());
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblCliente) {
			mouseClickedTblCliente(arg0);
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
	protected void mouseClickedTblCliente(MouseEvent e) {
		if(e.getClickCount() ==2){
			if(this.vent != null){
				int fila = tblCliente.getSelectedRow();
				Cliente cli = modelo.getCliente(fila);
				this.vent.CargarCliente(cli);
				this.dispose();
			}
		}
	}
}
