package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NewPrac {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count2 = 0;
		String tempQuery = "select * from city where ";
		try{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter field : ");
			String field = sc.next();
			if(count2>=1) tempQuery = tempQuery + " and ";
			System.out.print("\nEnter condition :");
			String condition = sc.next();
			System.out.print("\nEnter values :");
			String values = sc.next();
			count2++; 
			tempQuery = tempQuery + field + " " + condition + "(" + values + ")";		
			st = con.createStatement();
			rs = st.executeQuery(tempQuery) ;
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			for(int i=1; i<=count; i++) {
				System.out.print(meta.getColumnLabel(i) + "\t");
			}
			System.out.println();
			
			while(rs.next()) { // cursor processing
				for(int i=1; i<=count; i++) {
				System.out.printf("%20s", rs.getString(i));
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				try {
					if(con != null) con.close();
					if(rs != null) rs.close();
					if(st != null) st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		} // end of while
	}

