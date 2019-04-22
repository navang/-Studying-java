package d_array;

import java.util.Calendar;

public class Ex00_배열초기화 {

	private static int i;

	public static void main(String[] args) {
/*
		int a; // 변수 선언 (기본형) -> 메모리 확보 
		a= 10; // 값 지정
		int b =20; //초기화
		
		//-------------------------------------------'
//		int [] arr; //  변수 선언 (참조형) -> 메모리확보
//		arr = new int[3]; // 객체생성 (메모리 확보 ) 
		
		int [] arr = new int[] {3,4,5}; // 변수선언 + 배열 초기화 
		// int [] arr ={3,4,5}; // 변수선언 + 배열 초기화  줄여서 씀 
		
		for (int i =0; i< arr.length; i++); {
		
			System.out.println(arr[i]);
		}
*/	
		Calendar c = Calendar.getInstance();
		String [] day = {"일","월","화","수","목","금","토"};  // 배열을 선언 
		
		int yoil = c.get(Calendar.DAY_OF_WEEK);  		// day는 string  day[(달력에서 가져온 요일 값]
		
		System.out.println( day[(yoil-1)] + "요일");      // 일요일 이 1이므로 0부터시작하는 배열로 맞춰주기 위해 -1 
	
		
		
	}

}
