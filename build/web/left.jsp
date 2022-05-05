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
      
    </head>
    <body>
       
        
        <div class="top">
            <h4>Top view:</h4>
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <c:set var="t" scope="session" value="${top}"/>
  <div class="carousel-inner">
    <div class="carousel-item active">
        <a href="read?id=${t[0].id}"><img class="d-block w-100" src="image/${t[0].image}" alt="First slide"></a>
      <div class="carousel-caption d-none d-md-block">
          <h5>${t[0].title}</h5>
          <p>View:${t[0].viewed}</p>
      </div>
    </div>
      
    <div class="carousel-item ">
        <a href="read?id=${t[1].id}"><img class="d-block w-100" src="image/${t[1].image}" alt="Second slide"></a>
      <div class="carousel-caption d-none d-md-block">
          <h5>${t[1].title}</h5>
          <p>View:${t[1].viewed}</p>
      </div>
    </div>
    <div class="carousel-item ">
        <a href="read?id=${t[2].id}"><img class="d-block w-100" src="image/${t[2].image}" alt="Third slide"></a>
      <div class="carousel-caption d-none d-md-block">
          <h5>${t[2].title}</h5>
          <p>View:${t[2].viewed}</p>
      </div>
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
    </div>
    <c:if test="${not empty continue}">
      <div class="con">
          <h4>Continue to read:</h4>
          
          <div class="col-4 img" >
                            <img class="i" src="image/${continue.image}"/>
                        </div>
                        <div class="col-7 detail">
                        <a href="read?id=${continue.id}"><p style="text-align: center">${continue.title}</p></a>
                        <span>Uploader:<a href="search?search=${continue.uploader}">${continue.uploader}</a></span>&nbsp;&nbsp;&nbsp;
                        <span>Update: ${continue.timeCreate}</span><br>
                        Categories:<c:forEach items="${continue.categories}" var="c">
                            <a href="search?category=${c}"><span>${c}</span></a>&nbsp;
                        </c:forEach>
                            <p>Description: ${continue.description}</p>
                        </div>
      </div>
    </c:if>
 </div>
    </body>
   
</html>
