package e_method;

public class Ex01_흐름 {
	public static void main(String[] args) {

		System.out.println("main 시작 ");
		method();
		System.out.println("메인 끝 ");
	}

	// static 메소드에서 stattic 만 접근 가능 
	static void method() {
		System.out.println(" method 실행");
	}
}
