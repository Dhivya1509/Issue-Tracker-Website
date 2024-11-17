<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.sql.*"%>
<html>
<head>
<title>Update Status</title>
<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<script type="text/javascript">
function alertName(){
alert("Added your Category Successfully");
} 
</head>
<body>
<jsp:include page="adminnavbar.jsp" />

 <div class="container">
<h3>Select Holder</h3>
<strong>Fields with (*) is required</strong>
<form:form action="/repSetCat" method="POST" onSubmit="alertName" modelAttribute="catAttribute">
<table class="table table-striped">
<tbody>
<tr>
<td><label>Select Category (*):</label></td>

 <td>
<%
try {
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imdyingdb?" + "user=root&password=systemroot");
PreparedStatement st = conn.prepareStatement("select categoryName from category");
ResultSet rs;
rs = st.executeQuery();
%> <form:select path="repCategory" id="catName">
<%
while (rs.next()) {
%>
<form:option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></form:option>
<%}%>
</form:select>
</td>
<%} catch (Exception e) {

}%>
</tr>
<form:hidden value="${document.getElementById('catName')}" path="repCategory"/>
</tbody>
</table>
<button type="submit" class="btn btn-success">Save</button>

 </form:form>

 <div>
<a class="btn btn-secondary" href="<c:url value="/tickets" />">Back
to Tickets List</a>
</div>

 </div>

 <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>