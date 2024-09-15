package com.webapp.beerv2.view;

import com.webapp.beerv2.model.BeerExpert;
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

        // Retrieve the color selected in the form
        String color = request.getParameter("color");

        // Use the BeerExpert class to get the list of beer brands
        BeerExpert beerExpert = new BeerExpert();
        List<String> result = beerExpert.getBrands(color);

        // Store the result list in the request object
        request.setAttribute("styles", result);

        // Forward the request to result.jsp
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
}