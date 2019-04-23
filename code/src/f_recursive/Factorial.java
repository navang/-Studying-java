package f_recursive;

public class Factorial {

	//5! = 5*4*3*2*1 = 120
	public static void main(String[] args) {
		
		int fac=0;					// 1합산결과를 fac 이라하자
		fac= factorial(5);			// 2아래 factorial 메소드에 5부터 넣기
		System.out.println("결과 " + fac);
		

	}
	
	static int factorial(int i) {	// 3 재귀함수 자기안에서 i를 받는다
		if(i==1) return 1;			// 4 i가 1로 같아질때 까지 반복
		return i * factorial(i-1);	// 5 (5 4 3 2 1 ) 곱한다  
	}
}
