package a_datatype;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_ex1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
//		System.out.print("첫번째 입력 = ");
		int a = input.nextInt();
	
//		System.out.print("두번째 입력 = ");
		int b = input.nextInt();
		
//		System.out.print("세번째 입력 = ");
		int c = input.nextInt();

//		System.out.printf("%d, %d, %d 중 두번째로 큰 수는", a , b, c);

		
		if(a>100 || a<1 || b>100 || b<1 || c>100 || c<1 ) {
			System.out.println("1~100사이의 정수가 아닙니다.");
		}
		else {
			// 입력한 숫자가 1~100사이의 숫자면 순서대로 배열
		int numSort [] = {a, b, c};
		Arrays.sort(numSort);
		
		for(int i = 0; i < numSort.length; i++) // i가 순서인듯... 0부터 시작하는 정수 0, 1, 2, 3, ... 
		{
			if(i == 1) // 이중에서 두번째가 맞으면 표시하기로! 
			System.out.println(numSort[i]); 
		}
		}
		}
	
	

}
