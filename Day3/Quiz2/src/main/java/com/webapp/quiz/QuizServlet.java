package com.webapp.quiz;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class QuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = (Quiz) session.getAttribute("quiz");

        if (quiz == null) {
            quiz = new Quiz();
            session.setAttribute("quiz", quiz);
        }

        if (quiz.isQuizOver()) {
            request.setAttribute("score", quiz.getScore());
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } else {
            String currentQuestion = quiz.getCurrentQuestion();
            request.setAttribute("question", currentQuestion);
            request.setAttribute("score", quiz.getScore());
            request.getRequestDispatcher("quiz.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        String ageStr = request.getParameter("age");

        if (ageStr != null) {
            try {
                int age = Integer.parseInt(ageStr);
                if (age < 4 || age > 100) {
                    request.setAttribute("error", "Age must be between 4 and 100.");
                } else {
                    session.setAttribute("age", age);  // Store age in session
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Please enter a valid integer for age.");
            }
        }

        // If the user clicked the hint button, handle hint logic
        if ("hint".equals(request.getParameter("action"))) {
            String hint = quiz.getCurrentHint();
            response.setContentType("text/plain");
            response.getWriter().write(hint);
            return;  // Return after providing the hint (no further processing)
        }

        // Process answer submission
        if (quiz != null && !quiz.isQuizOver()) {
            String userAnswerStr = request.getParameter("answer");
            try {
                int userAnswer = Integer.parseInt(userAnswerStr);
                quiz.checkAnswer(userAnswer);
                session.setAttribute("quiz", quiz);
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Please enter a valid number.");
            }
        }

        // Redirect to GET to display the updated quiz state
        response.sendRedirect("quiz");
    }
}
