package edu.pnu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class H2BoardPaging {
	
	public class BoardDTO {
		private int NUM;
		private String TITLE;
		private String CONTENT;
		private int ID;
		private java.sql.Date POSTDATE;
		private int VISITCOUNT;
		//getters and setters
		
		public Integer getNUM() {
			return NUM;
		}
		
		BoardDTO() {
			super();
			NUM = 0;
			TITLE = null;
			CONTENT = null;
			ID = 0;
			POSTDATE = null;
			VISITCOUNT = 0;
		}
		public void setNUM(int nUM) {
			NUM = nUM;
		}
		public String getTITLE() {
			return TITLE;
		}
		public void setTITLE(String tITLE) {
			TITLE = tITLE;
		}
		public String getCONTENT() {
			return CONTENT;
		}
		public void setCONTENT(String cONTENT) {
			CONTENT = cONTENT;
		}
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public java.sql.Date getPOSTDATE() {
			return POSTDATE;
		}
		public void setPOSTDATE(java.sql.Date pOSTDATE) {
			POSTDATE = pOSTDATE;
		}
		public int getVISITCOUNT() {
			return VISITCOUNT;
		}
		public void setVISITCOUNT(int vISITCOUNT) {
			VISITCOUNT = vISITCOUNT;
		}
		//print
		@Override
		public String toString() {
			return "[" + NUM + "], " + TITLE + ", " + CONTENT + ", " + ID + ", "
					+ POSTDATE + ", " + VISITCOUNT + "]";
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//connect to DB
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "tiger")){
			List<BoardDTO> bbs = new Vector<>();
			psmt = con.prepareStatement("SELECT * FROM Board WHERE NUM BETWEEN ? AND ?");
			psmt.setInt(1, 1);
			psmt.setInt(2, 10);
			rs = psmt.executeQuery();
			while(rs.next()) {
//				BoardDTO dto = new BoardDTO();
//				dto.setNUM(rs.getInt("NUM"));
//				dto.setTITLE(rs.getString("TITLE"));
//				dto.setCONTENT(rs.getString("CONTENT"));
//				dto.setID(rs.getInt("ID"));
//				dto.setPOSTDATE(rs.getDate("POSTDATE"));
//				dto.setVISITCOUNT(rs.getInt("VISITCOUNT"));
//				bbs.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
