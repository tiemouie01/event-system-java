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
<h1>Edit Event</h1>
<form method="post" action="${pageContext.request.contextPath}/admin/events/edit">
    <%
        Event event = (Event) request.getAttribute("event");
    %>
    <input type="hidden" name="id" value="<%= event.getId() %>" />

    <label for="title">Title</label>
    <input type="text" id="title" name="title" value=<%= event.getTitle() %> required>

    <label for="description">Description</label>
    <input type="text" id="description" name="description" value=<%= event.getDescription() %>  required>

    <label for="date">Date</label>
    <input type="date" id="date" name="date" value=<%= event.getDate() %> required>

    <label for="location">Location</label>
    <input type="text" id="location" name="location" value=<%= event.getLocation() %> required>

    <label for="available_seats">Available Seats</label>
    <input type="number" id="available_seats" name="available_seats" value=<%= event.getAvailableSeats() %> required>

    <button type="submit">Save</button>
</form>
</body>
</html>
