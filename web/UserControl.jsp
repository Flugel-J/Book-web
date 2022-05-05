<%-- 
    Document   : UserControl
    Created on : Mar 16, 2022, 11:52:31 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Control</title>
        <jsp:include page="adminHeader.jsp"/>
    </head>
    <body>
        <h1>List of User:</h1>
        <form action="adminsearch" method="get" style="text-align: center">
            <input type="text" name="user" value="${search}" required>
            <input type="submit" value="search user"> 
        </form>
        <table>
            <th>Username</th><th>Status</th><th></th>
        <c:forEach items="${user}" var="u">
        <tr ${u.status==true?"":"style='color:red'"}>
            <td><a href="profile?user=${u.username}" target="_blank"> ${u.username}</a></td>
            <td>${u.status==true?"activated":"disable"}</td>
            <td>
                <form action="usercontrol" method="post">
                    <input type="text" name="username" value="${u.username}" hidden>
                    <input type="text" name="status" value="${u.status}" hidden>
                    <input type="submit" value="${u.status==true?"flag":"unflag"}">
                </form>
            </td>
        </tr>
        </c:forEach>
        </table>
    </body>
</html>
