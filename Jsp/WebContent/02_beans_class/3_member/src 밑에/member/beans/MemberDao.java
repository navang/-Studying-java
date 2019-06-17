package member.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {

	
	// DB 연결시  관한 변수 

	private static final String 	dbDriver	=	"oracle.jdbc.driver.OracleDriver";
	private static final String		dbUrl		=	"jdbc:oracle:thin:@192.168.0.95:1521:orcl";
	private static final String		dbUser		=	"myteam";
	private static final String		dbPass		=	"1234";

		
	private static MemberDao memberDao;
	
	public static MemberDao getInstance() throws MemberException
	{
		if( memberDao == null )
		{
			memberDao =  new MemberDao();
		}
		return memberDao;
	}
	

	private MemberDao() throws MemberException
	{
			
		try{
			
			/********************************************
				1. 드라이버를 로딩
						
			*/	
			Class.forName(dbDriver);
			
		}catch( Exception ex ){
			throw new MemberException("DB 연결시 오류  : " + ex.toString() );	
		}
	}
	
	/*******************************************
	 * * 회원관리테이블 MEMBERTEST 에  회원정보를 입력하는 함수
	 * @param rec
	 * @throws MemberException
	 */
	public void insertMember( Member rec ) throws MemberException
	{
		try {
			 // 0. 연결 객체 얻어오기	
			Connection con =  DriverManager.getConnection(dbUrl,dbUser,dbPass);
//			 String id = request.getParameter("id");
//			 String password = request.getParameter("password");
//			 String name = request.getParameter("name");
//			 String tel = request.getParameter("tel");
//			 String address = request.getParameter("address");
			 // 1. sql 문장 만들기 ( insert문 )
			 String sql = "INSERT INTO memberTest (id , password, name, tel, address) "
						+ "VALUES(?,?,?,?,?)";
			 // 2. sql 전송 객체 만들기
			 PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, rec.getId());
				st.setString(2, rec.getPassword());
				st.setString(3, rec.getName());
				st.setString(4, rec.getTel());
				st.setString(5, rec.getAddress());
			 // 3. sql 전송
				st.executeUpdate();
//				ResultSet rs= st.executeQuery();
			 // 4. 객체 닫기
				st.close();
				con.close();
				rs.close();
				
		} catch ( Exception ex ){
			throw new MemberException("멤버 입력시 오류  : " + ex.toString() );			
		}			
	}
	
	/**********************************************************
	 * * 회원관리테이블 MEMBERTEST에서 기존의 id값과 중복되는지 확인하는 함수
	 */
	public boolean isDuplicatedId( String id ) throws MemberException
	{
		boolean flag = false;
		
		try{

			
		}catch( Exception ex ){
			throw new MemberException("중복아이디 검사시 오류  : " + ex.toString() );			
		}
			
		return flag;
	}
}
