package negocio;

import java.sql.*;
import java.sql.*;
import java.util.ArrayList;
import entidades.*;
import conexion.Conexion;

public class NegocioDetCompra {

	private Connection con;
	private CallableStatement cstm;
	private PreparedStatement pst;
	private Statement st;
	private String sql = "";
	private ResultSet rs;
	
	public ArrayList<DetCompra> Listar(){
		ArrayList<DetCompra> lista = new  ArrayList<DetCompra>();
		sql = "select dc.Cod_Compra as Compra, p.ID as Producto, p.Descripcion as ProdDesc, "
				+ "dc.Cantidad as Cantidad, dc.Precio as Precio  "
				+ "from Det_Comp dc inner join Producto p on dc.Cod_Produc = p.ID";
		
		try {
			con = Conexion.Conectar();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				DetCompra obj = new DetCompra();
				obj.setCodCompra(rs.getString("Compra"));
				obj.getProd().setID(rs.getString("Producto"));
				obj.getProd().setDescripcion(rs.getString("ProdDesc"));
				obj.setCant(rs.getInt("Cantidad"));
				obj.setPrecio(rs.getDouble("Precio"));
				
				lista.add(obj);
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
	
	public boolean InsertarDetalle(DetCompra obj, Connection con){
		boolean exito = false;
		
		sql = "{call USP_DetCompMantenimiento(?,?,?,?,?)}";
		String out = "1";
		try {
			cstm = con.prepareCall(sql);
			cstm.registerOutParameter(1, Types.VARCHAR);
			cstm.setString(1,out);
			cstm.setString(2, obj.getCodCompra());
			cstm.setString(3, obj.getProd().getID());
			cstm.setInt(4, obj.getCant());
			cstm.setDouble(5, obj.getPrecio());
			
			cstm.executeUpdate();
			exito = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cstm != null)
					cstm.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return exito;
	}
	
	public boolean ModificarDetalle(DetCompra obj, Connection con){
		boolean exito = false;
		
		sql = "{call USP_DetCompMantenimiento(?,?,?,?,?)}";
		
		try {
			cstm = con.prepareCall(sql);
			cstm.setString(1, "2");
			cstm.setString(2, obj.getCodCompra());
			cstm.setString(3, obj.getProd().getID());
			cstm.setInt(4, obj.getCant());
			cstm.setDouble(5, obj.getPrecio());
			
			cstm.executeUpdate();
			
			exito = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cstm != null)
					cstm.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return exito;
	}
	
	public boolean EliminarDetalle(String comp, String prod){
		boolean exito = false;

		sql = "{call USP_DetCompMantenimiento(?,?,?)}";
		
		try {
			
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "3");
			cstm.setString(2, comp);
			cstm.setString(3, prod);
			
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
	
	//para eliminacion transaccional uso el 'con' de parametro
	public boolean EliminarDetalles(String comp, Connection con){
		boolean exito = false;

		sql = "{call USP_DetCompMantenimiento(?,?)}";
		String out ="4";
		try {
			cstm = con.prepareCall(sql);
			cstm.registerOutParameter(1, Types.VARCHAR);
			cstm.setString(1, out);
			cstm.setString(2, comp);
			
			cstm.executeUpdate();
			exito = true;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cstm != null)
					cstm.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return exito;
	}
	
	
	public ArrayList<DetCompra> getDetallesByVenta(String comp){
		ArrayList<DetCompra> lista = new  ArrayList<DetCompra>();
		sql = "select dc.Cod_Compra as Compra, p.ID as Producto, p.Descripcion as ProdDesc, "
				+ "dc.Cantidad as Cantidad, dc.Precio as Precio  "
				+ "from Det_Comp dc inner join Producto p on dc.Cod_Produc = p.ID WHERE dc.Cod_Compra = ?";
		
		try {
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, comp);
			
			rs = pst.executeQuery();
			
			while(rs.next()){
				DetCompra obj = new DetCompra();
				obj.setCodCompra(rs.getString("Compra"));
				obj.getProd().setID(rs.getString("Producto"));
				obj.getProd().setDescripcion(rs.getString("ProdDesc"));
				obj.setCant(rs.getInt("Cantidad"));
				obj.setPrecio(rs.getDouble("Precio"));
				
				lista.add(obj);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
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
	
}
