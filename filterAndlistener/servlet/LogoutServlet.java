package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 注销逻辑处理
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取字符输出流对象
		PrintWriter out = response.getWriter();
		
		//获取session对象
		HttpSession session = request.getSession();
		session.invalidate();
		
		out.println("注销成功！3秒后跳转到首页！");
		response.setHeader("Refresh", "3;URL=/myFilterListener/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
