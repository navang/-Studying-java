package z_연습문제;

import java.util.Scanner;

public class CalculatorTest {

	public static void main(String[] args) { 
		
		System.out.println(" 사칙연산을 할 숫자를 차례대로 입력하세요 ");

		int i=0;
		while(true) {	
			// 무조건 반복 while(true)
			Scanner scan = new Scanner(System.in); // 입력

			int n = scan.nextInt();				   // n,m 을 받는다 
			int m = scan.nextInt();

			CalculatorExpr ex = new CalculatorExpr(); // 클래스 CalculatorExpr 을 호출 해서 ex로 선언 
			ex.setNum1(n);							  // 클래스 CalculatorExpr 에서 불러온 Num1, Num2에
			ex.setNum2(m);							  // 입력값 n, m을 set(입력?

			int a = ex.getAddition();				 //호출 덧뺄곱나 한 각각의 메소드를 get (호출)
			int b = ex.getSubtraction();			 // "
			int c = ex.getMultiplication();			 // "
			double d = ex.getDivision();			 // "

			System.out.println(" 합: "+ a +" 차: "+ b +" 곱: "+ c +" 나눗셈: "+ d); // 결과값 출력
			System.out.println(" 다시하려면 숫자를 입력하세요 , 멈추려면 y or Y  ");		// 메세지 출력 

			if(i>0) {
				String stop = scan.nextLine();		
				System.out.println("다시하시겠습니까 Y/y 입력하세요 ");// 스탑 값 입력받음
				if(stop.equals('Y' | 'y')) {						//  'N' or 'n'이면
					break;										// 끝내겠다. END 라벨로 나가겠다 
				}
			}
			i++;
		}

	} 

}
