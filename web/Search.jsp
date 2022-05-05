<%-- 
    Document   : index
    Created on : Jan 25, 2022, 4:51:32 PM
    Author     : admin
--%>

<%@page import="model.Book"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"/>
    <jsp:include page="left.jsp"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
            
        
        
        <c:choose>
            <c:when test="${not empty search}">
            <form action="search" method="get" id="filter">    
                <select name="filter" class="form-select" onchange="this.form.submit()">
                <option value="N" ${filter=="N"? "selected":""}>Newest</option>
                <option value="O" ${filter=="O"? "selected":""}>Oldest</option>
                <option value="P" ${filter=="P"? "selected":""}>Most popular</option>
                <input type="text" name="search" value="${se}" hidden/>
                </select>
          
            </form>
                 <c:forEach items="${search}" var="s">
                    <div class="item">
                          <div class="col-4 img" >
                            <img class="i" src="image/${s.image}"/>
                        </div>
                         <div class="col-7 detail">
                            <a href="read?id=${s.id}"><p style="text-align: center">${s.title}</p></a>
                            <span>Uploader: <a href="profile?user=${s.uploader}">${s.uploader}</a></span>&nbsp;&nbsp;&nbsp;
                            <span>Update: ${s.timeCreate}</span><br>
                            Categories:<c:forEach items="${s.categories}" var="c">
                                <a href="search?category=${c}"><span>${c}</span></a>&nbsp;
                            </c:forEach>
                                Description:<p>${s.description}</p>
                        </div>
                    </div>
                </c:forEach>
                 <nav aria-label="..." id="paging">
            <ul class="pagination">
            <li class="page-item disabled">
                <c:forEach begin="${1}" end="${requestScope.numpage}" var="i">
                <li class="page-item ${i==page?"active":""}"><a class="page-link" href="search?search=${se}&page=${i}">${i}</a></li> 
                </c:forEach>
            </ul>
            </li>
        </nav> 
            </c:when>
            <c:when test="${not empty category}">
                <form action="search" method="post" id="filter">    
                    <select name="filter" class="form-select" onchange="this.form.submit()">
                        <option value="N" ${filter=="N"? "selected":""}>Newest</option>
                        <option value="O" ${filter=="O"? "selected":""}>Oldest</option>
                        <option value="P" ${filter=="P"? "selected":""}>Most popular</option>
                        <input type="text" name="category" value="${cate}" hidden/>
                    </select>
            </form>
                <h1>Category:${cate}</h1>
                 <c:forEach items="${category}" var="c">
                     
                    <div class="item">
                
                          <div class="col-4 img" >
                            <img class="i" src="image/${c.image}"/>
                          </div>
                         <div class="col-7 detail">
                                <a href="read?id=${c.id}"><p style="text-align: center">${c.title}</p></a>
                                <span>Uploader:<a href="profile?user=${c.uploader}">${c.uploader}</a></span>&nbsp;&nbsp;&nbsp;
                                <span>Update: ${c.timeCreate}</span><br>
                                Categories:<c:forEach items="${c.categories}" var="ca">
                                    <a href="search?category=${ca}"><span>${ca}</span></a>&nbsp;
                            </c:forEach>
                                Description:<p>${c.description}</p>
                        </div>
                    </div>
                    </c:forEach>
                        
                       
                 <nav aria-label="..." id="paging">
            <ul class="pagination">
            <li class="page-item disabled">
                <c:forEach begin="${1}" end="${requestScope.numpage}" var="i">
                <li class="page-item ${i==page?"active":""}"><a class="page-link" href="search?category=${cate}&page=${i}">${i}</a></li> 
                </c:forEach>
            </ul>
            </li>
        </nav> 
            </c:when>
            <c:otherwise>
                <h1>Can't find what you looking for...</h1>
            </c:otherwise>
                
        </c:choose>
        

                

        
    </body>
</html>
