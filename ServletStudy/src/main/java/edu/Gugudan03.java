package edu;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gugudan03")
public class Gugudan03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("executed");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		String dan = req.getParameter("dan"); //dan->num
		int num =3;
		if(dan!=null) {
			num = Integer.parseInt(dan);
		}
		int row = Math.floorDiv(9,num);
		System.out.println(row);
		out.println("<h1>" + num +" tables in a row</h1>");
		out.println("<table border= \"1\">\n");
		for(int i=0; i<row; i++) {
			out.println("<tbody>\n <tr>\n");
			for(int j=0; j<num; i++) {
				out.print("<tr>\n");
				for(int k=1; k<9; i++) {
					out.print("<th>" + i + j + k +"</th>");
				}
			}
			out.println("</tr>\n </tbody>\n");
		}
		out.println("</table>\n");
		out.close();
	}
}
