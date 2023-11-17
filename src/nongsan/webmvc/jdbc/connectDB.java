package nongsan.webmvc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connectDB {
	public connectDB(){
		super();
	}
	public static Connection getConnect(){
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String connString      ="jdbc:sqlserver://DESKTOP-4LTEG87\\SQLEXPRESS:1433;databaseName=QLNS;useUnicode=true;characterEncoding=UTF-8;   trustServerCertificate=true";
			String username = "";
			String password = "";
			connection = DriverManager.getConnection(connString,username,password);
			
			//connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;user=sa;password=123;useUnicode=true;characterEncoding=UTF-8");
			System.out.println("Kết nối thành công!");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Kết nối thất bại!"+e.getMessage());
		}
		return connection;
	}
	public static void main(String[] args) {
		System.out.println(getConnect());
	}
}