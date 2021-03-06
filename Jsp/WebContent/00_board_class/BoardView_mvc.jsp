<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.*, board.service.*" %>
<%@ page import="java.util.*" %>


<%
	// Control에서 param을 넘겨받아 mList 변수에 지정
	BoardRec rec = (BoardRec)request.getAttribute("selectbyId");  
	
%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    <!-- https://getbootstrap.com/docs/4.3/getting-started/introduction/ 부트스트랩에서 가져옴-->
    <link rel="stylesheet" href="../../99css/main.css">

    <script src="https://kit.fontawesome.com/825d367943.js"></script>
<title> 게시글 보기 </title>
</head>
<body>
  <div class="container-fluid">
	<h4> 게시판 글 보기 </h4><br/>
	<table border=1 class="table text-left table-hover">
	<div class="row">
	<tr>
		<td> 제  목 : </td>
		<td><%=rec.getTitle()%></td>
	</tr>
	<tr>
		<td> 작성자 : </td>
		<td><%=rec.getWriterName()%></td>
	</tr>
	<tr>
		<td> 작성일자 : </td>
		<td><%=rec.getPostingDate()%></td>
	</tr>
	<tr>
		<td> 내  용 : </td>
		<td><%=rec.getContent()%></td>
	</tr>
	<tr>
		<td> 조회 수 : </td>
		<td><%=rec.getReadCount()%></td>
	</tr>
	</div>
	<tr>
		<td colspan="2">
			 <a class="btn btn-secondary" type="button" href="">목록보기</a>
			 <a class="btn btn-primary" type="button" href="board?cmd=breply-page&article_id=<%=rec.getArticleId()%>">답변하기</a>
			<a class="btn btn-success" type="button" href="">수정하기</a>
			 <a class="btn btn-dark" type="button" href="board?cmd=bdeleteform-page&article_id=<%=rec.getArticleId()%>">삭제하기</a>
		</td>
	</tr>
	</table>
</div>

</body>
</html>