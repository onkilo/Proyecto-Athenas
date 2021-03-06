package negocio;

import java.sql.*;
import java.util.ArrayList;

import conexion.Conexion;
import entidades.Proveedor;

public class NegocioProveedor {

	private Connection con;
	private CallableStatement cstm;
	private PreparedStatement pst;
	private Statement st;
	private String sql = "";
	private ResultSet rs;

	public ArrayList<Proveedor> Listar() {
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();

		sql = "SELECT ID, Rz_Social, Representante, Email, Telefono, Direccion  FROM Proveedor";

		try {
			con = Conexion.Conectar();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				lista.add(new Proveedor(rs.getString("ID"), rs.getString("Rz_Social"), rs.getString("Representante"),
						rs.getString("Email"), rs.getString("Telefono"), rs.getString("Direccion")));
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

	public boolean InsertarProveedor(Proveedor p) {
		boolean exito = false;

		sql = "{call USP_ProveedorMantenimiento(?,?,?,?,?,?,?)}";

		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "1");
			cstm.setString(2, p.getID());
			cstm.setString(3, p.getRaz_Soc());
			cstm.setString(4, p.getRepresentante());
			cstm.setString(5, p.getEmail());
			cstm.setString(6, p.getTelf());
			cstm.setString(7, p.getDireccion());
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

	public boolean ModificarProveedor(Proveedor p) {
		boolean exito = false;

		sql = "{call USP_ProveedorMantenimiento(?,?,?,?,?,?,?)}";

		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "2");
			cstm.setString(2, p.getID());
			cstm.setString(3, p.getRaz_Soc());
			cstm.setString(4, p.getRepresentante());
			cstm.setString(5, p.getEmail());
			cstm.setString(6, p.getTelf());
			cstm.setString(7, p.getDireccion());
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

	public boolean ElimnarProveedor(String cod) {
		boolean exito = false;

		sql = "{call USP_ProveedorMantenimiento(?,?)}";

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

	public Proveedor getProveedorByID(String cod) {
		Proveedor p = null;

		sql = "SELECT ID, Rz_Social, Representante, Email, Telefono, Direccion  FROM Proveedor WHERE ID = ?";

		try {
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, cod);
			rs = pst.executeQuery();
			if (rs.next()) {
				p.setID(rs.getString("ID"));
				p.setRaz_Soc(rs.getString("Rz_Social"));
				p.setRepresentante(rs.getString("Representante"));
				p.setEmail(rs.getString("Email"));
				p.setTelf(rs.getString("Telefono"));
				p.setDireccion(rs.getString("Direccion"));
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

		return p;
	}

	public ArrayList<Proveedor> getProveedoresByID(String patron) {

		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		sql = "SELECT ID, Rz_Social, Representante, Email, Telefono, Direccion  FROM Proveedor WHERE ID like ?";

		try {
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + patron + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				Proveedor p = new Proveedor();
				p.setID(rs.getString("ID"));
				p.setRaz_Soc(rs.getString("Rz_Social"));
				p.setRepresentante(rs.getString("Representante"));
				p.setEmail(rs.getString("Email"));
				p.setTelf(rs.getString("Telefono"));
				p.setDireccion(rs.getString("Direccion"));

				lista.add(p);
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

	public ArrayList<Proveedor> getProveedoresByRzSocial(String patron) {

		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		sql = "SELECT ID, Rz_Social, Representante, Email, Telefono, Direccion  FROM Proveedor WHERE Rz_Social like ?";

		try {
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + patron + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				Proveedor p = new Proveedor();
				p.setID(rs.getString("ID"));
				p.setRaz_Soc(rs.getString("Rz_Social"));
				p.setRepresentante(rs.getString("Representante"));
				p.setEmail(rs.getString("Email"));
				p.setTelf(rs.getString("Telefono"));
				p.setDireccion(rs.getString("Direccion"));

				lista.add(p);
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

	public String nextCod() {
		sql = "{call USP_NextCod(?)}";
		String cod = "";
		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "3");
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
