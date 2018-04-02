package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 无缓存filter
 */
public class NoCacheFilter implements Filter {

   
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		
		res.setDateHeader("Expires", -1);//告诉浏览器可以缓存多长时间 -1 或者 0 表示不缓存
		res.setHeader("Cache_Control", "no-cache");//支持http1.1 告诉浏览器不要缓存
		res.setHeader("Pragma", "no-cache");//支持http1.0 告诉浏览器不要缓存
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
