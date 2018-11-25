package util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entidades.Proveedor;

public class ProveedorTableModel extends AbstractTableModel {

	// Listado de los datos del modelo <Proveedor>
	private ArrayList<Proveedor> data;
	// Columnas de la tabla
	private String[] columnas = { "Código", "Razón social", "Representante", "Email", "Telefono", "Dirección" };

	public ProveedorTableModel() {
		data = new ArrayList<Proveedor>();
	}

	public ProveedorTableModel(ArrayList<Proveedor> data) {
		this.data = data;
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public String getColumnName(int column) {
		return columnas[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Proveedor obj = data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return obj.getID();
		case 1:
			return obj.getRaz_Soc();
		case 2:
			return obj.getRepresentante();
		case 3:
			return obj.getEmail();
		case 4:
			return obj.getTelf();
		case 5:
			return obj.getDireccion();
		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public Proveedor getProveedor(int row) {
		return data.get(row);
	}

	// para añadir un proveedor al modelo
	public void addProveedor(Proveedor obj) {
		data.add(obj);
		fireTableRowsInserted(getRowCount(), getRowCount());
	}

	// para elimininar un proveedor del modelo
	public void deleteProveedor(int row) {
		data.remove(row);
		fireTableRowsDeleted(row, row);
	}

	// para modificar un proveedor del modelo
	public void updateProveedor(int row, Proveedor obj) {
		data.set(row, obj);
		fireTableRowsUpdated(row, row);
	}

	public void clearData() {
		data.clear();
		fireTableDataChanged();
	}

	public ArrayList<Proveedor> getData() {
		return this.data;
	}

	public void setData(ArrayList<Proveedor> data) {
		this.data = data;
		fireTableDataChanged();
	}
}
