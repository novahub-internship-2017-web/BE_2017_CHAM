<%@page import="com.cham.bean.Staff"%>
<%@page import="com.cham.bean.Teacher"%>
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
    <jsp:include page="admin/_header.jsp" />  
    <div id="content" style = "margin: 50px 50px 00px 350px;">
      <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost/QuanLyNhanSu"
        user="root"  password="root"/>
      <!-- <sql:query dataSource="" var="result">
        SELECT * from TEACHER;
        </sql:query> -->
      <% String type = request.getParameter("type"); %>
      <form action="" name = "user_type">
        <input type="radio" name="display" <% if (!"teacher".equals(type) && !"staff".equals(type)){ %> checked <% } %> value="All">All
        <input type="radio" name="display" <% if("staff".equals(type)){%> checked <% } %> value="Staff">Staff
        <input type="radio" name="display" <% if("teacher".equals(type)){%> checked <% } %> value="Teacher">Teacher 
      </form>
      <script type="text/javascript">
        function httpGet(theUrl)
        {
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
            xmlHttp.send( null );
            return xmlHttp.responseText;
        }
        
        var rad = document.user_type.display;
        var prev = null;
        for(var i = 0; i < rad.length; i++) {
            rad[i].onclick = function() {
                if(this.value == "Staff"){
                	    window.open("http://localhost:8080/QuanLyNhanSu/inforuser?action=getUser&type=staff", "_self");
                }
                else if(this.value == "Teacher"){
               	 	window.open("http://localhost:8080/QuanLyNhanSu/inforuser?action=getUser&type=teacher", "_self");
                }
                else {
                	window.open("http://localhost:8080/QuanLyNhanSu/inforuser?action=getUser", "_self");
                }
            };
        }
      </script>
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
          ArrayList<User> userList = (ArrayList<User>)request.getAttribute("userList");
          if(request.getAttribute("userList") != null){
          	int i=1;
          	ArrayList<Staff> listStaff = (ArrayList<Staff>) request.getAttribute("listStaff");
          	for(User user : userList){
          %>
        <%
          if(user.getType() == 2 && (type == null || "teacher".equals(type))) {
          	Teacher teacher = (Teacher)user;
          %>
        <tr>
          <th><%=i++ %></th>
          <th><%= teacher.getName() %></th>
          <th><%= teacher.getBirthDay() %></th>
          <th><%= teacher.getCountry() %></th>
          <th>Giảng Viên</th>
          <th><%= teacher.getFacutly() %></th>
          <th><%=teacher.getDegree() %></th>
          <th><%= teacher.getAllowance() %></th>
          <th><%= teacher.getLessons() %></th>
          <th><%= teacher.getCoefficientSalary() %></th>
          <th><%= teacher.getSalary() %></th>
          <th><a href="/QuanLyNhanSu/inforuser?action=edit&userId=<%= teacher.getUserId() %>">edit</a>
            <a href="/QuanLyNhanSu/inforuser?action=delete&userId=<%= teacher.getUserId() %>">delete</a>
          </th>
        </tr>
        <%} 
          else if(user.getType() == 1 && (type == null || "staff".equals(type))) {
          	Staff staff = (Staff)user;
          %>
        <tr>
          <th><%=i++ %></th>
          <th><%= staff.getName() %></th>
          <th><%= staff.getBirthDay() %></th>
          <th><%= staff.getCountry() %></th>
          <th>Nhân Viên</th>
          <th><%= staff.getDepartmemt() %></th>
          <th><%= staff.getPosition() %></th>
          <th><%= staff.getAllowance() %></th>
          <th><%= staff.getWorkdays() %></th>
          <th><%= staff.getCoefficientSalary() %></th>
          <th><%= staff.getSalary() %></th>
          <th><a href="/QuanLyNhanSu/inforuser?action=edit&userId=<%= staff.getUserId() %>">edit</a>
            <a href="/QuanLyNhanSu/inforuser?action=delete&userId=<%= staff.getUserId() %>">delete</a>
          </th>
        </tr>
        <%} %>
        <%} }%>
      </table>
    </div>
  </body>
</html>