<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Add Category</title>
<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
<jsp:include page="adminnavbar.jsp"/>

 <div class="container">
<h3>Add Category</h3>
<strong>Fields with (*) is required</strong>

 <form:form action="adminCategoryAdd" modelAttribute="categoryAttribute" method="POST">
<form:hidden path="categoryId" />
<table class="table table-striped">
<tbody>
<tr>
<td><label>Category title (*):</label></td>
<td><form:input path="categoryName" /></td>
<form:errors path="categoryName" cssClass="text-danger"/>
</tr>
</tbody>
</table>
<button type="submit" class="btn btn-success">Save</button>

 </form:form>

 <div>
<a class="btn btn-secondary" href="<c:url value="/categories" />">Back to Categories List</a>
</div>

 </div>

 <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>