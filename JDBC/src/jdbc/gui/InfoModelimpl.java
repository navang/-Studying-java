package jdbc.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InfoModelimpl {


	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.145:1521:orcl";
	String user = "scott";
	String pass = "tiger";


	// 드라이버로딩
	// 연결객체얻어ㅗ기 

	public InfoModelimpl() throws Exception{

		// 1. 드라이버를  메모리에 로딩
		Class.forName(driver);
	}
	public void insert(InfoVO vo) throws Exception{

		// 2. 연결객체 얻어오기  
		Connection con = DriverManager.getConnection(url, user, pass);
		
		String iname=vo.getName();
		String iid= vo.getId();
		String itel =vo.getTel();
		String isex =vo.getGender();
		int iage = vo.getAge();
		String ihome = vo.getHome();	
		//3.SQL 문장 만들기 (*****)
		
		String sql = "INSERT INTO infoview (iname, iid , itel, isex, iage, ihome) "
				+ "VALUES(?,?,?,?,?,?)";

		//String sql = "UPDATE  infoview SET iname =?, iid =?, itel =?, isex =? ,iage =?, ihome=? ";
		//4.SQL 전송객체 얻어오기 
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, iname);
		st.setString(2, iid);
		st.setString(3, itel);
		st.setString(4, isex);
		st.setInt(5, iage);
		st.setString(6, ihome);
		//5.sql 전송 
		int result = st.executeUpdate();
		//6.결과처리 try {} catcch() {}
		//7.닫기
		st.close();
		con.close();

		System.out.println(result + "db 입력완료");


		/*
		 * 2.연결객체 얻어오기
			3.SQL 문장 만들기 (*****)

			4.SQL 전송객체 얻어오기 

			5.sql 전송 


			6.결과처리
			7.닫기

		 */
	}
	public void update(InfoVO vo) throws Exception{

		// 2. 연결객체 얻어오기  
		Connection con = DriverManager.getConnection(url, user, pass);
		//3.SQL 문장 만들기 (*****)

		String iname=vo.getName();
		String iid= vo.getId();
		String itel =vo.getTel();
		String isex =vo.getGender();
		int iage = vo.getAge();
		String ihome = vo.getHome();	


		String sql = "INSERT INTO  infoview ( iname, iid, itel, isex ,iage, ihome) VALUES(?,?,?,?,?,?)";
		//4.SQL 전송객체 얻어오기 
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, iname);
		st.setString(2, iid);
		st.setString(3, itel);
		st.setString(4, isex);
		st.setInt(5, iage);
		st.setString(6, ihome);
		//5.sql 전송 
		int result = st.executeUpdate();
		
		//6.결과처리 try {} catcch() {}
		//7.닫기
		st.close();
		con.close();
		
		System.out.println(result + "db 수정완료");
		
	}	
	public InfoVO deleteData(String tel) throws Exception {
		InfoVO vo = new InfoVO();
		Connection con = null
				;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//2.연결객체 얻어오기
			con = DriverManager.getConnection(url,user,pass);
			//3.SQL 문장 만들기 (*****)
			String sql = "DELETE FROM infoview WHERE itel = ?";
			//4.SQL 전송객체 얻어오기 
			st = con.prepareStatement(sql);
			st.setString(1, tel);
			//5.sql 전송 
			rs = st.executeQuery();

			//6.결과처리
		}finally {

			//7.닫기
			rs.close();
			st.close();
			con.close();
		}
		return vo;
	}
	// 모든값 보기 
	public ArrayList<InfoVO> selectAll () throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//2.연결객체 얻어오기
			con = DriverManager.getConnection(url,user,pass);
			//3.SQL 문장 만들기 (*****)
			String sql = "SELECT * FROM infoview";
			//4.SQL 전송객체 얻어오기 
			st = con.prepareStatement(sql);

			//5.sql 전송 
			rs = st.executeQuery();

			//6.결과처리
			ArrayList<InfoVO> list = new ArrayList<InfoVO>();
			while (rs.next()) {

				InfoVO vo = new InfoVO();
				vo.setName(rs.getString("iname"));
				vo.setId(rs.getString("iid"));
				vo.setTel(rs.getString("itel"));
				vo.setGender(rs.getString("isex"));
				vo.setAge(rs.getInt("iage"));
				vo.setHome(rs.getString("ihome"));
				list.add(vo);
			}
			return list;
		}finally {
			//7.닫기
			rs.close();
			st.close();
			con.close();
		}
	}

	// tel로 검색하여 모든 값 tf 로보기 
	public InfoVO selectByTel(String tel) throws Exception {
		InfoVO vo = new InfoVO();
		Connection con = null
				;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//2.연결객체 얻어오기
			con = DriverManager.getConnection(url,user,pass);
			//3.SQL 문장 만들기 (*****)
			String sql = "SELECT * FROM infoview WHERE itel = ?";
			//4.SQL 전송객체 얻어오기 
			st = con.prepareStatement(sql);
			st.setString(1, tel);
			//5.sql 전송 
			rs = st.executeQuery();

			//6.결과처리

			if(rs.next()) {
				vo.setName(rs.getString("iname"));
				vo.setId(rs.getString("iid"));
				vo.setTel(rs.getString("itel"));
				vo.setGender(rs.getString("isex"));
				vo.setAge(rs.getInt("iage"));
				vo.setHome(rs.getString("ihome"));

			}
			return vo;
		}finally {
			//7.닫기
			rs.close();
			st.close();
			con.close();
		}
	}
	// Id로 검색하여 모든 값 tf 로보기 
	public InfoVO selectById(String id) throws Exception{
		InfoVO vo = new InfoVO();
		Connection con = null
				;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//2.연결객체 얻어오기
			con = DriverManager.getConnection(url,user,pass);
			//3.SQL 문장 만들기 (*****)
			String sql = "SELECT * FROM infoview WHERE TRIM(iid) = ?";
			//4.SQL 전송객체 얻어오기 
			st = con.prepareStatement(sql);
			st.setString(1, id);
			//5.sql 전송 
			rs = st.executeQuery();

			//6.결과처리

			if(rs.next()) {
				vo.setName(rs.getString("iname"));
				vo.setId(rs.getString("iid"));
				vo.setTel(rs.getString("itel"));
				vo.setGender(rs.getString("isex"));
				vo.setAge(rs.getInt("iage"));
				vo.setHome(rs.getString("ihome"));

			}
			return vo;
		}finally {
			//7.닫기
			rs.close();
			st.close();
			con.close();
		}


	}

}





