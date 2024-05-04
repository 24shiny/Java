package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DriverLoading {
	public static void main(String[] args) {
		Connection con = null;		
		try(Scanner sc = new Scanner(System.in)) {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Enter a table name (country, city or countrylanguage : ");
			String tbname = sc.next();
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
		
//		test1();
//		test2();
	}
	public static void test1(){
		// TODO Auto-generated method stub
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from country");
			System.out.println("countries : ");
			while(rs.next()) { // cursor processing
				System.out.println(rs.getString("name"));
			}
			
			rs = st.executeQuery("select name, population from city where countrycode='KOR' order by population desc");
			System.out.println("\ncities and their populations : ");
			while(rs.next()) { // cursor processing
				System.out.println(rs.getString("name") + ", " + rs.getString("population"));
			}
						
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("fail");
			e.printStackTrace();
		}
	}
	
	public static void test2(){
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
		
		st = con.createStatement();		
		rs = st.executeQuery("select * from country limit 10");
		ResultSetMetaData meta = rs.getMetaData();
		int count = meta.getColumnCount();
		System.out.println("data from country table : ");
		
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
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
	
	public static void test3(Connection con, String tbname){
		Statement st = null;
		ResultSet rs = null;
		try {
		
		st = con.createStatement();		
		rs = st.executeQuery("select * from " + tbname + " limit 10");
		ResultSetMetaData meta = rs.getMetaData();
		int count = meta.getColumnCount();
		System.out.println("data from country table : ");
		
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
