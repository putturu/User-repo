package com.sapient.aem.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.exception.PatientCaseSheetException;
import com.sapient.aem.model.PatientCaseSheet;
import com.sapient.aem.service.PatientCaseSheetService;
import com.sapient.aem.service.PatientCaseSheetServiceImpl;


@WebServlet("/getAllPatientCaseSheet")
public class GetPatientCaseSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PatientCaseSheetService patientCaseSheetService= new PatientCaseSheetServiceImpl();
	private Logger logger= Logger.getLogger(GetPatientCaseSheetServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer doctorId= Integer.parseInt(request.getParameter("doctorId"));
			List<PatientCaseSheet> patientCaseSheetList =  patientCaseSheetService.getPatientCasesheetByDoctorId(doctorId);
			if(patientCaseSheetList != null) {
				request.setAttribute("patientCaseSheetList",patientCaseSheetList );
				request.getRequestDispatcher("WEB-INF/views/show-patient-case-sheet.jsp").include(request, response);
				
					
			}else {
				request.setAttribute("message", "Invalid DoctorId");
				request.getRequestDispatcher("WEB-INF/views/status.jsp")
				.forward(request, response);
			}
			
			


		}catch(PatientCaseSheetException e) {
			logger.error(e.getMessage(),e);
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
