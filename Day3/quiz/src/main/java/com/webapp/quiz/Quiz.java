package com.webapp.quiz;

public class Quiz {
    private static final String[] questions = {
            "3, 1, 4, 1, 5",  // π
            "1, 1, 2, 3, 5",  // Fibonacci
            "1, 4, 9, 16, 25",  // Squares
            "2, 3, 5, 7, 11",  // Primes
            "1, 2, 4, 8, 16"  // Powers of 2
    };

    private static final int[] answers = {9, 8, 36, 13, 32};  // Correct answers

    private int currentQuestionIndex;
    private int score;

    public Quiz() {
        currentQuestionIndex = 0;
        score = 0;
    }

    public String getCurrentQuestion() {
        if (isQuizOver()) {
            return null; // Return null if quiz is over
        }
        return questions[currentQuestionIndex];
    }

    public boolean checkAnswer(int userAnswer) {
        if (isQuizOver()) {
            return false;
        }

        boolean isCorrect = userAnswer == answers[currentQuestionIndex];
        if (isCorrect) {
            score++;
        }

        currentQuestionIndex++;
        return isCorrect;
    }

    public boolean isQuizOver() {
        return currentQuestionIndex >= questions.length;
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return questions.length;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }
}
