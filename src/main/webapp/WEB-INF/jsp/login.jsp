<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Discipulus</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/home.js"></script>
</head>

<body>

<p id="header">Hi there!</p>
<c:url value="login" var="loginUrl"/>
<c:if test="${error}">
	<div>Invalid username or password</div>
</c:if>
<form action="${loginUrl}" method="post">
    <p>
        <label for="username">Username</label>
        <input type="text" id="username" name="username"/>	
    </p>
    <p>
        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>	
    </p>
    <input type="hidden"                        
        name="${_csrf.parameterName}"
        value="${_csrf.token}"/>
    <button type="submit" class="btn">Log in</button>
</form>
</body>

</html>
