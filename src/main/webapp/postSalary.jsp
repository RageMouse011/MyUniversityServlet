<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Registration new salary</title>
</head>
<body>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<form action="PostSalary" method="post">
    <h3>To register new salary u have to input it's value</h3>
    <input type="text" name="salaryValue">
    <input type="submit">
</form>

</body>
</html>
