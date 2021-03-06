package entidades;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Producto {
	private String ID;
	private String Descripcion;
	private double preCompra;
	private double preVenta;
	private int stockAcual;
	private int stockMin;
	private CategoriaProducto cate;
	private InputStream os; //---> Para recibir la imagen del sql server
	private byte[] img;
	
	public Producto() {
		this.cate = new CategoriaProducto();
	}

	public Producto(String iD, String descripcion, double preCompra, double preVenta, int stockAcual, int stockMin,
			CategoriaProducto cate) {
		ID = iD;
		Descripcion = descripcion;
		this.preCompra = preCompra;
		this.preVenta = preVenta;
		this.stockAcual = stockAcual;
		this.stockMin = stockMin;
		this.cate = cate;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public double getPreCompra() {
		return preCompra;
	}

	public void setPreCompra(double preCompra) {
		this.preCompra = preCompra;
	}

	public double getPreVenta() {
		return preVenta;
	}

	public void setPreVenta(double preVenta) {
		this.preVenta = preVenta;
	}

	public int getStockAcual() {
		return stockAcual;
	}

	public void setStockAcual(int stockAcual) {
		this.stockAcual = stockAcual;
	}

	public int getStockMin() {
		return stockMin;
	}

	public void setStockMin(int stockMin) {
		this.stockMin = stockMin;
	}

	public CategoriaProducto getCate() {
		return cate;
	}

	public void setCate(CategoriaProducto cate) {
		this.cate = cate;
	}

	public InputStream getOs() {
		return os;
	}

	public void setOs(InputStream os) {
		this.os = os;
	}
	
	/**/
	
	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		if(img != null)
		this.img = Arrays.copyOf(img, img.length);
	}
	/**/
	
	
}
