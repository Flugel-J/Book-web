<%-- 
    Document   : BookControl
    Created on : Mar 16, 2022, 12:29:55 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="adminHeader.jsp"/>
        <title>Book Control</title>
    </head>
    <body>
        <h1>Book :</h1>
     <form action="adminsearch" method="post" style="text-align: center">
            <input type="text" name="title" value="${search}" required>
            <input type="submit" value="search book"> 
        </form>
        <table>
            <th>Id</th><th>Title</th><th>Uploader</th><th>Status</th><th>isReported</th><th></th>
        <c:forEach items="${book}" var="b">
        <tr ${b.status==true?"":"style='color:red'"}>
            <td>${b.id}</td>
            <td><a href="read?id=${b.id}" target="_blank"> ${b.title}</a></td>
            <td><a href="profile?user=${b.uploader}" target="_blank"> ${b.uploader}</a></td>
            <td>${b.status==true?"available":"disable"}</td>
            <td>
                <c:if test="${b.description=='report'}">
                    <p>This book have been reported</p>
                    <a href="seereport?id=${b.id}" style="color:red" target="_blank">See report</a>
                </c:if>
            </td>
            <td>
                <form action="bookcontrol" method="post">
                    <input type="text" name="id" value="${b.id}" hidden>
                    <input type="text" name="status" value="${b.status}" hidden>
                    <input type="submit" value="${b.status==true?"flag":"unflag"}">
                </form>
            </td>
        </tr>
        </c:forEach>
        </table>
    </body>
</html>
