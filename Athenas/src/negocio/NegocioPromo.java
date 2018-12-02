package negocio;

import java.sql.*;
import java.util.ArrayList;

import conexion.Conexion;
import entidades.Promo;

public class NegocioPromo {
	
	private Connection con;
	private CallableStatement cstm;
	private PreparedStatement pst;
	private Statement st;
	private String sql = "";
	private ResultSet rs;
	
	public ArrayList<Promo> Listar(){
		ArrayList<Promo> lista = new ArrayList<Promo>();
		
		sql = "SELECT pm.ID AS PromoID,pd.ID as ProdID, pd.Descripcion as Producto,"
				+ " pm.Tipo as Tipo, pm.Valor as Valor, pm.FecIni as Inicio, pm.FecFin as Fin"
				+ " FROM Promo pm INNER JOIN Producto pd ON pm.Cod_Prod = pd.ID";
		
		try {
			
			con = Conexion.Conectar();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				Promo obj = new Promo();
				obj.setID(rs.getString("PromoID"));
				obj.getProd().setID(rs.getString("ProdID"));
				obj.getProd().setDescripcion(rs.getString("Producto"));
				obj.setTipo(rs.getInt("Tipo"));
				obj.setValor(rs.getDouble("Valor"));
				obj.setSqlFecIni(rs.getDate("Inicio"));
				obj.setSQlFecFin(rs.getDate("Fin"));
				
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
	
	public ArrayList<Promo> ListarActuales(){
		ArrayList<Promo> lista = new ArrayList<Promo>();
		
		sql = "SELECT pm.ID AS PromoID,pd.ID as ProdID, pd.Descripcion as Producto,"
				+ " pm.Tipo as Tipo, pm.Valor as Valor, pm.FecIni as Inicio, pm.FecFin as Fin"
				+ " FROM Promo pm INNER JOIN Producto pd ON pm.Cod_Prod = pd.ID WHERE convert(varchar,GETDATE(),101) BETWEEN pm.FecIni and pm.FecFin";
		
		try {
			
			con = Conexion.Conectar();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				Promo obj = new Promo();
				obj.setID(rs.getString("PromoID"));
				obj.getProd().setID(rs.getString("ProdID"));
				obj.getProd().setDescripcion(rs.getString("Producto"));
				obj.setTipo(rs.getInt("Tipo"));
				obj.setValor(rs.getDouble("Valor"));
				obj.setSqlFecIni(rs.getDate("Inicio"));
				obj.setSQlFecFin(rs.getDate("Fin"));
				
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
	
	public ArrayList<Promo> ListarVencidas(){
		ArrayList<Promo> lista = new ArrayList<Promo>();
		
		sql = "SELECT pm.ID AS PromoID,pd.ID as ProdID, pd.Descripcion as Producto,"
				+ " pm.Tipo as Tipo, pm.Valor as Valor, pm.FecIni as Inicio, pm.FecFin as Fin"
				+ " FROM Promo pm INNER JOIN Producto pd ON pm.Cod_Prod = pd.ID WHERE convert(varchar,GETDATE(),101) > pm.FecFin";
		
		try {
			
			con = Conexion.Conectar();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				Promo obj = new Promo();
				obj.setID(rs.getString("PromoID"));
				obj.getProd().setID(rs.getString("ProdID"));
				obj.getProd().setDescripcion(rs.getString("Producto"));
				obj.setTipo(rs.getInt("Tipo"));
				obj.setValor(rs.getDouble("Valor"));
				obj.setSqlFecIni(rs.getDate("Inicio"));
				obj.setSQlFecFin(rs.getDate("Fin"));
				
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
	
	public boolean InsertarPromo(Promo obj){
		boolean exito  = false;
		
		sql = "{call USP_PromoMantenimiento(?,?,?,?,?,?,?)}";
		
		try {
			
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "1");
			cstm.setString(2, obj.getID());
			cstm.setString(3, obj.getProd().getID());
			cstm.setInt(4, obj.getTipo());
			cstm.setDouble(5, obj.getValor());
			cstm.setDate(6, obj.getSqlFecIniTo());
			cstm.setDate(7, obj.getSqlFecFin());
			
			cstm.executeUpdate();
			
			exito = true;
			
		}  catch (Exception ex) {
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
	
	public boolean ModificarPromo(Promo obj){
		boolean exito  = false;
		
		sql = "{call USP_PromoMantenimiento(?,?,?,?,?,?,?)}";
		
		try {
			
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "2");
			cstm.setString(2, obj.getID());
			cstm.setString(3, obj.getProd().getID());
			cstm.setInt(4, obj.getTipo());
			cstm.setDouble(5, obj.getValor());
			cstm.setDate(6, obj.getSqlFecIniTo());
			cstm.setDate(7, obj.getSqlFecFin());
			
			cstm.executeUpdate();
			
			exito = true;
			
		}  catch (Exception ex) {
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
	
	public boolean EliminarPromo(String cod){
		boolean exito  = false;
		
		sql = "{call USP_PromoMantenimiento(?,?)}";
		
		try {
			
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "3");
			cstm.setString(2, cod);
			
			cstm.executeUpdate();
			
			exito = true;
			
		}  catch (Exception ex) {
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
	
	public Promo getPromoByID(String cod){
		Promo obj = null;
		
		sql = "SELECT pm.ID AS PromoID,pd.ID as ProdID, pd.Descripcion as Producto,"
				+ " pm.Tipo as Tipo, pm.Valor as Valor, pm.FecIni as Inicio, pm.FecFin as Fin"
				+ " FROM Promo pm INNER JOIN Producto pd ON pm.Cod_Prod = pd.ID WHERE pm.ID = ?";
		
		try {
			
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, cod);
			rs = pst.executeQuery();
			if(rs.next()){
				obj = new Promo();
				obj.setID(rs.getString("PromoID"));
				obj.getProd().setID(rs.getString("ProdID"));
				obj.getProd().setDescripcion(rs.getString("Producto"));
				obj.setTipo(rs.getInt("Tipo"));
				obj.setValor(rs.getDouble("Valor"));
				obj.setSqlFecIni(rs.getDate("Inicio"));
				obj.setSQlFecFin(rs.getDate("Fin"));
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
		
		return obj;
	}
	
	public ArrayList<Promo> getPromosByID(String patron){
		ArrayList<Promo> lista = new ArrayList<Promo>();
		
		sql = "SELECT pm.ID AS PromoID,pd.ID as ProdID, pd.Descripcion as Producto,"
				+ " pm.Tipo as Tipo, pm.Valor as Valor, pm.FecIni as Inicio, pm.FecFin as Fin"
				+ " FROM Promo pm INNER JOIN Producto pd ON pm.Cod_Prod = pd.ID WHERE pm.ID like ?";
		
		try {
			
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + patron + "%");
			rs = pst.executeQuery();
			
			while(rs.next()){
				Promo obj = new Promo();
				obj.setID(rs.getString("PromoID"));
				obj.getProd().setID(rs.getString("ProdID"));
				obj.getProd().setDescripcion(rs.getString("Producto"));
				obj.setTipo(rs.getInt("Tipo"));
				obj.setValor(rs.getDouble("Valor"));
				obj.setSqlFecIni(rs.getDate("Inicio"));
				obj.setSQlFecFin(rs.getDate("Fin"));
				
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
	
	public ArrayList<Promo> getPromosByProd(String patron){
		ArrayList<Promo> lista = new ArrayList<Promo>();
		
		sql = "SELECT pm.ID AS PromoID,pd.ID as ProdID, pd.Descripcion as Producto,"
				+ " pm.Tipo as Tipo, pm.Valor as Valor, pm.FecIni as Inicio, pm.FecFin as Fin"
				+ " FROM Promo pm INNER JOIN Producto pd ON pm.Cod_Prod = pd.ID WHERE pd.Descripcion like ?";
		
		try {
			
			con = Conexion.Conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + patron + "%");
			rs = pst.executeQuery();
			
			while(rs.next()){
				Promo obj = new Promo();
				obj.setID(rs.getString("PromoID"));
				obj.getProd().setID(rs.getString("ProdID"));
				obj.getProd().setDescripcion(rs.getString("Descripcion"));
				obj.setTipo(rs.getInt("Tipo"));
				obj.setValor(rs.getDouble("Valor"));
				obj.setSqlFecIni(rs.getDate("Inicio"));
				obj.setSQlFecFin(rs.getDate("Fin"));
				
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
	
	public double getDescuento(String prod){
		double desc = 0;
		
		sql = "{? = call dbo.UFC_Descuento_Producto(?)}";
		
		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.registerOutParameter(1, Types.DECIMAL);
			cstm.setString(2, prod);
			cstm.execute();
			desc = cstm.getDouble(1);
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
		
		return desc;
	}
	
	public boolean ProdEnPromocion(String cod, Date fecha){
		boolean existe = false;
		
		sql = "{? = call UDF_ProductoPromo(?,?)}";
		
		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.registerOutParameter(1, Types.INTEGER);
			cstm.setString(2, cod);
			cstm.setDate(3, fecha);
			cstm.execute();
			int resultado = cstm.getInt(1);
			if(resultado == 0){
				existe = false;
			}
			else{
				existe = true;
			}
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
		
		return existe;
	}
	
	public String nextCod() {
		sql = "{call USP_NextCod(?)}";
		String cod = "";
		try {
			con = Conexion.Conectar();
			cstm = con.prepareCall(sql);
			cstm.setString(1, "5");
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
