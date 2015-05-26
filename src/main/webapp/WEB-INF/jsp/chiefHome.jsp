<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.css">
<script src="../js/plugins/jquery-2.1.3.min.js"></script>
<script src="../js/plugins/bootstrap.js"></script>
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
        <li><a href="#">Manage courses</a></li>
    <li><a href="#">Propose courses</a></li>
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
      <tr class="sem1">
        <td>
          1
        </td>
        <td>
          Operating systems
        </td>
        <td>
          Radu Dragos
        </td>
        <td>
          Linux
        </td>
        <td>
        <select class="form-control">
          <option value="true">Accepted</option>
          <option value="false">Rejected</option>
      </select>
        </td>
      </tr>
      <tr class="sem2">
        <td>
          2
        </td>
        <td>
          Computer Networks
        </td>
    <td>
          Adrian Darabant
        </td>
    <td>
      Linux
        </td>
        <td>
      <select class="form-control">
        <option value="true">Accepted</option>
        <option value="false">Rejected</option>
      </select>
        </td>
      </tr>
      <tr class="sem3">
        <td>
          3
        </td>
        <td>
          Aspect Oriented Programming
        </td>
        <td>
          Cojocar Grigoreta
        </td>
        <td>
          Java
        </td>
        <td>
      <select class="form-control">
        <option value="true">Accepted</option>
        <option value="false">Rejected</option>
      </select>
        </td>
      </tr>
    </tbody>
    </table>
  </div>
    <div class="text-center">
  <button type="submit" class="btn btn-default btn-primary" >Save</button>
  <button class="btn btn-default">Cancel</button>
  </div>
</div>
</div>
</body>
 </html>