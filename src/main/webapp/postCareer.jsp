<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Registration new career</title>
</head>
<body>
      <%
        int careerId = (Integer) request.getAttribute("careerId");
        String careerName = (String) request.getAttribute("careerName");
        out.println("New career was successfully registered, its name is :" + careerName + " and it's id is: " + careerId);
      %>
</body>
</html>
