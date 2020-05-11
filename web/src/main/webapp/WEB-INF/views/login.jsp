<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http=equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login JSP</title>
    </head>
    <%
        Date date = new Date();
    %>
    <body>
        <div>Current date is <%=date%></div>
        <p>${errorMessage}</p>
        <form action="/login.do" method="post">
            Name: <input type="text" name="name" />
            Password: <input type="password" name="password" />
            <input type="submit" value="login" />
        </form>
    </body>
</html>
