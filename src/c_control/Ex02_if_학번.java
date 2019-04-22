package c_control;

import java.util.Scanner;

public class Ex02_if_학번 {

	public static void main(String[] args) {


		Scanner input = new Scanner(System.in); 

		String id = input.nextLine(); // 학번입력

		//		String id = ("2012102367"); //  학번 입력 

		String yyyy = id.substring(0,4); // 0번째부터 4의 전까지 (0000번째까지)
		String dande = "";  // 단대에 밑에서 대입한 값을 출력하기위해 문자열 변수를 선언 
		char dan = id.charAt(4); // 5번째 글자 변수를 선언 
		String hak = id.substring(5,7); // 학과구하기
		String hakkwa = "";
		
		// swich 문으로 바꿔 보자 
		
		
		//1이면 공대 2면 사회학과대 대입 // 예대로 바꿈 
	if(dan == '1') {
		dande = "예대";
		
		switch(hak){
		
		case "11" : hakkwa="시각디자인과"; break;
		case "02" : hakkwa="디지털콘텐츠학과"; break;
		case "13" : hakkwa="산업디자인학과"; break;
		case "22" : hakkwa="의류디자인학과"; break;
		case "33" : hakkwa="도예학과"; break;
		default : hakkwa = "전과";
			
	}
//			if(hak.equals("11")) {
//				hakkwa = "컴공학과";
//			}
//			if(hak.equals("12")) {
//				hakkwa = "소프트학과";
//			}
//			if(hak.equals("13")) {
//				hakkwa = "모바일학과";
//			}
//			if(hak.equals("22")) {
//				hakkwa = "자바학과";
//			}
//			if(hak.equals("33")) {
//				hakkwa = "서버학과";
//			}
			
	
			
		
		}
		if(dan == '2') {
			dande = "사회학과대";
			if(hak.equals("11")) {
				hakkwa = "사회학과";
			}
			if(hak.equals("12")) {
				hakkwa = "경영학과";
			}
			if(hak.equals("13")) {
				hakkwa = "경제학과";
			}
		}
		
		//1이면 공대 2면 사회학과대 대입
	


		String hakyeon = id.substring(6,8); // 6(7번째부터 8(9번째 전까지 

		System.out.println(id + "님은 " + yyyy + "년에 입학한 " + dande + " " + hakkwa + " 학생입니다" );

		/*
		 * 우리대학의 학번은 총 10자리로 되어 있습니다.
맨 앞의 4자리는 입학년도이고 5번째 문자는 단과대 번호입니다.
0000000
     1 : 공대
     2 : 사회대
그 뒤의 2자리는 각 학과번호입니다.
  공과대학인 경우는
     11 : 컴퓨터학과       12 : 소프트웨어학과          13 : 모바일학과
     22 : 자바학과         33 : 서버학과
사회대학인 경우는
  11 : 사회학과         12 : 경영학과          13 : 경제학과

       ex) 2017111001 는 2017년도에 입학한 공대 컴퓨터학과 학생입니다
       ex) 2019211001 는 2019년도에 입학한 사회대 사회학과 학생입니다
       ex) 2018133001 는 2018년도에 입학한 공대 서버학과 학생입니다  
		 */

	}

}
