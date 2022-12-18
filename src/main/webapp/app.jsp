<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<body>
<head>
    <title>Application</title>
</head>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    if (session.getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
    }
%>
    Welcome ${username}<br>
    <a href="postFaculty.jsp">Registration new faculty</a><br>
    <a href="postCareer.jsp">Registration new career</a><br>
    <a href="postSalary.jsp">Registration new salary</a><br>


<form action="Logout">
    <input type="submit" value="Logout">
</form>

</body>
</html>
