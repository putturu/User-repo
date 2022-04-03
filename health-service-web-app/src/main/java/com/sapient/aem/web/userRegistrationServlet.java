package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.exception.UserException;
import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;
import com.sapient.aem.service.UserService;
import com.sapient.aem.service.UserServiceImpl;
import com.sapient.aem.service.Validator;

@WebServlet("/user-reg")
public class userRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(userRegistrationServlet.class);
	private UserService userService= new UserServiceImpl();
	private Validator validator=new Validator();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		try {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String role=request.getParameter("role");
			
			Role myRole=null;
			if(role.equals("ADMIN")) {
				myRole= Role.ADMIN;
			}else if(role.equals("DOCTOR")) {
				myRole=Role.DOCTOR;
				
			}else if(role.equals("PATIENT")) {
				myRole=Role.PATIENT;
			}
			else {
				myRole=null;
			}
			
			if(validator.isValidName(username)) {
				userService.addUser(new User(username,password,myRole))	;
				if(role.equals("DOCTOR")) {
					request.getRequestDispatcher("WEB-INF/views/add-doctor.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("WEB-INF/views/add-patient.jsp").forward(request, response);
				}
				
			}else {
				out.println("<html><body><h2>"+"Enter Name Properly"+"</h2></body></html>");				
				request.getRequestDispatcher("WEB-INF/user-reg.jsp").include(request, response);
			}
			
		}catch(UserException e) {
			logger.error(e.getMessage(),e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
