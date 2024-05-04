package membership;
import Common.JDBConnect;
public class MemberDAO extends JDBConnect {
	
	public static void main(String[] args) {
//		String driver = "com.mysql.cj.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306/musthave";
//		String id = "musthave";
//		String pwd = "tiger";
//		MemberDAO dao = new MemberDAO(driver, url, id, pwd);
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMemberDTO("canhave", "1446");
		System.out.println(dto.toString());
	}	
	public MemberDAO() {
		super();
	}
	public MemberDAO(String driver, String url, String id, String pwd) {
		super(driver, url, id, pwd);
	}
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO();
		String query = "SELECT * FROM member WHERE id=? AND pass=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs= psmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
