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

import com.myhttpservlet.request.MyHttpServletRequest;

/**
 * filter入门案例
 * 	filter是一个具有拦截过滤功能的servlet
 */
public class EncodingFilter implements Filter {
	private String encoding;

  
    public EncodingFilter() {
    	System.out.println("MyFilter constructor");
    }
    
    public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("MyFilter init");
    	this.encoding = fConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	
    	System.out.println("my doFilter");
    	MyHttpServletRequest req = new MyHttpServletRequest((HttpServletRequest) request);
    	HttpServletResponse resp = (HttpServletResponse) response;
    	req.setCharacterEncoding(encoding);
    	resp.setContentType("text/html;charset=" + encoding); 
    	
    	// pass the request along the filter chain
    	chain.doFilter(req, resp);
    }
    
	public void destroy() {
		System.out.println("MyFilter destroy");
	}

}
