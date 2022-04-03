package com.sapient.aem.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Doctor implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer doctorId;
	private String doctorName;
	private String specialization;
	private String availableTiming;
	private String qualification;
	private Integer experienceInYears;
	private Long mobile;
	private String email;
	
	
	public Doctor(String doctorName, String specialization, String availableTiming, String qualification,
			Integer experienceInYears, Long mobile, String email) {
		super();
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.availableTiming = availableTiming;
		this.qualification = qualification;
		this.experienceInYears = experienceInYears;
		this.mobile = mobile;
		this.email = email;
		
	}
	
	
	

}
