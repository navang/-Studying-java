<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.*,board.service.*" %>

<%
	request.setCharacterEncoding("utf-8"); 
	// 0. 넘겨받는 한글 깨지지 않도록 지정
%>


<%

Object obj = request.getAttribute("input");
int result= obj.hashCode();

 
%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판글저장</title>
</head>
<body>


	<% if( result != 0) { %>
			글을 저장하였습니다.
	<% } else { %>
			삭제가 실패되었습니다.
	<% } %>
입력되었는지 확인해보시구염...<br/>
만일 안되어도..환장하지 맙시다 !!! ^^<br/><br/>
<a href="/board?cmd=bmain-page">메인가기</a>
</body>
</html>