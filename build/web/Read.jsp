<%-- 
    Document   : Read
    Created on : Feb 15, 2022, 2:00:45 PM
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        
        <c:set var="b" value="${record}"></c:set>
        <title>Read ${b.title}</title>
    </head>
    <body>
     <jsp:include page="header.jsp"/>
     <jsp:include page="left.jsp"/> 
     <c:if test="${r=='y'}">
             <h4 style="color: red">Your report has been sent</h4>
     </c:if>
     <div class="main">
        
        <form action="read" method="post" target="_blank">
        
            <div class="col-4 img">
                <img class="i" src="image/${b.image}"/>
            </div>
                    <div class="col-7 detail"> 
                       <h1 style="text-align:center; font-weight:bold" >${b.title}</h1>
                       <span>Uploader:<a href="profile?user=${b.uploader}"> ${b.uploader}</a></span> &nbsp;&nbsp;&nbsp;
                        <span>Update: ${b.timeCreate}</span> <br>
                        <p>Categories: <c:forEach items="${b.categories}" var="c">
                                <a href="search?category=${c}"><span>${c}</span></a>&nbsp;
                        </c:forEach>
                           
                        </p>
                        <p>View:${b.viewed}</p>
                        
                        <input type="text" name ="path" value="${b.detail}" hidden/>
                        <input type="text" name ="id" value="${b.id}" hidden/>
                        <input type="text" name="name" value="${b.title}" hidden/>
                    </div> 
                    </div>
                        <div class="des">            
                            <p>Description:${b.description}</p> 
                            <input type="submit" value="Read"/>
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">Report this book</button>
                        </div>
        </form>
                       
                        <br>
                        <c:if test="${user==b.uploader}">
                            <a href="manage?id=${b.id}">Manage</a> 
                          
                        </c:if>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br><br>
                        <br>
                        <br>
                        <br>
                        <br>
                       
                        <p>Comment:</p>
                        <div>
                            <form action="comment" method="post">
                                <input type="text" name="id" value="${b.id}" hidden/>
                                  <textarea name="comment" rows="2" cols="100" tabindex="40" 
                                            placeholder="${user==null?"You need to login to comment":"Write your comment here(255)"}" maxlength="255" required></textarea><br>
                                   <c:if test="${empty user}">
                                       <button><a href="login?position=read?id=${b.id}">Login</a></button>
                                   </c:if>
                                       <input type="submit" value="Post" ${user==null?"disabled":""}/>
                            </form>
                        </div>
                                      
                        <c:forEach items="${comment}" var= "c">
                            <c:if test="${c.id!=requestScope.spam}">
                            <div style="border: 1px solid">
                                <span>${c.user}</span> &nbsp;&nbsp;&nbsp;
                                <span>${c.timeCreate}</span><br>
                                <p>${c.detail}</p>
                               
                                <c:if test="${user==c.user}">
                                    <a href="comment?c=${c.id}">Delete<i class="fas-fa-edit" style="font-size: 32px"></i></a>
                                </c:if>
                                    <form action="comment" method="post">
                                        <input type="checkbox" name="like" value="like" onchange="this.form.submit()" />${c.like}
                                        <input type="text" name="id" value="${c.id}" hidden/>
                                    </form>
                                     <a style="text-align: right" href="report?id=${c.id}">Mark as inapproriate</a>
                            </div>
                            </c:if>
                        </c:forEach>
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Report</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <form action="report" method="post">
      <div class="modal-body">
          
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Book:</label>
            <input type="text" class="form-control" id="recipient-name" value="${b.title}" readonly>
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Reason:</label>
            <textarea class="form-control" id="message-text" name="reason" required></textarea>
          </div>
       
      </div>
      <div class="modal-footer">
          
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Send message</button>
      </div>
            <input type="text" name="id" value="${b.id}" hidden/>
     </form>
    </div>
  </div>
</div>
                
    </body>
</html>
