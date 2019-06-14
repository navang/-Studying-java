<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<%@ page errorPage="02_NormalErrorPage.jsp"  %>
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
	String sql = "UPDATE signup SET email =?, url= ?, password=?  WHERE name= ?";
	// 4. 전송 객체 얻어오기
	PreparedStatement st = con.prepareStatement(sql);
	st.setString(1, email);
	st.setString(2, url);
	st.setString(3, password);
	st.setString(4, name);
	// 5. 전송
	int result = st.executeUpdate();
	
	st.close();
	con.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateMember.jsp</title>
</head>
<body>


        <h2> 수정되었습니다. </h2>
        

</body>
</html>