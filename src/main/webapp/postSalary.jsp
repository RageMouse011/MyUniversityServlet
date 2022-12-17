<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Registration new salary</title>
</head>
<body>
<%
    int salaryId = (Integer) request.getAttribute("salaryId");
    Double salaryValue = (Double) request.getAttribute("salaryValue");
    out.println("New salary was successfully registered, its value is :" + salaryValue + " and it's id is: " + salaryId);
%>
</body>
</html>
