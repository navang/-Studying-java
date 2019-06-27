<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.service.*, board.model.*" %>
<%

String article_id= request.getParameter("article_id");

%>      
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 게시글 삭제하기 </title>
<script type="text/javascript">
function checkFields()
{	var frmObj = document.frm;

frmObj.action = "board?cmd=bdelete-page";
frmObj.submit();

}

</script>
</head>
<body>

<form method="post" name='frm'>
	삭제할 글암호를 입력하세요 <br/>
	<input type="password" name="password">
	<!-- 게시글번호를 다음 페이지로 넘기기 위해 hidden 태그로 지정 -->
	<input type="hidden" name='article_id' value='<%=article_id %>' >
	<input type="button" value="삭제하기" onclick="Javascript:checkFields()">
</form>

</body>
</html>