package c_control;

import java.util.Scanner;

/*
 * 문제 1)1~ N까지의 숫자를 다음처럼 출력하라

1 2 3 4 5 
6 7 8 9 10
11 12 13 14 15
 */

public class Ex06_for연습 {

	public static void main(String[] args) {
	
		
		for(int c=1; c<=15; c++)
		{
			System.out.print( c + " " );
			if(c%5==0) {
				System.out.println();
			}
		
		}
		
		/*
		문제3 ) 입력받은 문자열의 뒤집어서 출력하세요
		  
		   [예]  입력     출력
		   
		     안녕 친구  			 구친 녕안
		     CarpeDiem   meiDepraC */
		
		Scanner input = new Scanner(System.in);
		System.out.println("문자입력 -> ");
		String msg = input.nextLine();
		int length = msg.length();
		//for문으로 구조잡기
		// charAt() 이용해서 화면 출력 
	
		for(int c=length-1; c>=0; c--) {
			
			System.out.print(msg.charAt(c));
			
		}
			
	}	

}
