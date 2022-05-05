<%-- 
    Document   : Login
    Created on : Jan 25, 2022, 3:41:10 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <jsp:include page="header.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book web login</title>
    </head>
    <body>
        
        

        <form action ="login" method="post">
           
               
        
                <section class="vh-100" style="background-color: #2875b2;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <h3 class="mb-5">Sign in</h3>
            <h4 style="color: red;">${error}</h4>
            <div class="form-outline mb-4">
              <input type="text" id="typeEmailX-2" class="form-control form-control-lg" name="user" value="${cookie.user.value}" required/>
              <label class="form-label" for="typeEmailX-2">Username</label>
            </div>

            <div class="form-outline mb-4">
              <input type="password" id="typePasswordX-2" class="form-control form-control-lg" name="pass" value="${cookie.pass.value}" required/>
              <label class="form-label" for="typePasswordX-2">Password</label>
            </div>

            <!-- Checkbox -->
            <div class="form-check d-flex justify-content-start mb-4">
              <input
                class="form-check-input"
                type="checkbox"
                name="rem"
                id="form1Example3" checked
              />
              <label class="form-check-label" for="form1Example3"> Remember password </label>
            </div>

            <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
            
            <a href="register">Create new account</a>
            <input type="text" name="position" value="${position}" hidden>
           

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
        </form>
    </body>
</html>
