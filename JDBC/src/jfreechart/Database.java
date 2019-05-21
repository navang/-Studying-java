package jfreechart;

import java.sql.*;
import java.util.*;

public class Database {

	String URL = "jdbc:oracle:thin:@192.168.0.145:1521:orcl";
	String USER ="scott";
	String PASS = "tiger";

	public ArrayList<ArrayList> getData() {

		ArrayList<ArrayList> data = new ArrayList<ArrayList>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL, USER , PASS);	
			
			//***************************************************************
			
			/*String sql = "SELECT  count(*) cnt , to_char(hiredate,'MM') hiredate " + 
					"from emp " + 
					"where to_char(hiredate,'MM') IS NOT NULL " + 
					"GROUP BY  to_char(hiredate,'MM') " + 
					"ORDER by hiredate asc"; //월별 입사인원 
			/*
			String sql = "SELECT job  , round(avg(sal)) avg " + 
					"from emp " + 
					"WHERE JOB IS NOT NULL " + 
					"GROUP BY job"; //직무별 평균월급  
			*/
			String sql = "SELECT sal , empno " + 
					"FROM emp " + 
					"where rownum <=10 AND SAL IS NOT NULL " + 
					"ORDER BY SAL DESC"; //직무별 평균월급 
					
			//***************************************************************
			
			PreparedStatement stmt = con.prepareStatement( sql );	

			ResultSet rset = stmt.executeQuery();
			
			while( rset.next() ){
				ArrayList temp = new ArrayList();
				// temp.add( rset.getInt("job"));	
				temp.add( rset.getInt("sal"));     //****************
				temp.add( rset.getString("empno"));		//****************		
				data.add(temp);
			}
			rset.close();
			stmt.close();
			con.close();
		} catch(Exception ex){
			System.out.println("에러 : " + ex.getMessage() );
		}
		return data;
	}
}
