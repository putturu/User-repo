package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.exception.DoctorException;
import com.sapient.aem.model.Doctor;
import com.sapient.aem.service.DoctorService;
import com.sapient.aem.service.DoctorServiceImpl;
import com.sapient.aem.service.Validator;


@WebServlet("/add-doctor")
public class AddDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(AddDoctorServlet.class);
	private DoctorService doctorService= new DoctorServiceImpl();
	private Validator validator=new Validator();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {

			String dname= request.getParameter("dname");
			String specialization= request.getParameter("specialization");
			String availabletiming=request.getParameter("availabletiming");
			String qualification= request.getParameter("qualification");
			Integer expinyears= Integer.parseInt(request.getParameter("expinyears"));
			Long mobile= Long.parseLong(request.getParameter("mobile"));
			String email= request.getParameter("email");
            
			if(validator.isValidName(dname)) {
				if(validator.isValidMobile(mobile)) {
					if(validator.isValidEmail(email)) {

						Doctor doctor= 
								new Doctor(dname,specialization,availabletiming,qualification,expinyears,mobile,email);


						Integer doctorId=doctorService.addDoctor(doctor);
						if(doctorId !=null) {	
							request.getRequestDispatcher("getAllDoctor").forward(request, response);
						}else {
							response.getWriter().println("<html><body><h2>"+"Unable to add doctor"+"</h2></body></html>");
							request.getRequestDispatcher("WEB-INF/views/add-doctor.jsp")
							.include(request, response);
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

		}catch(DoctorException e) {
			logger.error(e.getMessage(),e);
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
