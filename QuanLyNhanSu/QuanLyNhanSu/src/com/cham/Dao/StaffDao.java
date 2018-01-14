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

public class StaffDao {
	public static Staff getStaff(int userId) {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM Staff WHERE UserId = '"+userId+"'";
		PreparedStatement ps;
		Staff staff = null;
		//Staff staff = new Staff();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			staff = new Staff(rs.getInt("UserId"),rs.getString("Name"), 
						rs.getInt("BirthYear"),rs.getString("Department"),rs.getInt("WorkDays"),
						rs.getFloat("CoefficientSalary"),rs.getString("Position"),rs.getString("Country"),
						rs.getInt("Allowance"),rs.getInt("Salary"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staff;
		
	}
	public ArrayList<Staff> getListStaffs() {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM Staff ";
		PreparedStatement ps;
		ArrayList<Staff> listStaff = new ArrayList<>();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Staff objStaff = new Staff(rs.getInt("StaffId"),rs.getString("Name"), 
						rs.getInt("BirthYear"),rs.getString("Department"),rs.getInt("WorkDays"),
						rs.getFloat("CoefficientSalary"),rs.getString("Position"),rs.getString("Country"),
						rs.getInt("Allowance"),rs.getInt("Salary"));
				listStaff.add(objStaff);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listStaff;
	}
	
	public static boolean delete(int staffId) {
		Connection conn = DBConnect.getConnecttion();
		Statement statement;
		try {
			statement = conn.createStatement();
			String sql = "DELETE FROM Staff WHERE UserId = '" + staffId + "';";
			statement.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public static Staff getStaffAndUserInforByUserId(int userId) {
		Connection conn = DBConnect.getConnecttion();
		String sql = "SELECT * FROM Staff INNER JOIN User ON Staff.UserId = User.UserId WHERE Staff.UserId = '" + userId + "'";
		PreparedStatement ps;
		Staff staff = null;
		//Staff staff = new Staff();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			staff = new Staff(rs.getInt("UserId"), rs.getString("Username"), rs.getString("Password"),
					rs.getInt("role"), rs.getInt("type"), rs.getString("Name"), rs.getInt("BirthYear"),rs.getString("Country"),
					rs.getString("Department"),rs.getString("Position"), rs.getInt("Workdays"),rs.getInt("Allowance"),rs.getFloat("CoefficientSalary"),
					rs.getInt("Salary"));
			
		}} catch (SQLException e) {
			e.printStackTrace();
		}
		return staff;	
	}
	
	public static boolean update(Staff staff) {
		Connection conn = DBConnect.getConnecttion();
		Statement statement = null;
		try {
			statement = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "Update Staff SET Name = '" + staff.getName() + "', BirthYear = '" + staff.getBirthDay() +
				"', Country = '" + staff.getCountry()+"', Department = '" + staff.getDepartmemt()+"', Position = '" + staff.getPosition()+
				"', WorkDays = '" + staff.getWorkdays()+"', Allowance = '" + staff.getAllowance()+
				"', CoefficientSalary = '" + staff.getCoefficientSalary()+"', Salary = '" + staff.getSalary()+
				"' where UserId = '" + staff.getUserId() + "'"; 
		System.out.println(sql+"teacher");
		PreparedStatement ps;
		try {
			System.out.println("toi day ne chammmm");
//			ps = conn.prepareCall(sql);
			statement.executeUpdate(sql);

			System.out.println("toi day ne cham");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean create(Staff staff) {
		Connection conn = DBConnect.getConnecttion();
		Statement statement = null;
		PreparedStatement preparedStatement1 = null;
	    PreparedStatement preparedStatement2 = null;
		try {
			conn.setAutoCommit(false);
			String sql1 = "INSERT INTO User (UserId, Username, Password, Role, Type) VALUES (?,?,?,?,?)";
			preparedStatement1 = conn.prepareStatement(sql1);
	        preparedStatement1.setInt(1, staff.getUserId());
	        preparedStatement1.setString(2, staff.getUsername());
	        preparedStatement1.setString(3, staff.getPassword());
	        preparedStatement1.setInt(4, staff.getRole());
	        preparedStatement1.setInt(5, staff.getType());
	        preparedStatement1.executeUpdate();
	        
	        String sql2 = "INSERT INTO Staff (UserId, Name, BirthYear, Country, Department, Position, Workdays, Allowance, CoefficientSalary, Salary ) "
	        		+ "VALUES(LAST_INSERT_ID(), ?, ?, ?, ?, ? , ?, ?, ?, ?)";
	        preparedStatement2 = conn.prepareStatement(sql2);
	        preparedStatement2.setString(1, staff.getName());
	        preparedStatement2.setInt(2, staff.getBirthDay());
	        preparedStatement2.setString(3, staff.getCountry());
	        preparedStatement2.setString(4, staff.getDepartmemt());
	       
	        preparedStatement2.setString(5, staff.getPosition());
	        preparedStatement2.setInt(6, staff.getWorkdays());
	        preparedStatement2.setInt(7, staff.getAllowance());
	        preparedStatement2.setFloat(8, staff.getCoefficientSalary());
	        preparedStatement2.setInt(9, staff.getSalary());
	        preparedStatement2.executeUpdate();
	        conn.commit();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
		
	}
}
