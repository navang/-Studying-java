package emp.oracle2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.145:1521:orcl";
		String user = "scott";
		String pass = "tiger";

		Connection con = null;

		try {
			// 1. 드라이버를 메모리에 로딩
			Class.forName(driver);
			// 2. 연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("연결성공");
		} catch (Exception ex) {
			System.out.println("연결실패:" + ex.getMessage());
		}

		// 3. SQL 문장만들기 ( 어려움.. )
		// 4. SQL 전송객체 만들기
		// 5. 전송하기
		// 6. 닫기
		try {
			int empno = 6789;
			String ename = "혹숙자";
			int sal = 12000; 
			int deptno = 20;
			String job= "개발"; 
			
			String sql= "UPDATE emp SET ename=?, sal=? , deptno=? , job=? "
					+ " WHERE empno=?";
					 
			
			// String sql = "UPDATE emp SET sal=60000 WHERE empno=8520";
			System.out.println(sql);
			PreparedStatement st = con.prepareStatement(sql);
			// 
		
			st.setString(1, ename);
			st.setInt(2, sal);
			st.setInt(3, deptno);
			st.setString(4, job);
			st.setInt(5, empno);
			// int result = st.executeUpdate(sql);
			int result = st.executeUpdate();
			st.close();
			con.close();
			System.out.println(result + "행 SQL 전송 성공");
		} catch (SQLException ex) {
			System.out.println("연결실패:" + ex.getMessage());
		}

	}
}