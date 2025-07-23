<!DOCTYPE html>
<html>
<head>
    <title>General Chat</title>
    <link rel="stylesheet" href="/css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client/dist/sockjs.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/stompjs/lib/stomp.min.js"></script>
</head>
<body>
<div class="container">
    <h1>Welcome to the General Chat, ${username}!</h1>

    <ul id="messages">
        <#list messages as message>
            <li>${message.sender}: ${message.content}</li>
        </#list>
    </ul>


    <input type="text" id="message" placeholder="Type your message here..." autofocus/>
    <button onclick="sendMessage()">Send</button>
</div>

<script>
    var stompClient = null;
    var username = "${username}";

    function connect() {
        var socket = new SockJS('/chat-websocket');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/messages', function (messageOutput) {
                showMessage(JSON.parse(messageOutput.body));
            });
        });
    }

    function sendMessage() {
        const message = document.getElementById('message').value;
        stompClient.send("/app/chat", {}, JSON.stringify({'sender': username, 'content': message}));
        document.getElementById('message').value = '';
    }

    function showMessage(message) {
        const messages = document.getElementById('messages');
        const li = document.createElement('li');
        li.textContent = message.sender + ": " + message.content;
        messages.appendChild(li);
        window.scrollTo(0, document.body.scrollHeight);
    }

    connect();
</script>
</body>
</html>