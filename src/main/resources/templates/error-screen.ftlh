<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h2>Oops! Something went wrong.</h2>
<p>Please check your input and try again.</p>
<form method="get" action="/">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <button type="submit">Home</button>
    <br><br>
</form>
</body>
</html>