<%-- 
    Document   : Manage
    Created on : Mar 8, 2022, 2:42:42 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage</title>
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
            function doDelete(id){
                if(confirm("Are you sure to delete this book:${book.title}?")){
                    window.location="manage?id="+id+"&a=book";
                }
            }
        </script>
    </head>
    <body>
        <h1>Manage your book:</h1>
        <div class="form-group upload">
        <form action="manage" method="post"  enctype="multipart/form-data">
            Title:<input type="text" class="form-control" name="title" value="${book.title}" required/><br>
            Uploader:<input type="text" class="form-control" name="uploader" value="${book.uploader}" readonly/><br>
            Categories:<input type="text" class="form-control" name="category" value="${categories}"/><br>
            Description:<br><textarea class="form-control" name="description" rows="4" cols="50" tabindex="40" 
                                      maxlength="255" value="${book.description}" placeholder="Write a short description of your work...(255)">${book.description}</textarea><br>
                       <div>
                        <img src="image/${book.image}" style="width: 60%"/>                         
                        </div>
                        Change book cover:<input type="checkbox" id="cover" name="update" onchange="upload()" value="update"/><br>
                                 <div id="change" style="display:none">
					
  					<input type="file" id="new" name="image" accept="image/png, image/gif, image/jpeg"><br><br>
				</div>
            <input type="text" name="id" value="${book.id}" hidden/>
            <input type="text" name ="cover" value="${book.image}" hidden/>
            <input type="submit" value="Update"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <a href="#" onclick="doDelete('${book.id}')" >Delete</a>
        </form>
        </div>
    </body>
</html>