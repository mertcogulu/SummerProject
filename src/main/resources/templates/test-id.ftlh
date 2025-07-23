<!DOCTYPE html>
<html>
<head>
    <title>Tests</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <form method="post" action="/tests/${id}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <#list questions as question>
            <label for="${question.id}">${question.question}</label>
            <select id="${question.id}" name="ans">
                <option value="optionA">${question.optionA}</option>
                <option value="optionB">${question.optionB}</option>
                <option value="optionC">${question.optionC}</option>
            </select>
            <br>
        </#list>
        <input type="submit" value="Submit your Answer">
    </form>
</div>
</body>
</html>