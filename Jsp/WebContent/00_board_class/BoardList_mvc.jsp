<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.*, board.service.*" %>
<%@ page import="java.util.*" %>

<%
	// Control에서 param을 넘겨받아 mList 변수에 지정
	List <BoardRec> mList = (List <BoardRec>)request.getAttribute("param");  
	
%>    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 게시글 목록 </title>
</head>

<BODY>

   <h3> 게시판 목록 </h3>
   
   <table border="1" bordercolor="darkblue">
   <tr>
      <td> 글번호 </td>
      <td> 제 목 </td>
      <td> 작성자 </td>
      <td> 작성일 </td>
      <td> 조회수 </td>
   </tr>
   

   <% if( mList.isEmpty() ) { %>
      <tr><td colspan="5"> 등록된 게시물이 없습니다. </td></tr>
   <% } else { %>
   <%for(int i=0; i<mList.size(); i++){ //arrayList의 length는 size()를 씀  
      BoardRec rec= mList.get(i); //mList의 값들을 get()을 활용해서 뽑아 rec에 담음
                                            //get()은 object타입으로 출력된걸 rec에 담음
   %>     
      <tr>
         <td><%=rec.getArticleId() %></td>
         <td>
         	<% for(int f=0; f<rec.getLevel(); f++){%>
         	&nbsp;
         	<%} %> <!--level리턴값에 따라 공백을 준다 -->
         	<% if(rec.getLevel() >0){ %>
         		<img alt='' src='./imgs/board_re.gif'>
         	<% }%>
      
         	<a href="board?cmd=bview-do&article_id=<%=rec.getArticleId()%>"><%=rec.getTitle() %></a>
         	<!-- 제목클릭시 위 링크로 가고 article_id를 가져옴  -->
         </td>
         <td><%=rec.getWriterName() %></td>      
         <td><%=rec.getPostingDate() %></td>
         <td><%=rec.getReadCount() %></td>
      </tr>
   <% } // end for %>
   <% } // end else %>
   
      <tr>
         <td colspan="5">
            <a href="BoardInputForm_mvc.jsp">글쓰기</a>
           
         </td>
      </tr>
   </table>
</BODY>
</HTML>