<%@ page language="java" import="subin.Info" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%
    // request 객체로부터 파라미터를 가져옴.
    String nickName = request.getParameter("nickName");
    String password = request.getParameter("b");
        Info.createUser(nickName);
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('"+nickName+"님 어서오세용.')");
        script.println("location.href = 'index.jsp'");
        script.println("</script>");
%>
<%--//출처 https://cloudstudying.kr/lectures/232--%>