<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>BookStore</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; background: #f7f7f7; }
        .container { max-width: 600px; margin: 80px auto; background: #fff; padding: 32px; border: 1px solid #e5e5e5; border-radius: 8px; text-align: center; }
        h1 { font-size: 24px; margin: 0 0 16px; }
        p { color: #555; margin: 0 0 24px; }
        .actions { display: flex; gap: 12px; justify-content: center; }
        a.btn { padding: 12px 16px; border-radius: 8px; text-decoration: none; color: #fff; background: #2563eb; display: inline-block; }
        a.btn.secondary { background: #16a34a; }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome to BookStore</h1>
    <p>Please choose an option below to continue.</p>
    <div class="actions">
        <a class="btn" href="${pageContext.request.contextPath}/login.jsp">Login</a>
        <a class="btn secondary" href="${pageContext.request.contextPath}/signup.jsp">Sign Up</a>
    </div>
</div>
</body>
</html>