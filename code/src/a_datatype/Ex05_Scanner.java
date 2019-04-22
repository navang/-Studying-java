package a_datatype;

import java.util.Scanner;

public class Ex05_Scanner {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		// 학생 이름을 입력받아 
		System.out.print("이름>>");
		String name = input.nextLine();
		
		System.out.print("국어 점수>>");
		int kor = input.nextInt();
	
		System.out.print("영어 점수>>");
		int eng = input.nextInt();
		
		System.out.print("수학 점수>>");
		int math = input.nextInt();
		
		// 총점 출력
		int total = kor + eng + math;
		System.out.println("총점:" +total);
		
		//평균 출력
		double avg = (double)total / 3;
				System.out.println("평균:" +avg);

	}

}
