package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class FrmBProveedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable tblProveedor;

	private ButtonGroup btnG;
	private JRadioButton rdbtPorCodigo;
	private JRadioButton rdbtPorRazon;
	private JButton btnResetear;
	private JLabel lblBuscar;
	private JScrollPane scrollPane;

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

		textField = new JTextField();
		contentPanel.add(textField, "cell 1 0,alignx leading");
		textField.setColumns(20);

		btnResetear = new JButton("Resetear");
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
		scrollPane.setViewportView(tblProveedor);
		
		btnG = new ButtonGroup();
		btnG.add(rdbtPorRazon);
		btnG.add(rdbtPorCodigo);
		
		rdbtPorCodigo.setSelected(true);
	}

}