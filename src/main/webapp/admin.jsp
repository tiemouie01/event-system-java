<%@ page import="com.event.model.Event" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: timothymiamba
  Date: 9/10/25
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; background: #f7f7f7; }
        .container { max-width: 700px; margin: 80px auto; background: #fff; padding: 28px; border: 1px solid #e5e5e5; border-radius: 8px; }
        h1 { font-size: 22px; margin: 0 0 8px; }
        p { color: #555; }
        a.btn { display: inline-block; margin-top: 12px; padding: 10px 14px; background: #16a34a; color: #fff; border-radius: 6px; text-decoration: none; }

        .jumbotron {
            margin-top: 1.5rem;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome, Admin</h1>
    <p>You have administrative access.</p>
    <a class="btn" href="${pageContext.request.contextPath}/index.jsp">Back to Home</a>
    <a class="btn" href="${pageContext.request.contextPath}/admin/events/create">Create Event</a>
    <a class="btn" href="${pageContext.request.contextPath}/logout">Logout</a>

    <div class="jumbotron">
        <h1>Available Events</h1>

        <%
            List<Event> events = (List<Event>) request.getAttribute("events");
            System.out.println(events);
            if (events == null || events.isEmpty()) {
        %>
        <p class="empty">No events available.</p>
        <%
        } else {
        %>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Location</th>
                <th>Available Seats</th>
                <th>Date</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Event event : events) {
            %>
            <tr>
                <td><%= event.getId() %></td>
                <td><%= event.getTitle() %></td>
                <td><%= event.getDescription() %></td>
                <td><%= event.getLocation() %></td>
                <td><%= event.getAvailableSeats() %></td>
                <td><%= event.getDate() %></td>
                <td><button>Edit</button></td>
                <td><button>Delete</button></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <%
            }
        %>
    </div>
</div>
</body>
</html>
