<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
div.content {
    font-family: calibri;
}
</style>
<body>
<div class="content">
	<div class="row">
<br /><br />
<form id="togglingForm" method="post" class="form-horizontal">
    <div class="form-group">
        	<label class="radio-inline">Search User by </label>  
            <label class="radio-inline">
                <input type="radio" name="rating" value="name" checked='checked' /> Name
            </label>
            <label class="radio-inline">
                <input type="radio" name="rating" value="country" /> Country
            </label>
            <label class="radio-inline">
                <input type="radio" name="rating" value="birthday" /> Birthday
            </label>
            <input type="text" size ="40" class="form-control" name="company"
                   required data-fv-notempty-message="The company name is required" /> 
            <button type="button" class="btn btn-success" data-toggle="#jobInfo">Search</button>
        </div>
    
</form>
</div></div>
</body>
</html>