package e_method;

public class Ex02_인자와반환 {        // main 에서 method 변경하기

	public static void main(String[] args) {
		// 데이터 입력 받기 
		int a = 10;
		double b= 20;
		add(a, b);										// 함수 호출 , a ,b를 넘겨줌  (a,b)를 인자라 한다. 
	}
	
	static void add(int a, double b) {  // 변수명은 관계없지만 사용자의 편의를 위해 같은걸로 하자 
		// 입력받은 데이터 합을 구해서 출력
		
		
		int sum = (int)(a+ b);
		System.out.println("합:" + sum);
	}

}
