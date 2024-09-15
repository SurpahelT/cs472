<%@ page import="com.webapp.quiz.Quiz" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Result</title>
</head>
<body>
<h1>The Number Quiz</h1>
<p>Your final score is <%= ((Quiz) request.getSession().getAttribute("quiz")).getScore() %> out of <%= ((Quiz) request.getSession().getAttribute("quiz")).getTotalQuestions() %>.</p>
<p>You have completed the Number Quiz.</p>
<a href="quiz.jsp">play again</a>
</body>
</html>
