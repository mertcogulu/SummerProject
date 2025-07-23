<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body class="page-home">
<div class="container">
    <h2>Welcome</h2>
    <p>You are logged in.</p>


    <form method="post" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit">Logout</button>
    </form>
    <br> <br><form method="get" action="/my-results">
        <button type="submit">My Test Results</button>
    </form>

    <form method="get" action="/chat">
        <button type="submit">Chat</button>
    </form>

    <form method="get" action="/tests">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit">All Tests</button>
    </form>



    <#if user.role == "TEACHER">
        <form method="get" action="/admin">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button type="submit">Admin Page</button>
        </form>
    </#if>

</div>
</body>
</html>