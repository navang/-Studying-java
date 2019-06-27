<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String projectName = "/Jsp"; %>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>BoardMain</title>
</head>
<body>


<a href="<%= projectName %>/board?cmd=binput-page">게시글쓰기</a>
<hr/>
<a href ='BoardView.jsp?article_id=10'>글로 바로가기</a>
<hr/>
<a href="<%= projectName %>/board?cmd=blist-page">목록보기</a>

</body>
</html>