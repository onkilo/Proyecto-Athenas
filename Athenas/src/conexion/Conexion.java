package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	private static String bd = "BDAthenas";
	private static String user = "sa";
	private static String pass = "sql";
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=" + bd;
	
	
	public static Connection Conectar(){
		Connection con = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
}
