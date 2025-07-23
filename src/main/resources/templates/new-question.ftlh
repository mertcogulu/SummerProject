<!DOCTYPE html>
<html>
<head>
    <title>New Question</title>
    <link rel="stylesheet" href="/css/style.css">

</head>
<body>
<div class="container">

    <form method="get" action="/">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit">Home</button>
    </form>

    <form method="post" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit">Logout</button>
    </form>
    <br><br>

    <h2>Create a New Question</h2>

    <form method="post" >
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <label>Question:</label><br>
        <input type="text" name="question" required><br><br>

        <label>Option A:</label><br>
        <input type="text" name="optionA" required><br><br>

        <label>Option B:</label><br>
        <input type="text" name="optionB" required><br><br>

        <label>Option C:</label><br>
        <input type="text" name="optionC" required><br><br>

        <label>Correct Answer:</label><br>
        <select name="correctAnswer" required>
            <option value="optionA">A</option>
            <option value="optionB">B</option>
            <option value="optionC">C</option>
        </select>

        <button type="submit">Submit</button>
    </form>

</div>
</body>
</html>