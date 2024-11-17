<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.itextpdf.kernel.pdf.PdfDocument"%> 
<%@ page import="com.itextpdf.kernel.pdf.PdfWriter"%>
<%@ page import="com.itextpdf.layout.Document" %>
<html>
<head>
<title>Report</title>
<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

<script type="text/javascript">
function alertName(){
alert("Report Prepared Successfully");
} 
</script> 


</head>
<body>
	<jsp:include page="adminnavbar.jsp" />

	<div class="container">
		<h3>Report</h3>
		<strong>Fields with (*) is required</strong>

		<form:form action="/report" method="POST" modelAttribute="ticket" onSubmit="alertName()">
			<table class="table table-striped">
				<tbody>
					<tr>
						<td><label>Select Category (*):</label></td>

						<td>
							<%
							try {
								//String cat=String.valueOf(request.getAttribute("cat"));
								Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imdyingdb?" + "user=root&password=systemroot");
								PreparedStatement st = conn.prepareStatement("Select categoryName from category");
								ResultSet rs;
								rs = st.executeQuery();
							%> <form:select path="title" id="title">
								<%
								while (rs.next()) {
								%>
								<form:option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></form:option>
								<%
								}
								%>
							</form:select> 
						</td>
						<%
						} catch (Exception e) {
						}
						%>
						</tr>
<!-- 						<tr> -->
<!-- 						<td>Select type of report:</td> -->
<!-- 						<td> -->
<!-- 						<select id="type"> -->
<!-- 							<option value="Date wise">Date wise</option> -->
<!-- 							<option value="weekly">Weekly</option> -->
<!-- 							<option value="monthly">Monthly</option> -->
<!-- 						</select></td> -->


<!-- 					</tr> -->
					
					<tr>
						<td><label>Select Date</label></td>
						<td><form:input type="date" path="createDate" id="date" class="form-control" autofocus="true" required="true" /></td> 
					</tr>
				



				</tbody>
			</table>
			<button type="submit" class="btn btn-success">Save</button>

		</form:form>

		
	</div>

	<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>