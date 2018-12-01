package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entidades.Producto;
import entidades.Promo;

public class PromoTableModel extends AbstractTableModel {
	
	private ArrayList<Promo> data;
	
	private String[] columnas = {"Código", "Producto", "Tipo Descuento", "Valor", "Fecha Inicial", "Fecha Final"};
	
	private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-uuuu");
	
	public PromoTableModel() {
		data = new ArrayList<Promo>();
	}
	
	public PromoTableModel(ArrayList<Promo> data) {
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
		Promo obj = data.get(rowIndex);
		switch(columnIndex){
		case 0: return obj.getID();
		case 1: return obj.getProd().getDescripcion();
		case 2: 
			if(obj.getTipo()==0){
				return "Fijo";
			}
			else{
				return "Porcentual";
			}
		case 3: return obj.getValor();
		case 4: return obj.getFecIni().format(formato);
		case 5: return obj.getFecFin().format(formato);
		default : return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex){
		case 3: return double.class;
		case 4:
		case 5: return LocalDate.class;
		default : return String.class;
		}
	}

	public Promo getPromo(int row){
		return this.data.get(row);
	}
	
	public void addPromo(Promo obj){
		data.add(obj);
		fireTableRowsInserted(getRowCount(), getColumnCount());
	}
	
	public void deletePromo(int row){
		data.remove(row);
		fireTableRowsDeleted(row, row);
	}
	
	//para modificar un producto del modelo
	public void updatePromo(int row, Promo obj){
		data.set(row, obj);
		fireTableRowsUpdated(row, row);
	}
	
	public void clearData(){
		data.clear();
		fireTableDataChanged();
	}
	
	public ArrayList<Promo> getData(){
		return  this.data;
	}
	
	public void setData(ArrayList<Promo> data){
		this.data = data;
		fireTableDataChanged();
	}
}
