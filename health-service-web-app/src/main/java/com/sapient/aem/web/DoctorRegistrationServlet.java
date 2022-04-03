package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.model.Doctor;
import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;
import com.sapient.aem.service.DoctorService;
import com.sapient.aem.service.DoctorServiceImpl;
import com.sapient.aem.service.UserService;
import com.sapient.aem.service.UserServiceImpl;
import com.sapient.aem.service.Validator;

@WebServlet("/regDoc")
public class DoctorRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DoctorService doctorService = new DoctorServiceImpl();
	private static UserService userService = new UserServiceImpl();
	private static Validator validator = new Validator();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			
			String doctorName = request.getParameter("doctorname");
			String password = request.getParameter("password");
			String specilization = request.getParameter("specilization");
			String availabletimings = request.getParameter("availabletimings");
			String qualification = request.getParameter("qualification");
			String email = request.getParameter("email");
			String role=request.getParameter("role");
			Integer expirience = Integer.parseInt(request.getParameter("expirienceinyears"));;
			Long mobileNumber = Long.parseLong(request.getParameter("mobilenumber"));;
			Role myRole=null;
			if(validator.isValidName(doctorName)) {
				
				if(validator.isValidMobile(mobileNumber)) {
					
					if(validator.isValidEmail(email)) {
						
						if(role.equals("DOCTOR")) {
							out.print(false);
							myRole= Role.DOCTOR;
							String 	s1=userService.addUser(new User(doctorName,password,myRole));
							Integer  id=doctorService.addDoctor(new Doctor(doctorName,specilization,availabletimings,qualification,expirience,mobileNumber,email));
							if(s1!=null&&id!=null) {
								String message ="SignUp successfully  ! Please  Sing In";
								out.print("<html><body><h4 align=\"center\" style=\"color: green;\">"+message+"</h4></body><html>");
							}
							else {
								out.print("<html><body><h6 align=\"center\" style=\"color: red;\">unable to add data !</h4></body><html>");
								request.getRequestDispatcher("doctor-registration.jsp").include(request, response);
							}
						}
						else {
							out.print("<html><body><h6 align=\"center\">Please Select Role !</h6></body><html>");
							request.getRequestDispatcher("doctor-registration.jsp").include(request, response);
						}
						
					}else {
						out.print("<html><body><h4 align=\"center\">Enter Valid Email!</h4></body><html>");
						request.getRequestDispatcher("doctor-registration.jsp").include(request, response);
					}
					
				}else {
					out.print("<html><body><h4 align=\"center\">Enter Valid MobileNumber!</h4></body><html>");
					request.getRequestDispatcher("doctor-registration.jsp").include(request, response);
				}
				
			}else {
				out.print("<html><body><h4 align=\"center\">Enter Valid Name!</h4></body><html>");
				request.getRequestDispatcher("doctor-registration.jsp").include(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
