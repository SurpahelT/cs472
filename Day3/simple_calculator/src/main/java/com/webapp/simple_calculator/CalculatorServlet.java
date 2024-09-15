package com.webapp.simple_calculator;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the parameters from the form
        String add1Str = request.getParameter("add1");
        String add2Str = request.getParameter("add2");
        String mul1Str = request.getParameter("mul1");
        String mul2Str = request.getParameter("mul2");

        // Initialize results
        String additionResult = "N/A";
        String multiplicationResult = "N/A";

        // Try to parse numbers and perform calculations
        try {
            if (add1Str != null && add2Str != null) {
                double add1 = Double.parseDouble(add1Str);
                double add2 = Double.parseDouble(add2Str);
                additionResult = String.valueOf(add1 + add2);
            }
        } catch (NumberFormatException e) {
            additionResult = "Invalid input for addition";
        }

        try {
            if (mul1Str != null && mul2Str != null) {
                double mul1 = Double.parseDouble(mul1Str);
                double mul2 = Double.parseDouble(mul2Str);
                multiplicationResult = String.valueOf(mul1 * mul2);
            }
        } catch (NumberFormatException e) {
            multiplicationResult = "Invalid input for multiplication";
        }

        // Display the results
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Calculation Results</h1>");
        response.getWriter().println("<h3>Addition Result: " + additionResult + "</h3>");
        response.getWriter().println("<h3>Multiplication Result: " + multiplicationResult + "</h3>");
        response.getWriter().println("</body></html>");
    }
}