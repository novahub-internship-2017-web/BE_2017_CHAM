<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="com.cham.bean.Staff"%>
<%@page import="com.cham.bean.Teacher"%>
<%@page import="com.cham.bean.User"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
      <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
      <link rel="stylesheet" href="css/mycss.css">
      <link rel="stylesheet" href="css/user.css">
      <link rel="stylesheet" href="css/edit.css">
      <title>USER</title>
   </head>
   <body>
      <jsp:include page="_header_staff.jsp" />  
      <% Staff staff = (Staff)request.getAttribute("staff"); %>

      <div class="container">
         <div class="row main">
            <div class="main-login main-center">
               <h5>Edit my information</h5>
               <form class="" method="post" action="../QuanLyNhanSu/inforstaff?action=update">
                  <div class="form-group">
                     <label for="name" class="cols-sm-2 control-label">Your Name</label>
                     <div class="cols-sm-10">
                        <div class="input-group">
                           <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                           <input type="text" value="<%= staff.getName() %>" class="form-control" name="name" id="name"  placeholder="Enter your Name"/>
                        </div>
                     </div>
                  </div>
                  <div class="form-group">
                     <label for="username" class="cols-sm-2 control-label">Birthday</label>
                     <div class="cols-sm-10">
                        <div class="input-group">
                           <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                           <input type="text" value="<%= staff.getBirthDay() %>" class="form-control" name="birthday" id="birthday"  placeholder="Enter your Birthday"/>
                        </div>
                     </div>
                  </div>
                  <div class="form-group">
                     <label for="department" class="cols-sm-2 control-label">Department</label>
                     <div class="cols-sm-10">
                        <div class="input-group">
                           <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                           <input type="text" value="<%= staff.getDepartmemt() %>" class="form-control" name="department" id="department"  placeholder="Enter your Department"/>
                        </div>
                     </div>
                  </div>
                  <div class="form-group">
                     <label for="workdays" class="cols-sm-2 control-label">Workdays</label>
                     <div class="cols-sm-10">
                        <div class="input-group">
                           <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                           <input type="text" value=<%= staff.getWorkdays() %> class="form-control" name="workdays" id="workdays"  placeholder="Enter your Workdays"/>
                        </div>
                     </div>
                  </div>
                  <div class="form-group">
                     <label for="coefficientSalary" class="cols-sm-2 control-label">CoefficientSalary</label>
                     <div class="cols-sm-10">
                        <div class="input-group">
                           <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                           <input type="text" value = <%= staff.getCoefficientSalary() %> class="form-control" name="coefficientSalary" id="coefficientSalary"  placeholder="Enter your CoefficientSalary"/>
                        </div>
                     </div>
                  </div>
                  <div class="form-group">
                     <label for="position" class="cols-sm-2 control-label">Position</label></br>
                     <select name ="position">
                        <option size = "50" <% if ("Trưởng Phòng".equals(staff.getPosition())){ %>selected <%} %> value="tp">Trưởng Phòng</option>
                        <option size = "50" <% if ("Phó Phòng".equals(staff.getPosition())){ %>selected <%} %> value="pp">Phó Phòng</option>
                        <option size = "50" <% if ("Nhân Viên".equals(staff.getPosition())){ %>selected <%} %> value="nv">Nhân Viên</option>
                        <option size = "50" <% if ("Admin".equals(staff.getPosition())){ %>selected <%} %> value="admin">Admin</option>
                     </select>
                  </div>
                  <div class="form-group">
                     <label for="email" class="cols-sm-2 control-label">Country</label>
                     <div class="cols-sm-10">
                        <div class="input-group">
                           <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                           <input type="text" value=<%= staff.getCountry() %> class="form-control" name="country" id="country"  placeholder="Enter your Country"/>
                        </div>
                     </div>
                  </div>
                  <div class="form-group">
                     <label for="allowance" class="cols-sm-2 control-label">Allowance</label>
                     <div class="cols-sm-10">
                        <div class="input-group">
                           <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                           <input type="text" value=<%= staff.getAllowance() %> class="form-control" name="allowance" id="allowance"  placeholder="Enter your Allowance"/>
                        </div>
                     </div>
                  </div>
                  <div class="form-group">
                     <label for="salary" class="cols-sm-2 control-label">Salary</label>
                     <div class="cols-sm-10">
                        <div class="input-group">
                           <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                           <input type="text" value=<%= staff.getSalary() %> class="form-control" name="salary" id="salary"  placeholder="Enter your Salary"/>
                        </div>
                     </div>
                  </div>
                  <div class="form-group">
                     <label for="username" class="cols-sm-2 control-label">Username</label>
                     <div class="cols-sm-10">
                        <div class="input-group">
                           <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                           <input type="text" value=<%= staff.getUsername() %> class="form-control" name="username" id="username"  placeholder="Enter your username"/>
                        </div>
                     </div>
                  </div>
                  <div class="form-group">
                     <label for="password" class="cols-sm-2 control-label">Password</label>
                     <div class="cols-sm-10">
                        <div class="input-group">
                           <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                           <input type="password" value=<%=staff.getPassword() %> class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
                        </div>
                     </div>
                  </div>
                  <div class="form-group ">
                     <button type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">EDIT</a>
                  </div>
               </form>
            </div>
         </div>
      </div>
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="js/bootstrap.min.js"></script>
   </body>
</html>