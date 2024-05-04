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

@WebServlet("/myservlet04")
public class MyServlet04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("myservlet");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		// #1
		out.println("<h1>country table 1</h1>");
		List<String> thead = Arrays.asList("num", "country","capital");
		List<String> col1 = Arrays.asList("1","2","3","4");
		List<String> col2 = Arrays.asList("Korea","USA","Japan","China");
		List<String> col3 = Arrays.asList("Seoul","Washington","Tokyo","Beijing");
		Iterator<String> iter1 = col1.iterator();
		Iterator<String> iter2 = col2.iterator();
		Iterator<String> iter3 = col3.iterator();
		out.println("<table border= \"1\">\n <thead>\n <tr>");
		for(int i=0; i<thead.size(); i++) {
			out.print("<th>" + thead.get(i)+ "</th>");
		}
		out.println("</tr>\n </thead>\n <tbody>\n");
		while(iter1.hasNext() & iter2.hasNext() & iter3.hasNext()) {
			out.print("<tr>\n");
			out.print("<th>" + iter1.next()+ "</th>");
			out.print("<th>" + iter2.next()+ "</th>");
			out.print("<th>" + iter3.next()+ "</th>");
			out.print("</tr>\n");
		}
		out.println("</tbody>\n </table>");
		
		// #2
		out.println("<h1>country table 2</h1>");
		ArrayList<List<String>> lol = new ArrayList<>();
		List<String> ent1 = Arrays.asList("num","1","2","3","4");
		List<String> ent2 = Arrays.asList("country","Korea","USA","Japan","China");
		List<String> ent3 = Arrays.asList("capital","Seoul","Washington","Tokyo","Beijing");
		lol.add(ent1); lol.add(ent2); lol.add(ent3); 
		out.println("<table border= \"1\">\n <thead>\n <tr>");
//		for(int i=0; i<lol.get(0).size(); i++) {
//			out.print("<th>" + lol.get(0).get(i)+ "</th>");
//		}
		out.println("</tr>\n </thead>\n <tbody>\n");
		for(int i=0; i<lol.size(); i++) {
			out.print("<tr>\n");
			for(int j=0; j<lol.get(i).size(); j++) {
				out.print("<th>" + lol.get(i).get(j)+ "</th>");
			}
			out.print("</tr>\n");
		}
		out.println("</tbody>\n </table>");
		out.close();
	}
}
