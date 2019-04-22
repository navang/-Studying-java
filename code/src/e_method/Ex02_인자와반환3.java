package e_method;

public class Ex02_인자와반환3 {		// 변경된 method에서 배열로 여러데이터 가져오기 // 지역변수로 변수들을 선언하면 method가 끝나고 제어권을 반환하면 메모리가 삭제된다. 

	public static void main(String[] args) {
		int[] arr = add();  // 데이터 받아주기 
		int sum = arr[0] + arr[1];
				
		System.out.println(" 합 : ");

		//합을 계산하기 
	}
	
	static int[] add()  {    // int []arr 의 자료형! 
		int a=10 , b = 20;
		int []arr = {a, b};
		return arr;
	}
}
