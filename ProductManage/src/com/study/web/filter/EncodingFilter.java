package com.study.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理编码
 */
public class EncodingFilter implements Filter {

	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		MyHttpServletRequest req = new MyHttpServletRequest((HttpServletRequest)request);
		HttpServletResponse resp = (HttpServletResponse)response;
		
		req.setCharacterEncoding("UTF-8");  // 处理post字符编码
		resp.setContentType("text/html;charset=UTF-8");
		
		// pass the request along the filter chain
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
