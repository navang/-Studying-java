<%@ page import="board.service.ReplyArticleService, board.model.BoardRec"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<%
	// CReply에서 rec을 객체로 받음 
	BoardRec reRec = (BoardRec)request.getAttribute("rec"); 
	int result =reRec.hashCode();
	
%>    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 답변 글 저장하기 </title>
</head>
<body>

<% if(result !=0){%>

답변글을 등록하였습니다. <br/><br/>
<% } else{%>
답변글을 등록 실패하였스빈다

<% }%>
<a href="BoardList.jsp"> 목록보기 </a> &nbsp;
<a href="BoardView.jsp?id=<%=reRec.getArticleId()%>"> 게시글 읽기 </a>

</body>
</html>