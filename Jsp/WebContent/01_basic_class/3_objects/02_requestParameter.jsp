<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Map" %>
<%
	request.setCharacterEncoding("utf-8");

%>
<!DOCTYPE html>
<html>
<head><title>요청 파라미터 출력</title></head>
<body>
<h5> 방법 1 이전 화면에서 사용자의 입력값을 출력 </h5>
이름 = <%= request.getParameter("name") %>
주소 : <%= request.getParameter("address") %>
좋아하는 동물 :  <%=
for() request.getParameterValues("pet") %>

<h5> 방법 2 </h5>



<h5> 방법 3 </h5>


</body>
</html>
