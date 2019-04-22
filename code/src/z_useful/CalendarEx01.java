package z_useful;

import java.util.*;

public class CalendarEx01 {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.YEAR) + "년");
		System.out.println((c.get(Calendar.MONTH)+1) + "월"); // 서구식 달력은 문자열이라서 0번째부터 1월이다. 
		System.out.println(c.get(Calendar.DATE) + "일");
		//요일  (일 = 1 , 월 =2 , 화 =3. .... >> 노답... 배열을 이용하자 ! 
		System.out.println(" " + c.get(Calendar.DAY_OF_WEEK) + " 요일");
		
		
		
		// 시 , 분 , 초 출력
		
		System.out.print(c.get(Calendar.HOUR) + "시");
		System.out.print(c.get(Calendar.MINUTE) + "분");
		System.out.println(c.get(Calendar.SECOND) + "초");
		
		// 그 외 정보 
		
		System.out.println("그해의 " + c.get(Calendar.DAY_OF_YEAR) + " 일 입니다");
		
		// 그 해의 몇 번째 주인가 
		System.out.println("그해의 " + c.get(Calendar.WEEK_OF_YEAR) + " 주 입니다");
		
		// 이 달의 몇 번째 주인가 
		System.out.println("이달의 " + c.get(Calendar.DAY_OF_MONTH) + " 일 입니다");
		
	}

}
