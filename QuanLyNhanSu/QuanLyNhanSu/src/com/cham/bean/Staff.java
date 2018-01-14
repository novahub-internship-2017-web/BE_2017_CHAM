package com.cham.bean;

public class Staff extends User {
	int id;
	String name;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	int birthDay;
	String departmemt;
	int workdays;
	float coefficientSalary;
	String position ;
	String country;
	int allowance;
	int salary;
	int userId;
	
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
//	create
	public Staff(int userId, String username, String password, int role, int type, String name, int birthDay,
			String country, String department, String position, int workdays,int allowance,
			float coefficientSalary, int salary) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.birthDay = birthDay;
		this.departmemt = department;
		this.workdays = workdays;
		this.coefficientSalary = coefficientSalary;
		this.position = position;
		this.country = country;
		this.allowance = allowance;
		this.salary = salary;
	}
	
	
	public Staff(int id, String name, int birthDay, String departmemt, int workdays, float coefficientSalary,
			String position, String country, int allowance, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
		this.departmemt = departmemt;
		this.workdays = workdays;
		this.coefficientSalary = coefficientSalary;
		this.position = position;
		this.country = country;
		this.allowance = allowance;
		this.salary = salary;
	}
	
//	userlist
	public Staff(int userId, String name, int birthDay, String country, int type, String departmemt,
			String position, int allowance, int workdays, float coefficientSalary, int salary) {
		this.userId = userId;
		this.name = name;
		this.birthDay = birthDay;
		this.departmemt = departmemt;
		this.workdays = workdays;
		this.coefficientSalary = coefficientSalary;
		this.position = position;
		this.country = country;
		this.allowance = allowance;
		this.salary = salary;
		this.type = type;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
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
	public String getDepartmemt() {
		return departmemt;
	}
	public void setDepartmemt(String departmemt) {
		this.departmemt = departmemt;
	}
	public int getWorkdays() {
		return workdays;
	}
	public void setWorkdays(int workdays) {
		this.workdays = workdays;
	}
	public float getCoefficientSalary() {
		return coefficientSalary;
	}
	public void setCoefficientSalary(float coefficientSalary) {
		this.coefficientSalary = coefficientSalary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
