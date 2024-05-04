package edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/myservlet05")
public class MyServlet05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("myservlet");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		// #1
		out.println("<h1>country table 1</h1>");
		List<String> thead = Arrays.asList("num", "country","capital","population");
		List<String> col1 = Arrays.asList("1","2","3","4");
		List<String> col2 = Arrays.asList("Korea","USA","Japan","China");
		List<String> col3 = Arrays.asList("Seoul","Washington","Tokyo","Beijing");
		List<String> col4 = Arrays.asList("1000M","70M","1400M","2100M");
		Iterator<String> iter1 = col1.iterator();
		Iterator<String> iter2 = col2.iterator();
		Iterator<String> iter3 = col3.iterator();
		Iterator<String> iter4 = col4.iterator();
		out.println("<table border= \"1\">\n <thead>\n <tr>");
		for(int i=0; i<thead.size(); i++) {
			out.print("<th>" + thead.get(i)+ "</th>");
		}
		out.println("</tr>\n </thead>\n <tbody>\n");
		while(iter1.hasNext() & iter2.hasNext() & iter3.hasNext() & iter4.hasNext()) {
			out.print("<tr>\n");
			out.print("<th>" + iter1.next()+ "</th>");
			out.print("<th>" + iter2.next()+ "</th>");
			out.print("<th>" + iter3.next()+ "</th>");
			out.print("<th>" + iter4.next()+ "</th>");
			out.print("</tr>\n");
		}
		out.println("</tbody>\n </table>");
		out.close();
	}
}
