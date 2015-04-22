<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.css">
<script src="js/plugins/jquery-2.1.3.min.js"></script>
<script src="js/plugins/bootstrap.js"></script>
</head>

<body>
<div class="container" style="margin-top:100px">
	<div class="col-md-6 col-md-offset-3">
	<c:url value="/login" var="loginUrl"/>
<c:if test="${error}">
	<div>Invalid username or password</div>
</c:if>
  <form action="${loginUrl}" method="post" class="form-horizontal" style="padding-top:50px;">
  <div class="form-group">
    <label for="exampleInputEmail1" class="col-md-4 control-label">Username</label>
	<div class="col-md-8">
		<input type="text" class="form-control" id="username" name="username" placeholder="username">
	</div>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1" class="col-md-4 control-label">Password</label>
	<div class="col-md-8">
		<input type="password" class="form-control" id="password" name="password" placeholder="password">
	</div>
  </div>
  <input type="hidden"                        
        name="${_csrf.parameterName}"
        value="${_csrf.token}"/>
  <div class="text-center">
	<button type="submit" class="btn btn-default btn-primary" >Log in</button>
  </div>
</div>
</body>
 </html>