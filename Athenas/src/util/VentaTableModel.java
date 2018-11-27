package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entidades.Trabajador;
import entidades.Venta;

public class VentaTableModel extends AbstractTableModel {
	
	private ArrayList<Venta> data;
	private String[] columnas = {"Código", "Cliente", "Trabajador", "Fecha", "IGV", "Descuento", "Total"};
	private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-uuuu");

	public VentaTableModel() {
		data = new ArrayList<Venta>();
	}

	public VentaTableModel(ArrayList<Venta> data) {
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
		Venta obj = data.get(rowIndex);
		
		switch(columnIndex){
		case 0 : return obj.getCodVenta();
		case 1 : return obj.getCli().getNombre() + " " + obj.getCli().getApellido();
		case 2 : return obj.getTrab().getNombre() + " " + obj.getTrab().getApellido();
		case 3 : return obj.getFecha().format(formato);
		case 4 : return obj.MontoIGV();
		case 5 : return obj.getDescTotal();
		case 6 : return obj.getCalcTotal();
		default : return null;
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex){
		case 3 : return LocalDate.class;
		case 4 :
		case 5 :
		case 6 : return double.class;
		default : return String.class;
		}
	}
	
	public Venta getVenta(int row) {
		return data.get(row);
	}

	// para añadir un trabajador al modelo
	public void adVenta(Venta obj) {
		data.add(obj);
		fireTableRowsInserted(getRowCount(), getRowCount());
	}

	// para elimininar un trabajador del modelo
	public void deleteVenta(int row) {
		data.remove(row);
		fireTableRowsDeleted(row, row);
	}

	// para modificar un trabajador del modelo
	public void updateVenta(int row, Venta obj) {
		data.set(row, obj);
		fireTableRowsUpdated(row, row);
	}

	public void clearData() {
		data.clear();
		fireTableDataChanged();
	}

	public ArrayList<Venta> getData() {
		return this.data;
	}

	public void setData(ArrayList<Venta> data) {
		this.data = data;
		fireTableDataChanged();
	}

}
