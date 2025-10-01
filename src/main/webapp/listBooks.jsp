<%--
  Created by IntelliJ IDEA.
  User: timothymiamba
  Date: 9/10/25
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bookstore.bookstore.model.Book" %>
<html>
<head>
    <title>Books</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 24px; }
        h1 { font-size: 20px; margin-bottom: 12px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background: #f5f5f5; }
        tr:nth-child(even) { background: #fafafa; }
        .empty { color: #666; font-style: italic; }
    </style>
    </head>
<body>
<%
    String username = (String) session.getAttribute("username");
    String role = (String) session.getAttribute("role");
    if (username == null) {
        response.sendRedirect("login.jsp");
    }
%>
    <h1>Available Books</h1>

    <%
        List<Book> books = (List<Book>) request.getAttribute("books");
        if (books == null || books.isEmpty()) {
    %>
        <p class="empty">No books available.</p>
    <%
        } else {
    %>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Stock</th>
                <th>Edit</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Book book : books) {
            %>
                <tr>
                    <td><%= book.getId() %></td>
                    <td><%= book.getTitle() %></td>
                    <td><%= book.getAuthor() %></td>
                    <td>MWK<%= String.format("%.2f", book.getPrice()) %></td>
                    <td><%= book.getStock() %></td>
                    <% if (role.equals("ADMIN")) {
                        out.println("<>");
                    }%>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    <%
        }
    %>

</body>
</html>
