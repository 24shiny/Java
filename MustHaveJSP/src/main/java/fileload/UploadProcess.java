package fileload;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Ch13/UploadProcess.do")
//@WebServlet("/up")
@MultipartConfig(
 maxFileSize = 1024*1024*1,
 maxRequestSize = 1024*1024*10
)
public class UploadProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
			try {
				String saveDirectory = getServletContext().getRealPath("/Uploads");
				String originalFiledName = FileUtil.uploadFile(req, saveDirectory);
				String saveFileName = FileUtil.renameFile(saveDirectory, originalFiledName);
				insertMyFile(req, originalFiledName, saveFileName);
				resp.sendRedirect("FileList.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	private void insertMyFile(HttpServletRequest req, String ofileName, String sFileName) {
		String title = req.getParameter("title");
		String[] cateArray = req.getParameterValues("cate");
		StringBuffer cateBuf = new StringBuffer();
		if(cateArray == null) {
			cateBuf.append("no option selected");
		} else {
			for(String s : cateArray) {
				cateBuf.append(s+", ");
			}
		}
		MyFileDTO dto = new MyFileDTO();
		dto.setTitle(title);
		dto.setCate(cateBuf.toString());
		dto.setOfile(ofileName);
		dto.setSfile(sFileName);
		MyFileDAO dao = new MyFileDAO();
		dao.insertFile(dto);
		dao.close();
	}
}
