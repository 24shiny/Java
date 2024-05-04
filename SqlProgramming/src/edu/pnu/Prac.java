package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Prac {

	public static void main(String[] args) {
		while(true) {
		Connection con = null;		
		try{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter field :");
			String field = sc.next();
			if(field == "done") break;
			System.out.print("\nEnter condition :");
			String condition = sc.next();
			System.out.print("\nEnter values :");
			String values = sc.next();
			test3(con, field, condition, values);
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
	}
	
	public static void test3(Connection con, String field, String condition, String values){
		Statement st = null;
		ResultSet rs = null;
		try {
		
		st = con.createStatement();
		rs = st.executeQuery("select * from city where " + field + " " + condition + "(" + values + ")") ;
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
