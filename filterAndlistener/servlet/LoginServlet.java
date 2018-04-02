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
 * ��½�߼�����
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// �ж��Ƿ��½�ɹ�
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username, password);
		List<User> users = UserDB.getUsers();
		if(users.contains(user)){
			// ��½�ɹ�������session����ת��index.jsp
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			out.print("3�����ת����ҳ");
			// ����·����Щ�Ĵ��벻Ҫд��
			response.setHeader("Refresh", "3;URL=" + request.getServletContext().getContextPath() + "/index.jsp"); 
			
		}else{
			// ��½ʧ�ܣ�����login.jsp
			out.print("3�����ת����½����");
			response.setHeader("Refresh", "3;URL=" + request.getServletContext().getContextPath() + "/login.jsp"); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
