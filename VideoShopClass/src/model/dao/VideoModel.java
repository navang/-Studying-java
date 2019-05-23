package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.VideoDao;
import model.vo.Video;

public class VideoModel implements VideoDao{

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.116:1521:orcl";
	String user = "heroes";
	String pass = "1004";

	public VideoModel() throws Exception{


		// 1. 드라이버로딩

		//Class.forName(driver);
		OracleCon.getInstance();

	}

    //입고 
	public void insertVideo(Video vo, int count) throws Exception{
		// 2. Connection 연결객체 얻어오기
		Connection con = DriverManager.getConnection(url, user, pass);
		int VID = vo.getVideoNo();
		String GENRE = vo.getGenre();
		String TITLE = vo.getVideoName();
		String DIR = vo.getDirector();
		String ACT = vo.getActor();
		String DES =vo.getExp();


		// 3. sql 문장 만들기
		String sql = "INSERT INTO VIDEO ( VID , GENRE, TITLE, DIR, ACT, DES) "
				+ " VALUES (video_se.nextval, ?, ?, ?, ?, ?) ";
		// 4. sql 전송객체 (PreparedStatement)	
		PreparedStatement st= con.prepareStatement(sql);
		//st.setInt(1, VID);
		st.setString(1, GENRE);
		st.setString(2, TITLE);
		st.setString(3, DIR);
		st.setString(4, ACT);
		st.setString(5, DES);
		
		// 5. sql 전송
		for(int i=0; i< count ; i++) { // 개수만큼 
		
			int result =st.executeUpdate();

		}
		// 6. 닫기

		st.close();
		con.close();
	}
	
	public ArrayList searchVideo(int sel, String word) throws Exception {

		String [] cols = {"TITLE","DIR"};
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList list =new ArrayList();
		// 2 연결객체 
		con = DriverManager.getConnection(url,user,pass);

			// 3 sql 문장  SELECT * FROM 테이블명 WHERE 감독 LIKE '%봉%'
			String sql = "SELECT VID, TITLE, GENRE, DIR, ACT, DES FROM VIDEO "
					+ " WHERE " + cols[sel] + " LIKE '%" + word + "%' " ;
			System.out.println(sql);

			

			//4 sql 전송객체 얻어오기 
			st = con.prepareStatement(sql);
			//5 sql 전송( executeQuery() ) 
			rs = st.executeQuery();
			//6 결과처리 
			while (rs.next()) {
			ArrayList data = new ArrayList();
			
				
				// data에 각 컬럼에서 얻어온 값을 추가 
				data.add(rs.getInt("VID"));
				data.add(rs.getString("TITLE"));
				data.add(rs.getString("GENRE"));
				data.add(rs.getString("DIR"));
				data.add(rs.getString("ACT"));
				
				// 나머지도
				list.add(data);
				}
			
			
return list;
	}


	public Video selectByPK(int vNum) {

		return null;
	}


}