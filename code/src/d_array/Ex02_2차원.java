package d_array;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Ex02_2차원 {

	public static void main(String[] args) {

//		입력할 학생수를 입력하세요. 4
//
//		4명의 국어, 영어, 수학 점수를 받아 결과 출력하기
//
//		1째 학생의 성적을 입력 -> 88/77/66
//		2째 학생의 성적을 입력 -> 50/40/70
//		3째 학생의 성적을 입력 -> 44/33/22
//		4째 학생의 성적을 입력 -> 55/50/70

//		[결과]
//		1째 학생의 총점 xxx 이고 평균은 ooo 입니다
//		2째 학생의 총점 xxx 이고 평균은 ooo 입니다
//		3째 학생의 총점 xxx 이고 평균은 ooo 입니다
//		4째 학생의 총점 xxx 이고 평균은 ooo 입니다
//
//		국어과목  총점 xxx 이고 평균은 ooo 입니다
//		영어과목  총점 xxx 이고 평균은 ooo 입니다
//		수학과목  총점 xxx 이고 평균은 ooo 입니다
		

	
		Scanner num = new Scanner(System.in);
		int su  = num.nextInt();  // 사람 입력을 받고 
		
		int [][]score; // 변수 선언
		score = new int[su][3]; // 배열 메모리 선언 [a][b] a 마다 b  
		
		// 수를 입력받고 번재를 < 수 로 반복문을 만들어라 
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("성적을 입력하세요 ex) 88/77/66"); // 점수 입력을 받는다 
		
		String inputsize = input.nextLine();
		StringTokenizer st = new StringTokenizer(inputsize, "/");  
		
		for(int t=0; t<3; t++) {
			 [i][t] = Integer.parseInt(st.nextToken());
		}
		
/*
		score [0][1] =88;
		score [0][2] =77;
		score [0][3] =66;

		score [1][1] =50;
		score [1][2] =40;
		score [1][3] =70;

		score [2][1] =44;
		score [2][2] =33;
		score [2][3] =22;

		score [3][1] =55;
		score [3][2] =50;
		score [3][3] =70;

		*/
		//// 학생 별 총점 , 평균  i 가 학생 j 과목
		for(int i=0; i<4; i++) {
			
			int total =0;
			int avg =0;
			for(int j=1; j<=3; j++) {

				total += score[i][j];
				avg= total/3;
			}
			
			System.out.println((i+1) + "번째 학생의 총점은" + total + "이고, 평균은 " + avg + " 입니다" ); 
			
		}
		
		System.out.println();
		//// 과목 별 총점 , 평균  i 가 학생 j 과목
		for(int j=1; j<4; j++) {
			
			int total =0;
			int avg =0;
			for(int i=0; i<=3; i++) {

				total += score[i][j];
				avg= total/4;
			}
			
			String a   =(j == 1)? "국어" :
						(j == 2)? "영어" : "수학" ;

			System.out.println( a + "의 총점은 " + total + "이고, 평균은 " + avg + " 입니다" );
			
		}
		}
		
	}

}
