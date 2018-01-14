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
      <jsp:include page="_header.jsp" />  
      <div class="container">
         <div class="row main">
            <div class="main-login main-center">
               <h5>Edit my information</h5>
               <form method="post" action="../QuanLyNhanSu/inforuser?action=create&userType=teacher">
                  <div class="form-group">
				   <label for="name" class="cols-sm-2 control-label">Your Name</label>
				   <div class="cols-sm-10">
				      <div class="input-group">
				         <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
				         <input type="text" class="form-control" name="name" id="name"  placeholder="Enter your Name"/>
				      </div>
				   </div>
				</div>
				<div class="form-group">
				   <label for="username" class="cols-sm-2 control-label">Birthday</label>
				   <div class="cols-sm-10">
				      <div class="input-group">
				         <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
				         <input type="text" class="form-control" name="birthday" id="birthday"  placeholder="Enter your Birthday"/>
				      </div>
				   </div>
				</div>
				<div class="form-group">
				   <label for="faculty" class="cols-sm-2 control-label">Faculty</label>
				   <div class="cols-sm-10">
				      <div class="input-group">
				         <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
				         <input type="text" value="" class="form-control" name="faculty" id="faculty"  placeholder="Enter your Faculty"/>
				      </div>
				   </div>
				</div>
				<div class="form-group">
				   <label for="lessons" class="cols-sm-2 control-label">Lessons</label>
				   <div class="cols-sm-10">
				      <div class="input-group">
				         <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
				         <input type="text" class="form-control" name="lessons" id="lessons"  placeholder="Enter your Lessons"/>
				      </div>
				   </div>
				</div>
				<div class="form-group">
				   <label for="coefficientSalary" class="cols-sm-2 control-label">CoefficientSalary</label>
				   <div class="cols-sm-10">
				      <div class="input-group">
				         <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
				         <input type="text" class="form-control" name="coefficientSalary" id="coefficientSalary"  placeholder="Enter your CoefficientSalary"/>
				      </div>
				   </div>
				</div>
				<div class="form-group">
				   <label for="degree" class="cols-sm-2 control-label">Degree</label></br>
				   <select name ="degree">
				      <option size = "50"  value="cn">Cử Nhân</option>
				      <option size = "50"  value="ths">Thạc Sĩ</option>
				      <option size = "50" value="ts">Tiến Sĩ</option>
				   </select>
				</div>
				<div class="form-group">
				   <label for="email" class="cols-sm-2 control-label">Country</label>
				   <div class="cols-sm-10">
				      <div class="input-group">
				         <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
				         <input type="text" class="form-control" name="country" id="country"  placeholder="Enter your Country"/>
				      </div>
				   </div>
				</div>
				<div class="form-group">
				   <label for="allowance" class="cols-sm-2 control-label">Allowance</label>
				   <div class="cols-sm-10">
				      <div class="input-group">
				         <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
				         <input type="text" class="form-control" name="allowance" id="allowance"  placeholder="Enter your Allowance"/>
				      </div>
				   </div>
				</div>
				<div class="form-group">
				   <label for="salary" class="cols-sm-2 control-label">Salary</label>
				   <div class="cols-sm-10">
				      <div class="input-group">
				         <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
				         <input type="text" class="form-control" name="salary" id="salary"  placeholder="Enter your Salary"/>
				      </div>
				   </div>
				</div>
				<div class="form-group">
				   <label for="username" class="cols-sm-2 control-label">Username</label>
				   <div class="cols-sm-10">
				      <div class="input-group">
				         <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
				         <input type="text" class="form-control" name="username" id="username"  placeholder="Enter your username"/>
				      </div>
				   </div>
				</div>
				<div class="form-group">
				   <label for="password" class="cols-sm-2 control-label">Password</label>
				   <div class="cols-sm-10">
				      <div class="input-group">
				         <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
				         <input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
				      </div>
				   </div>
				</div>
				<div class="form-group ">
				   <button type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">New Teacher</a>
				</div>
               </form>
            </div>
         </div>
      </div>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="js/bootstrap.min.js"></script>
   </body>
</html>