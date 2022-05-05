<%-- 
    Document   : Upload
    Created on : Feb 22, 2022, 9:36:14 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload</title>
        <script type="text/javascript">
             function upload(){
                if(document.getElementById('cover').checked){
                    document.getElementById('change').style.display="inline";
                    document.getElementById('new').setAttribute('required', true);
                }
                else{
                document.getElementById('change').style.display="none";
                document.getElementById('new').removeAttribute('required');
                }
            }
        </script>
    </head>
    <body>
    
      <div class="form-group upload">
        <form action="upload" method="post" enctype="multipart/form-data">
            Upload by:<input class="form-control-plaintext" type="text" name="uploader" value="${user}" readonly/><br><br>
            Title:<input class="form-control" type="text" name="title" placeholder="add a descritive title" required/><br><br>
            Category:<input class="form-control" type="text" name="categories" placeholder="i.e novel, myth..."/><br><br>
            Description:<br><textarea class="form-control" name="description" placeholder="a short description to your work(255)" maxlength="255" rows="5" cols="50"></textarea><br><br>
            Your pdf/word file:
            <input type="file" name="file" accept="application/pdf,application/msword" required/><br><br>
            <p>Your book cover default will be like this:</p>
            <img src="image/default.png"/><br>
            Add Book Cover:<input type="checkbox" id="cover" name="update" onchange="upload()"/><br>
                                 <div id="change" style="display:none">
  					<input type="file" id="new" name="image" accept="image/png, image/gif, image/jpeg"><br><br>
				</div>
            <input type="submit" value="Upload"/>
            
        </form>
      </div>
    </body>
</html>
