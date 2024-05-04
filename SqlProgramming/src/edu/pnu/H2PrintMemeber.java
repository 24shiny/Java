package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class H2PrintMemeber {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "tiger");
			st = con.createStatement();	
			rs = st.executeQuery("select * from board");
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			while(rs.next()) { // cursor processing
				for(int i=1; i<=count; i++) {
				System.out.print(rs.getString(i) + (i==count ? " ": ",\t"));
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			System.out.println("fail");
			e.printStackTrace();		
		} finally {
			
				try {
					if(con != null) con.close();
					if(st != null) st.close();
					if(rs != null) rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("fail");
					e.printStackTrace();
				}
		}
	}

}
