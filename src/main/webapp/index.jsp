<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>socket 测试</title>
    <meta charset="UTF-8">
    <script type="text/javascript">
        var msocket;

        if(typeof (WebSocket) == "undefined"){
            alert("This explor don't support websocket");
        }


        function connectsocket() {

            console.log(msocket);

            if(msocket==undefined){
                msocket = new WebSocket("ws://127.0.0.1:9999/conferencem/wbsocket");
                msocket.onopen = function (ev) {
                    console.log("socket is opened");
                }

                msocket.onmessage = function (msg) {
                    console.log("message is", msg);
                    var panel = document.getElementById("message");
                    panel.innerHTML = msg.data;
                }

                msocket.onclose = function () {
                    console.log("websocket is closed");
                }

                msocket.onerror = function (ev) {
                    console.log("error is " + ev);
                }
            }
        }

        function closesocket() {
            if(msocket!=undefined){
                msocket.close();
                console.log("Socket已关闭");
            }
        }

        function sendmsg() {
            if(msocket!=undefined){
                msocket.send("发送给服务器端数据 " + new Date().getSeconds());
            }
        }
    </script>
</head>
<body>
    <button onclick="connectsocket()">连接</button>
    <button onclick="closesocket()">关闭</button>
    <button onclick="sendmsg()">发送消息</button>

    <p id="message">

    </p>
</body>
</html>
