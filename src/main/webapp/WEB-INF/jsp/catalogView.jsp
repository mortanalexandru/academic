<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.css">
<script src="js/plugins/jquery-2.1.3.min.js"></script>
<script src="js/plugins/bootstrap.js"></script>
<script>
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
    console.log(valoare_jmekera);
    if(valoare_jmekera == true)
    {
      $(".catalog tr").show();
    }
  }
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
  <div class="col-md-4">
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
  <div class="col-md-8">
		<table class="table table-striped" >
		<thead>
			<tr>
				<th>
					Course code
				</th>
				<th>
					Name
				</th>
				<th>
					Grade
				</th>
				<th>
					ECTS
				</th>
				<th>
					Passed
				</th>
				<th>
					Teacher
				</th>
				<th>
					Type
				</th>
			</tr>
		</thead>
		<tbody class="catalog">
		<c:forEach var="course" items="${courses}">
						<tr class="sem${course.semester}">
							<td>${course.code}</td>
							<td>${course.name}</td>
							<td>${course.grade}</td>
							<td>${course.credits}</td>
							<td>
							<c:choose>
										<c:when test="${course.passed}">
       PASSED
    </c:when>
										<c:otherwise>
     	FAILED
    </c:otherwise>
									</c:choose>
							</td>
							<td>${course.teacher}</td>
							<td><c:choose>
										<c:when test="${course.optional}">
       Optional
    </c:when>
										<c:otherwise>
     	Mandatory
    </c:otherwise>
									</c:choose></td>				
						</tr>
				</c:forEach>
		</tbody>
		</table>
  </div>
</div>



</div>


</body>
 </html>