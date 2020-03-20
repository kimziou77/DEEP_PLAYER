<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
    <title>DEEP_PLAYER</title>
    <meta name="viewport" content="width=device-width",initial-scale="1">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%-- "control + R"--%>
존재하지않는유저입니다.
<form action="result.jsp" method="post">
    <div>
        <input name="nickName" type="text" placeholder="닉네임입력"/>
    </div>
    <button type="submit">측정</button>
</form>
<!-- Optional JavaScript -->
</body>
</html>
