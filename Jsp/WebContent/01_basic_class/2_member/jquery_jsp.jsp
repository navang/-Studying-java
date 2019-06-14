<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
	// 1. 드라이버 로딩
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url_1 = "jdbc:oracle:thin:@192.168.0.95:1521:orcl";
	String user = "myteam";
	String pass = "1234";
	// 2. 연결객체 얻어오기
	Connection con =  DriverManager.getConnection(url_1,user,pass);
	
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String url = request.getParameter("website");
    String password = request.getParameter("password");
    
	// 3. sql 문장 만들기
	String sql = "INSERT INTO signup (name, email , url, password) "
			+ "VALUES(?,?,?,?)";
	// 4. 전송 객체 얻어오기
	PreparedStatement st = con.prepareStatement(sql);
	st.setString(1, name);
	st.setString(2, email);
	st.setString(3, url);
	st.setString(4, password);
	// 5. 전송
	ResultSet rs= st.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%st.close();
		con.close();

		%>
        <h2> 정보확인 </h2>
         <form action="updateMember.jsp" method="post"  >
          <div>
            <label for="name">이름:</label>
            <input name="name" id="name" type="text" value="<%=name%>" readonly/>
          </div>
          <div>
            <label for="email">이메일:</label>
            <input name="email" id="email" type="text" value="<%=email%>"/>
          </div>
          <div>
            <label for="website">웹사이트 URL:</label>
            <input name="website" id="website" type="text" value="<%=url%>"/>
          </div>
          <div>
            <label for="password">암호:</label>
            <input name="password" id="password" type="password" value="<%=password%>"/>
          </div>
    
   <div>
           <input type="submit" value="수정하기" />
        </div>
       </form>
	

</body>
</html>