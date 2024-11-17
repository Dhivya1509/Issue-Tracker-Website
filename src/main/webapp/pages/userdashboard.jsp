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

</head>
<body>
<jsp:include page="usernavbar.jsp"/>
<% 
String username=null;
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imdyingdb?" + "user=root&password=systemroot");    
PreparedStatement st = conn.prepareStatement("Select firstName,lastName from loggedUser order by id desc limit 1");
ResultSet rs = st.executeQuery();
if(rs.next()){
username=rs.getString(1)+" " +rs.getString(2);
}

%>
<a><center>Welcome <% out.println(username); %>!!! You Have Logged in.</center></a>

<div class="container">
<h3>Notifications</h3>

 

<table class="table table-striped">
                    <tr>
                        <th>Id</th>
                        <th>Created</th>
                        <th>Ticket title</th>
                        <th>Ticket creator</th>
                        <th>Ticket holder</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="ticket" items="${tickets}">
                        <tr>
                            <td> ${ticket.ticketId} </td>
                            <td> Date: ${ticket.createDate.toLocalDate()}<br></td>
                            <td> ${ticket.title} </td>
                            <td> ${ticket.createrName} </td>
                            <td> ${ticket.holderName}</td>
                            <td>${ticket.status}</td>
<%--                             <td> ${ticket.active}</td> --%>
                            <td><button type="button" class="btn btn-primary"
                                 onclick="location.href='/viewticket/${ticket.ticketId}';">View Ticket</button>
                            </td>
                            
                        </tr>
                    </c:forEach>
 </table>
 </div>
<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>