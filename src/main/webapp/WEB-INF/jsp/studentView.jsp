<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.css">
<script src="../js/plugins/jquery-2.1.3.min.js"></script>
<script src="../js/plugins/bootstrap.js"></script>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="container">
  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Java 923</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="student">About me <span class="sr-only">(current)</span></a></li>
        <li><a href="${contextPath}/student/catalog">Consult Catalogs</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Learning Agreement <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${contextPath}/student/contracts">See Contracts</a></li>
            <li><a href="${contextPath}/student/optional_courses">Optional Courses</a></li>
          </ul>
        </li>
      </ul>
      <!--form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form-->
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${student.name}<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${contextPath}/student/editAccount">Edit Account</a></li>
			<li class="divider"></li>
            <li><a href="#">Log Out</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="text-center">
	<h2>${student.name}</h2>
	<br>
	<div class="row">
		<div class="col-md-5 col-md-offset-3">
		<div class="row">
		<div class="col-md-4" >
			<p style="float:right;"> Department: </p>
		</div>
		<div class="col-md-8">
			<p style="float:left;"><i> ${student.department} </i></p>
		</div>
		</div>
		<div class="row">
		<div class="col-md-4 " >
			<p style="float:right;"> Section: </p>
		</div>
		<div class="col-md-8">
			<p style="float:left;"><i> ${student.specialization} </i></p>
		</div>
		</div>
		<div class="row">
		<div class="col-md-4 " >
			<p style="float:right;"> Group: </p>
		</div>
		<div class="col-md-8">
			<p style="float:left;"><i> ${student.group} </i></p>
		</div>
		</div>
		<div class="row">
		<div class="col-md-4 " >
			<p style="float:right;"> Year of study: </p>
		</div>
		<div class="col-md-8">
			<p style="float:left;"><i> 2 </i></p>
		</div>
		</div>
		<div class="row">
		<div class="col-md-4 " >
			<p style="float:right;"> Current semester: </p>
		</div>
		<div class="col-md-8">
			<p style="float:left;"><i> 2 </i></p>
		</div>
		</div>
		</div>
	</div>
</div>
</div>
</body>
 </html>