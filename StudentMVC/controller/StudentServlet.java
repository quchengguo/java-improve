package com.mvcstudy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvcstudy.domain.Student;
import com.mvcstudy.service.StudentService;

/**
 * 控制层
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * 获取所有学生信息，转发到list.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService stuService = new StudentService();
		try {
			List<Student> students = stuService.findAll();
			for(Student stu : students){
				System.out.println(stu.getSname());
			}
			request.setAttribute("list", students);
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
