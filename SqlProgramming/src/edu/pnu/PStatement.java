package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class PStatement {
	public static void main(String[] args) {
		Connection con = null;	
		Statement st = null;
		ResultSet rs = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			// =======================================
			PreparedStatement pt = con.prepareStatement("select * from city WHERE CountryCode=?");
			pt.setString(1, "KOR");
			rs = pt.executeQuery();
			// =======================================
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			for(int i=1; i<=count; i++) {
				System.out.print(meta.getColumnLabel(i) + "\t");
			}
			System.out.println();
			while(rs.next()) { // cursor processing
				for(int i=1; i<=count; i++) {
				System.out.print(rs.getString(i) + (i==count ? " ": ",\t"));
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		} finally {
				try {
					if(con != null) con.close();
					if(rs != null) rs.close();
					if(st != null) st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
