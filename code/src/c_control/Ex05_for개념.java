package c_control;


/*
 * for ( 초기값 ; 조건문 ; 증가식 )
 * {
 * 	반복할 문장들 
 * } 
 * 
 */
public class Ex05_for개념 {

	public static void main(String[] args) {

		/*
		 * for(int i=1; i<=10; i++) {

			sum+= i; // sum = sum + i;
		}
		System.out.println("result :" + sum );

		 */

		// 연습 1~ 100 까지의 홀수의 합과 짝수의 합 
		/*		int sum = 0, sum1 =0;
		for(int i=1; i<=10; i++) {
			if(i%2 == 0)  sum+=i;
			else {sum1+=i;
			}
		 */
		// 2씩 띄워서 계산 
		/*
		int sum = 0, sum1 =0;
		for(int i=1; i<=10; i+=2) {
			sum+=i;
			sum1+=(i+1);
		}
		System.out.println("짝수들의 합은 :" + sum );
		System.out.println("홀수들의 합은 :" + sum1 );
		 */
		// A~Z 출력 


		for(char c='A'; c<='Z'; c++) {

			System.out.print( c + " " );
		}

		// A~Z 출력 


		for(char c='Z'; c>='A'; c--) {

			System.out.print( c + " " );
		}
	}
}

/* 내가 푼것 
		for(int i=1; i<=100; i++) {	

			if((i%2)== 0){		
				sum+= i;
			}
		}
		System.out.println("짝수들의 합은 :" + sum );

		for(int i=1; i<=100; i++) {

			if((i%2)== 1){		
				sum1+= i;
			}
		}
		System.out.println("홀수들의 합은 :" + sum1 );
		// sum = sum + i;

 */

