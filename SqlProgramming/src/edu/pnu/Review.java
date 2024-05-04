package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Review {
	public static void main(String[] args) {
		Connection con = null;		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			String tbname = "city";
			test3(con, tbname);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static void test3(Connection con, String tbname){
		Statement st = null;
		ResultSet rs = null;
		try {
		st = con.createStatement();		
		
		//#1
		rs = st.executeQuery("SELECT CountryCode, Name, Population\r\n"
				+ " FROM world.city\r\n"
				+ " WHERE CountryCode='KOR'\r\n"
				+ " order by Population DESC");
		ResultSetMetaData meta = rs.getMetaData();
		int count = meta.getColumnCount();
		System.out.println("data from " + tbname + " table : ");
		
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
		// TODO Auto-generated catch block
		System.out.println("fail");
		e.printStackTrace();
	} finally {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
}
