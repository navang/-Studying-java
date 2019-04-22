package b_operator;

import java.util.Scanner;

/*
 * 세수중 두번째로 큰 수 출력 
 */
public class Ex_ex02 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();

		int result = 	( a>b & b>c | c>b & b>a )? b :
						( a>c & c>b | b>c & c>a )? c :
						( c>a & a>b | b>a & a>c )? a : a;
		System.out.println(result);


	}

}
