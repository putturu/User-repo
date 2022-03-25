package com.sapient.aem.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sapient.aem.model.User;
import com.sapient.aem.service.UserService;
import com.sapient.aem.service.UserServiceImpl;

/**
 * Servlet implementation class UserDetaislServlet
 */
@WebServlet("/UserDetaislServlet")
public class UserDetaislServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserService userService = new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<User> l = userService.getAllUSers();
			request.setAttribute("user", l);
			request.getRequestDispatcher("./webapp/index.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
