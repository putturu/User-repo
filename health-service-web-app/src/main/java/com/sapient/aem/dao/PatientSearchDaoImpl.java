package com.sapient.aem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sapient.aem.model.Doctor;
import com.sapient.aem.model.PatientHistory;

public class PatientSearchDaoImpl implements PatientSearchDAO {

	@Override
	public List<Doctor> searchByDoctorName(String doctorName) throws SQLException {
		String sql="select * from doctor where doctor_name=?";
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1,doctorName);

			ResultSet resultSet= preparedStatement.executeQuery(sql);
			
			List<Doctor> doctorList=new ArrayList<>();			
			while(resultSet.next()) {
				Doctor doctor=new Doctor();
				populateDoctor(resultSet,doctor);
				doctorList.add(doctor);		
			}

			return doctorList;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
		
	}
	private void populateDoctor(ResultSet resultSet,Doctor doctor) throws SQLException{
		doctor.setDoctorId(resultSet.getInt("doctor_id"));
		doctor.setDoctorName(resultSet.getString("doctor_name"));
		doctor.setSpecialization(resultSet.getString("specialization"));
		doctor.setAvailableTiming(resultSet.getString("available_timings"));
		doctor.setQualification(resultSet.getString("qualification"));
		doctor.setExperienceInYears(resultSet.getInt("experience_in_years"));
		doctor.setMobile(resultSet.getLong("mobile"));
		doctor.setEmail(resultSet.getString("email"));
		
		
	}
	

	@Override
	public List<Doctor> searchBySpecialization(String specialization) throws SQLException {
		String sql="select * from doctor where specialization=?";
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1,specialization);

			ResultSet resultSet= preparedStatement.executeQuery(sql);
			
			List<Doctor> doctorList=new ArrayList<>();			
			while(resultSet.next()) {
				Doctor doctor=new Doctor();
				populateDoctor(resultSet,doctor);
				doctorList.add(doctor);		
			}

			return doctorList;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
		
	}
	
	private void populatePatientHistory(ResultSet resultSet, PatientHistory patienthistory) throws SQLException {
		patienthistory.setPatientHistoryId(resultSet.getInt("patient_history_id"));
		patienthistory.setPatientName(resultSet.getString("patient_name "));
		patienthistory.setCaseSheetOpenDate(resultSet.getDate("case_sheet_open_date ").toLocalDate());
		patienthistory.setCaseSheetCloseDate(resultSet.getDate("case_sheet_close_date ").toLocalDate());		
		patienthistory.setHostipalDetails(resultSet.getString("hostipal_details "));
		patienthistory.setHealthStatistics(resultSet.getString("health_statistics "));
		patienthistory.setSymptoms(resultSet.getString("symptoms"));
		patienthistory.setPrescription(resultSet.getString("prescrption"));
		patienthistory.setDiet(resultSet.getString("diet"));
		patienthistory.setPatientId(resultSet.getInt("patient_id"));
	}

	@Override
	public List<PatientHistory> getHistoryByPatientId(Integer patientId) throws SQLException {
		String sql="select * from patient_history where patient_id= ?";
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			Statement statement= 
					connection.createStatement();

			ResultSet resultSet= statement.executeQuery(sql);
			
			List<PatientHistory> patientHistoryList=new ArrayList<>();			
			while(resultSet.next()) {
				PatientHistory patientHistory=new PatientHistory();
				populatePatientHistory(resultSet,patientHistory);
				patientHistoryList.add(patientHistory);		
			}

			return patientHistoryList;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
		
	}

}
