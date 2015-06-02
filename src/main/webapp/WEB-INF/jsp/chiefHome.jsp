<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.css">
<script src="../js/plugins/jquery-2.1.3.min.js"></script>
<script src="../js/plugins/bootstrap.js"></script>
<script>
$( document ).ready(function() {
  function myFunction(checkbox) 
  {
    var valoare = checkbox.getAttribute("value");
    inputs = $("input[type='checkbox']");
    var valoare_jmekera = true;
    $.each( inputs, function( key, value ) {
      if(value.checked)
      {
        valoare_jmekera = false;
        $("."+value.getAttribute("value")).show();
      }
      else
      {
        $("."+value.getAttribute("value")).hide();
      }
    });
    if(valoare_jmekera == true)
    {
      $(".catalog tr").show();
    }
  }
   $('.submit_button').click( function(){
      var ids = [];
      var list = $("select").each(function(i,e) {
        if($(e).val())
        {
          ids[$(e).data("course-id")] = $(e).val()
        }
      });
  
      // this we will make the ajax call with the ids
      var token = $("input[name='_csrf']").val();
      var header = "X-CSRF-TOKEN";
      console.log("We will send the objects", ids);
      $.ajax({
        type: "POST",
        url: "teacher/aprove_courses",
        data: JSON.stringify(ids),
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.setRequestHeader(header, token);
        },
        success: function(url) {
          window.location = "aprove_courses";
        }
    });
      
      
  });
 });
</script>
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
        <li class="active"><a href="#">Accept optional courses</a></li>
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
<div class="row">
  <div class="col-md-3 text-center" >
  <div class="checkbox">
    <label>
      <input type="checkbox" value="sem1" onclick="myFunction(this)"> Sem 1
    </label>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox" value="sem2" onclick="myFunction(this)"> Sem 2
    </label>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox" value="sem3" onclick="myFunction(this)"> Sem 3
    </label>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox" value="sem4" onclick="myFunction(this)"> Sem 4
    </label>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox" value="sem5" onclick="myFunction(this)"> Sem 5
    </label>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox" value="sem6" onclick="myFunction(this)"> Sem 6
    </label>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox" value="sem7" onclick="myFunction(this)"> Sem 7
    </label>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox" value="sem8" onclick="myFunction(this)"> Sem 8
    </label>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox" value="sem9" onclick="myFunction(this)"> Sem 9
    </label>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox" value="sem10" onclick="myFunction(this)"> Sem 10
    </label>
  </div>
  </div>
  <div class="col-md-9">
    <table class="table">
    <thead>
      <tr>
        <th>
          Crt.No.
        </th>
        <th>
          Course Name
        </th>
        <th>
          Teacher Name
        </th>
        <th>
          Description
        </th>
        <th>
          Acceptance
        </th>
      </tr>
    </thead>
    <tbody class='catalog'>
      <c:forEach var="course" items="${courses}">
        <tr class="sem${course.semester}">
          <td>${course.code}</td>
          <td>${course.name}</td>
          <td>${course.getTeacher()}</td>
          <td>${course.credits}</td>
          <td>
            <select class="form-control" data-course-id="${course.code}">
              <option value="" disabled selected>Select your option</option>
              <option value="true">Accepted</option>
              <option value="false">Rejected</option>
            </select>
          </td>
        </tr>
      </c:forEach>
    </tbody>
    </table>
  </div>
    <div class="text-center">
      <a class="btn btn-default btn-primary submit_button" >Save</button>
      <a class="btn btn-default">Cancel</button>
    </div>
</div>
</div>
</body>
 </html>