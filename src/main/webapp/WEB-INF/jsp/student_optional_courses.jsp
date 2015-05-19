<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.css">
<script src="js/plugins/jquery-2.1.3.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="js/plugins/bootstrap.js"></script>
<script>
  $( document ).ready(function() {
    $('#final_optional').css({'min-height': "100px"});
    $('.submit_button').click( function(){
      var ids = [];
      var list = $("#final_optional li").each(function(i,e) {
        ids.push($(e).data("course-id")); 
      });
      console.log("We will send the objects", ids);
      // this we will make the ajax call with the ids
    });
    $('#final_optional, #available_optional').sortable({
      connectWith: ".sortable-list"
    });
  });
</script>
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
        <li class="active"><a href="${contextPath}/student">About me <span class="sr-only">(current)</span></a></li>
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

<div class="row">
  
  <div class="col-md-12">
  <div class="col-md-6">
    <h3> Available optional courses </h3>
    <ul id="available_optional" class="list-group sortable-list">
      <li class="list-group-item" data-course-id="1">Cras justo odio</li>
      <li class="list-group-item" data-course-id="2">Dapibus ac facilisis in</li>
      <li class="list-group-item" data-course-id="3">Morbi leo risus</li>
      <li class="list-group-item" data-course-id="4">Porta ac consectetur ac</li>
      <li class="list-group-item" data-course-id="5">Vestibulum at eros</li>
    </ul>
  </div>
  
  <div class="col-md-6">
    <h3> Final optional courses </h3>
    <ul id="final_optional" class="list-group sortable-list">
    </ul>
  </div>


  
  <div class="col-xs-12 text-center">
    <button type="button" class="btn btn-primary submit_button">Submit</button>
    <button type="button" class="btn btn-default "> Cancel</button>
  </div>
  </div>

</div>
</div>
</body>
 </html>