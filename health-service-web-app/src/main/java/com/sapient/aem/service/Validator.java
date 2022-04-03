package com.sapient.aem.service;

public class Validator {
	public Boolean isValidName(String name) {
		String pattern= "^[a-zA-Z\\s.]+$";
		if(name.matches(pattern)) {
			return true;
		}
		return false;
	}
	public Boolean isValidMobile(Long mobile) {
		String pattern="^[0-9]{10}$";
		if(mobile.toString().matches(pattern)) {
			return true;
		}
		return false;
	}
	public Boolean isValidEmail(String email) {
		String pattern="^[a-zA-Z0-9.]+@[a-zA-Z0-9]+.[a-zA-Z]{2,3}$";
		if(email.matches(pattern)) {
			return true;
		}
		return false;
	}
	
	
	

}
