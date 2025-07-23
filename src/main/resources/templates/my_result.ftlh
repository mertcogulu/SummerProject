<!DOCTYPE html>
<html>
<head>
    <title>My Test Results</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h1>All Test Results for ${user.name}</h1>

    <#if answers?size == 0>
        <p>You have no test results yet.</p>
    <#else>
        <#list answers as answer>
            <p>
                Test: ${answer.test.testName} <br>
                Question: ${answer.questions.question} <br>
                Your Answer: ${answer.answer} <br>
                Correct Answer: ${answer.questions.correctAnswer} <br>
                <#if answer.questions.correctAnswer == answer.answer>
                    <span class="correct">✅ Correct</span>
                <#else>
                    <span class="incorrect">❌ Incorrect</span>
                </#if>
            </p>
            <hr>
        </#list>
    </#if>
</div>
</body>
</html>