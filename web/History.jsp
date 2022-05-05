<%-- 
    Document   : History
    Created on : Mar 11, 2022, 3:55:12 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
    </head>
    <body>
        <h1>History</h1>
        <c:forEach items="${history}" var="h">
            <div class="item">
                <div class="col-4 img" >
                            <img class="i" src="image/${h.image}"/>
                        </div>
              <div class="col-7 detail">
                <p><a href="read?id=${h.id}">${h.title}</a></p>
                <span>by:</span><a href="profile?user=${h.uploader}">${h.uploader}</a>
              </div>
              <span class="close"><a href="history?id=${h.id}">x</a></span>
            </div>
        </c:forEach>
    </body>
</html>
