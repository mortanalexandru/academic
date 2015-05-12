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
  // function myFunction(checkbox) 
  // {
  //   var valoare = checkbox.getAttribute("value");
  //   inputs = $("input[type='checkbox']");
  //   var valoare_jmekera = true;
  //   $.each( inputs, function( key, value ) {
  //     if(value.checked)
  //     {
  //       valoare_jmekera = false;
  //       $("."+value.getAttribute("value")).show();
  //     }
  //     else
  //     {
  //       $("."+value.getAttribute("value")).hide();
  //     }
  //   });
  //   if(valoare_jmekera == true)
  //   {
  //     $(".catalog tr").show();
  //   }
  // }
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
        <li><a href="#">About me <span class="sr-only">(current)</span></a></li>
        <li class="active"><a href="#">Manage courses</a></li>
      </ul>
      <!--form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form-->
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">toie1637 <span class="caret"></span></a>
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

<div>
  <h3> Grades - Course X, Semester Y </h3>
  <table class="table">
    <thead>
      <tr>
        <th>
          Crt. no.
        </th>
        <th>
          Student Name
        </th>
        <th>
          Group
        </th>
        <th>
          Grade
        </th>
      </tr>
    </thead>
    <tbody class='catalog'>
      <tr >
        <td>
          1
        </td>
        <td>
          Suba Renata
        </td>
        <td>
          923
        </td>
        <td>
          <input type="text" name="grade_suba"/>  
        </td>
        
      </tr>
      <tr >
        <td>
          2
        </td>
        <td>
          Toma Ovidiu
        </td>
        <td>
          923
        </td>
        <td>
          <input type="text" name="grade_toma"/> 
        </td>
      </tr>
      <tr>
        <td>
          3
        </td>
        <td>
          Virtan Mara
        </td>
        
        <td>
          923
        </td>
        <td>
          <input type="text" name="grade_virtan"/> 
        </td>        
      
    </tbody>
    </table>

    <div class="text-center">
      <button type="submit" class="btn btn-default btn-primary" >Save</button>
      <button type="button" class="btn btn-default">Cancel</button>

    </div>
</div>

</div>
</body>
 </html>