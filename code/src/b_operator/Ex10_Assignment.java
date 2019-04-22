package b_operator;


/*
 *  	대입 연산자 ㅣ: = 
 *  		축약 대입연산자  ( 산술 / 이진논리 / 쉬프트 ) 
 */
public class Ex10_Assignment {

	public static void main(String[] args) {
		
		int a = 10, b = 7;
		
		a+=b; // a=a+b;
		System.out.println("A= " + a); // 17
		
		a-=b; // a=a-b;
		System.out.println("A= " + a); // 10

		
		a*=b; // a=a*b;
		System.out.println("A= " + a); // 70

		
		a%=b; // a=a%b;
		System.out.println("A= " + a); // 0
		
		a/=b; // a=a/b;
		System.out.println("A= " + a); // 0

		

		
	}

}
