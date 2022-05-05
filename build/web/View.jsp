<%-- 
    Document   : View
    Created on : Feb 20, 2022, 4:44:11 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${name}</title>
    </head>
    <body>
        <div>
            <embed src="${path}" type="application/pdf" style="position:fixed; top:0; left:0; bottom:0; right:0; width:100%; height:100%; border:none; margin:0; padding:0; overflow:hidden; z-index:999999;"/>
        </div>
    </body>
</html>
