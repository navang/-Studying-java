package d_array;

public class Z_ex_array {

	public static void main(String[] args) {

		/*[문제]
		동적크기로 합이 가장 큰 행을 출력하기
  		int a[][]=new int[][]{{3,-5, 12 }, {-2, 11, 2, -7}, {21, -21, -35, -93, -11}, 
  		{9, 14, 39, -98}};
  	
		결과 : 0행
		*/
		
		int a[][]=new int[][]{{3,-5, 12 }, {-2, 11, 2, -7}, {21, -21, -35, -93, -11}, {9, 14, 39, -98}};
		int sum =0;
		for( int i = 0; i<a.length; i++)	{
			for(int j =0; j<a[i].length; j++) {
				sum += a[i][j];
				System.out.println(sum);
			}
		}
		
		
		/*

[ 문제 ]: 합이 가장 큰 행과 열
 다음 배열 a에서 합이 가장 큰 행과 열의 번호를 각각 출력하기
 int a[][]=new int[][]{{3,-5, 12, 3, -21}, {-2, 11, 2, -7, -11}, {21, -21, -35, -93, -11}, {9, 14, 39, -98, -1}};

 결과 : 2 1
		 */
	}

}
