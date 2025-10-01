<%@ page import="com.event.model.Event" %><%--
  Created by IntelliJ IDEA.
  User: timothymiamba
  Date: 9/10/25
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Event</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 24px; }
        h1 { font-size: 20px; margin-bottom: 16px; }
        form { max-width: 360px; }
        label { display: block; margin: 8px 0 4px; font-size: 14px; }
        input { width: 100%; padding: 8px; box-sizing: border-box; }
        button { margin-top: 12px; padding: 8px 12px; cursor: pointer; }
    </style>
</head>
<body>
<h1>Create Booking</h1>
<form method="post" action="${pageContext.request.contextPath}/events/book">
    <%
        Event event = (Event) request.getAttribute("event");
    %>
    <input type="hidden" name="eventId" value="<%= event.getId() %>">

    <label for="number_of_tickets">Number of Tickets</label>
    <input type="number" id="number_of_tickets" name="number_of_tickets" required>

    <button type="submit">Save</button>
</form>
</body>
</html>
