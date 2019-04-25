package h_ingerit;

public class Test {

	public static void main(String[] args) {
		// 1. 클래스 생성과 메소드 호출 확인
/*		Umma u =new Umma();
		u.gene();
		u.job();
		// u.study();
		System.out.println();
		
		Ddal d = new Ddal();
		d.gene();		
		d.study();
		d.job();	// d. ( 부모, 자식의 메모리 주소를 모두 가지고 있음 ) 
		
*/
		//.2 						// 메모리 크기 자식>부모	
//		Ddal dd = new Umma();		 // 자식 변수에 부모 객체 생성 x
//		Umma uu = new Ddal();		// 부모 변수에 자식 객체 가능 !
//		uu.gene();
//		uu.job();
//		
		// **** overriding 
		// 		부모자식간에 메소드 명이 동일 
		// 		인자 동일 / 리턴형동일
		//		접근지정자는 같거나 크거나 
		// 		public, protected 가능 걍 복붙 
		//		부모변수에서 자식의 멤버 호출 
		
		//    형변환 (casting ) - 상속관계에서만  가능 
		// 	
		// 
		//Umma u = new Umma();
		// Ddal d = (Ddal)u;
		
//		Ddal d = new Ddal();
//		Umma u = (Umma)d;
//		d.study();
//		
//		Umma uu = new Ddal ();
//		uu.gene();
//		uu.job();
//		Ddal dd = (Ddal)uu;
//		dd.study();
//		
		//4. instanceof 연산자 
		Ddal d = new Ddal();
		if( d instanceof Ddal) {
			System.out.println(" Ddal 객체임");
		}
		if( d instanceof Umma) {
			System.out.println(" Umma 객체임");
		}
		if( d instanceof Object) {
			System.out.println(" Object 객체임");
		}
	
	}

}
