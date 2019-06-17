<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import = "info.beans.InfoBean" %>  <!--  확장자명은 쓸필요 없음 -->
   
<!--  아래와 같은 기능  -->
      <% request.setCharacterEncoding("utf-8"); %> <!--  post를 쓰면서 캐릭터 변경  -->
   <jsp:useBean id = "bean" class ="info.beans.InfoBean">
   <!-- InfoBean bean = new InfoBean();-->
      <jsp:setProperty name ="bean" property="*"/>
      <!--  String name = request.getParameter("name");
            bean.setName(name);
      -->
   </jsp:useBean>

<html>
<body>
   <h2>  당신의 신상명세서 확인 </h2>
   이   름  : <%= bean.getName() %><br/>
   주민번호 : <jsp:getProperty property="id"  name ="bean" /><br/>   <!--  property는 해당 변수명, name은 usebean 선언에서 지정한 id값 -->
   성  별   : <jsp:getProperty property="gender" name="bean"/><br/>  
   맞습니까????
</body>
</html>