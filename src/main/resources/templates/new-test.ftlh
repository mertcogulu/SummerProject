<!DOCTYPE html>
<html>
<head>
    <title>New Test</title>
    <link rel="stylesheet" href="/css/style.css">

</head>
<body>
<div class="container">
    <#if user.role == "TEACHER">
        <form method="get" action="/">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button type="submit">Home</button>
        </form>

        <form method="post" action="/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button type="submit">Logout</button>
        </form>
        <br><br>

        <h2>Create a New Test</h2>

        <form method="post" action="/new-test">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <label>Test Name:</label><br>
            <input type="text" name="testName" required><br><br>


            <button type="submit">Submit</button>
        </form>
    <#else> <h2>TEACHERS ONLY!</h2>
    </#if>
</div>
</body>
</html>