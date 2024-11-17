<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.sql.*"%>
<html>
<head>
<title>Set now category</title>
<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

<script type="text/javascript">
function alertName(){
alert("Mapped to different category");
} 

</head>
<body>
<jsp:include page="categoryRepnavbar.jsp"/>

 <div class="container">
<h3>Add Ticket</h3>
<strong>Fields with (*) is required</strong>

 <form:form action="/repmapticket" onSubmit="alertName()" modelAttribute="ticketAttribute" method="POST">
<form:hidden path="ticketId" />
<table class="table table-striped">
<tbody>
<tr>
<td><label>Issue (*):</label></td>

<td>
<%try {
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imdyingdb?" + "user=root&password=systemroot");
	PreparedStatement st = conn.prepareStatement("Select * from category");
	ResultSet rs;
	rs = st.executeQuery();%>
<select path="title" name="title" id="title">
<%while (rs.next()) {%>
<option><%=rs.getString(2)%></option>
<%}%>
</td>
<%} catch (Exception e) {
out.println("wrong entry" + e);
}%>
<form:errors path="title" cssClass="text-danger"/>
</tr>
</tbody>
</table>
<button type="submit" class="btn btn-success">Save</button>

 </form:form>

 <div>
<a class="btn btn-secondary" href="<c:url value='/replistissues' />">Back to Tickets List</a>
</div>

 </div>

 <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>