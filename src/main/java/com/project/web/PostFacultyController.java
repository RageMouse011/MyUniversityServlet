package com.project.web;

import com.project.web.dao.FacultyDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PostFacultyController", value = "/PostFaculty")
public class PostFacultyController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String facultyName = request.getParameter("facultyName");

        FacultyDAO dao = new FacultyDAO();
        int facultyId = dao.getFacultyId(facultyName);

        request.setAttribute("facultyName", facultyName);
        request.setAttribute("facultyId", facultyId);

        RequestDispatcher rd = request.getRequestDispatcher("postFaculty.jsp");
        rd.forward(request, response);
    }
}
