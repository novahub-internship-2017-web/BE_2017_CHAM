package com.cham.servlet;

import java.io.IOException;

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
@WebServlet("/InforStaff")
public class InforStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Staff staff = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InforStaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		StaffDao staffDao = new StaffDao();
//		staffDao.getListStaffs();
//		request.setAttribute("listStaff", staffDao.getListStaffs());
//		System.out.println("size: "+staffDao.getListStaffs().size());
//		RequestDispatcher rd = request.getRequestDispatcher("/listStaff.jsp");
//		rd.forward(request, response);
		// TODO Auto-generated method stub
				HttpSession session = request.getSession();
				User userinfor = (User)session.getAttribute("userinfor");
				response.setContentType("text/html;charset=UTF-8");
				request.setCharacterEncoding("utf-8");
				response.getWriter().append("Served at: ").append(request.getContextPath());
				String action;
				action = request.getParameter("action");
				System.out.println(action);
				if(action == null) {
					StaffDao staffDao = new StaffDao();
					staffDao.getListStaffs();
					request.setAttribute("listStaff", staffDao.getListStaffs());
					System.out.println("size: "+staffDao.getListStaffs().size());
					RequestDispatcher rd = request.getRequestDispatcher("/listStaff.jsp");
					rd.forward(request, response);
				}
				else {
						switch (action) {
						    case "detail":
							    	Staff staff = StaffDao.getStaff(userinfor.getUserId());
								request.setAttribute("staff", staff);
								request.getRequestDispatcher("/currentStaff.jsp").forward(request, response);
							    	break;
							case "edit":
								staff = StaffDao.getStaffAndUserInforByUserId(userinfor.getUserId());
								request.setAttribute("staff", staff);
								RequestDispatcher rd1 = request.getRequestDispatcher("/editStaff.jsp");
								rd1.forward(request, response);
								break;
							case "update":
								Staff staff_update = getStaff(request);
								boolean staff_update_return = StaffDao.update(staff_update);
								UserDao.update(staff_update);
								if (staff_update_return) {
									Staff staff1 = StaffDao.getStaffAndUserInforByUserId(userinfor.getUserId());
									request.setAttribute("staff", staff1);
									RequestDispatcher rd2 = request.getRequestDispatcher("/editStaff.jsp");
									rd2.forward(request, response);
									
								}
								else {
									
								}
								
							}
							
								
				}
		
	}
	
	public Staff getStaff(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
//		System.out.print("session user_id" + userId);
//		User userinfor = (User)session.getAttribute("userinfor");
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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
