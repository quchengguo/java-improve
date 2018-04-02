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
 * �޻���filter
 */
public class NoCacheFilter implements Filter {

   
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		
		res.setDateHeader("Expires", -1);//������������Ի���೤ʱ�� -1 ���� 0 ��ʾ������
		res.setHeader("Cache_Control", "no-cache");//֧��http1.1 �����������Ҫ����
		res.setHeader("Pragma", "no-cache");//֧��http1.0 �����������Ҫ����
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
