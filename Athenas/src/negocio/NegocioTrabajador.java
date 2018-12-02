package negocio;

import java.sql.*;
import entidades.Trabajador;
import conexion.Conexion;
import java.util.ArrayList;

public class NegocioTrabajador {
	private Connection con;
	private CallableStatement cstm;
	private PreparedStatement pst;
	private Statement st;
	private String sql = "";
	private ResultSet rs;

	public ArrayList<Trabajador> Listar() {
		ArrayList<Trabajador> lista = new ArrayList<Trabajador>();

		sql = "SELECT ID,Nombre,Apellido,Telefono,DNI,Email, Direccion, Usuario, Contrasenia,Sexo, Rol FROM Trabajador WHERE ID <> 'TB0000'";

		try {
			con = Conexion.Conectar();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Trabajador t = new Trabajador();
				t.setID(rs.getString("ID"));
				t.setNombre(rs.getString("Nombre"));
				t.setApellido(rs.getString("Apellido"));
				t.setTelf(rs.getString("Telefono"));
				t.setDNI(rs.getString("DNI"));
				t.setEmail(rs.getString("Email"));
				t.setDireccion(rs.getString("Direccion"));
				t.setUsuario(rs.getString("Usuario"));
				t.setPassword(rs.getString("Contrasenia"));
				t.setSexo(rs.getString("Sexo"));
				t.setRol(rs.getString("Rol"));

				lista.add(t);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return lista;
	}

	public boolean InsertarTrabajador(Trabajador t) {
		boolean exito = false;

		sql = "{call USP_TrabajadorMantenimiento(?,?,?,?,?,?,?,?,?,?,?,?)}";

		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "1");
			cstm.setString(2, t.getID());
			cstm.setString(3, t.getNombre());
			cstm.setString(4, t.getApellido());
			cstm.setString(5, t.getTelf());
			cstm.setString(6, t.getDNI());
			cstm.setString(7, t.getSexo());
			cstm.setString(8, t.getEmail());
			cstm.setString(9, t.getDireccion());
			cstm.setString(10, t.getUsuario());
			cstm.setString(11, t.getPassword());
			cstm.setString(12, t.getRol());

			cstm.executeUpdate();
			exito = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cstm != null)
					cstm.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return exito;
	}

	public boolean ModificarTrabajador(Trabajador t) {
		boolean exito = false;

		sql = "{call USP_TrabajadorMantenimiento(?,?,?,?,?,?,?,?,?,?,?,?)}";

		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "2");
			cstm.setString(2, t.getID());
			cstm.setString(3, t.getNombre());
			cstm.setString(4, t.getApellido());
			cstm.setString(5, t.getTelf());
			cstm.setString(6, t.getDNI());
			cstm.setString(7, t.getSexo());
			cstm.setString(8, t.getEmail());
			cstm.setString(9, t.getDireccion());
			cstm.setString(10, t.getUsuario());
			cstm.setString(11, t.getPassword());
			cstm.setString(12, t.getRol());

			cstm.executeUpdate();
			exito = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cstm != null)
					cstm.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return exito;
	}

	public boolean EliminarTrabajador(String cod) {
		boolean exito = false;

		sql = "{call USP_TrabajadorMantenimiento(?,?)}";

		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "3");
			cstm.setString(2, cod);
			cstm.executeUpdate();
			exito = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cstm != null)
					cstm.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return exito;
	}

	public Trabajador getTrabajadorBYID(String cod) {
		Trabajador t = null;

		sql = "SELECT ID,Nombre,Apellido,Telefono,DNI,Email, Direccion, Usuario, Contrasenia,Sexo, Rol FROM Trabajador WHERE ID = ? AND ID <> 'TB0000'";

		try {
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, cod);
			rs = pst.executeQuery();
			if (rs.next()) {
				t = new Trabajador();
				t.setID(rs.getString("ID"));
				t.setNombre(rs.getString("Nombre"));
				t.setApellido(rs.getString("Apellido"));
				t.setTelf(rs.getString("Telefono"));
				t.setDNI(rs.getString("DNI"));
				t.setEmail(rs.getString("Email"));
				t.setDireccion(rs.getString("Direccion"));
				t.setUsuario(rs.getString("Usuario"));
				t.setPassword(rs.getString("Contrasenia"));
				t.setSexo(rs.getString("Sexo"));
				t.setRol(rs.getString("Rol"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return t;
	}

	public ArrayList<Trabajador> getTrabajadoresBYID(String patron) {
		ArrayList<Trabajador> lista = new ArrayList<Trabajador>();

		sql = "SELECT ID,Nombre,Apellido,Telefono,DNI,Email, Direccion, Usuario, Contrasenia,Sexo, Rol FROM Trabajador WHERE ID like ? AND ID <> 'TB0000'";

		try {
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + patron + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				Trabajador t = new Trabajador();
				t.setID(rs.getString("ID"));
				t.setNombre(rs.getString("Nombre"));
				t.setApellido(rs.getString("Apellido"));
				t.setTelf(rs.getString("Telefono"));
				t.setDNI(rs.getString("DNI"));
				t.setEmail(rs.getString("Email"));
				t.setDireccion(rs.getString("Direccion"));
				t.setUsuario(rs.getString("Usuario"));
				t.setPassword(rs.getString("Contrasenia"));
				t.setSexo(rs.getString("Sexo"));
				t.setRol(rs.getString("Rol"));

				lista.add(t);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return lista;
	}

	public ArrayList<Trabajador> getTrabajadoresBYNombre(String patron) {
		ArrayList<Trabajador> lista = new ArrayList<Trabajador>();

		sql = "SELECT ID,Nombre,Apellido,Telefono,DNI,Email, Direccion, Usuario, Contrasenia,Sexo, Rol FROM Trabajador WHERE (Nombre + ' ' + Apellido) like ?  AND ID <> 'TB0000'";

		try {
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + patron + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				Trabajador t = new Trabajador();
				t.setID(rs.getString("ID"));
				t.setNombre(rs.getString("Nombre"));
				t.setApellido(rs.getString("Apellido"));
				t.setTelf(rs.getString("Telefono"));
				t.setDNI(rs.getString("DNI"));
				t.setEmail(rs.getString("Email"));
				t.setDireccion(rs.getString("Direccion"));
				t.setUsuario(rs.getString("Usuario"));
				t.setPassword(rs.getString("Contrasenia"));
				t.setSexo(rs.getString("Sexo"));
				t.setRol(rs.getString("Rol"));

				lista.add(t);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return lista;
	}

	public Trabajador getTrabajadorBYUser(String user, String pass) {
		Trabajador t = null;

		sql = "SELECT ID,Nombre,Apellido,Telefono,DNI,Email, Direccion, Usuario, Contrasenia,Sexo, Rol FROM Trabajador "
				+ "WHERE Usuario = ? COLLATE SQL_Latin1_General_CP1_CS_AS AND Contrasenia = ? COLLATE SQL_Latin1_General_CP1_CS_AS";

		try {
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, user);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			if (rs.next()) {
				t = new Trabajador();
				t.setID(rs.getString("ID"));
				t.setNombre(rs.getString("Nombre"));
				t.setApellido(rs.getString("Apellido"));
				t.setTelf(rs.getString("Telefono"));
				t.setDNI(rs.getString("DNI"));
				t.setEmail(rs.getString("Email"));
				t.setDireccion(rs.getString("Direccion"));
				t.setUsuario(rs.getString("Usuario"));
				t.setPassword(rs.getString("Contrasenia"));
				t.setSexo(rs.getString("Sexo"));
				t.setRol(rs.getString("Rol"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return t;
	}

	public String nextCod() {
		sql = "{call USP_NextCod(?)}";
		String cod = "";
		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "6");
			cstm.registerOutParameter(1, Types.VARCHAR);
			cstm.executeUpdate();
			cod = cstm.getString(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cstm != null)
					cstm.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return cod;
	}
}
