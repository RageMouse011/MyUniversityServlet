package com.project.user;

import com.project.web.dao.SigninDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Signin")
public class Signin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");

        SigninDAO dao = new SigninDAO();

        if(dao.register(uname, pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", uname);
            response.sendRedirect("app.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
