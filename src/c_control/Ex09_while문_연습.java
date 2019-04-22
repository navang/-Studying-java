package c_control;

/* 
 *  3,6,9, 게임 
 *  
 *  1~50 숫자중에서 3.6.9 포함되면 그 갯수만큼 짝 출력 
 *  하나도 포함되지않으면 그 숫자 출력
 */

public class Ex09_while문_연습 {


	public static void main(String[] args) {
		/*
		for ( int i =1; i<=51; i++) {
			int mok =i;
			boolean su369 = false;

			while(mok!=0) {
				int na = mok%10;
				if(na==3 | na==6 | na ==9 ) {
					System.out.print("짝");
					su369 = true;
				}

				mok /= 10; 
			}

			if(su369) {
				System.out.println();
			}else {
				System.out.println(i);
			}

		 */
		int cnt =0;  // a 번 
		int result = 0;
		for ( int i =1; i<=10000; i++) {  // 10000 번 반복
			int a = i; 					  // 
			while(a!=0) {
				result = a%10; // 나눈 결과
				if(result ==8 ) {
					cnt++;
				}
				a=a/10;
			}
			
		}	
		System.out.print("8의 개수는  " + cnt);
		//			if(su369) {
		//				System.out.println();
		//			}else {
		//				System.out.println(i);
		//			}


	}
}
