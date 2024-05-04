package edu;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gugudan02")
public class Gugudan02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("executed");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		String dir = req.getParameter("dir");
		if(dir.equals("ver")) {
			out.println("vertical number table");
			for(int i=2; i<9; i++) {
				for(int j=1; j<9; j++) {
				out.println(i + "*" + j + "=" + i*j + "<br/>");
				}
				out.println("<br/>");
			}
		} else if (dir.equals("hor")) {
			out.println("horizontal number table");
			out.println("<table border= \"1\">\n <tbody>\n");
			for(int i=2; i<10; i++) {
				out.print("<tr>\n");
				for(int j=2; j<10; j++) {
					out.print("<th>" + j + "*" + i + "=" + i*j + "</th>");
				}
				out.print("</tr>\n");
			}
			out.println("</tbody>\n </table>");
		} 
		out.close();
	}
}
