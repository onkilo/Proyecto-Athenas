package util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entidades.DetCompra;
import entidades.DetVenta;

public class DetCompraTableModel extends AbstractTableModel {
	
	private ArrayList<DetCompra> data;
	private String[] columnas = {"C�digo", "Descripci�n", "Cantidad", "Precio", "Subtotal"};
	Comunes comon = new Comunes();
	
	public DetCompraTableModel() {
		data = new ArrayList<DetCompra>();
	}
	
	public DetCompraTableModel(ArrayList<DetCompra> data) {
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		DetCompra obj = data.get(rowIndex);
		switch(columnIndex){
		case 0 : return obj.getProd().getID();
		case 1 : return obj.getProd().getDescripcion();
		case 2 : return obj.getCant();
		case 3 : return comon.formatDouble(obj.getPrecio());
		case 4 : return comon.formatDouble(obj.CalcSubtotal());
		default : return null;
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex){
		case 2 : return int.class;
		case 3 :
		case 4 : return double.class;
		default : return String.class;
		}
	}
	
	
	public DetCompra getDetCompra(int row) {
		return data.get(row);
	}

	// para a�adir un detalle de compra al modelo
	public void addDetCompra(DetCompra obj) {
		data.add(obj);
		fireTableRowsInserted(getRowCount(), getRowCount());
	}

	// para elimininar un detalle de compra del modelo
	public void deleteDetCompra(int row) {
		data.remove(row);
		fireTableRowsDeleted(row, row);
	}

	// para modificar un detalle de compra del modelo
	public void updateDetCompra(int row, DetCompra obj) {
		data.set(row, obj);
		fireTableRowsUpdated(row, row);
	}

	public void clearData() {
		data.clear();
		fireTableDataChanged();
	}

	public ArrayList<DetCompra> getData() {
		return this.data;
	}

	public void setData(ArrayList<DetCompra> data) {
		this.data = data;
		fireTableDataChanged();
	}
	
	public boolean ExisteDetalle(DetCompra obj){
		boolean existe = false;
		
		for(DetCompra item : data){
			if(item.getProd().getID().equals(obj.getProd().getID()) && item.getCodCompra().equals(obj.getCodCompra())){
				return true;
			}
		}
		
		return existe;
	}
	
	public int PosicionDetProd(DetCompra det){
		int pos = -1;
		String venta = det.getCodCompra();
		String prod = det.getProd().getID();
		for(int i = 0; i < data.size(); i++){
			if(venta.equals(data.get(i).getCodCompra()) && prod.equals(data.get(i).getProd().getID())){
				return i;
			}
		}
		return pos;
	}

}
