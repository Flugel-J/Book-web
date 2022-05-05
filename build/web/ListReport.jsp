<%-- 
    Document   : ListReport
    Created on : Mar 16, 2022, 5:03:05 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report</title>
        <jsp:include page="adminHeader.jsp"/>
    </head>
    <body>
        <table style="border: 1px solid">
            <th>Reporter:</th><th>Report on id</th><th>Reason</th>
        <c:forEach items="${report}" var="r">
            <tr>
                <td>${r.username}</td>
                <td>${r.id}</td>
                <td>${r.detail}</td>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
