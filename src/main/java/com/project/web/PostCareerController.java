package com.project.web;

import com.project.web.dao.CareerDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostCareerController", value = "/PostCareer")
public class PostCareerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String careerName = request.getParameter("careerName");

        CareerDAO dao = new CareerDAO();
        int careerId = dao.getCareerId(careerName);

        request.setAttribute("careerName", careerName);
        request.setAttribute("careerId", careerId);

        RequestDispatcher rd = request.getRequestDispatcher("postCareer.jsp");
        rd.forward(request, response);

    }
}
