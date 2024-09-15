<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The Number Quiz</title>
</head>
<body>
<h1>The Number Quiz</h1>
<p>Your current score is
    <%
        Integer score = (Integer) request.getAttribute("score");
        if (score != null) {
            out.print(score);
        } else {
            out.print("not yet started");
        }
    %>.
</p>
<p>Guess the next number in the sequence:</p>
<p><strong>
    <%
        String question = (String) request.getAttribute("question");
        if (question != null && !"No question available".equals(question)) {
            out.print(question);
        } else {
            out.print("No question available");
        }
    %>
</strong></p>

<% if (question != null && !"No question available".equals(question)) { %>
<form action="quiz" method="post">
    <label for="answer">Your answer:</label>
    <input type="text" name="answer" id="answer" required>
    <button type="submit">Submit</button>
</form>
<% } else { %>
<p>The quiz has finished. Your final score is <%= request.getAttribute("score") %>.</p>
<% } %>
</body>
</html>
