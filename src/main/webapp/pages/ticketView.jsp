<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
  <head>
  <title>Ticket id <c:out value="${ticket.ticketId}"/></title>
<link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>
<jsp:include page="usernavbar.jsp"/>
    <div class ="container">
		<h3>Ticket info</h3>
            <table class="table table-striped table-dark">
            	<tr>
            	    <th>Id</th>
            		<th>Created</th>
            		<th>Ticket title</th>
            		<th>Ticket creater</th>
            		<th>Ticket holder</th>      		
            		<th></th>
            	</tr>
                <tr>
                    <th> ${ticket.ticketId} </th>
                    <th> Date: ${ticket.createDate.toLocalDate()}<br> </th>
                    <th> ${ticket.title} </th>
                    <th> ${ticket.createrName} </th>
                    <th> ${ticket.holderName} </th>
                    <th>
                        <a class="btn btn-secondary" href="<c:url value="/tickets"/>">Back to Tickets List</a>
                    </th>
    			</tr>

            </table>
<h3>History</h3>
<table class="table table-bordered table-striped">

 <tr>
<th>Id</th>
<th>Created On</th>
<th>Created By</th>
<th>Issue Description</th>
</tr>

 <c:forEach var="message" items="${messages}">
<tr>
<td> ${message.messageId} </td>
<td> Date: ${message.createDate.toLocalDate()}</td>
<td>${message.authorName} </td>
<td> ${message.text} </td>
</tr>
</c:forEach>

 </table>
            
<!--         <h3>Messages</h3> -->
<!--     	<table class="table table-bordered table-striped"> -->

<!--     	    <tr> -->
<!--     			<th>Id</th> -->
<!--     		    <th>Created</th> -->
<!--     		    <th>Message author</th> -->
<!--     		    <th>Message recipient</th> -->
<!--     		    <th>Text</th> -->
<!--     		    <th>Updated</th> -->
<!--     		    <th>Action</th> -->
<!--     	    </tr> -->

<%-- <%--     		<c:forEach var="message" items="${ticket.getMessages()}"> --%>
<%--     		<tr> --%>
<%--     		    <td> ${message.messageId} </td> --%>
<%--     		    <td> Date: ${message.createDate.toLocalDate()}<br> --%>
<%--     		    Time: ${message.createDate.toLocalTime().withNano(0)} </td> --%>
<%--     		    <td> ${message.firstName} ${message.author.lastName} </td> --%>
<%--     		    <td> ${message.recipient.firstName} ${message.recipient.lastName} </td> --%>
<%--     		    <td> ${message.text} </td> --%>
<%--     		    <td> Date: ${message.updateDate.toLocalDate()}<br> --%>
<%--     		    Time: ${message.updateDate.toLocalTime().withNano(0)}  </td> --%>
<%--                 <td><button type="button" class="btn btn-primary" --%>
<%--                      onclick="location.href='/tickets/editMessageForm?ticketId=${message.ticket.ticketId}&messageId=${message.messageId}'"> --%>
<%--                      Edit message</button> --%>
<%--                 </td> --%>
<%--     		</tr> --%>
<%--     		</c:forEach> --%>
    		

<!--     	</table> -->


    	<div>
			<button type="button" class="btn btn-success"
 			onclick="location.href=' <c:url value="/addMessage?ticketId=${ticket.ticketId}&authorId=${ticket.createrName}'"/>"> 
			Add Message</button>
        </div>
        <br>
        <div>
            <button type="button" class="btn btn-success"
            onclick="location.href='/usereditticket/${ticket.ticketId }';">
            Update Status</button>
        </div>
        
        

    </div>

    <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</body>
</html>