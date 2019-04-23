package e_method;

import java.util.Scanner;

public class Ex09_복습 {
	
	public static void main(String[] args) {
	
		char[][] square = input();
			output();
		
	}
	
	static void input() { 
		// 두 정수와 알파벳 문자 하나를 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.println("문자입력 ex)34F");
		int m = sc.nextLine().charAt(0);
		int n = sc.nextLine().charAt(1);
		char c = sc.nextLine().charAt(2);
	
	
				makeSquare(m, n, c);
	
		
	}
	static void makeSquare(int m, int n, char c) {
		int i;
		for(i=0; i<m*n; i++) {
			
			}
			
		}
		// (*) 입력받은 값을 이용해서 n * m 문자배열을 만들기 
		// F G H I
		// J K L M
		// N O P Q
	
	
	static void output() {
		
	}

}

