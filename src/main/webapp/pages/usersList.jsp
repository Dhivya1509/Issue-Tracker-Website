<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
   <title>Users list</title>
   <link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>
<jsp:include page="adminnavbar.jsp"/>

<br>
    <div class ="container">
    
                <h3>Users List</h3>
    			<table class="table table-striped">
    				<tr>
    				    <th>Id</th>
    					<th>First Name</th>
    					<th>Last Name</th>
    					<th>Email</th>
    					<th>Role</th>
    					<th>Action</th>
    				</tr>

    				<c:forEach var="user" items="${users}">
    					<tr>
    					    <td> ${user.userId} </td>
    						<td> ${user.firstName} </td>
    						<td> ${user.lastName} </td>
    						<td> ${user.email} </td>
    						<td>${user.category}</td>
    						<td><button type="button" class="btn btn-primary"
    						    onclick="location.href='/tickets/${user.firstName}'">
    						    Get Tickets</button>

    	                        <%--<button type="button" class="btn btn-warning"
                                 onclick="location.href='/users/edit?userId=${user.userId}'">
                                 Edit User</button>--%>
                            </td>
    					</tr>

    				</c:forEach>

    			</table>

    </div>

	<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>