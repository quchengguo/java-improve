package com.study.web.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/** 
* @author quchengguo
*/
public class MyHttpServletRequest extends HttpServletRequestWrapper{

	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		String method = super.getMethod();
		
		// 千万不要给name加双引号
		String value = super.getParameter(name);
		
		if(value == null){
			return null;
		}
		
		if("GET".equals(method)){
//			String value = super.getParameter("name");
			try {
				return new String(value.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}
}
