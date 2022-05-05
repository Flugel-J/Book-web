<%-- 
    Document   : Category
    Created on : Mar 4, 2022, 4:14:21 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"/>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category</title>
        
    </head>
    <body>
        
        <h1>All Categories:</h1><br>
        <div class="category">
            <a href="categories?sort=a-z"><span style="border:1px solid">A-Z</span></a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="categories?sort=popular"><span style="border:1px solid">Popular</span></a>
        </div>
        <table align:center class="border">
            <tr>
        <c:forEach items="${categories}" var ="c" varStatus="Co">
            <c:if test="${Co.index%4==0}"></tr><tr class="border"></c:if>
                <td class="border">
                    <a href="search?category=${c}" style="color: black"><span style="border: 1px solid">${c}</span></a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                </td>
        </c:forEach>
        </table>
        
           
        
        
        
        
   
    
    </body>
       <nav aria-label="..." id="paging">
            <ul class="pagination">
            <li class="page-item disabled">
                <c:forEach begin="${1}" end="${requestScope.numpage}" var="i">
                <li class="page-item ${i==page?"active":""}"><a class="page-link" href="categories?page=${i}">${i}</a></li> 
                </c:forEach>
            </ul>
            
        </nav> 
</html>
