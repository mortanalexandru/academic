<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" type="text/css" href="/css/bootstrap/bootstrap.css">
<script src="/js/plugins/jquery-2.1.3.min.js"></script>
<script src="/js/plugins/bootstrap.js"></script>
</head>

<body>
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
        <li class="active"><a href="${contextPath}/student">About me <span class="sr-only">(current)</span></a></li>
        <li><a href="${contextPath}/student/catalog">Consult Catalogs</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Learning Agreement <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
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


  <div class="col-md-6 col-md-offset-3">
  <form class="form-horizontal" style="padding-top:50px;">
  <div class="form-group">
    <label for="name" class="col-md-4 control-label">name</label>
	<div class="col-md-8">
		<input type="text" class="form-control" id="exampleInputEmail1" value="${student.name}" disabled="disabled">
	</div>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1" class="col-md-4 control-label">Old Password</label>
	<div class="col-md-8">
		<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
	</div>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1" class="col-md-4 control-label">New Password</label>
	<div class="col-md-8">
		<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
	</div>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1" class="col-md-4 control-label">Confirm Password</label>
	<div class="col-md-8">
		<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
	</div>
  </div>
  <div class="text-center">
	<button type="submit" class="btn btn-default btn-primary" >Save</button>
	<button class="btn btn-default">Cancel</button>
  </div>
  </div>
</form>

</body>
 </html>