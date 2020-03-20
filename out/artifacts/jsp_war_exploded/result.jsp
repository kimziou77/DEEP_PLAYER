<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="subin.PlayerDAO"%>
<%@ page import="subin.*" %>
<%@ page import="java.util.*" %>
<%--<jsp:useBean id="user" class="subin.Player"/>--%>
<%--<jsp:setProperty name="user" property="nickName"/>--%>
<% request.setCharacterEncoding("UTF-8");%>
<%
    PrintWriter script = response.getWriter();
    String nickName = request.getParameter("nickName");

    PlayerDAO dao = new PlayerDAO();
    String playerID = dao.get_playerId_from_nickName(nickName);
    Player p=null;
    Long win=null;
    Long lose=null;
    double score=0;
    String result="";
    if(dao.IN_DB(playerID)==0){//만약 DB에없으면 생성시켜준다.
        p = Info.createUser(nickName);
        if(p==null){
            script.println("<script>");
            script.println("alert('[" + nickName + "] 은 존재하지 않는 닉네임 입니다.')");
            script.println("history.back();");
            script.println("</script>");
        }
        dao.join(p);
    }
    else{//DB에 있다면 있는정보를 불러들여온다.
        p=dao.DB_USER(playerID);
        System.out.println(playerID);
    }
    win=p.getWin();
    lose=p.getLose();
    score = Math.round((win.doubleValue()/(win.doubleValue()+lose.doubleValue()))*100);


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
    레벨 : <%=p.getGrade()%>급
</div>
<%--<div>--%>
<%--    PlayerId : <%=p.getPlayerId()%>--%>
<%--</div>--%>
<div>
    win : <%=p.getWin()%>
</div>
<div>
    lose : <%=p.getLose()%>
</div>
<div>
    승률 : <%=score%> %
</div>
<div>
    상태 : <%=p.getStat()%>
</div>
</p>
<hr>
<p>
    그래서 당신은 최종적으로
    <div>
    <%=p.getStat()%> 입니다.
    </div>

</p>

</body>
</html>
