<%-- 
    Document   : Library
    Created on : Feb 23, 2022, 5:38:12 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"/>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My library</title>
    </head>
    <body>
      
        <h1>${user}'s library</h1><br>
        <script type="text/javascript">
            function doDelete(id){
                if(confirm("Are you sure to delete this book?")){
                    window.location="manage?id="+id+"&a=book";
                }
            }
        </script>
        <c:if test="${empty library}">
            <p>you haven't upload anything yet</p>
            <a href="upload">Go to upload</a>
        </c:if>
        <c:if test="${not empty library}">
            <c:forEach items="${library}" var="l">
                <div class="lib">
                    <a href="read?id=${l.id}"><p style="text-align: center">${l.title}</p></a>
                    update:<span>${l.timeCreate}</span> &nbsp;&nbsp;&nbsp;
                    Viewed:<span>${l.viewed}</span><br>
                    Categories:<c:forEach items="${l.categories}" var="c">
                        <a href="search?category=${c}"><span>${c}</span></a>&nbsp;
                              
                                </c:forEach>
                    <br>     
                    <a href="manage?id=${l.id}">Edit</a>&nbsp;&nbsp;
                    <a href="#" onclick="doDelete('${l.id}')">Delete</a>  
                    <c:if test="${l.status==false}">
                        <h5 style="color:red;">This book is flagged by admin. Contact hoangvmhe161059@fpt.edu.vn for more info</h5>
                    </c:if>
                </div>
            </c:forEach>
        </c:if>    
        
    </body>
</html>
