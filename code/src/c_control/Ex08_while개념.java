package c_control;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex08_while개념 {

	public static void main(String[] args) {
/*
			int sum =0;
			int a=1;
//			for(; a<=10; ) {
			while(a<=10) {
				sum+=a;
				a++;
				
			}
			System.out.println("result :" + sum);
			*/
		
			// 연습 구구단수 n 을 입력받아 n단 을 수행 = while문 
		/*
		Scanner input = new Scanner(System.in);  
		int i = input.nextInt();  // 첫번째 입력
		
		int sum =0;
		
		int b=1;
			for (;  b<=9; )
			{
				System.out.print(" " + b*i);
				b++;
			}
		
		
		System.out.println();
		
		*/
		//
		/*
		
		String str = " 독도는 대한민국의 아름다운 섬입니다."; 
		StringTokenizer st = new StringTokenizer(str);
		// 처음과 끝을 모를 때 조건문만 넣어서  참인 값을 구할 수 있다. 
		while(st.hasMoreTokens()) { 
			System.out.println(st.nextToken());
			
		*/ 
		String str = "100*434+32/2"; 
		StringTokenizer st = new StringTokenizer(str,"+-*/%");
		// str에서 특정 문자 를 거른다.  
		while(st.hasMoreTokens()) { 
			System.out.println(st.nextToken());
		}
	}

}
