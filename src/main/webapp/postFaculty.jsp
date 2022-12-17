<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Registration new faculty</title>
</head>
<body>
        <%
            int facultyId = (Integer) request.getAttribute("facultyId");
            String facultyName = (String) request.getAttribute("facultyName");
            out.println("New faculty was successfully registered, its name is :" + facultyName + " and it's id is: " + facultyId);
        %>
</body>
</html>
