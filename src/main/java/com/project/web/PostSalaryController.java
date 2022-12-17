package com.project.web;

import com.project.web.dao.SalaryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostSalaryController", value = "/PostSalary")
public class PostSalaryController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Double salaryValue = Double.valueOf(request.getParameter("salaryValue"));

        SalaryDAO dao = new SalaryDAO();
        int salaryId = dao.getSalaryId(salaryValue);

        request.setAttribute("salaryValue", salaryValue);
        request.setAttribute("salaryId", salaryId);

        RequestDispatcher rd = request.getRequestDispatcher("postSalary.jsp");
        rd.forward(request, response);
    }
}
