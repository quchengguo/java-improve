package com.myhttpservlet.request;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/** 
* @author quchengguo
* @version 2018年4月2日 下午2:52:17 
* 包装HttpServletRequest
*/
public class MyHttpServletRequest extends HttpServletRequestWrapper{
	
	/**
	 * 将被包装的类传入
	 * @param request 被包装的类
	 */
	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		// 获取请求方式
		if("GET".equals(super.getMethod())){
			try {
				String value = super.getParameter(name);
				return new String(value.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// post 方式
		return super.getParameter(name);
	}

}
