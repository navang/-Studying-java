package d_array;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex_성적 {

	public static void main(String[] args) {

		int []kor = new int[5]; 
		Scanner input = new Scanner(System.in);
		System.out.println("점수입력(ex) 12 13 14");
		
		String score = input.nextLine();
		StringTokenizer st = new StringTokenizer(score); // new StringTokenizer(score, " "); score를 처리할건데 그 기준은 , " " 
		for(int i=0; st.hasMoreTokens(); i++) {
			kor[i] = Integer.parseInt(st.nextToken());
		}
		
//		for(int i=0; i<5; i++) {
//			kor[i] = input.nextInt();
//		}

		//총점구하기
		int total = 0;
		for(int i=0; i<5; i++) {
			total +=kor[i];
		}
		System.out.println("총점" + total);

	}

}
