package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import util.CateTableModel;
import util.Comunes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

import entidades.CategoriaProducto;
import negocio.NegocioCategoria;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCategoria extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JPanel panel_2;
	private JLabel lblCdigo;
	private JLabel lblDescripcin;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable tblCategoria;

	private CateTableModel modelo;
	private NegocioCategoria nCat = new NegocioCategoria();
	Comunes comon = new Comunes();
	String opGuardar = "";

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
			FrmCategoria dialog = new FrmCategoria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmCategoria() {
		setModal(true);
		setResizable(false);
		setTitle("Mantenimiento | Categor\u00EDas");
		setBounds(100, 100, 747, 441);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(153, 180, 209));
		contentPanel.setBorder(new EmptyBorder(5, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[350px:n][250px:n,grow]", "[][grow]"));

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Categor\u00EDa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(SystemColor.control);
		contentPanel.add(panel_2, "cell 0 0,grow");
		panel_2.setLayout(new MigLayout("", "[grow][grow]", "[50px:n][50px:n][]"));

		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setPreferredSize(new Dimension(100, 16));
		lblCdigo.setFont(new Font("Serif", Font.PLAIN, 14));
		panel_2.add(lblCdigo, "cell 0 0,alignx center");

		txtCodigo = new JTextField();
		txtCodigo.setBackground(SystemColor.control);
		txtCodigo.setEditable(false);
		panel_2.add(txtCodigo, "cell 1 0,alignx leading");
		txtCodigo.setColumns(8);

		lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setPreferredSize(new Dimension(100, 16));
		lblDescripcin.setFont(new Font("Serif", Font.PLAIN, 14));
		panel_2.add(lblDescripcin, "cell 0 1,alignx center");

		txtDescripcion = new JTextField();
		panel_2.add(txtDescripcion, "cell 1 1,alignx leading");
		txtDescripcion.setColumns(18);

		panel_3 = new JPanel();
		FlowLayout fl_panel_3 = (FlowLayout) panel_3.getLayout();
		fl_panel_3.setHgap(20);
		panel_3.setBackground(SystemColor.menu);
		panel_2.add(panel_3, "cell 0 2 2 1,grow");

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setPreferredSize(new Dimension(80, 35));
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnGuardar.setEnabled(false);
		btnGuardar.setBackground(new Color(128, 128, 0));
		panel_3.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setPreferredSize(new Dimension(80, 35));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCancelar.setEnabled(false);
		btnCancelar.setBackground(new Color(128, 128, 0));
		panel_3.add(btnCancelar);

		panel_4 = new JPanel();
		panel_4.setBorder(
				new TitledBorder(null, "Lista de categor\u00EDas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(SystemColor.control);
		contentPanel.add(panel_4, "cell 1 0 1 2,grow");
		panel_4.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_4.add(scrollPane, BorderLayout.CENTER);

		tblCategoria = new JTable();
		tblCategoria.setFont(new Font("Serif", Font.PLAIN, 14));
		tblCategoria.setRowHeight(20);
		tblCategoria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblCategoria);

		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(SystemColor.menu);
		contentPanel.add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[grow]", "[50px:n]"));

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.controlShadow, 2));
		panel_1.setBackground(SystemColor.menu);
		panel.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow]", "[]"));

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setPreferredSize(new Dimension(80, 35));
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNuevo.setBackground(new Color(138, 43, 226));
		panel_1.add(btnNuevo, "cell 0 0,alignx center");

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setPreferredSize(new Dimension(80, 35));
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnModificar.setBackground(new Color(138, 43, 226));
		panel_1.add(btnModificar, "cell 1 0,alignx center");

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setPreferredSize(new Dimension(80, 35));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEliminar.setBackground(new Color(138, 43, 226));
		panel_1.add(btnEliminar, "cell 2 0,alignx center");

		modelo = new CateTableModel();
		tblCategoria.setModel(modelo);
		modelo.setData(nCat.Listar());

		AjustaColumna(tblCategoria.getColumnModel().getColumn(0), 100);
		Habilita(false);
		
		tblCategoria.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!tblCategoria.getSelectionModel().isSelectionEmpty()){
					int fila = tblCategoria.getSelectedRow();
					CategoriaProducto obj = modelo.getCategoria(fila);
					LlenaDatos(obj);
				}
				
			}
		});
	}
	
	private void AjustaColumna(TableColumn col, int tam){
		col.setMinWidth(tam);
		col.setPreferredWidth(tam);
		col.setMaxWidth(tam);
	}
	
	private void Habilita(boolean estado){
		comon.habTextField(txtDescripcion, estado);
		btnGuardar.setEnabled(estado);
		btnCancelar.setEnabled(estado);
		
	}
	
	private void LlenaDatos(CategoriaProducto obj){
		txtCodigo.setText(obj.getID());
		txtDescripcion.setText(obj.getDescripcion());
	}
	
	private CategoriaProducto LeerCategoria() {
		CategoriaProducto obj = new CategoriaProducto();
		obj.setID(txtCodigo.getText());
		obj.setDescripcion(txtDescripcion.getText());
		return obj;
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(arg0);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);

		Habilita(true);
		txtDescripcion.setText("");
		txtCodigo.setText(nCat.nextCod());
		opGuardar = "Nuevo";
		tblCategoria.setEnabled(false);
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		if (!txtCodigo.getText().equals("")) {
			btnNuevo.setEnabled(false);
			btnEliminar.setEnabled(false);

			Habilita(true);
			opGuardar = "Modificar";
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para realzar esta acci�n",
					"Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		txtCodigo.setText("");
		Habilita(false);
		btnNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
		tblCategoria.setEnabled(true);

		if (!tblCategoria.getSelectionModel().isSelectionEmpty()) {
			int fila = tblCategoria.getSelectedRow();
			LlenaDatos(modelo.getCategoria(fila));
		}
	}
	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		if(comon.ValidaTexto(txtDescripcion.getText())){
			if (opGuardar.equals("Nuevo")) {
				nCat.InsertarCate(LeerCategoria());
				txtDescripcion.setText("");
				txtCodigo.setText(nCat.nextCod());
			} else if (opGuardar.equals("Modificar")) {
				nCat.ModificarCate(LeerCategoria());
			}
			modelo.setData(nCat.Listar());
		}
		else{
			JOptionPane.showMessageDialog(this, "Descripci�n inv�lida", "Error de ingreso de datos", JOptionPane.ERROR_MESSAGE);
			txtDescripcion.grabFocus();
		}
	}

	
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		if (!tblCategoria.getSelectionModel().isSelectionEmpty()) {
			int confirmar = JOptionPane.showConfirmDialog(this, "�Desea eliminar este regitro?", "Precauci�n",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (confirmar == JOptionPane.YES_OPTION) {
				String cod = txtCodigo.getText();
				nCat.EliminarCate(cod);
				modelo.setData(nCat.Listar());
				txtCodigo.setText("");
				txtDescripcion.setText("");
				JOptionPane.showMessageDialog(this, "Registro eliminado", "Confirmaci�n",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para realzar esta acci�n",
					"Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}
}
