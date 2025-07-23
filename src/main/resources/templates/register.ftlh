<!DOCTYPE html>
<html>
<head>
    <title>Register</title></head>
<link rel="stylesheet" href="/css/style.css">

<body class="page-register">
<div class="container">
    <h2>Register</h2>

    <form method="POST" action="/register">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <label>Name:</label><br>
        <input type="text" name="name" value="${userDto.name!}" required><br>

        <label>Email:</label><br>
        <input type="email" name="email" value="${userDto.email!}" required><br>

        <label>Password:</label><br>
        <input type="password" name="password" required><br>

        <label>Confirm Password:</label><br>
        <input type="password" name="confirmPassword" required><br>

        <button type="submit">Register</button>
    </form>



    <a href="/login">Already have an account?</a>
</div>
</body>
</html>