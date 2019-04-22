package b_operator;

import java.util.Scanner;

/* 
 *  삼항 연산자 
 *  
 *  	(조건)? A : B 
 *  	조건이 true이면 A 실행하고 false 이면 B 실행 
 *  
 */

public class Ex09_삼항 {

	public static void main(String[] args) {


		//		int score = 81;
		//		String result = (score>=80)? "합격" : "불합격";
		//		System.out.println(result);
		//	}


		// [문제] 두 수를 입력받아 큰 수만 출력 
		Scanner input = new Scanner(System.in); 
		int num  = input.nextInt(); 
		int num2 = input.nextInt();
		int result = (num>num2)? num : num2;
//		int result = ((num - num2)> 0 )? num : num2; 
		System.out.println(result);

	}

}
