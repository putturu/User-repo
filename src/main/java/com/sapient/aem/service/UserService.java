package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.model.User;

public interface UserService {
	public abstract List<User> getAllUSers() throws Exception;
}
