package empmodel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import empmodel.vo.emp;
import empmodel.vo.emp.Menu;
import model.MenuDao;

public class empModel implements MenuDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.116:1521:orcl";
	String user = "heroes";
	String pass = "1004";


	public empModel() throws Exception{
		OracleCon.getInstance();
	}
	//  결제시 db 에서 차감 
	/*
	public  void deleteCntFood(emp.Menu vo) throws Exception{
		
		// 2. Connection 연결객체 얻어오기
		Connection con = DriverManager.getConnection(url, user, pass);
		
		String FNAME = vo.getFood();
		int FPRICE = vo.getFprice();
		int CNT = vo.getFcnt();
		
		// 3. sql 문장 만들기
		String sql = "UPDATE INTO FOOD ( FNAME, FPRICE, CNT) "
				+ " VALUES ( ?, ?, ?) ";
		// 4. sql 전송객체 (PreparedStatement)	
		PreparedStatement st= con.prepareStatement(sql);
		
		st.setString(1, FNAME);
		st.setInt(2,  FPRICE);
		st.setInt(3,  CNT);
						
		// 5. sql 전송
		
			int result =st.executeUpdate();

		// 6. 닫기

		st.close();
		con.close();
	}
*/
// 검색, jtable 출력 
	@Override
	public ArrayList selectAllFood(String food, int fcnt) throws Exception {

		String [] cols = {"FNAME","CNT"};
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList list =new ArrayList();
		// 2 연결객체 
		con = DriverManager.getConnection(url,user,pass);

			// 3 sql 문장  SELECT * FROM 테이블명 WHERE 감독 LIKE '%봉%'
			String sql = "SELECT FNAME , CNT FROM FOOD";
			System.out.println(sql);
			//4 sql 전송객체 얻어오기 
			st = con.prepareStatement(sql);
			//5 sql 전송( executeQuery() ) 
			rs = st.executeQuery();
			//6 결과처리 
			while (rs.next()) {
			ArrayList data = new ArrayList();			
				
			// data에 각 컬럼에서 얻어온 값을 추가 
				data.add(rs.getString("FNAME"));
				data.add(rs.getInt("CNT"));
				
				// 나머지도
				list.add(data);
				}
		return null;
	}

	


	}
	

