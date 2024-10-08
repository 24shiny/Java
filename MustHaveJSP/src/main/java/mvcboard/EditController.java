package mvcboard;

import java.io.IOException;

import fileload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.JSFunction;

@WebServlet("/Ch14/edit.do")
@MultipartConfig(
		maxFileSize = 1024*1024*1,
		maxRequestSize = 1024*1024*10
)
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idx = req.getParameter("idx");
		MVCBoardDAO dao = new MVCBoardDAO();
		MVCBoardDTO dto = dao.selectView(idx);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/Ch14/Edit.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String saveDirectory = req.getServletContext().getRealPath("/Uploads");
		String originalFileName="";
		try {
			originalFileName = FileUtil.uploadFile(req, saveDirectory);
		} catch (Exception e) {
			JSFunction.alertBack(resp, "error in uploading a file");
			return;
		}
		String idx = req.getParameter("idx");
		String prevOfile = req.getParameter("prevOfile");
		String prevSfile = req.getParameter("prevSfile");
		String name = req.getParameter("name");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		HttpSession session = req.getSession();
		String pass = (String)session.getAttribute("pass");
		MVCBoardDTO dto = new MVCBoardDTO();
		dto.setIdx(idx);
		dto.setName(name);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setPass(pass);
		if(originalFileName!="") {
			String savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);
			dto.setOfile(originalFileName);
			dto.setSfile(savedFileName);
			FileUtil.deleteFile(req, "/Uploads", prevSfile);
		} else {
			dto.setOfile(prevOfile);
			dto.setSfile(prevSfile);
		}
		MVCBoardDAO dao = new MVCBoardDAO();
		int result = dao.updatePost(dto);
		dao.close();
		if(result==1) {
			session.removeAttribute("pass");
			resp.sendRedirect("./view.do?idx" + idx);
		} else {
			JSFunction.alertLocation(resp, "check the password", "./view.do?idx="+idx);
		}
	}
}
