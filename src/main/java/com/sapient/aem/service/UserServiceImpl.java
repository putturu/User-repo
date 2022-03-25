package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.dao.UserDAO;
import com.sapient.aem.dao.UserDaoImpl;
import com.sapient.aem.model.User;

public class UserServiceImpl implements UserService{
	private static UserDAO userDAO = new UserDaoImpl();

	@Override
	public List<User> getAllUSers() throws Exception {
		try {
			List<User> result = userDAO.getAllUSers();
			return result;
		}catch(SQLException e) {
			throw new Exception(e);
		}
	}

}
