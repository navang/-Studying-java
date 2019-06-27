<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
 <%@ page import="mybatis.guest.model.Comment" %>    
 <%@ page import="mybatis.guest.service.CommentService" %>   
  
  <% 
  long commentNo = Integer.parseInt( request.getParameter("cId"));
  Comment comment = CommentService.getInstance().selectCommentByPrimaryKey(commentNo);
  %>
 <%
 CommentService.getInstance().deleteComment(comment);
 %>
        
    
  <!--  
  		1.IMPORT
  		2.이전화면에서 넘어오는 cId값 얻어오기
  		3. service에 함수호출 
		  
   -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteComment</title>
</head>
<body>\

삭제되었는지 확인해보세요. <br/>
<a href="listComment.jsp">목록보기</a>

</body>
</html>