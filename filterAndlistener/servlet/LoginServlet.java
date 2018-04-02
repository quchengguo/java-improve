package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.User;
import com.domain.UserDB;

/**
 * 登陆逻辑处理
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// 判断是否登陆成功
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username, password);
		List<User> users = UserDB.getUsers();
		if(users.contains(user)){
			// 登陆成功，设置session并跳转至index.jsp
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			out.print("3秒后跳转到首页");
			// 关于路径这些的代码不要写死
			response.setHeader("Refresh", "3;URL=" + request.getServletContext().getContextPath() + "/index.jsp"); 
			
		}else{
			// 登陆失败，返回login.jsp
			out.print("3秒后跳转到登陆界面");
			response.setHeader("Refresh", "3;URL=" + request.getServletContext().getContextPath() + "/login.jsp"); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
