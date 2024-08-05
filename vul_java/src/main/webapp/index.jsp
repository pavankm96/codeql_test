<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession session = request.getSession();
    String username = request.getParameter("username");
    String password = request.getParameter("password");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Vulnerable Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>
        <input type="submit" value="Login">
    </form>
    <%
        if (username != null && password != null) {
            out.println("Welcome, " + username + "! Your password is " + password);
        }
    %>
</body>
</html>