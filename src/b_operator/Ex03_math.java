package b_operator;

import java.util.Scanner;

/*
 * 	산술 연산자 : *   /  %(나머지연산) , +  -
 */

public class Ex03_math {

	public static void main(String[] args) {

		// 1. 숫자하나를 입력받기 ( Scanner - inport java.util.* ) 
		// 2. 홀수인지 짝수인지 연산하여 출력 ( % : 나머지 연산자) 

		Scanner input = new Scanner(System.in);

		int A = input.nextInt();

		if((A%2)==0){
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}


	}
}
