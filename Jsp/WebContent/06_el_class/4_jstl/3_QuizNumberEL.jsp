<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 

<!-- 0. JSTL 설정 -->



<!DOCTYPE html>
<html>
<head>
<title> 1~100까지 중 숫자 맞추기 </title>
</head>
<body>



<!-- 1. 이전화면 값 얻어와 guess 변수에 지정 -->
<c:set var='guess' value='${param.guess }'></c:set> 
<!-- 2. 그 값이 없다면 임의의 수를 만들어 세션에 지정 (처음이란 뜻)-->
<c:if test="${guess eq null }">
<%
int tNum=0;
Random rnum = new Random();
tNum = rnum.nextInt(100);
session.setAttribute("answer", tNum );
%>
맞춰야 하는 값 : <%= tNum%>

<!-- 3. 세션의 값을 가져와 answer 변수에 지정 -->
<!-- 4. guess의 변수에 값이 있다면 -->
<!--  (1) guess와 answer값이 같다면 맞춰다고 출력 -->
<!--  (2) 다르다면 guess값이 answer값보다 크면 크다고 출력 작으면 작다고 출력 -->
<c:set var='answer' value='${sessionScope.answer }'></c:set>
	</c:if>
<c:if test="${guess ne null }">
	<c:choose>
		<c:when test="${guess eq answer }">정답입니다~~
	</c:when>
		<c:when test="${guess lt answer }">더 큰 수를 생각하세요
	</c:when>
		<c:when test="${guess gt answer }">더 작은 수를 생각하세요
	</c:when>
		<c:otherwise >1~100사이의 수를 입력하세요</c:otherwise>
	</c:choose>

</c:if>




	<hr><hr>
	1부터 100까지 수 중에서 하나를 잘 찍으시오~!! <br/>
	
	<form method='get'>
			어떤 수일까요?
			<input type='text' name='guess'>
			<input type='submit' value="Submit">
	</form>
</body>
</html>