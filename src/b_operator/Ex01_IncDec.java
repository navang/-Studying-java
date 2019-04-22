package b_operator;

/*
  증가 , 감소 연산자 : ++, -- 
 */

public class Ex01_IncDec {

	public static void main(String[] args) {
		
//		int a=5, b=7;
		/*System.out.println("A=" + (a+1) +", B=" +(b+1));
		
		    a= a+1;
			b= b-1;
			System.out.println("A="+ a +", B=" + b );
			
			a++; 
			b--;
			System.out.println("A="+ a +", B=" + b );
			
			++a;
			--b;
			System.out.println("A="+ a +", B=" + b );

	}
	*/
//		int result = ++a; // 먼저 증가하고 대입함 ( a값이 먼저 변하고a를 result에 대입
//		System.out.println("Result= " + result + ", A=" + a); // 6 5
//
//		int result2 = a++; // 먼저 연산(대입)(result)하고 맨마지막에 증가(a)함 
//		System.out.println("Result= " + result2 + ", A=" + a);// 5 6
//	}
	
		int a=5, b=7;
		System.out.println("A="+ ++a + ", B=" + --b); // 6 6
		System.out.println("A="+ a++ + ", B=" + b--); 
		// 6 6 (대입해서 보여준 상태 사실 값은 7, 5 
		System.out.println("A="+ a + ", B=" + b); // 7 5
	
	}
	
	
}
