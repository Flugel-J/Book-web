<%-- 
    Document   : adminHeader
    Created on : Mar 16, 2022, 11:53:22 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="Css/style.css">
    </head>
    <body>
       <nav class="navbar navbar-default navbar-static-bottom">
		  <div class="container">
		    <ul class="nav nav-pills">
                        <li><a href="admin">Statistic</a><li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <li><a href="usercontrol">User</a><li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<li><a href="bookcontrol">Book</a><li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<li role="presentation" class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"
				aria-haspopup="true" aria-expanded="false">
				Report<span class="caret"></span></a>
			<ul class="dropdown-menu">
                            <li><a href="reportcontrol">Book Report</a></li>
                            <li><a href="commentcontrol">Comment report</a></li>
			</ul>
			</li>
                    </ul>
		    </div>
		</nav>
    </body>
     <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
