package negocio;

import java.awt.Window.Type;
import java.sql.*;
import java.util.ArrayList;

import conexion.Conexion;
import entidades.Producto;

public class NegocioProducto {
	private Connection con;
	private CallableStatement cstm;
	private PreparedStatement pst;
	private Statement st;
	private String sql = "";
	private ResultSet rs;
	
	public ArrayList<Producto> listar(){
		ArrayList<Producto> lista = new ArrayList<>();
		
		sql = "SELECT p.ID as ID, p.Descripcion as Descripcion, p.Precio_Compra as Precio_Compra,"
				+ " p.Precio_Venta as Precio_Venta, p.Stock_Actual as Stock_Actual, p.Stock_Min as Stock_Min, "
				+ "c.ID as catID, c.Descripcion as categoria ,p.Imagen as Imagen FROM Producto p INNER JOIN Cat_Prod c ON p.Cat_Id = c.ID";
		
		try {
			con = Conexion.Conectar();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				Producto obj = new Producto();
				obj.setID(rs.getString("ID"));
				obj.setDescripcion(rs.getString("Descripcion"));
				obj.setPreCompra(rs.getDouble("Precio_Compra"));
				obj.setPreVenta(rs.getDouble("Precio_Venta"));
				obj.setStockAcual(rs.getInt("Stock_Actual"));
				obj.setStockMin(rs.getInt("Stock_Min"));
				obj.getCate().setID(rs.getString("catID"));
				obj.getCate().setDescripcion(rs.getString("categoria"));
				obj.setImg(rs.getBytes("Imagen"));
				lista.add(obj);
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
	
	public ArrayList<Producto> ProductoSinPromo(){
		ArrayList<Producto> lista = new ArrayList<>();
		
		sql = "SELECT p.ID as ID, p.Descripcion as Descripcion, p.Precio_Compra as Precio_Compra,"
				+ " p.Precio_Venta as Precio_Venta, p.Stock_Actual as Stock_Actual, p.Stock_Min as Stock_Min, "
				+ "c.ID as catID, c.Descripcion as categoria ,p.Imagen as Imagen FROM Producto p INNER JOIN Cat_Prod c ON p.Cat_Id = c.ID "
				+ "where ID not in (select Cod_Prod from Promo where CONVERT(varchar, GETDATE(), 101) between FecIni and FecFin)";
		
		try {
			con = Conexion.Conectar();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				Producto obj = new Producto();
				obj.setID(rs.getString("ID"));
				obj.setDescripcion(rs.getString("Descripcion"));
				obj.setPreCompra(rs.getDouble("Precio_Compra"));
				obj.setPreVenta(rs.getDouble("Precio_Venta"));
				obj.setStockAcual(rs.getInt("Stock_Actual"));
				obj.setStockMin(rs.getInt("Stock_Min"));
				obj.getCate().setID(rs.getString("catID"));
				obj.getCate().setDescripcion(rs.getString("categoria"));
				obj.setImg(rs.getBytes("Imagen"));
				lista.add(obj);
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
	
	public boolean InsertarProducto(Producto obj){
		boolean exito = false;
		
		sql = "{call USP_ProductoMantenimiento(?,?,?,?,?,?,?,?,?)}";
		
		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "1");
			cstm.setString(2, obj.getID());
			cstm.setString(3, obj.getDescripcion());
			cstm.setDouble(4, obj.getPreCompra());
			cstm.setDouble(5, obj.getPreVenta());
			cstm.setInt(6, obj.getStockAcual());
			cstm.setInt(7, obj.getStockMin());
			cstm.setString(8, obj.getCate().getID());
			if(obj.getOs() != null){
				cstm.setBinaryStream(9, obj.getOs());
			}else{
				cstm.setNull(9, Types.VARBINARY);
			}
			cstm.executeUpdate();
			exito = true;
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
		return exito;
	}
	
	public boolean ModificarProducto(Producto obj){
		boolean exito = false;
		
		sql = "{call USP_ProductoMantenimiento(?,?,?,?,?,?,?,?,?)}";
		
		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "2");
			cstm.setString(2, obj.getID());
			cstm.setString(3, obj.getDescripcion());
			cstm.setDouble(4, obj.getPreCompra());
			cstm.setDouble(5, obj.getPreVenta());
			cstm.setInt(6, obj.getStockAcual());
			cstm.setInt(7, obj.getStockMin());
			cstm.setString(8, obj.getCate().getID());
			if(obj.getOs() != null){
				cstm.setBinaryStream(9, obj.getOs());
			}else{
				cstm.setNull(9, Types.VARBINARY);
			}
			cstm.executeUpdate();
			exito = true;
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
		return exito;
	}
	
	public boolean EliminarProducto(String cod){
		boolean exito = false;
		
		sql = "{call USP_ProductoMantenimiento(?,?)}";
		
		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "3");
			cstm.setString(2, cod);
			cstm.executeUpdate();
			exito = true;
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
		return exito;
	}
	
	
	public boolean EliminarImg(String cod){
		boolean exito = false;
		
		sql = "{call USP_ProductoMantenimiento(?,?)}";
		
		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "4");
			cstm.setString(2, cod);
			cstm.executeUpdate();
			exito = true;
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
		return exito;
	}
	
	public Producto getProductoByID(String cod){
		Producto obj = null;
		sql = "SELECT p.ID as ID, p.Descripcion as Descripcion, p.Precio_Compra as Precio_Compra,"
				+ " p.Precio_Venta as Precio_Venta, p.Stock_Actual as Stock_Actual, p.Stock_Min as Stock_Min, "
				+ "c.ID as catID, c.Descripcion as categoria ,p.Imagen as Imagen FROM Producto p INNER JOIN Cat_Prod c ON p.Cat_Id = c.ID "
				+ "WHERE p.ID = ?";
		
		try {
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, cod);
			rs = pst.executeQuery();
			while(rs.next()){
				obj = new Producto();
				obj.setID(rs.getString("ID"));
				obj.setDescripcion(rs.getString("Descripcion"));
				obj.setPreCompra(rs.getDouble("Precio_Compra"));
				obj.setPreVenta(rs.getDouble("Precio_Venta"));
				obj.setStockAcual(rs.getInt("Stock_Actual"));
				obj.setStockMin(rs.getInt("Stock_Min"));
				obj.getCate().setID(rs.getString("catID"));
				obj.getCate().setDescripcion(rs.getString("categoria"));
				obj.setImg(rs.getBytes("Imagen"));
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
		
		return obj;
	}
	
	public ArrayList<Producto> getProductosByID(String patron){
		ArrayList<Producto> lista = new ArrayList<>();
		
		sql = "SELECT p.ID as ID, p.Descripcion as Descripcion, p.Precio_Compra as Precio_Compra,"
				+ " p.Precio_Venta as Precio_Venta, p.Stock_Actual as Stock_Actual, p.Stock_Min as Stock_Min, "
				+ "c.ID as catID, c.Descripcion as categoria ,p.Imagen as Imagen FROM Producto p INNER JOIN Cat_Prod c ON p.Cat_Id = c.ID "
				+ "WHERE p.ID like ?";
		
		try {
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + patron + "%");
			rs = pst.executeQuery();
			while(rs.next()){
				Producto obj = new Producto();
				obj.setID(rs.getString("ID"));
				obj.setDescripcion(rs.getString("Descripcion"));
				obj.setPreCompra(rs.getDouble("Precio_Compra"));
				obj.setPreVenta(rs.getDouble("Precio_Venta"));
				obj.setStockAcual(rs.getInt("Stock_Actual"));
				obj.setStockMin(rs.getInt("Stock_Min"));
				obj.getCate().setID(rs.getString("catID"));
				obj.getCate().setDescripcion(rs.getString("categoria"));
				obj.setImg(rs.getBytes("Imagen"));
				lista.add(obj);
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
	
	public ArrayList<Producto> getProductosByDescripcion(String patron){
		ArrayList<Producto> lista = new ArrayList<>();
		
		sql = "SELECT p.ID as ID, p.Descripcion as Descripcion, p.Precio_Compra as Precio_Compra,"
				+ " p.Precio_Venta as Precio_Venta, p.Stock_Actual as Stock_Actual, p.Stock_Min as Stock_Min, "
				+ "c.ID as catID, c.Descripcion as categoria ,p.Imagen as Imagen FROM Producto p INNER JOIN Cat_Prod c ON p.Cat_Id = c.ID "
				+ "WHERE p.Descripcion like ?";
		
		try {
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + patron + "%");
			rs = pst.executeQuery();
			while(rs.next()){
				Producto obj = new Producto();
				obj.setID(rs.getString("ID"));
				obj.setDescripcion(rs.getString("Descripcion"));
				obj.setPreCompra(rs.getDouble("Precio_Compra"));
				obj.setPreVenta(rs.getDouble("Precio_Venta"));
				obj.setStockAcual(rs.getInt("Stock_Actual"));
				obj.setStockMin(rs.getInt("Stock_Min"));
				obj.getCate().setID(rs.getString("catID"));
				obj.getCate().setDescripcion(rs.getString("categoria"));

				lista.add(obj);
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
			cstm.setString(1, "4");
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
