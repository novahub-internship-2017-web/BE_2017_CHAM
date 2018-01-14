package com.cham.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cham.DBConnect.DBConnect;
import com.cham.bean.Staff;
import com.cham.bean.Teacher;
import com.cham.bean.User;

public class UserDao {
	
	public boolean checklogin(String name,String password) {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM User WHERE Username ='"+name+"' and Password = '" +password+ "'";
		PreparedStatement ps;
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				conn.close();
				return true;
			}
			
		}catch (SQLException ex) {
			Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,ex);
		}
			return false;
		
	}
	public int checkID(String name) {
		Integer vaitro=0;
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM User WHERE Username ='"+name+"'";
		try {
			Statement stm = conn.createStatement();
			stm.execute(sql);
			ResultSet rs = stm.getResultSet();
			if(rs.next()) {
				vaitro = rs.getInt("Role");
			}
		}catch (SQLException ex) {
			Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,ex);
		}
		return vaitro;
	}
	public ArrayList<User> getListUsers() {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM User ";
		PreparedStatement ps;
		ArrayList<User> listUser = new ArrayList<>();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User objUser = new User(rs.getInt("UserId"),rs.getString("Username"), rs.getString("Password"),rs.getInt("Role"), rs.getInt("type"));
				listUser.add(objUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}
	public User getUserByUsername(String username) {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM User WHERE Username = '"+username+"'";
		PreparedStatement ps;
		User objUser = new User();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				 objUser = new User(rs.getInt("UserId"),rs.getString("Username"), rs.getString("Password"),rs.getInt("Role"), rs.getInt("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objUser;
	}
	
	public static User getUserById(int userId) {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM User WHERE UserId = '"+userId+"'";
		PreparedStatement ps;
		User user = null;
		//Staff staff = new Staff();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			user = new User(rs.getInt("UserId"), rs.getString("Username"), rs.getString("Password"), rs.getInt("Role"), rs.getInt("Type"));
			
		}} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
//	update here
	
	public static boolean update(User user) {
		Connection conn = DBConnect.getConnecttion();
		Statement statement = null;
		try {
			statement = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "Update User SET Username = '" + user.getUsername() + "', Password = '" +user.getPassword() +"' where UserId = '" + user.getUserId() + "'";
		System.out.print(sql);
		System.out.print("aaaaa"+ user.getUserId());
		PreparedStatement ps;
		try {
//			ps = conn.prepareCall(sql);
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static ArrayList<User> getAllTeacherAndStaff() {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT Teacher.UserId AS UserId, Teacher.Name AS name, Teacher.BirthYear AS birthYear,"
				+ " Teacher.Country AS country, 2 AS type, Teacher.Faculty AS C1,"
				+ " Teacher.Degree AS C2, Teacher.Allowance AS C3, Teacher.Lessons AS C4,"
				+ " Teacher.CoefficientSalary AS C5, Teacher.Salary AS C6 FROM Teacher\n" + 
				"UNION\n" + 
				"SELECT Staff.UserId AS UserId, Staff.Name AS name, Staff.BirthYear AS birthYear,"
				+ " Staff.Country AS country, 1 AS type, Staff.Department AS C1,"
				+ " Staff.Position AS C2, Staff.Allowance AS C3, Staff.WorkDays AS C4,"
				+ " Staff.CoefficientSalary AS C5, Staff.Salary AS C6 From Staff"
				+ " ORDER BY UserId DESC";
		PreparedStatement ps;
		ArrayList<User> listUser = new ArrayList<>();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt("Type") == 2) {
					Teacher teacher = new Teacher(rs.getInt("UserId"), rs.getString("name"), rs.getInt("birthYear"), rs.getString("country"), rs.getInt("Type"),
							rs.getString("C1"), rs.getString("C2"), rs.getInt("C3"), rs.getInt("C4") , rs.getFloat("C5"), rs.getInt("C6"));
					listUser.add(teacher);
					
				}
				else if(rs.getInt("Type") == 1) {
				    Staff staff = new Staff(rs.getInt("UserId"), rs.getString("name"), rs.getInt("birthYear"), rs.getString("country"), rs.getInt("Type"),
							rs.getString("C1"), rs.getString("C2"), rs.getInt("C3"), rs.getInt("C4") , rs.getFloat("C5"), rs.getInt("C6"));
				    listUser.add(staff);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}
	
	public static boolean delete(int userId) {
		Connection conn = DBConnect.getConnecttion();
		Statement statement;
		try {
			statement = conn.createStatement();
			String sql = "DELETE FROM User WHERE UserId = '" + userId + "';";
			statement.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}