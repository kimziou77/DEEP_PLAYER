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
  사이퍼즈고인물측정기입니다
  <div>
    <h1>Form</h1>
    <p>폼을 통해 데이터 전송해봅시다.</p>
  </div>
  <form action="result.jsp" method="post">
    <div>
      <label>닉네임</label>
      <input name="nickName" type="text" />
    </div>
    <button type="submit">측정</button>
  </form>
  <!-- Optional JavaScript -->
  </body>
</html>
