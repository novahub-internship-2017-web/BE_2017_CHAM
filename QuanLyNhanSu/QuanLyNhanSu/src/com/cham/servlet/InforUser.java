package com.cham.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cham.Dao.StaffDao;
import com.cham.Dao.TeacherDao;
import com.cham.Dao.UserDao;
import com.cham.bean.Staff;
import com.cham.bean.Teacher;
import com.cham.bean.User;

/**
 * Servlet implementation class Infor
 */
@WebServlet("/InforUser")
public class InforUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String userIdString = null;
	int userId = 0;
	String userType = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InforUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Integer currentUserId = (Integer)session.getAttribute("userId");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.print("action" + request.getParameter("action"));
		if(request.getParameter("action") != null) {
			switch (request.getParameter("action")) {
			case "getUser": 
				ArrayList<User> userList = UserDao.getAllTeacherAndStaff();
				request.setAttribute("userList", userList);
				request.getRequestDispatcher("/Admin.jsp").forward(request, response);
	//			if(request.getParameter("type").equals("staff")) {
	//				System.out.print("staff");
	//			}
	//			else if(request.getParameter("type").equals("teacher")) {
	//				System.out.print("teacher");
	//			}
	//			else {
	//				System.out.print("all");
	//			}
				break;
			case "delete":
				userIdString = request.getParameter("userId");
				userId = Integer.parseInt(userIdString);
				User userDelete = UserDao.getUserById(userId);
				if(userDelete.getType() == 1){
					UserDao.delete(userDelete.getUserId());
					StaffDao.delete(userDelete.getUserId());
				}
				else if(userDelete.getType() == 2) {
					UserDao.delete(userDelete.getUserId());
					TeacherDao.delete(userDelete.getUserId());
				}
				request.getRequestDispatcher("/inforuser?action=getUser").include(request, response);
				break;
			case "edit":
				userIdString = request.getParameter("userId");
				userId = Integer.parseInt(userIdString);
				User userEdit = UserDao.getUserById(userId);
				if(userEdit.getType() == 1){
					Staff staff = StaffDao.getStaffAndUserInforByUserId(userEdit.getUserId());
					request.setAttribute("staff", staff);
					RequestDispatcher rd1 = request.getRequestDispatcher("/admin/editStaff.jsp");
					rd1.forward(request, response);
				}
				else if(userEdit.getType() == 2) {
					Teacher teacher = TeacherDao.getTeacherAndUserInforByUserId(userEdit.getUserId());
//					teacher.setUserId(userId);
					request.setAttribute("teacher", teacher);
					RequestDispatcher rd1 = request.getRequestDispatcher("/admin/editTeacher.jsp");
					rd1.forward(request, response);
				}
//				request.getRequestDispatcher("/inforuser?action=getUser").include(request, response);
				break;
				
			case "update":
				int userIdUpdate = Integer.parseInt(request.getParameter("userId"));
				User userUpdate =  UserDao.getUserById(userIdUpdate);
				if(userUpdate.getType() == 2) {
					Teacher teacher_update = getTeacher(request);
					teacher_update.setUserId(userIdUpdate);
					boolean update_teacher_return = TeacherDao.update(teacher_update);
					UserDao.update(teacher_update);
					if (update_teacher_return) {
						Teacher teacher1 = TeacherDao.getTeacherAndUserInforByUserId(Integer.parseInt(request.getParameter("userId")));
						request.setAttribute("teacher", teacher1);
						RequestDispatcher rd2 = request.getRequestDispatcher("admin/editTeacher.jsp");
						rd2.forward(request, response);
						
					}
					else {
						
					}
				}
				else if(userUpdate.getType() == 1) {
					Staff staffUpdate = getStaff(request);
					if("Admin".equals(staffUpdate.getPosition())) {
						staffUpdate.setRole(1);
					}
					else {
						staffUpdate.setRole(2);
					}
					staffUpdate.setUserId(userIdUpdate);
					boolean update_staff_return = StaffDao.update(staffUpdate);
					UserDao.update(staffUpdate);
					if (update_staff_return) {
						Staff staff1 = StaffDao.getStaffAndUserInforByUserId(userIdUpdate);
						request.setAttribute("staff", staff1);
						RequestDispatcher rd2 = request.getRequestDispatcher("admin/editStaff.jsp");
						rd2.forward(request, response);
						
					}
					else {
						
					}
					
				}
			case "new":
				userType = request.getParameter("userType") ;
				switch(userType) {
				case "teacher":
					RequestDispatcher rd1 = request.getRequestDispatcher("/admin/newTeacher.jsp");
					rd1.forward(request, response);
					break;
				case "staff":
					RequestDispatcher rd2 = request.getRequestDispatcher("/admin/newStaff.jsp");
					rd2.forward(request, response);
					break;
				}
				
				break;
			case "create":
				switch(userType) {
				case "teacher":
					Teacher teacher_create = getTeacher(request);
					userType = request.getParameter("userType") ;
					teacher_create.setType(2);
					teacher_create.setRole(2);
					TeacherDao.create(teacher_create);
					request.getRequestDispatcher("/inforuser?action=getUser").include(request, response);
					break;
				case "staff":
					Staff staffCreate = getStaff(request);
					userType = request.getParameter("userType") ;
					staffCreate.setType(2);
					if("Admin".equals(staffCreate.getPosition())) {
						staffCreate.setRole(1);
					}
					else {
						staffCreate.setRole(2);
					}
					StaffDao.create(staffCreate);
					request.getRequestDispatcher("/inforuser?action=getUser").include(request, response);
					break;
				}
				
				break;
			}
			}
		}
	
	public Teacher getTeacher(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		System.out.print("session user_id" + userId);
//		User userinfor = (User)session.getAttribute("userinfor");
		String name = (request.getParameter("name"));
		int birthday = Integer.parseInt(request.getParameter("birthday"));
		String facutly = (request.getParameter("faculty"));
		String select_degree = (request.getParameter("degree"));
		String degree = null;
		switch (select_degree){
		case "cn":
			degree = "Cử Nhân";
			break;
		case "ths":
			degree = "Thạc Sĩ";
			break;
		case "ts":
			degree = "Tiến Sĩ";
			break;
		}
		int lessons = Integer.parseInt(request.getParameter("lessons"));
		float coefficientSalary = Float.parseFloat(request.getParameter("coefficientSalary"));
		String country = (request.getParameter("country"));
		int allowance = Integer.parseInt(request.getParameter("allowance"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		String username = (request.getParameter("username"));
		String password = (request.getParameter("password"));
		Teacher teacher = new Teacher(userId, username,password,2,2,name,birthday,facutly,lessons,coefficientSalary,degree,country,allowance,salary);
		return teacher;
		
	}
	
	public Staff getStaff(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		int userId = (int) session.getAttribute("userId");
		String name = (request.getParameter("name"));
		int birthday = Integer.parseInt(request.getParameter("birthday"));
		String department = (request.getParameter("department"));
		String select_position = (request.getParameter("position"));
		String position = null;
		System.out.println("positionpositionpositionposition" + select_position);
		switch (select_position){
		case "tp":
			position = "Trưởng Phòng";
			break;
		case "pp":
			position = "Phó Phòng";
			break;
		case "nv":
			position = "Nhân Viên";
			break;
		case "admin":
			position = "Admin";
			break;
		}
		int workdays = Integer.parseInt(request.getParameter("workdays"));
		float coefficientSalary = Float.parseFloat(request.getParameter("coefficientSalary"));
		String country = (request.getParameter("country"));
		int allowance = Integer.parseInt(request.getParameter("allowance"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		String username = (request.getParameter("username"));
		String password = (request.getParameter("password"));
		Staff staff = new Staff(userId, username,password,2,1,name,birthday,country,department, position, workdays, allowance,coefficientSalary,salary);
		return staff;
		
	}
	
	public User currentUser(HttpServletRequest request) {
		return null;
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
