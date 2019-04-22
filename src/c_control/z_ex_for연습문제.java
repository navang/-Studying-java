package c_control;

import java.util.Scanner;

public class z_ex_for연습문제 {

	public static void main(String[] args) {
	
	/* 문제 6----------------------------------------------------------------
	문제2)  문자열처리하기
문자 N(a~z, A~Z)를 입력받아 N이 소문자면 a부터 N까지 인쇄하고 
N이 대문자이면 문자 N부터  Z까지 출력하라 
그 밖의 문자가 입력되면 Error 를 출력하라

입력  출력
f       abcdef
X       XYZ
6       Error
*///--------------------------------------
	/*
		Scanner input = new Scanner(System.in);  
		char eng = input.next().charAt(0);  // eng가 입력된 char 
		
		if(eng >='a' && eng<='z'){
			for( char  i='a' ;  i<=eng; i++ ) {   // eng' 에서부터  시작하고 'Z'에서 끝나기 
				System.out.print(i);
		}
			
		}
		else if(eng >='A' && eng<='Z') {
			for( char  i=eng ;  i<='Z'; i++ ) {   // eng' 에서부터  시작하고 'Z'에서 끝나기 
			System.out.print(i);
		}
		}
		else if(eng < 'a' || eng>='Z') {
			System.out.println("error");
			
		};
		
			문제 3 -----------------
			행과 열의 수를 입력받아 다음과 같이 출력하는 프로그램을 작성하시오. 
   
     입력 
     3  4   
     
     출력
     1 2 3 4
     2 4 6 8
     3 6 9 12
		*/
		
		Scanner input = new Scanner(System.in);  
		int i = input.nextInt();  // 첫번째 입력
		int j = input.nextInt();  // 두번째 입력
		
		for( int  a=1;  a<=i; a++ ) {  // i 행 세로
		
			for( int  b=1;  b<=j; b++ ) {   // j 열  가로
				
			System.out.print(a*b + " " );   //  (i >a>=1) 세로배열 * (j > b >=1) 가로배열 
		}
		
		System.out.println();
		
		 
		}
		
		/*
		for(int c=i; c>0; c++)
		{
			System.out.print( c + " " );
			if(c%j==0) {   
				System.out.println();
			}
		
		}
		*/
	}
}

