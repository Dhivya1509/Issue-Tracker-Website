<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import ="java.sql.*" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Contact Us<c:out value="${ticket.ticketId}"/></title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
<jsp:include page="usernavbar.jsp"/>
<center>
<br><br>
<div class="container">
<label><h3>Contact Details:</h3></label>
	<table class="table table-striped">
	<tr>
					
    				    <th><center>Email</center></th>
    					<th><center>Contact No</center></th>
    </tr>
    
    
    					<tr>
    					
    					    <td><center>admin@gmail.com</center> </td>
    						<td><center>7598691746</center></td>
    						</tr>
    						
	
	</table>
	</div>
</center>
</body>
</html>