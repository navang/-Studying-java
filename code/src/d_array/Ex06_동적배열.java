package d_array;

public class Ex06_동적배열 {

	public static void main(String[] args) {

		char [][] star = new char [4][] ;           // 4줄에 메모리잡을 영역을 선언하지않았지만 
 
		//값 지정 

		for (int i = 0; i < star.length; i++) {		// length 의 길이 만큼 
			star[i] = new char[i+1];
			for ( int j = 0; j < i+1; j++) {
				star[i][j]= '*' ;
			}

		}

		for (int i = 0; i < star.length; i++) {
			for ( int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
	}

}
