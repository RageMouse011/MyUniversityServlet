<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="Signin" method="post">
    Enter username: <input type="text" name="uname"><br>
    Enter password: <input type="password" name="pass"><br>
    <input type="submit" value="signin">
</form>
<form action="Login" method="post">
    Enter username: <input type="text" name="uname"><br>
    Enter password: <input type="password" name="pass"><br>
    <input type="submit" value="login">
</form>
</body>
</html>
