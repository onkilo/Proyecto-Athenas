package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import entidades.Compra;
import entidades.Venta;

public class CompraTableModel extends AbstractTableModel{
	
	private ArrayList<Compra> data;
	private String[] columnas = {"Código", "Proveedor", "Trabajador", "Fecha", "IGV", "Total", "Estado"};
	private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-uuuu");
	private Comunes comu = new Comunes();

	public CompraTableModel() {
		data = new ArrayList<>();
	}

	public CompraTableModel(ArrayList<Compra> data) {
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
		Compra obj = data.get(rowIndex);
		switch(columnIndex){
		case 0 : return obj.getId();
		case 1 : return obj.getProv().getRaz_Soc();
		case 2 : return obj.getTrab().getNombre() + " " + obj.getTrab().getApellido();
		case 3 : return obj.getFecha().format(formato);
		case 4 : return comu.formatDouble(obj.MontoIGV());
		case 5 : return comu.formatDouble(obj.getCalcTotal());
		case 6 : 
			if (obj.getEstado() == 0) return "Por Recibir";
			else return "Recibido";
		default : return null;
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex){
		case 3 : return LocalDate.class;
		case 4 :
		case 5 : return double.class;
		default : return String.class;
		}
	}
	
	public Compra getCompra(int row) {
		return data.get(row);
	}

	// para añadir una compra al modelo
	public void addCompra(Compra obj) {
		data.add(obj);
		fireTableRowsInserted(getRowCount(), getRowCount());
	}

	// para elimininar un trabajador del modelo
	public void deleteCompra(int row) {
		data.remove(row);
		fireTableRowsDeleted(row, row);
	}

	// para modificar un trabajador del modelo
	public void updateCompra(int row, Compra obj) {
		data.set(row, obj);
		fireTableRowsUpdated(row, row);
	}

	public void clearData() {
		data.clear();
		fireTableDataChanged();
	}

	public ArrayList<Compra> getData() {
		return this.data;
	}

	public void setData(ArrayList<Compra> data) {
		this.data = data;
		fireTableDataChanged();
	}
}
