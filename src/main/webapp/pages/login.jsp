<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import ="java.sql.*" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Log in with your account</title>

      <link rel="stylesheet"
               href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
      
  </head>

  <body >

     <div class="container">
      
      <form:form method="POST" class="form-signin" modelAttribute="signinForm" name="loginForm">
        <h2 class="form-heading"style="color:white"><center>Log in</center></h2>
        <br><br>
            <div class="form-group ">
                <input name="email" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
                   <br><br>
                <input name="password" type="password" class="form-control" placeholder="Password"/>
            </div>
            
                <div class="form-group">
                <div class="col-xs-15">
                    <div>
                        <!-- Check for login error -->
                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                <span>${error}</span>
                            </div>
                        </c:if>
                        <!-- Check for logout -->
                        <c:if test="${param.logout != null}">
                            <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                <span>${message}</span>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
           <br>
            <div class="form-group">
                <button type="submit" class="btn btn-outline-light btn-block">Log In</button>
                <br>
                
                <h4 class="text-center" ><a href="${contextPath}/registration" style="color:white">Create an account</a></h4>
             
                <h4 class="text-center" ><a href="${contextPath}/resetPassword" style="color:white">Forgot Password?</a></h4>
            </div>

      </form:form>
    </div>
</div>

 


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>