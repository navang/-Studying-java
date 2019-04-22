package d_array;


/*
 * 1차원배열  = for문 하나 // 정렬은 2개
 * 2차원 배열  = for문 하나 // 정렬 을 3개 이상 
 * ***
 */
public class Ex05_로또 {

	public static void main(String[] args) {

		int [][] lotto = new int [5][6]; // 로또  5행 6열의 배열을 선언 
		// 로또 번호 생성 5 줄 6 개 씩  
		for ( int i = 0; i < lotto.length; i++) { 			// lotto.length 가 5줄
			for ( int j = 0; j < lotto[i].length; j++) {    // lotto[i]마다의.length 가 6개 
				lotto[i][j] = (int)(Math.random()*45)+1;    // [i,j] 의 값을 int로 변환   ( Math.random은 임의의 실수 값 0< <1 이므로 정수에서 자르고 (로또는 1부터니까)1을더해준다
															// /Math.random()*45/ 0~44까지 , -> 1~45 바꿔줌
				for(int k=0; k<j; k++) {					// k, j가 가로줄 , 다시 세어주기위해서 k 다음이 j 
					if( lotto[i][k] == lotto[i][j]) {		// [i][k] (앞에거가) [i][j] 랑 같으면
						j--;								// j를 증가시키지말고 다시 작업해라 
					}
				}
			}
		}
		// 정렬

		for(int k = 0; k < lotto.length; k++) {				// 정렬  lotto의 총 배열의 길이
			for(int i = lotto[k].length-1; i>0; i--) {      
				for(int j=0; j<i; j++) {
					if( lotto[k][j] > lotto[k][j+1]) {
						int temp = lotto[k][j];
						lotto[k][j] = lotto[k][j+1];
						lotto[k][j+1]=temp;
					}
				}
			}
			
		}
		
		// 출력 
		// -숫자의 합이 106 ~170 사이라면 별표 출력 
		for ( int i = 0; i < lotto.length; i++) {	
			int sum= 0;
			for ( int j = 0; j < lotto[i].length; j++) {
				sum += lotto[i][j];
				
				System.out.print(lotto[i][j]+ "\t");  //        \t는 tab 
	
			}
			if( 106< sum && sum <170) System.out.print("☆");
			
			System.out.println();
		}
		
		
		}

	
}
