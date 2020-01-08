package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {

		public static Connection conn = null; 
		
		public static Connection getConnection()  { 	
			
			if(conn == null) {
				
//				String endpoint = "jdbc:oracle:thin:@database-1.cadwco3azhqc.us-east-2.rds.amazonaws.com:1521:ORCL";
//				String username = "admin";
//				String password = "password";
				String driver = "oracle.jdbc.driver.OracleDriver";
				try {
					Class.forName(driver);
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Properties props = new Properties();
				
				FileInputStream input;
				try {
					input = new FileInputStream(JDBCConnection.class.getClassLoader().getResource("connection.properties").getFile());
					props.load(input);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					
				
				
				String endpoint = props.getProperty("url");
				String username = props.getProperty("username");
				String password = props.getProperty("password");
				
				
				try {
					
					conn = DriverManager.getConnection(endpoint, username, password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				return conn;
			}
			
			return conn;
		}
		
		public static void main(String[] args) throws IOException {
			
			Connection conn1 = getConnection();
			System.out.println(conn1);
		}
}
