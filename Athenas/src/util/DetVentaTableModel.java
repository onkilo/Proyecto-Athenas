package util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entidades.DetVenta;
import entidades.Venta;

public class DetVentaTableModel extends AbstractTableModel {
	
	private ArrayList<DetVenta> data;
	private String[] columnas = {"C�digo", "Descripci�n", "Cantidad", "Precio", "Descuento", "Subtotal"};
	Comunes comon = new Comunes();

	public DetVentaTableModel() {
		data = new ArrayList<DetVenta>();
	}

	public DetVentaTableModel(ArrayList<DetVenta> data) {
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
		DetVenta obj = data.get(rowIndex);
		
		switch(columnIndex){
		case 0 : return obj.getProd().getID();
		case 1 : return obj.getProd().getDescripcion();
		case 2 : return obj.getCant();
		case 3 : return comon.formatDouble(obj.getPrecio());
		case 4 : return comon.formatDouble(obj.DescTotal());
		case 5 : return comon.formatDouble(obj.getSubDesc());
		default : return null;
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex){
		case 2 : return int.class;
		case 3 :
		case 4 :
		case 5 : return double.class;
		default : return String.class;
		}
	}
	
	
	public DetVenta getDetVenta(int row) {
		return data.get(row);
	}

	// para a�adir un detalle de venta al modelo
	public void adDetVenta(DetVenta obj) {
		data.add(obj);
		fireTableRowsInserted(getRowCount(), getRowCount());
	}

	// para elimininar un detalle de venta del modelo
	public void deleteDetVenta(int row) {
		data.remove(row);
		fireTableRowsDeleted(row, row);
	}

	// para modificar un detalle de venta del modelo
	public void updateDetVenta(int row, DetVenta obj) {
		data.set(row, obj);
		fireTableRowsUpdated(row, row);
	}

	public void clearData() {
		data.clear();
		fireTableDataChanged();
	}

	public ArrayList<DetVenta> getData() {
		return this.data;
	}

	public void setData(ArrayList<DetVenta> data) {
		this.data = data;
		fireTableDataChanged();
	}
	
	public boolean ExisteVenta(DetVenta obj){
		boolean existe = false;
		
		for(DetVenta item : data){
			if(item.getProd().getID().equals(obj.getProd().getID()) && item.getCodVenta().equals(obj.getCodVenta())){
				return true;
			}
		}
		
		return existe;
	}
	
	public int PosicionDetProd(DetVenta obj){
		int pos = -1;
		String venta = obj.getCodVenta();
		String prod = obj.getProd().getID();
		for(int i = 0; i < data.size(); i++){
			if(venta.equals(data.get(i).getCodVenta()) && prod.equals(data.get(i).getProd().getID())){
				return i;
			}
		}
		return pos;
	}
}
