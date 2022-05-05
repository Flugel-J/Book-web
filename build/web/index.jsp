<%-- 
    Document   : index
    Created on : Jan 25, 2022, 4:51:32 PM
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <jsp:include page="left.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
        
      
    </head>
    <body>
       
        
        <form action="index" method="get" id="filter">    
            <select name="filter" class="form-select" onchange="this.form.submit()">
            <option value="N" ${filter=="N"? "selected":""}>Newest</option>
            <option value="O" ${filter=="O"? "selected":""}>Oldest</option>
            <option value="P" ${filter=="P"? "selected":""}>Most popular</option>
            
         </select>
          
        </form>
       
        
        <c:choose>
           
            
             <c:when test="${not empty book}">
                 <c:forEach items="${book}" var="b">
                    <div class="item">
                        <div class="col-4 img" >
                            <img class="i" src="image/${b.image}"/>
                        </div>
                        <div class="col-7 detail">
                        <a href="read?id=${b.id}"><p style="text-align: center">${b.title}</p></a>
                        <span>Uploader:<a href="profile?user=${b.uploader}">${b.uploader}</a></span>&nbsp;&nbsp;&nbsp;
                        <span>Update: ${b.timeCreate}</span><br>
                        Categories:<c:forEach items="${b.categories}" var="c">
                            <a href="search?category=${c}"><span>${c}</span></a>&nbsp;
                        </c:forEach>
                            <p>Description: ${b.description}</p>
                        </div>
                    </div>
                        <br>
                </c:forEach>
            </c:when>
            
            <c:otherwise>
                <meta http-equiv="refresh" content="3;URL=/book_web_project/index">
                <h1>Oops... something when wrong</h1>
                <a href="index">Go back</a>
            </c:otherwise>
                
        </c:choose>
       
                

    </body> 
    <nav aria-label="..." id="paging">
            <ul class="pagination">
            <li class="page-item disabled">
                <c:forEach begin="${1}" end="${requestScope.numpage}" var="i">
                <li class="page-item ${i==page?"active":""}"><a class="page-link" href="index?page=${i}">${i}</a></li> 
                </c:forEach>
            </ul>
            </li>
        </nav> 
 
</html>
