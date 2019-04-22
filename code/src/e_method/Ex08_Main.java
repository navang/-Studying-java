package e_method;

public class Ex08_Main {

	/*
	 * 메소드명 : main
	 * 인자 : String[] args
	 * 리턴형 : void 
	 * 
	 */
	
	/*
	 *  Test.java
	 *  	(1) 컴파일 : javac Test.java
	 *  	(2) 실행 	 : java  Test 192.168.0.1 scott tiger (ip id pw )  실행할때 데이터를 변경가능 
	 */
	public static void main(String[] args) {
		
		for (int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
		
		
	}

}
