<%--
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
    </style>
</head>
<body>
<div class="container">
    <%
        String username = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");
        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        if (role == null || !role.equals("ADMIN")) {
            response.sendRedirect("home.jsp");
            return;
        }
    %>
    <h1>Welcome, Admin</h1>
    <p>You have administrative access.</p>
    <a class="btn" href="${pageContext.request.contextPath}/index.jsp">Back to Home</a>
    <a class="btn" href="${pageContext.request.contextPath}/createBook.jsp">Create Book</a>
    <a class="btn" href="${pageContext.request.contextPath}/createBook.jsp">Edit Book</a>
    <a class="btn" href="/BookStore/books">View Books</a>
    <a class="btn" href="${pageContext.request.contextPath}/logout">Logout</a>
</div>
</body>
</html>
