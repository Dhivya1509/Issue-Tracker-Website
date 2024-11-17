<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
   <title>Users list</title>
   <link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body><nav class="navbar navbar-expand-lg navbar-light shadow-5-strong">
          <span class="navbar-brand ">
        <img src= "https://mail.google.com/mail/u/0?ui=2&ik=b7c421875b&attid=0.1&permmsgid=msg-a:r-265563734129940041&th=17b621511952bc6a&view=att&disp=safe&realattid=17b5f8692ff7b66d5b41" height=200 width=200>
        
        </span>


        <div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
          <ul class="nav justify-content-center nav-tabs">
          <li><h4>			</h4>         </li><li/>
            <li class="nav-item ">
              <a class="nav-link"  href="<c:url value="/userdashboard"/>"><h4>Home</h4></a>
            </li>
            
            <li class="nav-item">
              <a class="nav-link" href="<c:url value="/tickets"/>"><h4>Help</h4></a>
            </li>
                        <li class="nav-item">
              <a class="nav-link" href="<c:url value="/contact"/>"><h4>Contact US</h4></a>
            </li>
            </ul>
            </div>
           
            <div class="collapse navbar-collapse justify-content-center">
            <c:url value="/logout" var="logoutUrl"/>
            <form:form class="form-inline my-2 my-lg-0" action="${logoutUrl}" method="POST" enctype="multipart/form-data">
                <span class="navbar-text mr-sm-2">${pageContext.request.userPrincipal.name}</span>
            <button type="Logout" class="btn btn-info">Log out</button>
            </form:form>
        </div>
      </nav>

	<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>