package g_exception;

public class Ex04_throw {
	public static void main(String[] args) {
		try {
			readArray();
		}catch (Exception ex) {
			System.out.println("예외발생: " + ex.getMessage());
		}
		System.out.println(" 정상종료 ");
	}
	static void readArray() throws Exception{ 						// 예외를 다 받기 
		String str[] = {"우리는 한배" , "가즈아" , "ㅇㅅㅇ"};
		try {
			for(int i=0; i<=str.length ; i++) {						// 예외를 일부러 발생 
				System.out.println(str[i]);
			}
		}catch(Exception ex) {
			throw new MyException();
		}
	}
}
