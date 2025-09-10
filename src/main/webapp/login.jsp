<%--
  Created by IntelliJ IDEA.
  User: timothymiamba
  Date: 9/10/25
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; background: #f7f7f7; }
        .container { max-width: 420px; margin: 60px auto; background: #fff; padding: 24px; border: 1px solid #e5e5e5; border-radius: 8px; }
        h1 { font-size: 22px; margin: 0 0 16px; }
        .field { display: flex; flex-direction: column; margin-bottom: 12px; }
        label { font-size: 13px; color: #333; margin-bottom: 6px; }
        input[type=text], input[type=password] { padding: 10px; border: 1px solid #ccc; border-radius: 6px; font-size: 14px; }
        .actions { margin-top: 16px; display: flex; gap: 8px; align-items: center; }
        button, .btn { padding: 10px 14px; border: none; border-radius: 6px; background: #2563eb; color: #fff; cursor: pointer; font-size: 14px; text-decoration: none; display: inline-block; }
        .btn.secondary { background: #6b7280; }
        .hint { font-size: 12px; color: #666; }
    </style>
    </head>
<body>
    <div class="container">
        <h1>Login</h1>
        <form method="post" action="${pageContext.request.contextPath}/login">
            <div class="field">
                <label for="username">Username</label>
                <input id="username" name="username" type="text" required />
            </div>
            <div class="field">
                <label for="password">Password</label>
                <input id="password" name="password" type="password" required />
            </div>
            <div class="actions">
                <button type="submit">Sign in</button>
                <a class="btn secondary" href="${pageContext.request.contextPath}/index.jsp">Back</a>
            </div>
            <p class="hint">Don't have an account? <a href="${pageContext.request.contextPath}/signup.jsp">Sign up</a></p>
        </form>
    </div>
</body>
</html>
