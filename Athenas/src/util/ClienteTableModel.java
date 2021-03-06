package util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Cliente;

public class ClienteTableModel extends AbstractTableModel {

	// Listado de los datos del modelo <Cliente>
	private List<Cliente> data;
	// Columnas de la tabla
	private String[] columnas = { "C�digo", "Nombre", "Tel�fono", "DNI", "Sexo" };

	public ClienteTableModel() {
		data = new ArrayList<Cliente>();
	}

	public ClienteTableModel(ArrayList<Cliente> data) {
		this.data = data;
		fireTableDataChanged();
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
		// obtenemos el cliente de la lista
		Cliente c = data.get(rowIndex);
		// Usamos switch para determinar que dato nos piden del cliente
		// se usa para pintar los datos en la tabla
		switch (columnIndex) {
		case 0:
			return c.getID();
		case 1:
			return c.getNombre() + " " + c.getApellido();
		case 2:
			return c.getTelefono();
		case 3:
			return c.getDni();
		case 4:
			if (c.getSexo().equalsIgnoreCase("M"))
				return "Masculino";
			else
				return "Femenino";
		default : return null;
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
	
	//obtener cliente seleccionado
	public Cliente getCliente(int row){
		return data.get(row);
	}

	//para a�adir un cliente al modelo
	public void addCliente(Cliente c){
		data.add(c);
		fireTableRowsInserted(getRowCount(), getRowCount());
	}
	
	//para elimininar un cliente del modelo
	public void deleteCliente(int row){
		data.remove(row);
		fireTableRowsDeleted(row, row);
	}
	
	//para modificar un cliente del modelo
	public void updateCliente(int row, Cliente c){
		data.set(row, c);
		fireTableRowsUpdated(row, row);
	}
	
	public void clearData(){
		data.clear();
		fireTableDataChanged();
	}
	
	public ArrayList<Cliente> getData(){
		return (ArrayList<Cliente>) this.data;
	}
	
	public void setData(ArrayList<Cliente> data){
		this.data = data;
		fireTableDataChanged();
	}
}
