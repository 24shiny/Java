package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import membership.MemberDAO;
import membership.MemberDTO;
import utils.JSFunction;

@WebFilter(filterName="LoginFilter", urlPatterns="/Ch15/LoginFilter.jsp")
public class LoginFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
		ServletContext application = filterConfig.getServletContext();
//		String MySQLDriver = application.getInitParameter("MySQLDriver");
//		String MySQLURL = application.getInitParameter("MySQLURL");
//		String MySQLId = application.getInitParameter("MySQLId");
//		String MySQLPwd = application.getInitParameter("MySQLPwd");
	}	
	@Override
	public void doFilter(ServletRequest req0, ServletResponse resp0, FilterChain fc)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)req0;
		HttpServletResponse resp = (HttpServletResponse)resp0;
		HttpSession session = req.getSession();
		String method = req.getMethod();
		if(method.equals("POST")) {
			String user_id = req0.getParameter("user_id");
			String user_pw = req0.getParameter("user_pw");
			MemberDAO dao = new MemberDAO();
			MemberDTO memberDTO = dao.getMemberDTO(user_id, user_pw);
			dao.close();
			
			if(memberDTO.getId()!=null) {
				session.setAttribute("UserId",memberDTO.getId());
				session.setAttribute("UserName", memberDTO.getName());
				String backUrl = req0.getParameter("backUrl");
				if(backUrl!=null&&!backUrl.equals("")) {
					JSFunction.alertLocation(resp, "forwarded to the previous page", backUrl);
					return;
				} else {
					resp.sendRedirect("./Ch15/LoginFilter.jsp");
				}
			} else {
				req.setAttribute("LoginErrMsg", "fail in login");
				req.getRequestDispatcher("./Ch15/LoginFilter.jsp").forward(req, resp);
			}
		} else if(method.equals("GET")) {
			String mode = req0.getParameter("mode");
			if(mode!=null&&mode.equals("loggout")) {
				session.invalidate();
			}
		}
		fc.doFilter(req0,resp0);
	}
	
}
