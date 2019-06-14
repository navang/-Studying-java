<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%!
 	String msg = "아라라라라랄";
 %>
     <%!
 	String name = "홍길동";
 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<% if(name.equals("홍길동")) { %>
		이 름 : <%= name %>
		<% } else { %>
		할 일 : <%= msg %><hr/>
		<% } %>
</body>
</html>