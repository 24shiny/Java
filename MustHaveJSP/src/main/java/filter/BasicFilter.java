package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class BasicFilter implements Filter{
	FilterConfig config;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
		config = filterConfig;
		String filterName = filterConfig.getFilterName();
		System.out.println("BasicFilter -> init() : " + filterName);
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String filterInitParam = config.getInitParameter("FILTER_INIT_PARAM");
		System.out.println("BasicFilter -> initialized parameter : " + filterInitParam);
		String method = ((HttpServletRequest)req).getMethod();
		System.out.println("BasicFilter -> forwading method : " + method);
		fc.doFilter(req, resp);
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
		System.out.println("BasicFilter -> destroy()");
	}
}
