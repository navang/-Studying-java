<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title> 데이타 받는 페이지 </title>
</head>
<body>

<!-- request.getParameter("") -->
전 페이지의 값 :  ${param.data }<br/> 
<!-- session.getAttribute("")-->
세션의 값 : ${sessionScope.login } <br/> <!-- 기존 JSP에서 session 이름을 쓰고 있기때문에 sessionScope -->
<!-- Cookie[] c= request.getCookies()-->
쿠키의 값 :	 ${cookie.isFlag.value} <br/>


<hr>


</body>
</html>