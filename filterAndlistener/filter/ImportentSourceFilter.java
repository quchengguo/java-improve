package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.impl.ior.GenericTaggedComponent;

/**
 * 拦截  /importent 下的资源
 */
public class ImportentSourceFilter implements Filter {

   

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("user");
		
		// 判断session中的user是否为空
		if(obj != null){
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}else{
			resp.getWriter().println("请您先登陆，3秒后跳转到登陆页面");
			resp.setHeader("Refresh", "3;URL=" + req.getServletContext().getContextPath() + "/login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
