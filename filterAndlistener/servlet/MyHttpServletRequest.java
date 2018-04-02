package com.myhttpservlet.request;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/** 
* @author quchengguo
* @version 2018��4��2�� ����2:52:17 
* ��װHttpServletRequest
*/
public class MyHttpServletRequest extends HttpServletRequestWrapper{
	
	/**
	 * ������װ���ഫ��
	 * @param request ����װ����
	 */
	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		// ��ȡ����ʽ
		if("GET".equals(super.getMethod())){
			try {
				String value = super.getParameter(name);
				return new String(value.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// post ��ʽ
		return super.getParameter(name);
	}

}
