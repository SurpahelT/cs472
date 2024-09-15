<%@ page import="java.util.List" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Beer Recommendations</title>
</head>
<body>
<h1>Beer Recommendations</h1>
<p>
    <%
        List<String> styles = (List<String>) request.getAttribute("styles");
        if (styles != null) {
            for (String style : styles) {
                out.print("Try: " + style + "<br>");
            }
        } else {
            out.print("No recommendations available.");
        }
    %>
</p>
</body>
</html>