package entidades;

import java.sql.Date;
import java.time.LocalDate;

public class Compra {
	private String Id;
	private Proveedor prov;
	private Trabajador trab;
	private LocalDate fecha;
	private double IGV;
	private int estado;
	private double subtotal;
	private double total;
	
	
	public Compra(){
		prov = new Proveedor();
		trab = new Trabajador();
		estado = 0;
		IGV = 0.18;
	}
	
	public Compra(String id, Proveedor prov, Trabajador trab, LocalDate fecha, double iGV, int estado) {
		Id = id;
		this.prov = prov;
		this.trab = trab;
		this.fecha = fecha;
		IGV = iGV;
		this.estado = estado;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public Proveedor getProv() {
		return prov;
	}

	public void setProv(Proveedor prov) {
		this.prov = prov;
	}

	public Trabajador getTrab() {
		return trab;
	}

	public void setTrab(Trabajador trab) {
		this.trab = trab;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getIGV() {
		return IGV;
	}

	public void setIGV(double iGV) {
		IGV = iGV;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	//Adicionales 
	public Date getSQlFecha(){
		return Date.valueOf(fecha);
	}
	
	public void setSqlFecha(Date fecha){
		this.fecha = fecha.toLocalDate();
	}
	
	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double MontoIGV(){
		return subtotal * IGV;
	}
	
	public double getCalcTotal(){
		return subtotal + MontoIGV();
	}
}
