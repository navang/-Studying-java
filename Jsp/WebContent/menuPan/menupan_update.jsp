<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ page import="product.model.*,product.service.*" %>   
<%@ page import="java.util.List" %>   
    
<%
	// 0. �Ѱܹ޴� ����Ÿ�� �ѱ� ó��
	 request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="m" class="product.model.ProductRec">
	<jsp:setProperty name='m' property="*"/>
</jsp:useBean>

<%
	// 2. Service�� update() ȣ���Ͽ� ���ڵ� ����
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
           <h1>����?</h1>
           <h1>a</h1>
           <h1>a</h1>
           <h1>s</h1>
       </div>
</body>
</html>