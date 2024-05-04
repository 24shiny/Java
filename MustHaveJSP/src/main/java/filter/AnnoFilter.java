package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(filterName="AnnoFilter", urlPatterns="/Ch15/AnnoFilter.jsp")
public class AnnoFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String searchField = req.getParameter("searchField");
		String searchWord = req.getParameter("searchWord");
		System.out.println("searchField : " + searchField);
		System.out.println("searchWord : " + searchWord);
		fc.doFilter(req, resp);
	}
	
}
