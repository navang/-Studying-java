package b_operator;

import java.util.Scanner;

public class Ex_ex02_윤년 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int year = input.nextInt();
	
		String a = "true";
		String b = "false";
	
		
		String result = (year%4 == 0 | year/400 == 0 )? a : b;
		System.out.println(result);
		

	}
}
