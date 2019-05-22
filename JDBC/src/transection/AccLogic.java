package transection;

import java.sql.*;
public class AccLogic 
{
	// 연결 객체 생성시 필요한 변수 선언
	String url;
	String user;
	String pass;

	//===============================================
	// 드라이버를 드라이버매니저에 등록
	public AccLogic() throws Exception{
		/////////////////////////////////////////////////////////
		// 1. 드라이버를 드라이버 매니저에 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		url = "jdbc:oracle:thin:@192.168.0.145:1521:orcl";
		user = "scott";
		pass = "tiger";
	}


	//====================================================
	// 보내는 계좌번호와 받는 계좌번호와 계좌금액을 넘겨받아 
	//	보내는계좌에서 계좌금액을 빼고 받는계좌에서 계좌금액을 더한다
	public int moveAccount(String sendAcc, String recvAcc, int amount)
	{
	
	      ///////////////////////////////////////////////////////////
	      //    1. Connection 객체 생성
		Connection con = null;
	      //@@ 2. Auto-commit을 해제
		con.setAutoCommit(false);
	  
	         
	     
	      try {

	          Connection con = null;
	          ///////////////////////////////////////////////////////////
	          //    1. Connection 객체 생성
	          //@@ 2. Auto-commit을 해제
	          //    3. 출금계좌에서 이체금액을 뺀다
	             
	          
	          try {
	             //4. 전송 객체 생성
	             con = DriverManager.getConnection(url, user, pass);
	             
	             //쿼리가 바로 commit 되지 않도록 하는 방법, 이 후 쿼리 commit 방법 >>> con.commit();
	             con.setAutoCommit(false);
	             
	             
	             //****************************************************************
	             // send
	             //****************************************************************
	             //전송 객체는 각 쿼리당, 하나의 전송 객체(Statements)를 만드는 것이 좋다.
	             String send_query = "UPDATE ACCOUNT SET amount = amount - ?"
	                                + " WHERE account_num = ?";   
	             
	             PreparedStatement send_pst = con.prepareStatement(send_query);
	             
	             //생성자 객체명을 인자값으로 받았기 때문에, 이 해당 메소드에서 객체명 사용 가능.
	             send_pst.setInt(1,  amount);
	             send_pst.setString(2,  sendAcc);

	             //5. sql 전송 및 결과값 받기
	             int send_result = send_pst.executeUpdate();
	             
	             //update 문이 처리되지 않았을 때?
	             if(send_result != 1) {
	                con.rollback();
	                return -1;
	             }

	             //6. 결과값 콜솔창 출력
	             System.out.println("send SQL 전송 성공: " + send_result);      
	             
	             
	             //****************************************************************
	             // receive
	             //****************************************************************
	             String receive_query= "UPDATE ACCOUNT SET amount = amount + ?"
	                                       + " WHERE account_num = ?";
	             
	             PreparedStatement receive_pst = con.prepareStatement(receive_query);
	             
	             //생성자 객체명을 인자값으로 받았기 때문에, 이 해당 메소드에서 객체명 사용 가능.
	             receive_pst.setInt(1,  amount);
	             receive_pst.setString(2,  recvAcc);

	             //5. sql 전송 및 결과값 받기
	             int receive_result = receive_pst.executeUpdate();

	             if(receive_result != 1) {
	                con.rollback();
	                return -1;
	             }
	             
	             //6. 결과값 콜솔창 출력
	             System.out.println("receive SQL 전송 성공: " + receive_result);
	             
	             
	             //쿼리 commit
	             con.commit();
	             
	             
	             //마지막 쿼리 전송 후 close
	             //7. close
	             con.close();

	          } catch (SQLException e) {
	             // TODO Auto-generated catch block
	             e.printStackTrace();
	             return -1;
	          }
	          

	          
	          //    4. 입금계좌에 이체금액을 더한다
	          //@@ 5. commit을 전송한다
	          //    6. 객체 닫기
	          //    - 만일 정상적인 경우는 0을 리턴하고 도중에 잘못되었으면 트랜잭션을 롤백시키고 -1을 리턴

	          return 0;
	//=======================================================
	//	보내는계좌번호와 받는계좌번호를 넘겨받아
	//		보내는계좌고객명과 보내는계좌의남은 금액을 얻어오고
	//		받는계좌고객명을 얻어와서
	//		얻은 정보를 ConfirmData객체에 넣고 리턴
	public ConfirmData confirmAccount(String sendAcc, String recvAcc) 
		throws Exception{

		
		String sendCust="", recvCust="";
		int gainMoney=0;
		ConfirmData  resultData=null;
		
		//	1. Connection 객체 생성
		//	2. 테이블에서, 넘겨받은 sendAcc와 같은 account_num필드에서 customer, amount를 얻어온다
		//	3. 테이블에서, 넘겨받은 recvAcc와 같은 account_num필드에서 customer를 얻어온다
		//  4. 2와 3에서 얻은 값을 ConfirmData 객체에 저장
		//	5. 4번의 객체를 리턴



		return resultData;
	}

}


//#################################################################
//	테이블명 : account
//	account_num		계좌번호		varchar2(20)
//	customer		고객명			varchar2(20)
//	amount			계좌금액		int
