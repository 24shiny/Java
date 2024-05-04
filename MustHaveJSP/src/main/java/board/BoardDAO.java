package board;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import Common.JDBConnect;

public class BoardDAO extends JDBConnect {
	public BoardDAO(){
		super();
	}
	public int selectCount(Map<String, Object> map) {
		int totalCount = 1;
		String query = "SELECT COUNT(*) FROM board";
		if(map.get("searchWord")!=null) {
			query += "WHERE " + map.get("searchField") + " "
					+ "LIKE '%" + map.get("searchWord") + "%'";
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return totalCount;
	}
	public List<BoardDTO> selectList(Map<String,Object> map){
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		String query = "SELECT  * FROM board";
		if(map.get("searchWord")!=null) {
			query += "WHERE " + map.get("searchField") + " "
					+ "LIKE '%" + map.get("searchWord") + "%' ";
		}
//		query += "ORDER BY num DESC; ";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("Visitcount"));
				bbs.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bbs;
	}
	public List<BoardDTO> selectListPage(Map<String,Object> map){
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		String query = "SELECT * FROM board ";
		if(map.get("searchWord")!=null) {
			query += " WHERE " + map.get("searchField") + " LIKE '%" + map.get("searchWord") + "%'";
		}
		query += " ORDER BY num DESC limit ?,?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, (int)map.get("start"));
			psmt.setInt(2, (int)map.get("pageSize"));
//			psmt.setString(1, map.get("start").toString());
//			psmt.setString(2, map.get("pageSize").toString());
			rs = psmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId("id");
				dto.setVisitcount(rs.getString("visitcount"));
				bbs.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bbs;
	}
	public int insertWrite(BoardDTO dto) {
		int result = 0;
		try {
			String query = "INSERT INTO board (title, content, id, visitcount) "
							+ "VALUES (?, ?, ?, 0)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public BoardDTO selectView(String num) {
		BoardDTO dto = new BoardDTO();
		String query = "SELECT B.*, M.name From member M INNER JOIN board B ON M.id=B.id WHERE num=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setName(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString(6));
				dto.setName(rs.getString("name"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public void updateVisitcount(String num) {
		String query = "UPDATE board SET visitcount=visitcount+1 WHEHRE num=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateEdit(BoardDTO dto) {
		int result = 0;
		try {
			String query = "UPDATE board SET title=?, content=? WHERE num=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getNum());
			result = psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int deletePost(BoardDTO dto) {
		int result=0;
		try {
			String query = "DELETE FROM board WHERE num=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getNum());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
