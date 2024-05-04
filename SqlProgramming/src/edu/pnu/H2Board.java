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

public class H2Board {
	
	public static boolean createTable(Connection con) {
		Statement st = null;
		try {
			st = con.createStatement();
			st.execute("DROP TABLE Board IF EXISTS");
			st.execute("CREATE TABLE Board ("
					+ "num INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
					+ "title varchar(200) , "
					+ "content varchar(2000) , "
					+ "id INT NOT NULL, "
					+ "postdate date NOT NULL DEFAULT(curdate()), "
					+ "visitcount INT DEFAULT 0 )");
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
	
	public static boolean deleteBoard(Connection con) {
		Statement st = null;
		try {
			st = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter what NUM to delete : ");
			int num_in = sc.nextInt();
			st.execute("DELETE FROM Board WHERE NUM=" + num_in);
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

	public static boolean updateBoard(Connection con) {
		Statement st = null;
		try {
			st = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter what NUM to update : ");
			int num_in = sc.nextInt();
			System.out.print("Enter its title : ");
			String title_in = sc.next();
			System.out.print("Enter its content : ");
			String content_in = sc.next();
			
			st.execute("UPDATE Board SET TITLE= '" + title_in + "', CONTENT='" + content_in + "' WHERE NUM=" + num_in);
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "tiger")){

		// create table
//		boolean flag = createTable(con);
//		if(flag) System.out.println("success in creation");
//		Random rd = new Random();
//		PreparedStatement psmt = con.prepareStatement("insert into Board(id,visitcount) values(?,?)");
//		for(int i = 1 ; i <= 5 ; i ++) {
//			for(int j=1; j<=10; j++) {
//				psmt.setInt(1,i);
//				psmt.setInt(2,rd.nextInt(101));
//				int result = psmt.executeUpdate();	
//			System.out.println("Board 테이블에 "+ result + " 개가 입력되었습니다");
//			}
//		}
		
		// delete rows
//		boolean flag2 = deleteBoard(con);
//		if(flag2) System.out.println("success in deletion");
		
//		 update rows
		boolean flag3 = updateBoard(con);
		if(flag3) System.out.println("success in update");
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
