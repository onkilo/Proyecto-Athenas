package entidades;

import java.sql.Date;
import java.time.LocalDate;

public class Promo {
	private String ID;
	private Producto prod;
	private int tipo;
	private double valor;
	private LocalDate fecIni;
	private LocalDate fecFin;
	
	public Promo() {
	}

	public Promo(String iD, Producto prod, int tipo, double valor, LocalDate fecIni, LocalDate fecFin) {
		ID = iD;
		this.prod = prod;
		this.tipo = tipo;
		this.valor = valor;
		this.fecIni = fecIni;
		this.fecFin = fecFin;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Producto getProd() {
		return prod;
	}

	public void setProd(Producto prod) {
		this.prod = prod;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getFecIni() {
		return fecIni;
	}

	public void setFecIni(LocalDate fecIni) {
		this.fecIni = fecIni;
	}

	public LocalDate getFecFin() {
		return fecFin;
	}

	public void setFecFin(LocalDate fecFin) {
		this.fecFin = fecFin;
	}
	
	//Conversiones de fecha
	public void setSqlFecIni(Date fecha){
		this.fecIni = fecha.toLocalDate();
	}
	
	public void setSQlFecFin(Date fecha){
		this.fecFin = fecha.toLocalDate();
	}
	
	public Date getSqlFecIniTo(){
		return Date.valueOf(this.fecIni);
	}
	
	public Date getSqlFecFin(){
		return Date.valueOf(this.fecFin);
	}
}
