<%@page import="com.cham.bean.Staff"%>
<%@page import="com.cham.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>ADMIN</title>
</head>
<body>
<div id="header">
		<div style="width: 100%">
         <h1>TRƯỜNG ĐẠI HỌC BÁCH KHOA - ĐẠI HỌC ĐÀ NẴNG</h1>
         </div>  
              </div>
<div class="nav-side-menu">
    <div class="brand">*^_^* MENU *^_^*</div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">
                <li>
                  <a href="#">
                  <i class="fa fa-dashboard fa-lg"></i> Home
                  </a>
                </li>
				<li>
                  <a href="#">
                  <i class="fa fa-users fa-lg"></i> Add
                  </a>
                </li>
                <li>
                  <a href="#">
                  <i class="fa fa-users fa-lg"></i> Edit
                  </a>
                </li>
                <li>
                  <a href="#">
                  <i class="fa fa-users fa-lg"></i> Search
                  </a>
                </li>
                <li>
                  <a href="#">
                  <i class="fa fa-user fa-lg"></i> Delete
                  </a>
                  </li>
                <li data-toggle="collapse" data-target="#new" class="collapsed">
                  <a href="#"><i class="fa fa-car fa-lg"></i> My Information <span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="new">
                  <li>Infor</li>
                  <li>Edit Infor</li>
                  <li>Edit user and password</li>
                </ul>
				 <li>
                  <a href="#">
                  <i class="fa fa-users fa-lg"></i> Logout
                  </a>
                </li>
            </ul>
     </div>
</div>
<div id="content" style = "margin: 50px 50px 00px 350px;">
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/QuanLyNhanSu"
     user="root"  password="root"/>
 <form action="">
<input type="radio" name="display" value="All">All
<input type="radio" name="display" value="Staff">Staff
<input type="radio" name="display" value="Teacher">Teacher 
</form>
<table border="1" width="100%">
<tr>
	<th>STT</th>
   <th>Name</th>
   <th>Birthday</th>
   <th>Country</th>
   <th>Type</th>
   <th>C1</th>
   <th>C2</th>
   <th>C3</th>
   <th>C4</th>
   <th>C5 </th>
   <th>C6</th>
   <th>Action</th>
</tr>
<%
	
	if(request.getAttribute("listStaff") != null){
		System.out.print("toi day");
		ArrayList<Staff> listStaff = (ArrayList<Staff>) request.getAttribute("listStaff");
		int i=0;
		for(Staff objStaff : listStaff){
			
%>
<tr>
   <th><%= i++ %></th>
   <th><%=objStaff.getName() %></th>
   <th><%=objStaff.getBirthDay() %></th>
   <th><%=objStaff.getCountry() %></th>
   <th>Nhân Viên</th>
   <th><%=objStaff.getDepartmemt() %></th>
   <th><%=objStaff.getPosition() %></th>
   <th><%=objStaff.getAllowance() %></th>
   <th><%=objStaff.getWorkdays() %></th>
   <th><%=objStaff.getCoefficientSalary() %></th>
   <th><%=objStaff.getSalary() %></th>
   <th></th>
</tr>
<%} }%>
</table>
</div>
</body>
</html>