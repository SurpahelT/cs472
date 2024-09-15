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
<%
    Quiz quiz = (Quiz) request.getSession().getAttribute("quiz");
%>
<p>Your final score is <%= quiz.getScore() %> out of <%= quiz.getTotalQuestions() %>.</p>
<p style="color:red;">Final grade: <%= quiz.getGrade() %></p>
<p>You have completed the Number Quiz.</p>
<a href="quiz.jsp">Play again</a>
</body>
</html>
