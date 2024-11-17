package com.project.leebugzz.model;

import java.sql.Date;

public class UserEntity {

	private int userId;

	private String firstName;

	private String lastName;

	private String email;

	private Date dob;

	private String gender;

	private String category;

	private long contactNo;

	private String repCategory;

	public String getRepCategory() {
		return repCategory;
	}

	public void setRepCategory(String repCategory) {
		this.repCategory = repCategory;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	private String password;

	private String q1;
	private String q2;
	private String q3;

	public UserEntity(int userId, String firstName, String lastName, String email, Date dob, String gender,
			String category, long contactNo, String repCategory, String password, String q1, String q2, String q3) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.category = category;
		this.contactNo = contactNo;
		this.repCategory = repCategory;
		this.password = password;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQ1() {
		return q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}

	public String getQ2() {
		return q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	public String getQ3() {
		return q3;
	}

	public void setQ3(String q3) {
		this.q3 = q3;
	}

}