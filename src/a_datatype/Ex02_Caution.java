package a_datatype;

/*
 * 	데이터 타입 (자료형) 
 * 1. 기본형 (primetive	
 * 					논리형 : boolean 
 * 					문자형 : char
 * 					정수형 : int  / lon
 * 					실수형 : double
 * 
 * 2. 참조형 (레퍼런스) : 클래스, 배열
 * 					-> new 연산자를 이용해서 메모리 할당 (확보)				
 * 
 * ex) string 
 * 					
 */




public class Ex02_Caution {

	public static void main(String[] args) {


			//실수형 
//			float f; 
			double f;
			f = 3.6;
			System.out.println("실수:" + f);
			
			// 문자형 - 정수형 
			char ch;
			ch = 65;
			System.out.println("ch값: " +ch);
			
//			int i;
//			i = 'a'; 
			int i ='a';
			System.out.println("i 값: " + i);
			
			long l = 10000000000L;
			System.out.println("l 값 : " + l);
//			int i2 = 10000000000;
			
			//형변환 - casting 값을 넣어줄때 데이터크기보다 작아야한다. 
			double db = (double)100;
			System.out.println("db값: " + db);
		
			int in = (int)100.1;
			System.out.println("in값: " + in);
			
			
			
	}

}
