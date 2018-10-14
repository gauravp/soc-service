package com.paliwal.employee;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class Employee  implements Serializable  {
	private static final long serialVersionUID = 1L;

/*
 * First Name
Last Name
Gender
Date of Birth
Department
 * */	
	
String firstName;
String lastName;
String gender;
String dob;
String department;
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}


	
}
