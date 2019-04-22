package c_control;

import java.util.Scanner;

public class z_ex_for도전문제 {

	public static void main(String[] args) {
		//문제1 해결! 
		/* 
		Scanner input = new Scanner(System.in);  
		int i = input.nextInt();  // 첫번째 입력
		int j = input.nextInt();  // 두번째 입력

		for(int c=1; c<=i*j; c++)
		{
			System.out.print( c + " " );
			if(c%j==0) {
				System.out.println();
			}

		}*/
// 문제 2 해결! 
		/*
		Scanner input = new Scanner(System.in);  
		int i = input.nextInt();  // 첫번째 입력



		for( int  a=1;  a<=i; a++ ) {  // 

			for ( int c =0; c<=i-1; c++){

				System.out.print(" " + (a+(c*i)));   //  세로로는 a의 증가폭 만큼 증가하고 가로로는 a에다가 c*i만큼씩 증가한다.
			}
			System.out.println();

		}
		*/
		/*
		Scanner input = new Scanner(System.in);  
		int n = input.nextInt();  // 세로
		int m = input.nextInt();  // 가로
		
		for(int d=0; d<=n; d++) {
			for(int a=1; a<=m; a++) {
			
				if((a-1) == 0) {
				for(int b=0; b<=m; b++) {
					System.out.println(" " + (((a*n)+b)+1)); 
				}
			}else 
				
				if((a-1) == 1) {
				for(int c=0; c<=m; c++) {
					System.out.println(" " + (((a*n)-c)+1));
				}
			}
			}System.out.println();
			
		}System.out.println();
*/

		Scanner input = new Scanner(System.in);  
		int i = input.nextInt();  // 첫번째 입력
		int j = input.nextInt();  // 두번째 입력
		
		for( int  a=1;  a<=i; a++ ) {  // i 행 세로
					if(a%2 == 1) {// 홀수면 정방향
						for( int  b=1;  b<=j; b++ ) {   // j 열  가로
						
						System.out.print(a*b + " " );   //  (i >a>=1) 세로배열 * (j > b >=1) 가로배열 
					} 	
						
					}
					else if(a%2 == 0) {
						for( int  b=1;  b<=j; b++ ) {   // j 열  가로
							
							System.out.print(a*b-1 + " " );   //  (i >a>=1) 세로배열 * (j > b >=1) 가로배열 
						} 	
							
						}
					
					
			
		
			
		
		System.out.println();
		
		 
		}
	}

}
