package e_method;

public class Ex01_흐름2 {
	public static void main(String[] args) {

		System.out.println("main 시작 ");
		Ex01_흐름2 ex = new Ex01_흐름2();
		ex.method();
		System.out.println("메인 끝 ");
	}

														// static 메소드에서 static 만 접근 가능 
	void method() {										//	static을 안쓰는 경우 위에서 메모리 객체 선언을 해준다 
		System.out.println(" method 실행");
	}
}
