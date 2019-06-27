<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 변수선언 -->
<c:set var='gender' value='male'/>

<!-- 조건문 -->
<c:if test="${gender eq 'male' }">남자</c:if>       <!--  동등 연산자        == eq   -->
<c:if test="${gender eq 'female' }">여자</c:if>
<!--  age 변수선언  -->
<c:set var='age' value='12' ></c:set>

<c:choose>
<c:when test="${age le '10' }">어린이입니다</c:when>
<c:when test="${ age lt '20' and  age gt '10'  }">청소년입니다</c:when>
<c:otherwise>성인입니다</c:otherwise>
</c:choose>

<c:set var='sum' value='0'></c:set>
<c:forEach var='i' begin='1' end='100'>
	<c:set var='sum' value='${sum+i}'/>
</c:forEach>
<hr/>
1~100 의 합 : ${sum } <br/>
<!-- 1~100 홀수의 합과 짝수의 합 출력 -->

<c:forEach var='i' begin='1' end='100' step='2'>
<c:set var='odd' value='${odd+i}'/>	
</c:forEach>

<c:forEach var='i' begin='0' end='100' step='2'>
<c:set var='even' value='${even+i}'/>
</c:forEach>
<hr/>
1~100 의 짝수의 합 : ${even } <br/>
1~100 의 홀수의 합 : ${odd } <br/>


</body>
</html>