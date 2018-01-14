<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link rel="stylesheet" href="css/mycss.css">
<link rel="stylesheet" href="css/login.css">
<title>LOGIN</title>
</head>
<body>
<div id="header">
		<div style="width: 100%">
         <h1>TRƯỜNG ĐẠI HỌC BÁCH KHOA - ĐẠI HỌC ĐÀ NẴNG</h1>
         </div>
        </div>
<div class="container">
   <div class="login-container">
      <div id="output"></div>
       <div class="avatar"></div>
       <div class="form-box">
           <form action="${pageContext.request.contextPath}/LoginServlet" method="post" enctype="application/x-www-form-urlencoded">
               <input name="username" type="text" placeholder="username">
               <input name="password" type="password" placeholder="password">
               <button class="btn btn-info btn-block login" type="submit">Login</button>
           </form>
       </div>
   </div>
 </div>
</body>
</html>