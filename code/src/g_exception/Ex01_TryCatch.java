package g_exception;

/*
 * 	오류
 * 
 * 		- 에러 : 심각 오류
 * 		- 예외 : 심각하지않은 오류 
 * 
 * 	예외처리 - 프로그램을 정상적으로 종료하기 위해 
 * 
 * 	(1) 예외를 잡자 - try ~ catch 구문 
 * 	try{
 * 		예외 발생할 구문 
 * 	}catch() {
 * 		예외가 발생한 후의 구문
 * 	}finally{
 * 		예외발생여부 상관없이 무조건 실행 구문
 * 	}
 */

public class Ex01_TryCatch {

	public static void main(String[] args) {

		String [] str = { "맛점", "우산" , "즐거운   "};

		try {									// try ~ catch 예외 오류가 있으면 catch다음으로
			for(int i=0; i <= str.length; i++) 	// '=' 가 오류 
			{
				System.out.print(str[i]); 
			}
			System.out.println("예외가 발생할 여지가 있는 구문");	// try~catch를 씌워주고 예외오류가 없으면 실행
			return;											// return 이면 제어권 을 반환해  40줄로 끝남
		}catch(Exception ex) {								// try~ catch구문
			System.out.println(" 예외발생" + ex.toString()); 	// ex.getMessage // ex.toString // ex.printStackTrace
		}finally {											//return을 해도 무조건 수행// 무조건 실행 
			System.out.println("무조건 실행 구문");	
		}
		System.out.println("종료");							//return; 했기때문에 실행하지않음 
	}
}
