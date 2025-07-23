<!DOCTYPE html>
<html>
<head>
    <title>Tests</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h2>Welcome</h2>

    <form method="get" action="/">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit">Home</button>
    </form>
    <br><br>

    <#list tests as test>
        <a href="/tests/${test.id}">${test.testName}</a>
        <br>
    </#list>
</div>
</body>
</html>