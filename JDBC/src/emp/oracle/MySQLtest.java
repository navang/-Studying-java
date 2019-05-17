package emp.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLtest {
	public static void main(String[] args) {


		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://192.168.0.145:3306/test?serverTimezone=UTC&useSSL=false"; //timezone 픽스 
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
			String sql = "INSERT INTO temp (ename, mgr, sal, deptno)"
					+ "VALUES ('thefirstone' , 100, 1000, 90)";

			Statement st = con.createStatement();



			// 5. 전송하기
			// 6 . 닫기
			st.executeUpdate(sql);


			st.close();
			con.close();
			System.out.println("입력성공");

		}catch(SQLException ex) {
			System.out.println("전송실패:" + ex.getMessage());

		}


	}

}
