package b_operator;

import java.util.Scanner;

/*		논리 연산자
 * 			- 일반 논리 :(true/false) && || 
 * 			- 이진 논리  :( bit에 있는 1/0) & | ^(입력신호가 서로다를때) 
 * 
 */
public class Ex05_GeneralLogical {

	public static void main(String[] args) {
		
		// 문자 하나를 입력받아 
		// 1) 대문자인지 출력 
		// 2) 대문자인지 소문자인지 그외 출력
		
		Scanner input = new Scanner(System.in);
		System.out.println("문자 하나 입력하세요");
		
		char ch = input.next().charAt(0);
		System.out.println("입력값:" + ch);
		
		if(ch>='A' && ch<='Z') {
			System.out.println("대문자");
		}
		if(ch>='a' && ch<='z') {
			System.out.println("소문자");
		}else
		 {
			System.out.println("영어가 아님");
		}
		
		
		/*
		int 성적 = 75;
		char 태도 = 'A';
		
		// 성적 향상반 조건 - 80점 and A 
		if(성적>=80 && 태도=='A') {
			System.out.println("성적향상반");
			
		// 우등생 조건 80 점 or A	
		}else  if(성적>=80 || 태도=='A') {
			System.out.println("우등생"); 
		
		}
		*/
		
		
		 
	}

}
