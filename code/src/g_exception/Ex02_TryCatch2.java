package g_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex02_TryCatch2 {

	public static void main(String[] args) {
		FileInputStream fis = null;						//변수를 먼저 선언해준다 아래 finally에서 처리하기위해
		try {
			fis = new FileInputStream("abcf.txt");
			System.out.println("파일 연결");
			fis.read();

		} catch (FileNotFoundException e) {						// 파일이 없으면 발생
			System.out.println("파일 없는 예외  " + e.getMessage());
		} catch (IOException e ) {								// IOException을 처리하는 (파일안에 문자나 뭐 그런거
			System.out.println("입출력 예외" + e.getMessage());
		} catch (Exception e) {							 // 모든 예외를 처리하는 범용 Exception 그래서 맨 마지막에 온다 
			System.out.println(" 그외 예외 처리");
		} finally {
			try{ fis.close(); } catch(Exception ex) {}		// fis를 실행 안하고 
		}

	}

}
