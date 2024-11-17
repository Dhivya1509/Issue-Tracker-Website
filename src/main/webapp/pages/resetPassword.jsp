<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Create an account</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">


</head>

<body>

	<div class="container">

		<form:form method="POST"  class="form-signin"  modelAttribute="user" >
			 <h2 class="form-heading"style="color:white"><center>Reset Password</center></h2>
<br><br>
			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="email" path="email" class="form-control" name="email" id="email"
						placeholder="Email" autofocus="true" required="true"></form:input>
					<form:errors path="email"></form:errors>
				</div>
			</spring:bind>

			
			<spring:bind path="q1">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="q1" class="form-control"
						id="q1" placeholder="What is your nickname?" required="true"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>
			
			<spring:bind path="q2">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="q2" class="form-control"
						id="q2" placeholder="What is your birth city?" required="true"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>
			
			<spring:bind path="q3">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="q3" class="form-control"
						id="q3" placeholder="What is your favourite color?" required="true"></form:input>
					<form:errors path="q3"></form:errors>
				</div>
			</spring:bind>
			
			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						id="password" placeholder="New Password" required="true"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>

			<button class="btn btn-lg btn-primary btn-block" type="submit" >Submit</button>
		</form:form>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>