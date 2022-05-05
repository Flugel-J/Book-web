<%-- 
    Document   : header
    Created on : Mar 12, 2022, 11:39:49 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
            <a href="index"><i class="fa fa-home" aria-hidden="true" style="font-size: 40px"></i></a>&nbsp;
		  <nav class="container">
		    <ul class="nav nav-pills">
                        <li><form action="search" method="get">
                            <input type="text" name="search" placeholder="search name, author, tag..." value="${se}" required> 
                            <input type="submit" value="search">
                            </form>
                        </li>
			<li role="presentation" class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"
				aria-haspopup="true" aria-expanded="false">
				Categories<span class="caret"></span></a>
			<ul class="dropdown-menu">
                            <c:forEach items="${categories}" var="c" begin="0" end="6">
				<li><a href="search?category=${c}">${c}</a></li>
                            </c:forEach>
                                <li><a href="categories">More..</a></li>
			</ul>
			</li>
                  </nav>
               <div id="user">
                        <c:if test="${not empty user }">
			<li role="presentation" class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"
				aria-haspopup="true" aria-expanded="false">
                                    ${sessionScope.user}<span class="caret"></span></a>
			<ul class="dropdown-menu">
                                <li><a href="profile">My profile</a></li>
                                <li><a href="upload?user=${user}">My library</a></li>
                                <li><a href="history">History</a></li>
                                <li><a href="upload">Upload</a></li>
				<li><a href="logout">Logout</a></li>
                                
                            
			</ul>
			</li>
                
                    </c:if> 
                        
           
                    <c:if test="${empty user}">
                            <a href="upload"><i class="fa fa-arrow-up" style="font-size:32px"></i></a> &nbsp;&nbsp;
                        <button><a href="login">Login</a></button> &nbsp;&nbsp;
                        <button><a href="register">Register</a></button>
                    </c:if>
                </div>
            
		    
           
                
        
        </nav>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
