package util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entidades.CategoriaProducto;

public class CateTableModel extends AbstractTableModel {
	
	private ArrayList<CategoriaProducto> data;
	private String[] columnas = {"C�digo", "Descripci�n"};

	
	public CateTableModel() {
		data = new ArrayList<CategoriaProducto>();
	}
	public CateTableModel(ArrayList<CategoriaProducto> data) {
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
		CategoriaProducto obj = data.get(rowIndex);
		switch(columnIndex){
		case 0 : return obj.getID();
		case 1 : return obj.getDescripcion();
		default : return null;
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public CategoriaProducto getCategoria(int row){
		return data.get(row);
	}
	
	public void addCategoria(CategoriaProducto obj){
		data.add(obj);
		fireTableRowsInserted(getRowCount(), getRowCount());
	}
	
	//para elimininar una categoria del modelo
	public void deleteCategoria(int row){
		data.remove(row);
		fireTableRowsDeleted(row, row);
	}
	
	//para modificar una categoria del modelo
	public void updateCategoria(int row, CategoriaProducto obj){
		data.set(row, obj);
		fireTableRowsUpdated(row, row);
	}
	
	public void clearData(){
		data.clear();
		fireTableDataChanged();
	}
	
	public ArrayList<CategoriaProducto> getData(){
		return this.data;
	}
	
	public void setData(ArrayList<CategoriaProducto> data){
		this.data = data;
		fireTableDataChanged();
	}
}
