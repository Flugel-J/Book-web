<%-- 
    Document   : Profile
    Created on : Mar 7, 2022, 4:06:48 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"/>
    <head>
        
        
        <title>Profile</title>
    </head>
    <body>
 
      
            <div class="container">
        <div class="row">
		<div class="col-12">
			<!-- Page title -->
			<div class="my-5">
				<h3>${r=="readonly"? "":"My"} Profile</h3>
				<hr>
			</div>
			<!-- Form START -->
			  <form action="profile" method="post">
				<div class="row mb-5 gx-5">
					<!-- Contact detail -->
					<div class="col-xxl-8 mb-5 mb-xxl-0">
						<div class="bg-secondary-soft px-4 py-5 rounded">
							<div class="row g-3">
                                                            <h4 class="mb-4 mt-0">Contact detail</h4>
								<!-- First Name -->
								<div class="col-md-6">
									<label class="form-label">User</label>
                                                                        <input type="text" class="form-control" placeholder="" aria-label="Name" name="user" value="${profile.username}" readonly>
								</div>
                                                                <div class="col-md-6">
									<label class="form-label">Name</label>
                                                                        <input type="text" class="form-control" placeholder="" aria-label="Name" name="name" value="${profile.name}" ${r}>
								</div>
								
								<!--dob -->
								<div class="col-md-6">
									<label class="form-label">DOB:</label>
									<input type="date" class="form-control" placeholder="" aria-label="dob" name="dob" value="${profile.dob}" ${r}>
								</div>
								<!-- Email -->
								<div class="col-md-6">
									<label for="inputEmail4" class="form-label">Email</label>
									<input type="email" class="form-control" id="inputEmail4" name="email" value="${profile.email}" ${r}>
								</div>
                                                                <div class="col-md-6">
                                                                    <label class="form-label">Gender:</label>
									Male<input type="radio" name="gender"  value="0" ${profile.gender==true?"":"checked"} ${r=="readonly"?"disable":""}/>
                                                                        Female<input type="radio" name="gender" value="1" ${profile.gender==true?"checked":""} ${r}/>
								</div>
                                                                <div class="col-md-12">
									<label class="form-label">Intro</label>
									<br><textarea  name="intro" placeholder="add your intro(255)" maxlength="255" rows="5" cols="50"  ${r}>${profile.intro}</textarea><br><br>
								</div>
								
							</div> <!-- Row END -->
						</div>
					</div>
					<!-- Upload profile -->
					
				</div> <!-- Row END -->
                                <c:if test="${empty r}">
                                    <div class="gap-3 d-md-flex justify-content-md-end">
					
                                        <input type="submit" class="btn btn-primary btn-lg" value="Update profile">
				</div>
                          </c:if>
                                </form>
                          
				
				<!-- button -->
				
			<!-- Form END -->
		</div>
	</div>
            </div>
       
    </body>
</html>
