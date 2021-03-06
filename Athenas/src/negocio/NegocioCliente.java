package negocio;

import java.sql.*;
import entidades.Cliente;
import conexion.Conexion;
import java.util.ArrayList;

public class NegocioCliente {
	private Connection con;
	private CallableStatement cstm;
	private PreparedStatement pst;
	private Statement st;
	private String sql = "";
	private ResultSet rs;
	
	public ArrayList<Cliente> Listar(){
		ArrayList<Cliente> lista = new ArrayList<>();
		
		sql = "SELECT ID, Nombre, Apellido, Telefono, DNI, Sexo from Cliente";
		
		try {
			con = Conexion.Conectar();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()){
				lista.add(new Cliente(
							rs.getString("ID"),
							rs.getString("Nombre"),
							rs.getString("Apellido"),
							rs.getString("Telefono"),
							rs.getString("DNI"),
							rs.getString("Sexo")
						));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(con != null) con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return lista;
	}
	
	public boolean InsertarCliente(Cliente c){
		boolean exito = false;
		
		sql = "{call USP_ClienteMantenimiento(?,?,?,?,?,?,?)}";
		
		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "1");
			cstm.setString(2, c.getID());
			cstm.setString(3, c.getNombre());
			cstm.setString(4,c.getApellido());
			cstm.setString(5, c.getTelefono());
			cstm.setString(6, c.getDni());
			cstm.setString(7, c.getSexo());
			
			cstm.executeUpdate();
			exito = true;
		}  catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			try {
				if(cstm != null) cstm.close();
				if(con != null) con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return exito;
	}
	
	public boolean ModificarCliente(Cliente c){
		boolean exito = false;
		
		sql = "{call USP_ClienteMantenimiento(?,?,?,?,?,?,?)}";
		
		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "2");
			cstm.setString(2, c.getID());
			cstm.setString(3, c.getNombre());
			cstm.setString(4,c.getApellido());
			cstm.setString(5, c.getTelefono());
			cstm.setString(6, c.getDni());
			cstm.setString(7, c.getSexo());
			
			cstm.executeUpdate();
			exito = true;
		}  catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			try {
				if(cstm != null) cstm.close();
				if(con != null) con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return exito;
	}
	
	public boolean EliminarCliente(String cod){
		boolean exito = false;
		
		sql = "{call USP_ClienteMantenimiento(?,?)}";
		
		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "3");
			cstm.setString(2, cod);
			cstm.executeUpdate();
			exito = true;
		}  catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			try {
				if(cstm != null) cstm.close();
				if(con != null) con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return exito;
	}
	
	public Cliente getClienteByID(String cod){
		Cliente c = null;
		
		sql = "SELECT ID, Nombre, Apellido, Telefono, DNI, Sexo from Cliente WHERE ID = ?";
		
		try {
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, cod);
			rs = pst.executeQuery();
			if(rs.next()){
				c = new Cliente();
				c.setID(rs.getString("ID"));
				c.setNombre(rs.getString("Nombre"));
				c.setApellido(rs.getString("Apellido"));
				c.setTelefono(rs.getString("Telefono"));
				c.setDni(rs.getString("DNI"));
				c.setSexo(rs.getString("Sexo"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			try {
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				if(con != null) con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return c;
	}
	
	public ArrayList<Cliente> getClientesByID(String patron){
		 ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		sql = "SELECT ID, Nombre, Apellido, Telefono, DNI, Sexo from Cliente WHERE ID like ?";
		
		try {
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + patron + "%");
			rs = pst.executeQuery();
			while(rs.next()){
				Cliente c = new Cliente();
				c.setID(rs.getString("ID"));
				c.setNombre(rs.getString("Nombre"));
				c.setApellido(rs.getString("Apellido"));
				c.setTelefono(rs.getString("Telefono"));
				c.setDni(rs.getString("DNI"));
				c.setSexo(rs.getString("Sexo"));
				
				lista.add(c);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			try {
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				if(con != null) con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return lista;
	}
	
	
	public ArrayList<Cliente> getClientesByNombre(String patron){
		 ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		sql = "SELECT ID, Nombre, Apellido, Telefono, DNI, Sexo from Cliente WHERE (Nombre + ' ' + Apellido) like ?";
		
		try {
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + patron + "%");
			rs = pst.executeQuery();
			while(rs.next()){
				Cliente c = new Cliente();
				c.setID(rs.getString("ID"));
				c.setNombre(rs.getString("Nombre"));
				c.setApellido(rs.getString("Apellido"));
				c.setTelefono(rs.getString("Telefono"));
				c.setDni(rs.getString("DNI"));
				c.setSexo(rs.getString("Sexo"));
				
				lista.add(c);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			try {
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				if(con != null) con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return lista;
	}
	
	
	public String nextCod(){
		sql = "{call USP_NextCod(?)}";
		String cod = "";
		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "2");
			cstm.registerOutParameter(1, Types.VARCHAR);
			cstm.executeUpdate();
			cod = cstm.getString(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			try {
				if(cstm != null) cstm.close();
				if(con != null) con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return cod;
	}
	
}
