package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.CustomerDao;
import model.vo.Customer;

public class CustomerModel implements CustomerDao{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.116:1521:orcl";
	String user = "heroes";
	String pass = "1004";

	
	
	public CustomerModel() throws Exception{
	 	// 1. 드라이버로딩
		OracleCon.getInstance();
	}
	
	public void insertCustomer(Customer vo) throws Exception{
		// 2. Connection 연결객체 얻어오기
		Connection con = DriverManager.getConnection(url, user, pass);
		
		String name= vo.getCustName();
		String tel=vo.getCustTel1();
		String a_tel =vo.getCustTel2();
		String addr =vo.getCustAddr();
		String email = vo.getCustEmail();
		
		// 3. sql 문장 만들기
		String sql = "INSERT INTO MEMBER (name, tel , a_tel, addr, email) "
				+ "VALUES(?,?,?,?,?)";
		// 4. sql 전송객체 (PreparedStatement)	
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, name);
		st.setString(2, tel);
		st.setString(3, a_tel);
		st.setString(4, addr);
		st.setString(5, email);

		// 5. sql 전송
		int result = st.executeUpdate();
		// 6. 닫기 
		st.close();
		con.close();

		System.out.println(result + "회원정보 입력완료");
	}
	
	public Customer selectByTel(String tel) throws Exception{
		
		Customer dao = new Customer();
		Connection con = null;
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//2.연결객체 얻어오기
			con = DriverManager.getConnection(url,user,pass);
			//3.SQL 문장 만들기 (*****)
			String sql = "SELECT * FROM MEMBER WHERE trim(tel) = ?";
			//4.SQL 전송객체 얻어오기 
			st = con.prepareStatement(sql);
			st.setString(1, tel);
			//5.sql 전송 
			rs = st.executeQuery();

			//6.결과처리

			if(rs.next()) {
				dao.setCustName(rs.getString("NAME"));
				dao.setCustTel1(rs.getString("TEL"));
				dao.setCustTel2(rs.getString("A_TEL"));
				dao.setCustAddr(rs.getString("ADDR"));
				dao.setCustEmail(rs.getString("EMAIL"));
			}
			return dao;
		}finally {
			//7.닫기
			rs.close();
			st.close();
			con.close();
		}		
	}
public Customer selectByName(String name) throws Exception{
		
		Customer dao = new Customer();
		Connection con = null;
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//2.연결객체 얻어오기
			con = DriverManager.getConnection(url,user,pass);
			//3.SQL 문장 만들기 (*****)
			String sql = "SELECT * FROM MEMBER WHERE trim(name) = ?";
			//4.SQL 전송객체 얻어오기 
			st = con.prepareStatement(sql);
			st.setString(1, name);
			//5.sql 전송 
			rs = st.executeQuery();

			//6.결과처리

			if(rs.next()) {
				dao.setCustName(rs.getString("NAME"));
				dao.setCustTel1(rs.getString("TEL"));
				dao.setCustTel2(rs.getString("A_TEL"));
				dao.setCustAddr(rs.getString("ADDR"));
				dao.setCustEmail(rs.getString("EMAIL"));
			}
			return dao;
		}finally {
			//7.닫기
			rs.close();
			st.close();
			con.close();
		}		
	}
	
	public int updateCustomer(Customer vo) throws Exception{
		// 2. 연결객체 얻어오기  
				Connection con = DriverManager.getConnection(url, user, pass);
				//3.SQL 문장 만들기 (*****)

				String name= vo.getCustName();
				String tel=vo.getCustTel1();
				String a_tel =vo.getCustTel2();
				String addr =vo.getCustAddr();
				String email = vo.getCustEmail();

				String sql = "UPDATE MEMBER SET NAME = ? , TEL = ?,  ADDR = ? , EMAIL= ? WHERE TEL = ? ";
				//4.SQL 전송객체 얻어오기 
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, name);
				st.setString(2, a_tel);
				st.setString(3, addr);
				st.setString(4, email);
				st.setString(5, tel);
				//5.sql 전송 
				int result = st.executeUpdate();
				
				//6.결과처리 try {} catcch() {}
				//7.닫기
				st.close();
				con.close();
				
				System.out.println(result + "db 수정완료");
				
				
	//	int result = 0;
		
		
		return result;
	}
	
}
