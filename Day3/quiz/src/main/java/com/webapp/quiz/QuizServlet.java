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
            System.out.println("Current question: " + currentQuestion); // Debug line
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

        if (quiz != null && !quiz.isQuizOver()) {
            String userAnswerStr = request.getParameter("answer");
            try {
                int userAnswer = Integer.parseInt(userAnswerStr);
                quiz.checkAnswer(userAnswer);
                session.setAttribute("quiz", quiz);  // Update quiz in session
            } catch (NumberFormatException e) {
                // Handle invalid input (non-integer)
                request.setAttribute("error", "Please enter a valid number.");
            }
        }

        // Redirect to GET to display the updated quiz state
        response.sendRedirect("quiz");
    }
}
