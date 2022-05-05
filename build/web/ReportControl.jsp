<%-- 
    Document   : ReportControl
    Created on : Mar 16, 2022, 4:36:58 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report Control</title>
        <jsp:include page="adminHeader.jsp"/>
        
    </head>
    <body>
        <h1>List of Reported Book:${numrp}</h1>
           <a href="reportcontrol?a=all">Clear all report</a>
        <c:choose>
         <c:when test="${not empty book}">
                 <c:forEach items="${book}" var="b">
                    <div class="item">
                        <div class="col-4 img" >
                            <img class="i" src="image/${b.image}"/>
                        </div>
                        <div class="col-7 detail">
                            <a href="read?id=${b.id}" target="_blank"><p style="text-align: center">${b.title}</p></a>
                        <span>Uploader:<a href="profile?user=${b.uploader}">${b.uploader}</a></span>&nbsp;&nbsp;&nbsp;
                        <span>Update: ${b.timeCreate}</span><br>
                        Categories:<c:forEach items="${b.categories}" var="c">
                            <a href="search?category=${c}"><span>${c}</span></a>&nbsp;
                        </c:forEach>
                            <p>Description: ${b.description}</p>
                        </div>
                      
                    </div> 
                        <div class="col-md-1">
                            <a href="seereport?id=${b.id}" style="color:red">See report</a>
                        </div>
                        <br>
                </c:forEach>
            </c:when>
            
            <c:otherwise>
              
                <h1>There is no book currently being report</h1>
                
            </c:otherwise>
                
        </c:choose>
       
    </body>
</html>
