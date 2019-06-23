package product.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import guest.model.Message;
import product.model.ProductException;

public class ProductDao
{
	
	// Single Pattern 
	private static ProductDao instance;
	
	// DB 연결시  관한 변수 
	private static final String 	dbDriver	=	"oracle.jdbc.driver.OracleDriver";
	private static final String		dbUrl		=	"jdbc:oracle:thin:@192.168.0.95:1521:orcl";
	private static final String		dbUser		=	"myteam";
	private static final String		dbPass		=	"1234";
	
	
	private Connection	 		con;	
	
	//--------------------------------------------
	//#####	 객체 생성하는 메소드 
	public static ProductDao	getInstance() throws ProductException
	{
		if( instance == null )
		{
			instance = new ProductDao();
		}
		return instance;
	}
	
	private ProductDao() throws ProductException
	{
	
		try{
			
			/********************************************
				1. 오라클 드라이버를 로딩
					( DBCP 연결하면 삭제할 부분 )
			*/
			Class.forName( dbDriver );	
		}catch( Exception ex ){
			throw new ProductException("DB 연결시 오류  : " + ex.toString() );	
		}
		
	}

	   /* -------------------------------------------------------
	    * 메세지 전체 레코드 수를 검색
	    */
	   
	   public int getTotalCount() throws ProductException{
	      Connection          con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      int count = 0;

	      try{
	    	   // 1. 연결객체(Connection) 얻어오기
	          Class.forName(dbDriver);
	          con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
	          // 2. sql 문장 만들기
	          String sql ="SELECT COUNT(*) CNT FROM product";
	          // 3. 전송객체 만들기
	          // 4. 전송하기
	          // 5. 결과받기 
	         
	          ps = con.prepareStatement(sql);
	          rs = ps.executeQuery();
	          if(rs.next()) {
	        	  count = rs.getInt("CNT");
	          }
	             
	            
	         return  count;
	         
	      }catch( Exception ex ){
	         throw new ProductException("메뉴 ) DB에 목록 검색시 오류  : " + ex.toString() );   
	      } finally{
	         if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
	         if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
	         if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
	      }         
	   }
	

	//------------------------ProductRec rec 에 각컬럼 값 지정 -------------------
	
	 public List<ProductRec> productList(int startRow, int endRow) throws ProductException
	   {
	      Connection          con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      List<ProductRec> pRec = new ArrayList<ProductRec>();
	      boolean isEmpty = true;
	      
	      try{
	         // 1. 연결객체(Connection) 얻어오기
	         Class.forName(dbDriver);
	         String sql ="SELECT * FROM product"; 
	         // 2. sql 문장 만들기
	         con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
	         ps = con.prepareStatement(sql);
	         rs = ps.executeQuery();
	         while(rs.next()) {
	            //각 컬럼들의 값을 가져와서 Message의 property로 지정
	            //그 Message 객체를 ArrayList에 추가
	            ProductRec rec = new ProductRec();
	            rec.setpNo(rs.getString("PNO"));
	            rec.setpName(rs.getString("PNAME"));
	            rec.setpPrice(rs.getInt("PPRICE"));
	            rec.setpEach(rs.getInt("PEACH"));
	            rec.setpPath(rs.getString("PPATH"));
	            pRec.add(rec);
	            isEmpty = false;
	         }
	         
	         if( isEmpty ) return Collections.emptyList();
	         
	         return  pRec;
	      }catch( Exception ex ){
	         throw new ProductException("메뉴) DB에 목록 검색시 오류  : " + ex.toString() );   
	      } finally{
	         if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
	         if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
	         if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
	      }      
	   }
	   
}