
package entidades;

public class Trabajador {

	private String ID;
	private String Nombre;
	private String Apellido;
	private String Telf;
	private String DNI;
	private String Direccion;
	private String Email;
	private String Usuario;
	private String Password;
	private String Sexo;
	private String Rol;

	public Trabajador(String ID, String Nombre, String Apellido, String Telf, String DNI, String Direccion,
			String Email, String Usuario, String Password, String Sexo, String Rol) {
		this.ID = ID;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.Telf = Telf;
		this.DNI = DNI;
		this.Direccion = Direccion;
		this.Email = Email;
		this.Usuario = Usuario;
		this.Password = Password;
		this.Sexo = Sexo;
		this.Rol = Rol;
	}

	public Trabajador() {
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String Apellido) {
		this.Apellido = Apellido;
	}

	public String getTelf() {
		return Telf;
	}

	public void setTelf(String Telf) {
		this.Telf = Telf;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String Usuario) {
		this.Usuario = Usuario;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String Sexo) {
		this.Sexo = Sexo;
	}

	public String getRol() {
		return Rol;
	}

	public void setRol(String Rol) {
		this.Rol = Rol;
	}

}
