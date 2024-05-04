package mvcboard;

import java.io.IOException;

import fileload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JSFunction;

public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		req.getRequestDispatcher("/Ch14/Write.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	String saveDirectory = req.getServletContext().getRealPath("/Uloads");
	String originalFileName = "";
	try {
		originalFileName = FileUtil.uploadFile(req, saveDirectory);
	} catch (Exception e) {
		JSFunction.alertLocation(resp, "error", "./write.do");
	}
	MVCBoardDTO dto = new MVCBoardDTO();
	dto.setName(req.getParameter("name"));
	dto.setTitle(req.getParameter("title"));
	dto.setContent(req.getParameter("content"));
	dto.setPass(req.getParameter("pass"));
	if(originalFileName!="") {
		String savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);
		dto.setOfile(originalFileName);
		dto.setSfile(savedFileName);
	}
	MVCBoardDAO dao = new MVCBoardDAO();
	int result = dao.inserWrite(dto);
	dao.close();
	if(result==1) {
		resp.sendRedirect("./list.do");
	} else {
		resp.sendRedirect("./write.do");
//		JSFunction.alertLocation(resp, "error", "../write.do");
	}
	}
}
