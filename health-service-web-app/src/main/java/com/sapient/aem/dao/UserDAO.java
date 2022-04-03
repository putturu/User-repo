package com.sapient.aem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;

public interface UserDAO {
	public abstract Boolean isValidUser(String userName,String password, Role role) throws Exception;
	public abstract String addUser(User user)throws SQLException;
	public abstract String deleteUser(Integer userId)throws SQLException;
	public abstract User getUserById(Integer userId)throws SQLException;
	public abstract List<User> getUser()throws SQLException;
	public abstract String updateUser(User user)throws SQLException;
	public abstract Integer getUserId(User user) throws SQLException;

}
