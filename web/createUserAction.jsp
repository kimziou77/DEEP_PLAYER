<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="user.UserDAO"%>
<%@ page import="java.io.PrintWriter"%> <%--자바스크립트문장을작성하기위해사용--%>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty name="user" property="userID"/>
<jsp:setProperty name="user" property="userPassword"/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width",initial-scale="1">
    <%--    <link rel="stylesheet" href="css/bootstrap.css">--%>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>DEEP_PLAYER</title>
</head>
<body>
<%
    if(user.getUserID()==null||user.getUserPassword()==null) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('빈칸을채우세요')");
        script.println("history.back()");
        script.println("</script>");
    }else{
        UserDAO userDAO= new UserDAO();
        int result = userDAO.join(user);
        if(result== -1){//데이터베이스오류 ->이미존재하는아이디
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('이미존재하는아이디입니다')");
            script.println("history.back()");
            script.println("</script>");
        }
        else{//데이터베이스오류
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("location.href='main.jsp'");
            script.println("</script>");
        }
    }
%>
</body>
</html>
