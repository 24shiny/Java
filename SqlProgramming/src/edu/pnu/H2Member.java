package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class H2Member {

	public static boolean createTable(Connection con) {
		Statement st = null;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter a number of ");
			st = con.createStatement();
			st.execute("DROP TABLE Member IF EXISTS");
			st.execute("CREATE TABLE Member ("
					+ "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
					+ "username varchar(10), "
					+ "password varchar(10), "
					+ "birthyear INT NOT NULL, "
					+ "regidate date NOT NULL default(curdate()))");
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(st!=null) st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public static boolean deleteMember(Connection con) {
		Statement st = null;
		try {
			st = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter what ID to delete : ");
			int id_in = sc.nextInt();
			st.execute("DELETE FROM Member WHERE ID=" + id_in);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(st!=null) st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static boolean updateMember(Connection con) {
		Statement st = null;
		try {
			st = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter what ID to update : ");
			int id_in = sc.nextInt();
			System.out.print("Enter its title : ");
			String username_in = sc.next();
			System.out.print("Enter its content : ");
			String password_in = sc.next();
			
			st.execute("UPDATE Board SET USERNAME= '" + username_in + "', PASSWORD='" + password_in + "' WHERE ID	=" + id_in);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(st!=null) st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static void printMember(Connection con) {
		Statement st = null;
		ResultSet rs = null;
		try {
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
				if(st != null) st.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("fail");
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "tiger")){
		
		//create
//		boolean flag = createTable(con);
//		if(flag) System.out.println("success");
//		Random rd = new Random();
//		PreparedStatement psmt = con.prepareStatement("insert into Member(username,password,birthyear) values(?,?,?)");
//		for(int i = 1 ; i <= 5 ; i ++) {
//			psmt.setString(1,"user"+i);
//			psmt.setString(2, "pass"+i);
//			psmt.setInt(3,rd.nextInt(11)+2000);
//			int result = psmt.executeUpdate();	
////			System.out.println(	Member 테이블에 "+ result + " 개가 입력되었습니다");
//		}
		
		//delete
		boolean flag2 = deleteMember(con);
		if(flag2) System.out.println("success in deletion");
		
		//update
		boolean flag3 = updateMember(con);
		if(flag3) System.out.println("success in update");
		
		//print
		printMember(con);
		
		}
		
		//print
		
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
