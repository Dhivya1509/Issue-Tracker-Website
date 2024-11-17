<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 

<html>
<head>
 <title>Index</title>
   <link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
   <link rel="stylesheet"
               href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark d-none d-lg-block" style="z-index: 2000;">
   
     <div class="container-fluid">
        <!-- Navbar brand -->
        
        <button class="navbar-toggler" type="button" data-mdb-toggle="collapse" data-mdb-target="#navbarExample01"
          aria-controls="navbarExample01" aria-expanded="false" aria-label="Toggle navigation">
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarExample01">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            
            <li class="nav-item-active"><div>
   <button  class="btn btn-outline-light btn-lg m-2"><a class="nav-link" href="<c:url value="/login"/>" >
              <h6>Login</h6></a></button> </div>
            </li>
            <br><br><br><br>
            <br>
            <li class="nav-item-active"><div>
                 <button class="btn btn-outline-light btn-lg m-2">
                 <a class="nav-link" href="${contextPath}/registration"><h6>New User? Create an account</h6></a></button>
          </div>  </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- Navbar -->

 

    <!-- Background image -->
    <div id="intro" class="bg-image shadow-2-strong">
      <div class="mask" style="background: linear-gradient(to right,  rgba(106, 133, 182, 0.8), rgba(186, 200, 224, 0.8));">
        <div class="container d-flex align-items-center justify-content-center text-center h-100">
          <div class="text-color-midnight blue">
          <h1 class="h1-responsive font-weight-bold wow fadeInLeft"  style="color:navy" >Welcome to Lee Bugzz</h1>
           </div>
            </div>
            </div>
            </div>
           <div class="container">
      <!--Section: Content-->
      <section>
        <div class="row">
          <div class="col-md-6 gx-5 mb-4">
            <div class="bg-image hover-overlay ripple shadow-2-strong rounded-5" data-mdb-ripple-color="light">
              <img src="https://mail.google.com/mail/u/0?ui=2&ik=b7c421875b&attid=0.1&permmsgid=msg-a:r-265563734129940041&th=17b621511952bc6a&view=att&disp=safe&realattid=17b5f8692ff7b66d5b41" class="img-fluid" />
              <a href="#!">
                <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
              </a>
            </div>
          </div>
        <br><br><br>
        
        
          <div class="col-md-6 gx-5  mt-5 " style="color:navy">
            <h4><strong>A Complete Spot to Find Solution....</strong></h4>
            <p class="text">
              Lee Bugzz is Issue Tracker Platform where as a User you can 
              Raise a ticket to solve you Issues that can be based on Hardware , Software or any other issues
              related to technologies.
              This plateform provides you with the complete Solution for your Issues.
            </p>
            <hr class="my-5" />
            
            <h4><strong>Instructions for the User....</strong></h4>
            <p class="text">
             If you are a New User to this platform , please to Register for Login.
             While Register please do Fill all the Appropriate fields.
             Or an Existing User please do Login and further you can proceed with your Tickets.
            </p></div>
           
        
        </div>
      </section>
          

 

</body>
</html>