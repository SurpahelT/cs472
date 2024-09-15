package com.webapp.web;

import com.webapp.model.BeerExpert;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class BeerSelect extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String color = request.getParameter("color");
        BeerExpert beerExpert = new BeerExpert();
        List<String> result = beerExpert.getBrands(color);

        request.setAttribute("styles", result);

        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
}