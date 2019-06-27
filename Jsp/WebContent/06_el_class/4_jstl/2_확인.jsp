<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    
<%@ page import ='member.beans.Member' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHECK</title>
</head>
<body>

1. JAVA 객체 <br/>

<%
	Member m = new Member();
	m.setName("홍길자");
	m.setAddr("한국");
%>
이름 : <%= m.getName() %> / 주소 : <%= m.getAddr() %> <br/>
이름 : ${m.name } / 주소 : ${m.addr }<br/> <hr/>

2. c:set 변수 지정 <br/>
<c:set var='m2' value='<%=m%>'></c:set>
이름 : ${m2.name } / 주소 : ${m2.addr }<br/> <hr/>

</body>
</html>