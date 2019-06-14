<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%  
    	request.setCharacterEncoding("UTF-8");
     
    	String name = request.getParameter("name");
    	String gender = request.getParameter("gender");
    	String job = request.getParameter("occupation");
    	String []hobby = request.getParameterValues("hobby");
		String hobbystr = "";
		if( hobby != null){
		for(String h : hobby){
			hobbystr += h + "/";
			}
		}
    	%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		이름 : <% out.println(name); %>
		성별 : <% out.println(gender); %>
		직업 : <% out.println(job); %>
		취미 : <%= hobbystr %>
		
</body>
</html>