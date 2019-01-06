<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Pong Applet</title>

    <style type="text/css">

        p {color: yellow; }
        body {background-color: black; }

    </style>

</head>
<body>

<jsp:plugin type="applet" code="PongApplet.class" codebase="games" archive="pong.jar"
            width="600" height="400">
    <jsp:fallback>
        <p>Nie laduje</p>
    </jsp:fallback>
</jsp:plugin>

</body>
</html>