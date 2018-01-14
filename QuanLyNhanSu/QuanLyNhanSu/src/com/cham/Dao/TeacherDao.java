package com.cham.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cham.DBConnect.DBConnect;
import com.cham.bean.Staff;
import com.cham.bean.Teacher;

public class TeacherDao {
	public ArrayList<Teacher> getListTeachers() {
		System.out.print("as1");
		Connection conn = DBConnect.getConnecttion();
		System.out.print("as2");
		String sql ="SELECT * FROM Teacher ";
		PreparedStatement ps;
		ArrayList<Teacher> listTeacher = new ArrayList<>();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.print("as");
				
				Teacher objTeacher = new Teacher(rs.getInt("UserId"),rs.getString("Name"), rs.getInt("BirthYear"),
						rs.getString("Faculty"),rs.getInt("Lessons"),rs.getFloat("CoefficientSalary"),rs.getString("Degree"),
						rs.getString("Country"),rs.getInt("Allowance"),rs.getInt("Salary"));
				listTeacher.add(objTeacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTeacher;
	}

public static Teacher getTeacher(int userId) {
	Connection conn = DBConnect.getConnecttion();
	String sql ="SELECT * FROM Teacher WHERE UserId = '"+userId+"'";
	PreparedStatement ps;
	Teacher teacher = null;
	//Staff staff = new Staff();
	try {
		ps = conn.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
		teacher = new Teacher(rs.getInt("UserId"),rs.getString("Name"), rs.getInt("BirthYear"),
				rs.getString("Faculty"),rs.getInt("Lessons"),rs.getFloat("CoefficientSalary"),
				rs.getString("Degree"),rs.getString("Country"),rs.getInt("Allowance"),rs.getInt("Salary"));
		
	}} catch (SQLException e) {
		e.printStackTrace();
	}
	return teacher;
}
public static Teacher getTeacherAndUserInforByUserId(int userId) {
	System.out.print("user_id" + userId);
	Connection conn = DBConnect.getConnecttion();
	String sql = "SELECT * FROM Teacher INNER JOIN User ON Teacher.UserId = User.UserId WHERE Teacher.UserId = '" + userId + "'";
	PreparedStatement ps;
	Teacher teacher = null;
	//Staff staff = new Staff();
	try {
		ps = conn.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
		teacher = new Teacher(rs.getInt("UserId"), rs.getString("Username"), rs.getString("Password"),
				rs.getInt("role"), rs.getInt("type"), rs.getString("Name"), rs.getInt("BirthYear"),
				rs.getString("Faculty"),rs.getInt("Lessons"),rs.getFloat("CoefficientSalary"),
				rs.getString("Degree"),rs.getString("Country"),rs.getInt("Allowance"),rs.getInt("Salary"));
		
	}} catch (SQLException e) {
		e.printStackTrace();
	}
	return teacher;	
}
public static boolean update(Teacher teacher) {
	Connection conn = DBConnect.getConnecttion();
	Statement statement = null;
	try {
		statement = conn.createStatement();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	String sql = "Update Teacher SET Name = '" + teacher.getName() + "', BirthYear = '" + teacher.getBirthDay() +
			"', Country = '" + teacher.getCountry()+"', Faculty = '" + teacher.getFacutly()+"', Degree = '" + teacher.getDegree()+
			"', Lessons = '" + teacher.getLessons()+"', Allowance = '" + teacher.getAllowance()+
			"', CoefficientSalary = '" + teacher.getCoefficientSalary()+"', Salary = '" + teacher.getSalary()+
			"' where UserId = '" + teacher.getUserId() + "'"; 
	System.out.println(sql+"teacher");
	PreparedStatement ps;
	try {
		System.out.println("toi day ne chammmm");
//		ps = conn.prepareCall(sql);
		statement.executeUpdate(sql);

		System.out.println("toi day ne cham");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	return true;
}

public static boolean delete(int teacherId) {
	Connection conn = DBConnect.getConnecttion();
	Statement statement;
	try {
		statement = conn.createStatement();
		String sql = "DELETE FROM Teacher WHERE UserId = '" + teacherId + "';";
		statement.executeUpdate(sql);
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}

public static boolean create(Teacher teacher) {
	Connection conn = DBConnect.getConnecttion();
	Statement statement = null;
	PreparedStatement preparedStatement1 = null;
    PreparedStatement preparedStatement2 = null;
	try {
		conn.setAutoCommit(false);
		String sql1 = "INSERT INTO User (UserId, Username, Password, Role, Type) VALUES (?,?,?,?,?)";
		preparedStatement1 = conn.prepareStatement(sql1);
        preparedStatement1.setInt(1, teacher.getUserId());
        preparedStatement1.setString(2, teacher.getUsername());
        preparedStatement1.setString(3, teacher.getPassword());
        preparedStatement1.setInt(4, teacher.getRole());
        preparedStatement1.setInt(5, teacher.getType());
        preparedStatement1.executeUpdate();
        
        String sql2 = "INSERT INTO Teacher (UserId, Name, BirthYear, Country, Faculty, Degree, Lessons, Allowance, CoefficientSalary, Salary ) "
        		+ "VALUES(LAST_INSERT_ID(), ?, ?, ?, ?, ? , ?, ?, ?, ?)";
        System.out.print("deasdasdasdasdasdasdasdasdas" + teacher.getDegree());
        preparedStatement2 = conn.prepareStatement(sql2);
        preparedStatement2.setString(1, teacher.getName());
        preparedStatement2.setInt(2, teacher.getBirthDay());
        preparedStatement2.setString(3, teacher.getCountry());
        preparedStatement2.setString(4, teacher.getFacutly());
       
        preparedStatement2.setString(5, teacher.getDegree());
        preparedStatement2.setInt(6, teacher.getLessons());
        preparedStatement2.setInt(7, teacher.getAllowance());
        preparedStatement2.setFloat(8, teacher.getCoefficientSalary());
        preparedStatement2.setInt(9, teacher.getSalary());
        preparedStatement2.executeUpdate();
        conn.commit();
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return true;
}
}
