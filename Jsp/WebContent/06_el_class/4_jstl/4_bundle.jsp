<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>

<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 
<%@ taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>

<fmt:setLocale value='sp'/> 
<fmt:bundle basename="resource.message">
<fmt:message key='TITLE' var='title'></fmt:message>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1><fmt:message key='GREETING'/></h1>

</body>
</html>

</fmt:bundle>