package entidades;

import java.sql.Date;
import java.time.LocalDate;

public class Venta {

	private String CodVenta;
	private Cliente cli;
	private Trabajador trab;
	private LocalDate fecha;
	private double IGV;
	private double DescTotal;
	private double subtotal;
	private double total;
	
	
	public Venta(){
		cli = new Cliente();
		trab = new Trabajador();
		DescTotal = 0;
		IGV = 0.18;
	}


	public Venta(String codVenta, Cliente cli, Trabajador trab, LocalDate fecha, double iGV, double descTotal) {
		CodVenta = codVenta;
		this.cli = cli;
		this.trab = trab;
		this.fecha = fecha;
		IGV = iGV;
		DescTotal = descTotal;
	}


	public String getCodVenta() {
		return CodVenta;
	}


	public void setCodVenta(String codVenta) {
		CodVenta = codVenta;
	}


	public Cliente getCli() {
		return cli;
	}


	public void setCli(Cliente cli) {
		this.cli = cli;
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


	public double getDescTotal() {
		return DescTotal;
	}


	public void setDescTotal(double descTotal) {
		DescTotal = descTotal;
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
	
	public double getSubDesc(){
		return subtotal - DescTotal;
	}

	/*public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}*/

	public double MontoIGV(){
		return getSubDesc() * IGV;
	}
	
	public double getCalcTotal(){
		return getSubDesc() + MontoIGV();
	}
}
