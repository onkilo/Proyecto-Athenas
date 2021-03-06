package entidades;

public class CategoriaProducto {
	
	private String ID;
	private String Descripcion;
	
	public CategoriaProducto() {
	}

	public CategoriaProducto(String iD, String descripcion) {
		ID = iD;
		Descripcion = descripcion;
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
	@Override
	public String toString() {
		return this.Descripcion;
	}
}
