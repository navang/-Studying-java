package emp.oracle2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest2 {
public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.145:1521:orcl";
		String user = "scott";
		String pass = "tiger";
		
		Connection con =null;
		try {
		// 1. 드라이버를  메모리에 로딩
		Class.forName(driver);
		// 2. 연결객체얻어오기
		con = DriverManager.getConnection(url, user, pass );
		System.out.println("연결성공");
		}catch(Exception ex) {
			System.out.println("연결실패:" + ex.getMessage());
		}
		
		// 3. SQL 문장만들기
		// 4. SQL 전송객체 만들기
		// 5. SQL 전송하기
		// 6. SQL 닫기
		
		try { // 사원테이블의 총 사원수와 월급의 평균을 출력하세요 
		
			
			
			String sql = "SELECT count(*) as cnt, round(avg(sal), 0) as sala FROM emp";
 			PreparedStatement st = con.prepareStatement(sql); //-- sql 지정 
			
			ResultSet rs = st.executeQuery(); //-- sql 지정 ㄴㄴ 
			if(rs.next()) {
				System.out.println(rs.getInt("cnt") + "/"
								+ rs.getInt("sala"));
			}
			st.close();
			con.close();
			
		}catch(SQLException ex) {
			System.out.println("전송실패:" + ex.getMessage());
			
		}
		

	}

}
