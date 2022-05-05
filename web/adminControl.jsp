<%-- 
    Document   : adminControl
    Created on : Mar 15, 2022, 8:45:45 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <jsp:include page="adminHeader.jsp"/>
    </head>
    <body>
        

        <h1>Hello Admin!</h1>	
        <div style="position:relative">   
          <div class="col-md-2 stat">
            <h3>Total user</h3>
            <h4>${user}</h4>
            <i class="f">+0 this week</i>
          </div>
          <div class="col-md-2 stat">
            <h3>Total Book</h3>
            <h4>${book}</h4>
             <i class="f">+1 this week</i>
          </div>
          <div class="col-md-2 stat">
            <h3>Total view count</h3>
            <h4>${requestScope.viewed}</h4>
            <i class="f">+1 this week</i>
          </div>
        </div>
    </body>
    
</html>
