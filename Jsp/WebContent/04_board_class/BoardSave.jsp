<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.*,board.service.*" %>

<%
	request.setCharacterEncoding("utf-8"); 
	// 0. 넘겨받는 한글 깨지지 않도록 지정
%>

<!--  1. 전 화면 입력값을 넘겨받아 BoardRec 클래스의 각 멤버필드에 지정 -->
<jsp:useBean id="m" class="board.model.BoardRec">
	<jsp:setProperty name='m' property="*"/>
</jsp:useBean>

<% 
    WriteArticleService service = WriteArticleService.getInstance();
	BoardRec result= service.write(m);     
	//2. Service클래스에 write() 함수호출
	
	//3. 화면을 리다이렉트로 바꾸기//페이지를 바꿔서 중복 증가를 막자 
	response.sendRedirect("BoardView.jsp?article_id=" + result.getArticleId());
	
%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판글저장</title>
</head>
<body>
입력되었는지 확인해보시구염...<br/>
만일 안되어도..환장하지 맙시다 !!! ^^<br/><br/>
</body>
</html>