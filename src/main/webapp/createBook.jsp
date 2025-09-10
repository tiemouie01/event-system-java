<%--
  Created by IntelliJ IDEA.
  User: timothymiamba
  Date: 9/10/25
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Book</title>
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
    <h1>Create Book</h1>
    <form method="post" action="${pageContext.request.contextPath}/admin/book/create">
        <label for="title">Title</label>
        <input type="text" id="title" name="title" required>

        <label for="author">Author</label>
        <input type="text" id="author" name="author" required>

        <label for="price">Price</label>
        <input type="number" id="price" name="price" step="0.01" min="0" required>

        <label for="stock">Stock</label>
        <input type="number" id="stock" name="stock" min="0" required>

        <button type="submit">Save</button>
    </form>
</body>
</html>
