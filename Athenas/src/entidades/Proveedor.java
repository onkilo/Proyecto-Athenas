
package entidades;

public class Proveedor {
	private String ID;
	private String Raz_Soc;
	private String Representante;
	private String Email;
	private String Telf;
	private String Direccion;

	public Proveedor(String ID, String Raz_Soc, String Representante, String Email, String Telf, String Direccion) {
		this.ID = ID;
		this.Raz_Soc = Raz_Soc;
		this.Representante = Representante;
		this.Email = Email;
		this.Telf = Telf;
		this.Direccion = Direccion;
	}

	public Proveedor() {
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getRaz_Soc() {
		return Raz_Soc;
	}

	public void setRaz_Soc(String Raz_Soc) {
		this.Raz_Soc = Raz_Soc;
	}

	public String getRepresentante() {
		return Representante;
	}

	public void setRepresentante(String Representante) {
		this.Representante = Representante;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getTelf() {
		return Telf;
	}

	public void setTelf(String Telf) {
		this.Telf = Telf;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}

}
