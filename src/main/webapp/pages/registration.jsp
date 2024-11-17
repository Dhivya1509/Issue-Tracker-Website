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


<script type="text/javascript">
function alertName(){
alert("Registered Successfully");
} 
</script> 
</head>

<body>

	<div class="container">
<h2 class="form-signin-heading" style="color:white"><center>Create your Account</center></h2>
		<form:form method="POST" onSubmit="alertName()" class="form-signin"  modelAttribute="userForm" >
			<h2 class="form-signin-heading">Create your account</h2>

			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="email" path="email" class="form-control" name="email" id="email"
						placeholder="Email" autofocus="true" required="true"></form:input>
					<form:errors path="email"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="firstName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="firstName" class="form-control"
						placeholder="First Name" autofocus="true" required="true"></form:input>
					<form:errors path="firstName"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="lastName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="lastName" class="form-control"
						placeholder="Last Name" autofocus="true" required="true"></form:input>
					<form:errors path="lastName"></form:errors>
				</div>
			</spring:bind>



			<spring:bind path="dob">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="date" path="dob" class="form-control"
						placeholder="Date of Birth" autofocus="true" required="true"></form:input>
					<form:errors path="dob"></form:errors>
				</div>
			</spring:bind>



			<spring:bind path="gender">
				<div class="form-group" required="true">
					<label for="gender" class="control-label">Select Gender</label>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="gender" name="gender"
							class="custom-control-input" value="female"> <label
							class="custom-control-label" for="gender">Female</label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="gender" name="gender"
							class="custom-control-input" value="male"> <label
							class="custom-control-label" for="gender">Male</label>
					</div>
				</div>
			</spring:bind>


			<spring:bind path="category">
				<div class="form-group" required="true">
					<label for="category" class="control-label">Select Category</label>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="category" name="category"
							class="custom-control-input" value="User"> <label
							class="custom-control-label" for="category">User</label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="category" name="category"
							class="custom-control-input" value="Category Rep"> <label
							class="custom-control-label" for="category">Category
							Representative</label>
					</div>
				</div>
			</spring:bind>



			<spring:bind path="contactNo">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="contactNo" class="form-control"
						id="contactNo" placeholder="Contact Number" autofocus="true" pattern="[0-9]{3}[0-9]{3}[0-9]{4}"
						required="true"></form:input>
					<form:errors path="contactNo"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						id="password" placeholder="Password" required="true"></form:input>
					<form:errors path="password"></form:errors>
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

			<button class="btn btn-lg btn-primary btn-block" type="submit" >Submit</button>
		</form:form>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>