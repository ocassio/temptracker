<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Temperature Tracker</title>

    <%
        String username = (String) request.getAttribute("name");
        if (username != null)
        {
    %>
            <script type="text/javascript">
                window.username = '<%=username%>';
            </script>
            <script src="../../dist/js/libs.js" type="text/javascript"></script>
            <script src="../../dist/js/app.js" type="text/javascript"></script>
    <%
        }
    %>

    <link rel="stylesheet" href="../../dist/css/libs.css" />
    <link rel="stylesheet" href="../../dist/css/main.css" />

</head>
<body ng-app="temptracker">
    <%
        if (username != null)
        {
    %>
        <xx-top-panel></xx-top-panel>
        <div class="wrapper">
            <ui-view></ui-view>
        </div>
    <%
        }
        else
        {
    %>
            <form action="/" class="login-form" method="POST">
                <span class="label">Please enter your name</span>
                <input class="field" name="name" type="text" />
                <button class="button-primary" type="submit">Submit</button>
            </form>
    <%
        }
    %>
</body>
</html>