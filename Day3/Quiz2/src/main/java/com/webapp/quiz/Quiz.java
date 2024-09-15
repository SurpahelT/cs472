package com.webapp.quiz;

public class Quiz {
    private static final String[] questions = {
            "3, 1, 4, 1, 5",  // π
            "1, 1, 2, 3, 5",  // Fibonacci
            "1, 4, 9, 16, 25",  // Squares
            "2, 3, 5, 7, 11",  // Primes
            "1, 2, 4, 8, 16"  // Powers of 2
    };

    private static final String[] hints = {
            "Hint: Think of Pi",
            "Hint: Fibonacci series",
            "Hint: Perfect squares",
            "Hint: Prime numbers",
            "Hint: Powers of 2"
    };

    private static final int[] answers = {1, 5, 16, 7, 16};
    private static final int MAX_ATTEMPTS = 3;

    private int currentQuestionIndex;
    private int score;
    private int attempts;

    public Quiz() {
        currentQuestionIndex = 0;
        score = 0;
        attempts = 0;
    }

    public String getCurrentQuestion() {
        if (isQuizOver()) {
            return null;
        }
        return questions[currentQuestionIndex];
    }

    public String getCurrentHint() {
        return hints[currentQuestionIndex];
    }

    public boolean checkAnswer(int userAnswer) {
        if (isQuizOver()) {
            return false;
        }

        boolean isCorrect = userAnswer == answers[currentQuestionIndex];
        if (isCorrect) {
            if (attempts == 0) {
                score += 10;
            } else if (attempts == 1) {
                score += 5;
            } else if (attempts == 2) {
                score += 2;
            }
            currentQuestionIndex++;
            attempts = 0;  // Reset attempts for the next question
        } else {
            attempts++;
            if (attempts >= MAX_ATTEMPTS) {
                currentQuestionIndex++;
                attempts = 0;  // Reset attempts for the next question
            }
        }
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

    public int getAttempts() {
        return attempts;
    }

    public String getGrade() {
        if (score >= 45) {
            return "A";
        } else if (score >= 35) {
            return "B";
        } else if (score >= 25) {
            return "C";
        } else {
            return "NC";
        }
    }
}
