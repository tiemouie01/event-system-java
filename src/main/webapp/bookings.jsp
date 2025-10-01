<%@ page import="com.event.model.Event" %>
<%@ page import="java.util.List" %>
<%@ page import="com.event.model.Booking" %><%--
  Created by IntelliJ IDEA.
  User: timothymiamba
  Date: 9/10/25
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bookings</title>
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
            List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
            System.out.println(bookings);
            if (bookings == null || bookings.isEmpty()) {
        %>
        <p class="empty">No bookings available.</p>
        <%
        } else {
        %>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Booking Date</th>
                <th>Number of Tickets</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Booking booking : bookings) {
            %>
            <tr>
                <td><%= booking.getId() %></td>
                <td><%= booking.getBookingDate() %></td>
                <td><%= booking.getNumberOfTickets() %></td>

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
