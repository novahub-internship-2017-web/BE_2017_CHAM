<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <%@page import="com.cham.bean.Staff"%>
   <%@page import="com.cham.bean.Teacher"%>
   <%@page import="com.cham.bean.User"%>
   <%@ page import="java.io.*,java.util.*,java.sql.*"%>
   <%@ page import="javax.servlet.http.*,javax.servlet.*" %>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
      <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
      <link rel="stylesheet" href="css/mycss.css">
      <link rel="stylesheet" href="css/user.css">
      <title>USER</title>
   </head>
   <body>
      <%Teacher teacher = (Teacher)request.getAttribute("teacher"); %>
      <%= teacher.getBirthDay() %>
      <jsp:include page="_header_teacher.jsp" />  
      <div id="content" style = "margin: 50px 50px 00px 350px;">
         <center>
            <h3>MY INFORMATION</h3>
         </center>
         </br>
         <label for="name">My name</label>: <input type="text" value="<%= teacher.getName() %>" id="name" name="name" size="80" /></br>
         <label for="email">Birthday</label>: <input type="text" value ="<%= teacher.getBirthDay() %>"id="birthday" name="birthday" size="80" /></br>
         <label for="email">Facutly</label>: <input type="text"value ="<%= teacher.getFacutly() %>" id="faculty" name="f" size="80" /></br>
         <label for="email">Lessons</label>: <input type="text" value ="<%= teacher.getLessons() %>"id="lessons" name="lessons" size="80" /></br>
         <label for="email">CoefficientSalary</label>: <input value ="<%= teacher.getCoefficientSalary() %>"type="text" id="coefficientSalary" name="coefficientSalary" size="80" /></br>
         <label for="email">Degree</label>: <input type="text" value ="<%= teacher.getDegree() %>"id="degree" name="degree" size="80" /></br>
         <label for="email">Country</label>: <input type="text" value ="<%= teacher.getCountry() %>"id="country" name="country" size="80" /></br>
         <label for="email">Allowance</label>: <input type="text" value ="<%= teacher.getAllowance() %>"id="allowance" name="allowance" size="80" /></br>
         <label for="email">Salary</label>: <input type="text" value ="<%= teacher.getSalary() %>"id="salary" name="salary" size="80" />
      </div>
   </body>
</html>