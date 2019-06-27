<%@ page language="java" contentType="text/html; charset=utf-8"%>
 <%@ page import="mybatis.guest.model.Comment" %>   
 <%@ page import="mybatis.guest.service.CommentService" %>   
  
      
  <!-- 키에 해당하는 글번호를 넘겨받아 서비스의 메소드 호출  -->
  <% 
  long commentNo = Integer.parseInt( request.getParameter("cId"));
  Comment comment = CommentService.getInstance().selectCommentByPrimaryKey(commentNo);
  %>
     
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
<title> 메세지 보기 </title>
<script type="text/javascript">
window.onload = function(){
// 	function deleteComment(){
// 		var Dfrm = document.frm;
<%-- 		Dfrm.action ="deleteComment.jsp?cId=<%=comment.getCommentNo()%>"; --%>
// 		}
	
// 	function modifyComment(){
// 		var Dfrm = document.frm;
<%-- 		Dfrm.action =modifyComment.jsp?cId=<%=comment.getCommentNo()%>"; --%>
// 		}
	
	document.getElementById("btnDelete").onclick =function(){
		window.location.href = "deleteComment.jsp?cId=<%=comment.getCommentNo()%>"; 
	}

}
</script>
</head>
<body>
<form name='frm' action='updateComment.jsp' method='get'>
<input type='hidden' name="commentNo" value='<%=  comment.getCommentNo()%>'>
<table border="1">
		<tr><td>글번호</td><td></td></tr>
		<tr><td>작성자</td><td><input name="userId" value='<%=  comment.getUserId()%>' ></input></td></tr>
		<tr><td>메세지</td><td><input name="commentContent" value='<%=  comment.getCommentContent()%>'></input></td></tr>
		<tr><td>등록일</td><td name="regDate" ><%=  comment.getRegDate()%></td></tr>
		<tr><td colspan="2">
				<input type="submit" id="btnModify" value="수정" />
				<input type="button" id="btnDelete" value="삭제" />
				</td></tr>
				
</table>
</form>
<a href="listComment.jsp">목록보기</a>

</body>
</html>