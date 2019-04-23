package g_exception;

import java.io.FileInputStream;

public class Ex03_throws {

	public static void main(String[] args) {

		try {
			readFile();
			System.out.println("읽음");
		}catch(Exception ex) {
			System.out.println("예외발생");
		}

	}
	static void readFile() throws Exception { // 구체적으로 알면 써주면 됨. 그냥 범용 Exception을 하면 모두 
		FileInputStream fis = new FileInputStream("abc.txt");
		System.out.println("파일연결");
	}

}
