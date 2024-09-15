<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recommended Beer Styles</title>
</head>
<body>
<h2>Recommended Beer Styles</h2>

<%
    // Get the list of styles from the request
    List<String> styles = (List<String>) request.getAttribute("styles");
    if (styles != null && !styles.isEmpty()) {
        for (String style : styles) {
            out.println("<br>try: " + style);
        }
    } else {
        out.println("<br>No styles available");
    }
%>

<hr>
<p>Current Date and Time:</p>

<%
    // Get the current date and time
    Date now = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
    String formattedDate = formatter.format(now);
%>
<span style="color: blue; font-size: 14px;"><%= formattedDate %></span>

</body>
</html>
