<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%	// 1. 이전 화면에서 넘겨받은 데이타
	String cate = request.getParameter("cate");
	String name = request.getParameter("name");
	
	// 2. 다시 화면으로 보낼 데이터 구성
	String result ="";
	result += "{";
	result += "'first' : '서버에서"+ cate + "',"; // '서버에서book'
	result += "'second' : '" + name +"변경'"; // 'hong변경'
	result += "}";
	
	
	out.write(result);
	
%>    
