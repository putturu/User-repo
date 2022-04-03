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

public class DoctorDaoImpl implements DoctorDAO{
	
	@Override
	public Doctor getDoctorById(Integer doctorId) throws SQLException {
		String sql="select * from doctor where doctor_id=?";
		Connection connection =null;
		try  {
			
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, doctorId);
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				Doctor doctor= new Doctor();
				
				populateDoctor(resultSet,doctor);
				return doctor;				
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
	public List<Doctor> getDoctor() throws SQLException {
		String sql="select * from doctor";
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			Statement statement= 
					connection.createStatement();

			ResultSet resultSet= statement.executeQuery(sql);
			
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

	@Override
	public Integer addDoctor(Doctor doctor) throws SQLException {
		String sql="insert into doctor(doctor_name,specialization,available_timings,qualification,experience_in_years,mobile,email) values(?,?,?,?,?,?,?)";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			
			preparedStatement.setString(1,doctor.getDoctorName());
			preparedStatement.setString(2,doctor.getSpecialization());
			preparedStatement.setString(3,doctor.getAvailableTiming());
			preparedStatement.setString(4,doctor.getQualification());
			preparedStatement.setInt(5,doctor.getExperienceInYears());
			preparedStatement.setLong(6,doctor.getMobile());
			preparedStatement.setString(7,doctor.getEmail());
			
			int n=preparedStatement.executeUpdate();
			
			if(n>0) {
				return this.getMaxId();
			}else {
				throw new SQLException("Unable to add record");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
			
		}finally {
			connection.close();
		}
	}
	
	

	

	@Override
	public String updateDoctor(Doctor doctor) throws SQLException {
		String sql="update doctor set doctor_name=?,availableTiming=?,mobile=? where doctorId=?";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);

			
			preparedStatement.setString(1,doctor.getEmail());
			preparedStatement.setString(2,doctor.getAvailableTiming());
			preparedStatement.setLong(3,doctor.getMobile());
			preparedStatement.setInt(4, doctor.getDoctorId());
			

			int n = preparedStatement.executeUpdate();
			if(n>0) {
				return "DoctorId "+doctor.getDoctorId()+" updated";
			}else {
				return "Unable to update DoctorId: "+doctor.getDoctorId();
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
	public String deleteDoctor(Integer doctorId) throws SQLException {
		String sql="delete from doctor where doctor_id=?";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);

			preparedStatement.setInt(1, doctorId);
			int n= preparedStatement.executeUpdate();
			if(n>0) {
				return "DoctorId:"+doctorId+" deleted from database";
			}else {
				return "Unable to delete doctorId: "+doctorId;
			}

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	private Integer getMaxId()  throws SQLException{
		String sql="select max(doctor_id) from doctor";
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
