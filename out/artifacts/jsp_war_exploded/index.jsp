<%--
  Created by IntelliJ IDEA.
  user: souvenir
  Date: 2020-03-17
  Time: 오후 4:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.SQLException" %>

<html>
  <head>
    <title>$Title$</title>
    <Script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <Script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  </head>
  <body>
  <%
    Connection con = null;
    //localhost는 MySQL이 설치된 곳의 IP
    //mysql : DB 명
    //3306 : MySQL 접속을 위한 디폴트 포트
    String url = "jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8&serverTimezone=UTC";
    String id = "root";                     //MySQL에 접속을 위한 계정의 ID
    String pwd = "990902";            //MySQL에 접속을 위한 계정의 암호
    String driver = "com.mysql.jdbc.Driver";
    try { //1. JDBC 드라이버 로딩
      Class.forName(driver); // 2. Connection 생성
      con = DriverManager.getConnection(url, id, pwd);
      //데이터베이스 연결
      System.out.println("[Database 연결 성공]");

    } catch (SQLException e) {
      System.out.println("[SQL Error : " + e.getMessage() +"]");
    } catch (ClassNotFoundException e1) {
    System.out.println("[JDBC Connector Driver Error : " + e1.getMessage() + "]");
    } finally {
      //Connection 사용 후Close
      if(con != null) {
        try {
          con.close();
        } catch (Exception e) {
          System.out.println("error!");
        }
      }
    }



  %>
<%-- "control + R"--%>
  사이퍼즈고인물측정기입니다
  <div>
    <h1>Form</h1>
    <p>폼을 통해 데이터 전송해봅시다.</p>
  </div>
  <form action="result.jsp" method="get">
    <div>
      <label>닉네임</label>
      <input name="nickName" type="text" />
    </div>
    <div>
      <label>비밀번호</label>
      <input name="b" type="text" />
    </div>
    <button type="submit">측정</button>
  </form>
  <!-- Optional JavaScript -->
  </body>
</html>
