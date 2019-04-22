package c_control;

import java.util.Scanner;

public class Ex10_do_while {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);  
		 
		char result ='\0';
		do {                                       // 입력부터하고 조건을 뒤로 보낼 때 
			// 구구단 입력하면 구구단 출력
			System.out.println("구구단 입력 > ");
			int dan =input.nextInt();
			for(int i=1; i <=9; i++) {
				System.out.println(dan + "*" + i + "=" + (dan*i));
				
			}
			
			System.out.println("retry? (y|Y)");
			result = input.next().charAt(0);
			
		}while(result == 'Y' | result == 'y');

	}

}
