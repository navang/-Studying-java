package z_constructor_연습문제;

import java.util.Scanner;
import java.util.Set;

public class GradeTest {

	public static void main(String[] args) {
	
		//처리하려는 데이터의 개수를 표준 입력받는다
		Scanner input = new Scanner(System.in);
		System.out.println("점수들(과목 개수)의 개수를 입력하세요");			// 데이터 갯수
		int m = input.nextInt();								// m이 입력한 갯수 5
		
		// 입력된 데이터 개수 크기의 원소를 갖는 int 타입 배열을 생성한다
			int score[] = new int [m];
		// 앞에서 만들어진 배열을 전달하면서 GradeExpr 객체를 생성한 후에 	
			GradeExpr ex = new GradeExpr(score); 			
		
		// 표준입력으로 데이터를 받아서 첫 번째 원소부터 마지막 원소까지 저장한다 
			int i=0;
			while(i<m) {
			System.out.println((i+1) + "번째 입력");
			score[i] = (input.nextInt());
			System.out.print(score[i] + ", ");
			i++;
		}
	
		// 저장된 원소값들을 하나의 행에 , 기호로 분리하여 출력합니다
	
		
		//jumsu[m].GradeExpr();
		ex.getTotal();
		ex.getAverage();
		ex.getGoodScore();
		ex.getBadScore();
		// 총점과 평균을 구하는 메소드를 호출하여 그 수행결과를 다음과 같은 형식으로
		
		//화면에 표준 출력한다
		
		//System.out.println("점수들 : " );
		System.out.println("총점 : " + ex.getTotal());
		System.out.println("평균 : " + ex.getAverage());
		System.out.println("최고점수 : " + ex.getGoodScore());
		System.out.println("최저점수 : " + ex.getBadScore());
	}

}
