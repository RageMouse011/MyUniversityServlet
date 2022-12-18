package com.project.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname = request.getParameter("uname");
        String password = request.getParameter("password");

        if(uname.equals("ragemouse11") && password.equals("Q12we34r56t")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", uname);
            response.sendRedirect("app.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
