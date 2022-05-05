<%-- 
    Document   : Register
    Created on : Jan 26, 2022, 4:26:18 PM
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
       
       
       
        
      
<form action ="register" method="post">
 <section class="vh-100" style="background-color: #2875b2;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <h3 class="mb-5">Welcome new user</h3>
          
            <div class="form-outline mb-4">
              <input type="text" id="typeEmailX-2" class="form-control form-control-lg" name="user"  required/>
              <span style=color:red;">${error}</span><br>
              <label class="form-label" for="typeEmailX-2">Username</label>
            </div> 

            <div class="form-outline mb-4">
              <input type="password" id="typePasswordX-2" class="form-control form-control-lg" id="pass" name="pass" required/>
              <label class="form-label" for="typePasswordX-2">Password</label>
            

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

            <button class="btn btn-primary btn-lg btn-block" type="submit">Register</button>
            
         

           

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
        </form>
    </body>
</html>
