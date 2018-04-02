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
 * ����  /importent �µ���Դ
 */
public class ImportentSourceFilter implements Filter {

   

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("user");
		
		// �ж�session�е�user�Ƿ�Ϊ��
		if(obj != null){
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}else{
			resp.getWriter().println("�����ȵ�½��3�����ת����½ҳ��");
			resp.setHeader("Refresh", "3;URL=" + req.getServletContext().getContextPath() + "/login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
