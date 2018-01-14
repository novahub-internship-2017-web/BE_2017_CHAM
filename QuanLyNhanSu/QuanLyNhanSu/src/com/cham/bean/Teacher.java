package com.cham.bean;

public class Teacher extends User {
	int id;
	String name;
	int birthDay;
	String facutly;
	int lessons;
	float coefficientSalary;
	String degree ;
	String country;
	int allowance;
	int salary;
	int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}
	public String getFacutly() {
		return facutly;
	}
	public void setFacutly(String facutly) {
		this.facutly = facutly;
	}
	public int getLessons() {
		return lessons;
	}
	public void setLessons(int lessons) {
		this.lessons = lessons;
	}
	public float getCoefficientSalary() {
		return coefficientSalary;
	}
	public void setCoefficientSalary(float coefficientSalary) {
		this.coefficientSalary = coefficientSalary;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAllowance() {
		return allowance;
	}
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Teacher(int id, String name, int birthDay, String facutly, int lessons, float coefficientSalary,
			String degree, String country, int allowance, int salary) {
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
		this.facutly = facutly;
		this.lessons = lessons;
		this.coefficientSalary = coefficientSalary;
		this.degree = degree;
		this.country = country;
		this.allowance = allowance;
		this.salary = salary;
	}
	
//	userlist
	public Teacher(int userId, String name, int birthDay, String country, int type, String facutly, String degree,
			int allowance, int lessons, float coefficientSalary, int salary) {
		this.userId = userId;
		this.name = name;
		this.birthDay = birthDay;
		this.facutly = facutly;
		this.lessons = lessons;
		this.coefficientSalary = coefficientSalary;
		this.degree = degree;
		this.country = country;
		this.allowance = allowance;
		this.salary = salary;
		this.type = type;
	}
	
	public Teacher(int userId, String username, String password, int role, int type, String name, int birthDay, String facutly, int lessons, float coefficientSalary,
			String degree, String country, int allowance, int salary) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.birthDay = birthDay;
		this.facutly = facutly;
		this.lessons = lessons;
		this.coefficientSalary = coefficientSalary;
		this.degree = degree;
		this.country = country;
		this.allowance = allowance;
		this.salary = salary;
	}
	
//	edit
	public Teacher( int userId, String username, String password, String name) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.name = name;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
