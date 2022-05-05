<%-- 
    Document   : CommentControl
    Created on : Mar 16, 2022, 8:26:42 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comment control</title>
        <jsp:include page="adminHeader.jsp"/>
    </head>
    <body>
        <h1>List of comment being marked:</h1>
        <a href="commentcontrol?a=all">Clear all report</a>
        <c:forEach items="${report}" var ="r">
             <div style="border: 1px solid">
                                <span>${r.user}</span> &nbsp;&nbsp;&nbsp;
                                <span>${r.timeCreate}</span><br>
                                <p>${r.detail}</p>
                                <form action="commentcontrol" method="post">
                                    <input type="text" name="id" value="${r.id}" hidden>
                                    <input class="btn-btn-danger" type="submit" value="delete">
                                </form>
             </div>
        </c:forEach>
    </body>
</html>
