<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/bootstrap/bootstrap.css">
<script src="/js/plugins/jquery-2.1.3.min.js"></script>
<script src="/js/plugins/bootstrap.js"></script>
<script>
 $( document ).ready(function() {
    $('.submit_button').click( function(){
      var ids = new Array;
      var list = $("input.form-control").each(function(i,e) {
        ids[$(e).attr("id")] = $(e).val();
      });

      var token = $("input[name='_csrf']").val();
      var header = "X-CSRF-TOKEN";
      console.log("We will send the objects", ids);
      $.ajax({
        type: "POST",
        url: "propose_courses",
        data: JSON.stringify(ids),
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.setRequestHeader(header, token);
        },
        success: function(url) {
    
        }
      });
    });
  });
</script>
<title>Home</title>
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
        <li ><a href="${contextPath}/teacher">About me <span class="sr-only">(current)</span></a></li>
        <li ><a href="${contextPath}/teacher/courses">Manage courses</a></li>
        <li class="active"><a href="${contextPath}/teacher/propose_courses">Propose courses</a></li>
      </ul>
      <!--form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form-->
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${teacher.name} <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Edit Account</a></li>
      <li class="divider"></li>
            <li><a href="#">Log Out</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

  <div class="col-md-6 col-md-offset-3">
  <form class="form-horizontal" style="padding-top:50px;">
  <div class="form-group">
    <label for="exampleInputEmail1" class="col-md-4 control-label">Course name</label>
  <div class="col-md-8">
    <input type="text" class="form-control" id="name" placeholder="Course name">
  </div>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1" class="col-md-4 control-label">Semester</label>
  <div class="col-md-8">
    <input type="text" class="form-control" id="semester" placeholder="Semester">
  </div>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1" class="col-md-4 control-label">Nr. of credits</label>
  <div class="col-md-8">
    <input type="text" class="form-control" id="credits" placeholder="Credits">
  </div>
  </div>
  <div class="text-center">
  <a class="btn btn-default btn-primary submit_button" >Save</a>
  <a class="btn btn-default">Cancel</a>
  </div>
  </div>
</form>

</body>
</html>