package edu;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gugudan01")
public class Gugudan01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("executed");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		String snum = req.getParameter("num");
		int num =2;
		if(snum!=null) {
			num = Integer.parseInt(snum);
		}
		out.println("<h1>" + num + "number table</h1>");
		for(int i=1; i<9; i++) {
			out.println(num + "*" + i + "=" + num*i + "<br/>");
		}
		out.close();
	}
}
