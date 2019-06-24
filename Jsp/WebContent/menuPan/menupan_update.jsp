<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ page import="product.model.*,product.service.*" %>   
<%@ page import="java.util.List" %>   
    
<%
	// 0. 넘겨받는 데이타의 한글 처리
	 request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="m" class="product.model.ProductRec">
	<jsp:setProperty name='m' property="*"/>
</jsp:useBean>

<%
	// 2. Service에 update() 호출하여 레코드 수정
	UpdateProductService service=UpdateProductService.getInstance();
	int result= service.update(m);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

       <div>
           <h1>성공?</h1>
           <h1>a</h1>
           <h1>a</h1>
           <h1>s</h1>
       </div>
</body>
</html>