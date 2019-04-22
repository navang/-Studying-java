package e_method;

public class Ex05_Overloading {
	
	/*
	 	overloading 
	 		: 동일한 이름의 메소드들
	 		~ 인자의 자료형과 갯수 달라야 함 
	 		
	 		/[*] 주의할 점
	 			int 	add(int a, int b ){ }
	 			double 	add(int x, int b ){ } 
	 		
	 		/리턴형만 다르면 컴파일 오류 발생
	 */
	
	
		
	public static void main(String[] args) {
		int a = 5 , b=7;
		add(a,b); 					// 메소드는 보통 소문자로 기입,  영어가 둘이상 붙을 때는 두번째 영단어 대문자시작
		int c = 3;
		double d = 3.6 ;			
		add(c,d); 					// 인자의 자료형과 갯수가 같다면 동일한 method 명도 됨
	}
	static void add(int c, double d) {		//동일한 역할이라면 메소드명이 같아도 된다. 
		System.out.println(c+d);
	}
	static void add(int a , int b) {
		System.out.println(a+b);
		
	}

}
