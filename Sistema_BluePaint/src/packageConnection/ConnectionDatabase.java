package packageConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDatabase {
	private final static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final static String URL = "jdbc:sqlserver://localhost:54664;encrypt=false;databaseName=Budega";
	private final static String User = "sa";
	private final static String password = "Senailab05";

	public static Connection getConnection() {
		try {
			Class.forName(Driver);
			System.out.print("Conexão estabelecida! ");
			return DriverManager.getConnection(URL, User, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro de conexão!", e);
		}
		
	}
		public static void closeConnection(Connection con) {
			try {
				if(con != null) {
					con.close();
					System.out.println("Conexão fechada!");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
		     	e.printStackTrace();
			
		}
}
		
		public static void closeConnection(Connection con, PreparedStatement stmt) {
			closeConnection(con); 
			try {
				if(stmt != null) {
					stmt.close();
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
			closeConnection(con,stmt);
			
			try {
				if(rs != null) {
					rs.close();
}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
}
}