<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
       String projectName ="/Jsp";   //앵간하면 프로젝트 url을 변수로 잡아서 활용하는게 좋음 
                                                 //경로변경이 생기면 변수만 바꾸면됨
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   기존 모델 1 방식으로 연결
   <a href= "<%=projectName%>/05_mvc_class/1_mvcSimple/simpleView.jsp">기존방식</a>
   </hr>
   
   mvc방식으로 연결
   <a href="<%=projectName%>/xxxxxx.ksm">mvc요청</a><br/>
   <a href="<%=projectName%>/SimpleControl?type=first">mvc요청2</a><br/>
   <a href="<%=projectName%>/simple">mvc요청3</a><br/>
   

</body>
