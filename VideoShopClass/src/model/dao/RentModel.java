package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.RentDao;


public class RentModel implements RentDao {
	

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.116:1521:orcl";
	String user = "heroes";
	String pass = "1004";

	
	Connection con;
	
	public RentModel() throws Exception{

		// 1. 드라이버를  메모리에 로딩
		OracleCon.getInstance();
				
	}
	//대여 메소드
	public void rentVideo(String tel, int vNum) throws Exception{
		// 2. 연결객체 얻어오기  
				Connection con = DriverManager.getConnection(url, user, pass);
				String TEL = tel;
				int VID = vNum;
				
				// 3  sql 문장
		String sql = "INSERT INTO RENT (RENTID , TEL, VID, RENT_DATE)"
									// 대여번호, 전화번호, 비디오번호, 대여일, 대여여부
				+ " VALUES (RENT_SE.NEXTVAL, ? , ?, sysdate) ";
		// 4 전송객체
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1, TEL);
		st.setInt(2, VID);
		
		// 5 전송
		int result = st.executeUpdate();
		
		// 6 닫기		
		st.close();
		con.close();
	}
	
	// 반납 메소드
	public 	int	returnVideo(int vNum) throws Exception{
		int result=0;
		
		String sql = "UPDATE 대여테이블명 SET 반납일 = SYSDATE, 반납여부= 'N' "
				+ " WHERE 비디오번호 =? AND  반납여부= 'N' ";
		
		return result;
	}
	
	// 미납정보 검색 메소드 
	public ArrayList selectList() throws Exception{
		ArrayList list = new ArrayList();
		
		String sql = "";
		// SELECT  비디오번호, 제목, 고객명, 전화번호, 반납예정일( 오늘_대여일 + 3일), 반납여부 
		// FROM  대여테이블 r 
		// INNER JOIN 비디오테이블v 
		// INNER JOIN 고객테이블 c
		// ON r.vid = v.vid AND r.tel = c.tel 
		
		
		
		return list; // 보이기만 할거니 인자가 필요없다
		
	}


	
}
