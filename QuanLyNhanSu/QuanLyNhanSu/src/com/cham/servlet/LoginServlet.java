package com.cham.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDao userdao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserDao userDao = new UserDao();
		User userinfor = new User();
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		userinfor = userDao.getUserByUsername(username);
		
		
		
		if(userdao.checklogin(request.getParameter("username"),request.getParameter("password"))) {
			request.setAttribute("userInfor", userinfor);
			session.setAttribute("type", userinfor.getType());
			session.setAttribute("userId", userinfor.getUserId());
			session.setAttribute("userinfor", userinfor);
			if(userdao.checkID(request.getParameter("username"))==1){
				request.getRequestDispatcher("/inforuser?action=getUser").include(request, response);
			}
			if(userdao.checkID(request.getParameter("username"))==2){
				if(userinfor.getType() == 1) {
					request.getRequestDispatcher("/inforstaff?action=detail").include(request, response);
				}else if(userinfor.getType() == 2) {		
					request.getRequestDispatcher("/inforteacher?action=detail").include(request, response);
				}
				
//				request.getRequestDispatcher("/User.jsp").forward(request, response);
			}
			
			
//			System.out.print(session.getAttribute("type"));
//			System.out.print(session.getAttribute("userId"));
		}
		else request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
