package util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entidades.Proveedor;
import entidades.Trabajador;

public class TrabajadorTableModel extends AbstractTableModel {

	private ArrayList<Trabajador> data;
	private String[] columnas = { "Código", "Nombre", "Teléfono", "DNI", "Dirección", "Correo", "Sexo", "Cargo" };

	public TrabajadorTableModel() {
		data = new ArrayList<Trabajador>();
	}

	public TrabajadorTableModel(ArrayList<Trabajador> data) {
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
		Trabajador obj = data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return obj.getID();
		case 1:
			return obj.getNombre() + " " + obj.getApellido();
		case 2:
			return obj.getTelf();
		case 3:
			return obj.getDNI();
		case 4:
			return obj.getDireccion();
		case 5:
			return obj.getEmail();
		case 6:
			if (obj.getSexo().equalsIgnoreCase("M"))
				return "Masculino";
			else
				return "Femenino";
		case 7:
			return obj.getRol();
		default:
			return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public Trabajador getTrabajador(int row) {
		return data.get(row);
	}

	// para añadir un trabajador al modelo
	public void addTrabajador(Trabajador obj) {
		data.add(obj);
		fireTableRowsInserted(getRowCount(), getRowCount());
	}

	// para elimininar un trabajador del modelo
	public void deleteTrabajador(int row) {
		data.remove(row);
		fireTableRowsDeleted(row, row);
	}

	// para modificar un trabajador del modelo
	public void updateTrabajador(int row, Trabajador obj) {
		data.set(row, obj);
		fireTableRowsUpdated(row, row);
	}

	public void clearData() {
		data.clear();
		fireTableDataChanged();
	}

	public ArrayList<Trabajador> getData() {
		return this.data;
	}

	public void setData(ArrayList<Trabajador> data) {
		this.data = data;
		fireTableDataChanged();
	}

}
