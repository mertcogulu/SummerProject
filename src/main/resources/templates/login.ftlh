<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body class="page-login">
<div class="container">
    <h2>Login</h2>

    <#if RequestParameters.error??>
        <div style="color:red;">Invalid email or password</div>
    </#if>

    <form action="/login" method="post">
        <label>Email:</label><br>
        <input type="email" name="username" required><br>

        <label>Password:</label><br>
        <input type="password" name="password" required><br>

        <!-- CSRF Token -->
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

        <button type="submit">Login</button>
    </form>

    <a href="/register">Don't have an account?</a>
</div>
</body>
</html>