<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="subin.*" %>
<% request.setCharacterEncoding("UTF-8");%>
<%--<jsp:useBean id="user" class="subin.Player"/>--%>
<%--<jsp:setProperty name="user" property="*"/>--%>
<%
    // request 객체로부터 파라미터를 가져옴.
    String nickName = request.getParameter("nickName");
    Player p = Info.createUser(nickName);
    //

    PrintWriter script = response.getWriter();
    script.println("<script>");
    script.println("alert('" + nickName + "님 어서오세용.')");
    System.out.println(p);
//    script.println("location.href = 'index.jsp'");
    script.println("</script>");
    p.toString();
    //ctl alt l
%>
<%--//출처 https://cloudstudying.kr/lectures/232--%>
<!DOCTYPE html>
<html>
<head>
    <title>DEEP_PLAYER</title>
    <meta name="viewport" content="width=device-width",initial-scale="1">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%=nickName%>의 정보
    <div>
        급수 : <%=p.getLevel()%>
    </div>
    <div>
        닉네임 : <%=p.getNickName()%>
    </div>
    <div>
        PlayerId : <%=p.getPlayerId()%>
    </div>
</body>
</html>
