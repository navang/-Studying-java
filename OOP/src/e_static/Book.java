package e_static;
/*
 *  static 변수 : 각 객체에서 공유하고자 
 *  			 메모리에 단 하나임 
 *  			* 클래스 명 접근 가능 ( 그래서 static 변수 = 클래스 변수 ) 
 */
	public class Book {
	private static int count;  // 스태틱 변수는 이미 설정됨 encapsulize
	int temp;
	
	public Book() {
		count++;			//count 호출
		System.out.println("책 생성");
	}
	
	static public int getCount() {	// static 
		return count;
	}
}
