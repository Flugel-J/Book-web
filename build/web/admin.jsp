<%-- 
    Document   : admin
    Created on : Mar 15, 2022, 8:37:06 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin page</title>
    </head>
    <body>
        <h1 style="text-align: center">Who are you?</h1>
        <form action="admin" method="post" style="text-align: center">
            <input type="password" name="id"/>
            <input type="submit" value="identity"/>
        </form>
    </body>
</html>
