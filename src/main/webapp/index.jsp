<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<body>
      <form action="PostFaculty" method="post">
          <h3>To register new faculty u have to input it's name</h3>
        <input type="text" name="facultyName">
        <input type="submit">
      </form><br>

     <form action="PostCareer" method="post">
         <h3>To register new career u have to input it's name</h3>
         <input type="text" name="careerName">
         <input type="submit">
     </form><br>

      <form action="PostSalary" method="post">
          <h3>To register new salary u have to input it's value</h3>
          <input type="text" name="salaryValue">
          <input type="submit">
      </form>
</body>
</html>
