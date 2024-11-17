<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
<meta charset="utf-8">
<title>Categories</title>
<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>
<jsp:include page="adminnavbar.jsp"/>
<div class ="container">
<h3>Categories</h3>
<table class="table table-striped table-dark">
<tr>
<th>Id</th>
<th>Category Name</th>
<th>Action</th>
</tr>
<c:forEach var="category" items="${categories}">
<tr>
<th> ${category.categoryId} </th>
<th>${category.categoryName }</th>
<th>
<button type="button" class="btn btn-primary"
onclick="location.href='/deleteCategory/${category.categoryId}';">Delete</button>
</th>
</tr>
</c:forEach>
</table>
<div>
<button type="button" class="btn btn-success"
onclick="location.href='adminCategoryAdd'">
Add Category</button>
</div>

 </div>

 <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</body>
</html>