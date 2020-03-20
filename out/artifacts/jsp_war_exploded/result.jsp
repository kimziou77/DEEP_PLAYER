<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="subin.*" %>
<%@ page import="java.util.*" %>
<% request.setCharacterEncoding("UTF-8");%>
<%
    PrintWriter script = response.getWriter();

    String nickName = request.getParameter("nickName");
    Player p = Info.createUser(nickName);
    HashMap<String,Long> more_info = Info.moreInfo(p.getPlayerId());
    Long win = more_info.get("win");
    Long lose = more_info.get("lose");
    double score = Math.round((win.doubleValue()/(win.doubleValue()+lose.doubleValue()))*100);

    String result= "뉴비";
//    script.println("<script>");
//    script.println("alert('" + nickName + "님 어서오세용.')");
//    script.println("</script>");
    System.out.println(p);
    //ctl alt l
%>
<%--//출처 https://cloudstudying.kr/lectures/232--%>
<!DOCTYPE html>
<html>
<head>
    <title>DEEP_PLAYER</title>
    <meta name="viewport" content="width=device-width" ,initial-scale="1">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<p>
        <%=nickName%>의 정보
<%--    <% include file="index.jsp"%>--%>

<div>
    닉네임 : <%=p.getNickName()%>
</div>
<div>
    레벨 : <%=p.getLevel()%>급
</div>
<%--<div>--%>
<%--    PlayerId : <%=p.getPlayerId()%>--%>
<%--</div>--%>
<div>
    win : <%=win%>
</div>
<div>
    lose : <%=lose%>
</div>
<div>
    승률 : <%=score%> %
</div>
<div>
    상태 : <%=result%>
</div>
</p>


</body>
</html>
