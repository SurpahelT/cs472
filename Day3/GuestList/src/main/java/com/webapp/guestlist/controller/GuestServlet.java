package com.webapp.guestlist.controller;

import com.webapp.guestlist.app.Guest;
import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "guestServlet", urlPatterns = {"*.ajax"})
public class GuestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("guests.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        List<Guest> guestList = (List<Guest>) session.getAttribute("guestList");

        if (guestList == null) {
            guestList = new ArrayList<>();
            session.setAttribute("guestList", guestList);
        } else if (!(guestList instanceof ArrayList)) {
            throw new IllegalStateException("Session attribute 'guestList' is not of type ArrayList<Guest>");
        }

        String firstInput = request.getParameter("first");
        String lastInput = request.getParameter("last");

        guestList.add(new Guest(firstInput, lastInput));

        String jsonGuests = new Gson().toJson(guestList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(jsonGuests);
    }
}
