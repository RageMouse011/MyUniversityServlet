package com.project.login;

import com.project.web.dao.LoginDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");

        LoginDAO dao = new LoginDAO();

        if(dao.check(uname, pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", uname);
            response.sendRedirect("app.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
