package e_method;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex03_성적 {

	public static void main(String[] args) {
		int[] kem = input();
//		System.out.println( " 입력값 :" + kem[0]);
		
		double result[] = calc(kem);
//		double 형인 result 를 받고  kem을  calc에 넣어줌  
		
		output(result);

	}

	static int[] input() {
		
		
		int []kem = new int[3]; 				
		Scanner input = new Scanner(System.in);
		System.out.println("점수입력(ex) 12 13 14");
		
		String score = input.nextLine();
		StringTokenizer st = new StringTokenizer(score);
		for(int i=0; st.hasMoreTokens(); i++) {
			kem[i] = Integer.parseInt(st.nextToken());
		}
		
		return kem;
		// 국영수 입력받기

	}

	static double[] calc(int []kem) {		// []kem 을 받아 넣어줌 
		
		int total = 0;
		double avg = 0;
		for(int i=0; i<3; i++) {
			total +=kem[i];
		}
		avg = total/3;
		double []result = { total, avg };
		return result;

		// input() 에서 입력받은 점수들의 합과 평균

	}
	static void output(double []result) {		// []result 를 받아 넣어줌 
		
		System.out.println(" 총 합  :" + result[0]);
		System.out.println(" 평균 : " + result[1]);
		
		// calc() 구한값과 평균 출력

	}
}
