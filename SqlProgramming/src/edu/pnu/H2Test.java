package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class H2Test {
	
	public static boolean createTable(Connection con) {
		Statement st = null;
		try {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "tiger")){
		boolean flag = createTable(con);
		if(flag) System.out.println("success");
		Random rd = new Random();
		PreparedStatement psmt = con.prepareStatement("insert into Member(username,password,birthyear) values(?,?,?)");
		for(int i = 1 ; i <= 5 ; i ++) {
			psmt.setString(1,"user"+i);
			psmt.setString(2, "pass"+i);
			psmt.setInt(3,rd.nextInt(11)+2000);
			int result = psmt.executeUpdate();	
//			System.out.println("Member 테이블에 "+ result + " 개가 입력되었습니다");
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
