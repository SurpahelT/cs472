<%@ page import="com.webapp.quiz.Quiz" %>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>The Number Quiz</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>The Number Quiz</h1>--%>

<%--<form action="quiz" method="post">--%>
<%--    <label for="age">Your age:</label>--%>
<%--    <input type="text" name="age" id="age" value="<%= session.getAttribute("age") != null ? session.getAttribute("age") : "" %>" required>--%>
<%--    <p style="color:red;"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>--%>

<%--    <p>Your current score is <%= request.getAttribute("score") %>.</p>--%>
<%--    <p>Guess the next number in the sequence:</p>--%>
<%--    <strong><%= request.getAttribute("question") %></strong>--%>
<%--    <br></br>--%>

<%--    <label for="answer">Your answer:</label>--%>
<%--    <input type="text" name="answer" id="answer" required>--%>
<%--    <button type="submit">Submit</button>--%>
<%--    <button type="submit" name="action" value="hint">Hint</button>--%>
<%--</form>--%>

<%--<p><%= request.getAttribute("hint") != null ? "Hint: " + request.getAttribute("hint") : "" %></p>--%>
<%--<p>Attempts: <%= ((Quiz) session.getAttribute("quiz")).getAttempts() %>/3</p>--%>

<%--</body>--%>
<%--</html>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The Number Quiz</title>
    <script>
        // Function to handle hint retrieval without submitting the form
        function getHint() {
            const xhr = new XMLHttpRequest();
            xhr.open("POST", "quiz", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                    // Update the page with the hint
                    document.getElementById("hint").innerHTML = xhr.responseText;
                }
            };
            xhr.send("action=hint");
        }
    </script>
</head>
<body>
<h1>The Number Quiz</h1>

<form action="quiz" method="post">
    <label for="age">Your age:</label>
    <input type="text" name="age" id="age" value="<%= session.getAttribute("age") != null ? session.getAttribute("age") : "" %>" required>
    <p style="color:red;"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>

    <p>Your current score is <%= request.getAttribute("score") %>.</p>
    <p>Guess the next number in the sequence:</p>
    <strong><%= request.getAttribute("question") %></strong>

    <label for="answer">Your answer:</label>
    <input type="text" name="answer" id="answer" required>

    <!-- Submit button for answer -->
    <button type="submit">Submit</button>
</form>

<button type="button" onclick="getHint()">Hint</button>


<p id="hint" style="color: blue;">
    <%= request.getAttribute("hint") != null ? request.getAttribute("hint") : "" %>
</p>

<p>Attempts: <%= ((Quiz) session.getAttribute("quiz")).getAttempts() %>/3</p>

</body>
</html>
