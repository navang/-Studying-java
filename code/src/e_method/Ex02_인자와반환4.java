package e_method;

public class Ex02_인자와반환4 { // 전역변수로  변수를 선언하게되면 여러 method에서 가져다 쓸수 있어 편리하지만 메모리를 계속 차지하고 있다 
	
	static int a, b; // 멤버 변수 (글로벌 변수 ) 
	static int sum;  
	
	public static void main(String[] args) {
		a=10;	
		b=20;
		add();
		System.out.println("합: "+ sum);
			
	}
	
	static void add() {
		sum = a + b ; 
	}

}
