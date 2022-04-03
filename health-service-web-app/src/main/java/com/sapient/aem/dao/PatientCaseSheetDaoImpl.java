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

import com.sapient.aem.model.PatientCaseSheet;

public class PatientCaseSheetDaoImpl implements PatientCaseSheetDAO {
	@Override
	public PatientCaseSheet getPatientCaseSheetById(Integer patientCaseSheetId) throws SQLException {
		String sql="select * from patient_case_sheet where patient_case_sheet_id = ?";
		Connection connection=null;
		try {
			
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, patientCaseSheetId);
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				PatientCaseSheet patientCaseSheet= new PatientCaseSheet();
				
				populatePatientCaseSheet(resultSet,patientCaseSheet);
				return patientCaseSheet;				
			}else {
				return null;
			}

		}catch(SQLException e) {
			
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}

	}
	
	private void populatePatientCaseSheet(ResultSet resultSet, PatientCaseSheet patientCaseSheet) throws SQLException{
		
		patientCaseSheet.setPatientCaseSheetId(resultSet.getInt("patient_case_sheet_id"));
		patientCaseSheet.setPatientName(resultSet.getString("patient_name"));
		patientCaseSheet.setCaseSheetOpenDate(resultSet.getDate("case_sheet_open_date").toLocalDate());
		patientCaseSheet.setCaseSheetCloseDate(resultSet.getDate("case_sheet_close_date").toLocalDate());
		patientCaseSheet.setHostipalDetails(resultSet.getString("hostipal_details"));
		patientCaseSheet.setHealthStatistics(resultSet.getString("health_statistics"));
		patientCaseSheet.setSymptoms(resultSet.getString("symptoms"));
		patientCaseSheet.setPrescription(resultSet.getString("prescription"));
		patientCaseSheet.setDiet(resultSet.getString("diet"));
		patientCaseSheet.setStatus(resultSet.getString("status"));
		patientCaseSheet.setPatientId(resultSet.getInt("patient_id"));
		patientCaseSheet.setDoctorId(resultSet.getInt("doctor_id"));

	}
	
	@Override
	public List<PatientCaseSheet> getPatientCasesheet() throws SQLException {
		String sql= "select * from patient_case_sheet";
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			Statement statement= 
					connection.createStatement();

			ResultSet resultSet= statement.executeQuery(sql);
			
			List<PatientCaseSheet> patientCaseSheetList=new ArrayList<>();			
			while(resultSet.next()) {
				PatientCaseSheet patientCaseSheet= new PatientCaseSheet();
				populatePatientCaseSheet(resultSet,patientCaseSheet);
				patientCaseSheetList.add(patientCaseSheet);				
			}

			return patientCaseSheetList;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	@Override
	public Integer addPatientCaseSheet(PatientCaseSheet patientCaseSheet) throws SQLException {
		String sql= "insert into patient_case_sheet(patientCaseSheetId,patientName,caseSheetOpenDate,caseSheetCloseDate,hostipalDetails,healthStatistics,symptoms,prescription,diet,status,patientId,doctorId) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);

			preparedStatement.setString(1, patientCaseSheet.getPatientName());
			preparedStatement.setDate(2,java.sql.Date.valueOf(patientCaseSheet.getCaseSheetOpenDate()));
			preparedStatement.setDate(3,java.sql.Date.valueOf(patientCaseSheet.getCaseSheetCloseDate()));
			preparedStatement.setDate(4, java.sql.Date.valueOf(patientCaseSheet.getHostipalDetails()));
			preparedStatement.setString(5, patientCaseSheet.getHealthStatistics());
			preparedStatement.setString(6, patientCaseSheet.getDiet());
			preparedStatement.setString(7, patientCaseSheet.getStatus());
			preparedStatement.setInt(8, patientCaseSheet.getPatientId());
			preparedStatement.setInt(9, patientCaseSheet.getDoctorId());
			preparedStatement.setString(10, patientCaseSheet.getPrescription());
			int n= preparedStatement.executeUpdate();
			if(n>0) {
				return this.getMaxId();
			}else {
				throw new SQLException("Unable to add record");
			}

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}

	}
	@Override
	public String updatePatientCaseSheet(PatientCaseSheet patientCaseSheet) throws SQLException {
		String sql="update patient_case_sheet set caseSheetOpenDate=?,caseSheetCloseDate=?,hostipalDetails=?,healthStatistics=?, symptoms=?,prescription=?,diet=?,status=?,patientId=?,doctorId=? where patientCaseSheetId=?";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);

			preparedStatement.setString(1, patientCaseSheet.getPatientName());
			preparedStatement.setDate(2,java.sql.Date.valueOf(patientCaseSheet.getCaseSheetOpenDate()));
			preparedStatement.setDate(3,java.sql.Date.valueOf(patientCaseSheet.getCaseSheetCloseDate()));
			preparedStatement.setString(4, patientCaseSheet.getHostipalDetails());
			preparedStatement.setString(5, patientCaseSheet.getHealthStatistics());
			preparedStatement.setString(6, patientCaseSheet.getDiet());
			preparedStatement.setString(7, patientCaseSheet.getStatus());
			preparedStatement.setInt(8, patientCaseSheet.getPatientId());
			preparedStatement.setInt(9, patientCaseSheet.getDoctorId());
			preparedStatement.setString(10, patientCaseSheet.getPrescription());

			int n = preparedStatement.executeUpdate();
			if(n>0) {
				return "PatientCaseSheetId: "+ patientCaseSheet.getPatientCaseSheetId()+" updated";
			}else {
				return "Unable to update patientCaseSheetId: "+ patientCaseSheet.getPatientCaseSheetId();
			}

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}


	@Override
	public String deletePatientCaseSheet(Integer patientCaseSheetId) throws SQLException {
		String sql="delete from patient_case_sheet where patientCaseSheetId=?";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);

			preparedStatement.setInt(1, patientCaseSheetId);
			int n= preparedStatement.executeUpdate();
			if(n>0) {
				return "PatientCaseSheetId"+patientCaseSheetId+" deleted from database";
			}else {
				return "Unable to delete empno: "+patientCaseSheetId;
			}

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}
	@Override
	public List<PatientCaseSheet> getPatientCasesheetByDoctorId(Integer doctorId) throws SQLException {
		String sql= "select * from patient_case_sheet where doctor_id=?";
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1,doctorId);

			ResultSet resultSet= preparedStatement.executeQuery();
			
			List<PatientCaseSheet> patientCaseSheetList=new ArrayList<>();			
			while(resultSet.next()) {
				PatientCaseSheet patientCaseSheet= new PatientCaseSheet();
				populatePatientCaseSheet(resultSet,patientCaseSheet);
				patientCaseSheetList.add(patientCaseSheet);				
			}

			return patientCaseSheetList;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}
	
	private Integer getMaxId()  throws SQLException{
		String sql="select max(patient_case_sheet_id ) from patient_case_sheet";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			Statement statement= connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}else {
				throw new SQLException("No records in the table");
			}
		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	
	
}
