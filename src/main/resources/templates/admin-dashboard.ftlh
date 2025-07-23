<!DOCTYPE html>
<html>
<head>
    <title>Admin Page</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <#if user.role == "TEACHER">
        <h2>Welcome to Admin Panel</h2>

        <form method="post" action="/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button type="submit">Logout</button>
        </form>

        <form method="get" action="/new-test">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button type="submit">Create New Test</button>
        </form>


    <#else> <h2>TEACHERS ONLY!</h2>
    </#if>

</div>
</body>
</html>