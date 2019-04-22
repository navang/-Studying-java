package e_method;

import java.util.Scanner;

/*
 	(문제 1) 영문자를 입력하여 이 문자가 소문자면 true 아니면 false을 반환하는 메소드를 작성하시오. 
  함수명 : checkLower
  인자 : char
  리턴(반환) : boolean
 */

public class Z_Ex_예제01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("문자 하나 입력하세요");
		
		char check = input.nextLine().charAt(0);
		
		boolean result = checkLower(check);  // 반환 
		System.out.println(result);

	}
	static boolean checkLower(char check) {
		if(check >='a'&& check <= 'z') {
			return true;
		}else {
			return false;
		}

	}

}
