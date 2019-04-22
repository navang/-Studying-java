package c_control;

import java.util.Calendar;

/*
 * 1 - 정수값 1 (연산가능)
 * '1' - 문자 1 
 * "1" - 문자열 1
 */

public class Ex03_주민번호나이 {

	public static void main(String[] args) {

		String id = "181214-3111111";

		String nai1 = id.substring(0, 2); // nai1 - 92
		int nai2 = Integer.parseInt(nai1);

		int age = 0;

		// 7번째 주민번호가
		// 1 이거나 2 라면 1900을 더하고
		// 3이거나 4라면 2000을 더해 계산


		char gen = id.charAt(7);
		// int year = 
		
		
		Calendar year = Calendar.getInstance();

			if(gen == '1' || gen == '2') {
			age = year.get(Calendar.YEAR) - ( 1900 + nai2) + 1;
		}


			else if(gen == '3' || gen == '4') {
			age = year.get(Calendar.YEAR) - ( 2000 + nai2) + 1;
		}

				// Calendar 클래스를 이용하여 연도 대입 
		System.out.println(" 당신의 나이는 : " + age);


	}

}
