
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">s
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../css/bootstrap/bootstrap.css">
<script src="../../js/plugins/jquery-2.1.3.min.js"></script>
<script src="../../js/plugins/bootstrap.js"></script>
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

<div class="row">
  <div class="col-md-3 text-center">
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
          Course code
        </th>
        <th>
          Name
        </th>
        <th>
          ECTS
        </th>
      </tr>
    </thead>
    <tbody class='catalog'>
      <tr class="sem1">
        <td>
          MLE5007
        </td>
        <td>
          Operating systems
        </td>
        <td>
          5
        </td>
        
      </tr>
      <tr class="sem2">
        <td>
          MLE5009
        </td>
        <td>
          Computer Networks
        </td>
        <td>
          6
        </td>
        
      </tr>
      <tr class="sem3">
        <td>
          MLE5010
        </td>
        <td>
          Advanced programming methods
        </td>
        
        <td>
          6
        </td>
        
      </tr>
      <tr class="sem3">
        <td>
          MLE5011
        </td>
        <td>
          Graph algorithms
        </td>
        
        <td>
          5
        </td>
        
      </tr>
      <tr class="sem1">
        <td>
          MLE5012
        </td>
        <td>
          Computational logic
        </td>
        
        <td>
          5
        </td>
       
      </tr>
      <tr class="sem4">
        <td>
          MLE5013
        </td>
        <td>
          Software Engeneering
        </td>
        
        <td>
          6
        </td>
        
      </tr>
      <tr class="sem4">
        <td>
          MLE5014
        </td>
        <td>
          Advanced Programming methods
        </td>
        
        <td>
          5
        </td>
        
      </tr>
      <tr class="sem1">
        <td>
          MLE5015
        </td>
        <td>
          Algebra
        </td>
       
        <td>
          5
        </td>
        
      </tr>
      <tr class="sem2">
        <td>
          MLE5008
        </td>
        <td>
          Geometry
        </td>
        
        <td>
          6
        </td>
        
      </tr>
    </tbody>
    </table>
  </div>
</div>



</div>


</body>
 </html>