package negocio;

import java.sql.*;
import java.util.ArrayList;

import conexion.Conexion;
import entidades.CategoriaProducto;

public class NegocioCategoria {
	
	private Connection con;
	private CallableStatement cstm;
	private PreparedStatement pst;
	private Statement st;
	private String sql = "";
	private ResultSet rs;
	
	public ArrayList<CategoriaProducto> Listar(){
		ArrayList<CategoriaProducto> lista = new ArrayList<CategoriaProducto>();
		
		sql = "SELECT ID, Descripcion FROM Cat_Prod";
		
		try {
			con = Conexion.Conectar();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				CategoriaProducto cat = new CategoriaProducto();
				cat.setID(rs.getString("ID"));
				cat.setDescripcion(rs.getString("Descripcion"));
				
				lista.add(cat);
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

}
