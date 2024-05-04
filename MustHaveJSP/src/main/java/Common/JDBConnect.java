package Common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletContext;

public class JDBConnect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	public JDBConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/musthave";
			String id = "musthave";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("success in connection1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public JDBConnect(String driver, String url, String id, String pwd) {
		try {
			Class.forName(driver);
//			String url = "jdbc:mysql://localhost:3306/musthave";
//			String id = "musthave";
//			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("success in connection2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public JDBConnect(ServletContext application) {
		try {
			String driver = application.getInitParameter("MySQLDriver");
			Class.forName(driver);
//			String url = "jdbc:mysql://localhost:3306/musthave";
//			String id = "musthave";
//			String pwd = "tiger";
			String url = application.getInitParameter("MySQLURL");
			String id = application.getInitParameter("MySQLId");
			String pwd = application.getInitParameter("MySQLPwd");
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("success in connection3");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(psmt!=null) psmt.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
