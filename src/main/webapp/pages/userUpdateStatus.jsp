<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import ="java.sql.*" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Status<c:out value="${ticket.ticketId}"/></title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
      
      <script type="text/javascript">
function alertName(){
alert("Status Updated Successfully");
} 

</head>
<body>
<jsp:include page="usernavbar.jsp"/>
<br>
	<div class="container">
	<h3>Update Status</h3><br>
    <strong>Fields with (*) is required</strong>

	<form:form action="/usereditsave" onSubmit="alertName" modelAttribute="statusAttribute" method="POST">
    			<form:hidden path="ticketId" />
    			<table class="table table-striped">
    			<br>
    				<tbody>
    					<tr>
    						<td><label>Update Ticket Status (*):</label></td>
    						<td><select name="status"  >
    						<option>Close</option>
    						<option>reopen</option></select></td>	
    					</tr>
                        
    				</tbody>
    			</table>
    			<button type="submit" class="btn btn-success">Save</button>

    		</form:form>

            <div>
<%--             <a class="btn btn-secondary" href="<c:url value="/tickets"/>">Back to Tickets List</a> --%>
             <a class="btn btn-secondary" href="<c:url value="/tickets "/>">Back to Tickets List</a>
            </div>

    </div>

	<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>