package e_method;

public class Ex02_인자와반환2 {		// 변경된 method에서 데이터 가져오기 

	public static void main(String[] args) {
		int sum = add();					//밑에서 return 값을 받아올때 변수 명은 상관 x  자료형만 맞춰주자 
		System.out.println("합 : " + sum);
	}
	
	static int add() {
		int a = 10, b= 20;
		int sum = a+ b; 
		return sum;          			//return //add)();//로 무조건 반환 
	
	}
		// return;  흐름 반환 
		// return 값 : 호출한 곳으로 단 *하나*의 값을 반환 
	}


