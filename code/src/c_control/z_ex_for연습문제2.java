package c_control;

import java.util.Scanner;

public class z_ex_for연습문제2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);  
		int a = input.nextInt();  // 첫번째 입력
		
		for( int i=1; i<=6; i++) { 			//  i값
			for(int j=1; j<=6; j++) {		//  j값
			if(a == (i +j)  ) {				//  합쳐서 a값이 나와야함
				System.out.println(i + " " + j);
			
			}
		}
		
		 
		}

	}

}
