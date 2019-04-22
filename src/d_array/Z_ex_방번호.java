package d_array;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Z_ex_방번호 {

		public static void main(String[] args) {
/*
			//  1.컴퓨터 랜덤 수 3개 만들기
			int baseball[] = new int [6];					// 3칸의 인덱스 메모리를 할당
			for( int a=0; a<baseball.length; a++) {			// 배열 baseball[0, 1, 2] 의 
				baseball[a] = (int)(Math.random()*10);		// 값을 0~9까지 무작위 숫자로 넣겠다 

				//1-1. 동일수 비교해서 같으면 다시 작업
				for(int k=0; k<a; k++) {					// 인덱스 에서 k가 a전 거 (앞뒤 비교   
					if( baseball[a] == baseball[k]) {		// a 와 k 번째의 수가 같으면 
						k--;								// k 를 증가시키지말고 다시 작업해라 (다른 번호 만 넣어서 
					}
				}
			}
			*/
			
			/* for( int a=0; a<baseball.length; a++) {	    //* 컴퓨터가 설정한 임의의 3개 숫자 baseball[] 정답
				System.out.println(baseball[a]);			
			} */
			
			END :											 // 3 strike 인 경우 break 가 오는 라벨 포인트
				for (int n=0; n<10; n++)  {  					 // 기회를 10번 주겠다 
					

					Scanner input = new Scanner(System.in);			// 입력
					System.out.println("숫자를 입력(ex) _ _ _"); 		// 시작 안내문

					String score = input.nextLine();					// 입력 __ __ __
					int answer[] = new int [3];							// 메모리 할당 
					StringTokenizer st = new StringTokenizer(score); 	// " "를 기준으로 잘라서 입력받아라  
					for(int i=0; st.hasMoreTokens(); i++) {				// " "다음에 단어가 있으면 i++
						answer[i] = Integer.parseInt(st.nextToken());   //2. 사용자가 입력값 답을 answer 에 각각 담기 
					}
					// System.out.println(answer[0] + "" + answer[1] + "" + answer[2]);  //입력받은것 확인 
					
					System.out.println(" 앞으로 " + (9-n) + "번의 기회가 있습니다");
					//3. baseball 배열과 answer 배열을 각각 비교 
					int strike =0, ball=0;						// strike 와 ball 의 초기값 설정
					for(int i=0;i<baseball.length; i++) {		// baseball[] 의 인덱스 번호
						for(int j=0; j<answer.length; j++) {	// answer [] 의 인덱스 번호
							if(baseball[i] == answer[j]) {    	// 배열 안에서 값이 같다면
								if(i == j) {					// 자리까지 같다면 strike ++
									strike++;
								}else { 			    		// 위치는 다르면 ball++
									ball++;
								}
							}
							if( strike == 3) { 					// strike 가 3 이면 
								System.out.println(" 정답을 맞췄습니다");
								break END;						//3. strike 이라면 반복문 종료 
							}

						} 

					}
					System.out.println(strike + "strike "+ball +"ball"); //결과값 출력 
				}

			
	}

}
