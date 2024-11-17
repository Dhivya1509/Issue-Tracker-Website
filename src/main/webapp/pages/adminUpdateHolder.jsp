<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import ="java.sql.*" %>
<html>
<head>
<title>Update Status</title>
<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
<jsp:include page="adminnavbar.jsp"/>

 <div class="container">
<h3>Select Holder</h3>
<strong>Fields with (*) is required</strong>

<%-- <form:form action="/updateholder" name="updateHolder" method="POST" modelAttribute="holderModel"> --%>
<form:form action="/updateholder" method="POST" modelAttribute="holderAttribute">
<table class="table table-striped">
<tbody>
<tr>
<td><label>Select Holder (*):</label></td>

<td>
<% try{
	String cat=String.valueOf(request.getAttribute("cat"));
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imdyingdb?" + "user=root&password=systemroot");
PreparedStatement st = conn.prepareStatement("Select firstName from user where category='Category Rep' and repCategory=?");
st.setString(1,cat);
ResultSet rs ;
rs= st.executeQuery();
%>
<form:select path="holderName" id="holder" >
<% while(rs.next()){ %>
<form:option value="<%= rs.getString(1) %>"><%= rs.getString(1) %></form:option>
<%} %>
</form:select>
<form:hidden path="holderName" value="${document.getElementById('holder')}" />
<form:hidden path="ticketId" value="${request.getParameter('ticketId')}" />
</td>
<%

}
catch(Exception e)
{
}
%>
</tr>
</tbody>
</table>
<button type="submit" class="btn btn-success">Save</button>

 </form:form>

 <div>
<a class="btn btn-secondary" href="<c:url value="/tickets" />">Back to Tickets List</a>
</div>

 </div>

 <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>