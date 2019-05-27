package empmodel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

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
	public void  deleteCntFood(ArrayList aMenu, ArrayList aCnt) throws Exception{

		// 인자를 풀어서 FCNT, FNAME 에 저장 

		Connection con =  DriverManager.getConnection(url,user,pass);
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList COUNT =new ArrayList();
		// 2 연결객체 		

		// 3 sql 문장  
		String sql = "UPDATE FOOD SET CNT = CNT-? "
				+ " WHERE FNAME = ?";
		System.out.println(sql+">");
		//4 sql 전송객체 얻어오기 

		for(int i=0; i<aMenu.size(); i++) {
			String FNAME = aMenu.get(i).toString();
			String CNT = aCnt.get(i).toString();			
			System.out.println(FNAME+">"+CNT);
			st = con.prepareStatement(sql);
			st.setString(1, CNT );
			st.setString(2, FNAME );

			st.executeUpdate();
		}

		//5 sql 전송( executeQuery() ) 

	

	}

	// 검색, jtable 출력 
	@Override
	public ArrayList selectAllFood() throws Exception {

		String [] cols = {"FNAME","FPRICE", "CNT"};
		Connection con =  DriverManager.getConnection(url,user,pass);
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList list =new ArrayList();
		// 2 연결객체 


		// 3 sql 문장  SELECT * FROM 테이블명 WHERE 감독 LIKE '%봉%'
		String sql = "SELECT FNAME , FPRICE , CNT FROM FOOD";
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
			data.add(rs.getInt("FPRICE"));
			data.add(rs.getInt("CNT"));


			// 나머지도
			list.add(data);
		}
		return list;
	}


}


