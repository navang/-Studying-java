package e_static2;

public class DBConnect {
	
	static DBConnect db; 							//객체명이 없는 상태에서 클래스몀으로 불러오기위해 static // 전역변수선언
	
	 private DBConnect(){							// private 로 접근제한 변경
		  System.out.println("실제로 디비에 연결을 얻어옴");
		 }
	 
	 public static DBConnect getInstance() {		// static 을 써서 DBConnect getInstance  
		 if( db == null) db= new DBConnect();		// 
		 return db;
		 
	 }

}
