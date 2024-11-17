<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 

<%@ page import ="java.sql.*" %>

 

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Dashboard</title>


      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<title>DashBoard</title>
</head>
<body>
<jsp:include page="adminnavbar.jsp"/>
<% 
String username=null;
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imdyingdb?" + "user=root&password=systemroot");    
PreparedStatement st = conn.prepareStatement("Select firstName,lastName from loggedUser order by id desc limit 1");
ResultSet rs = st.executeQuery();
if(rs.next()){
username=rs.getString(1)+" " +rs.getString(2);
}

%>
<a><center>Welcome <% out.println(username); %>Admin!!! You Have Logged in.</center></a>
<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>