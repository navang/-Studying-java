package emp.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.95:1521:orcl";
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
		
		try {
			String sql = "SELECT * FROM emp";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("EMPNO")+ "/"
								+ rs.getString("ENAME") + "/"
								+ rs.getInt("SAL"));
			}
			
			st.close();
			con.close();
		
			
		}catch(SQLException ex) {
			System.out.println("전송실패:" + ex.getMessage());
			
		}
		

	}

}
