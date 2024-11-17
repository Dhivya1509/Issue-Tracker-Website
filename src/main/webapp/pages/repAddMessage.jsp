<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Add Message</title>
<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

<script type="text/javascript">
function alertName(){
alert("Issue Description Added Successfully");
} 

</head>
<body>
<jsp:include page="categoryRepnavbar.jsp"/>
<br>
<div class="container">
<h2>Add Description</h2>
<strong>Fields with (*) is required</strong>

<form:form action="repaddMessage" modelAttribute="messageAttribute" onSubmit="alertName()" method="POST">
<form:hidden path="ticketId" value="${param.ticketId}"/>
<form:hidden path="authorName" value="${param.authorName}"/>
<%-- <form:hidden path="holderName" value="${param.holderName}"/> --%>
<br>
<form:hidden path="createDate" />
<table class="table">
<tbody>


<tr>
<td><label>Issue Description(*):</label></td>
<td><form:input path="text" /></td>
<form:errors path="text" cssClass="error"/>
</tr>
</tbody>
</table>

 <button type="submit" class="btn btn-success">Save</button>

 </form:form>

 <div>
<a class="btn btn-secondary" href="<c:url value="/replistissues" />">Back to Tickets List</a>
</div>

 </div>

 <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>