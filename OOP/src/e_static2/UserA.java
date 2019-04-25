package e_static2;

public class UserA {
	DBConnect con;					// DBConnect 클래스 con 선언
	 
	 public UserA(){				  // ~~ 생성자 함수 
	  // con = new DBConnect();
	  con = DBConnect.getInstance();	// con = (클래스명).캡슐화된 변수 가져오기 ; 
	  
	 }
	 
	 public void use(){
	  System.out.println("디비 작업중");
	 }

}
