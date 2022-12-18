<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Registration new faculty</title>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    if (session.getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
    }
%>

<form action="PostFaculty" method="post">
    <h3>To register new faculty u have to input it's name</h3>
    <input type="text" name="facultyName">
    <input type="submit">
</form><br>
<%

%>

</body>
</html>
