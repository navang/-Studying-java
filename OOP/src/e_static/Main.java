package e_static;

public class Main {  // 하나에 클래스당 하나의 자바파일을 두자 

	public static void main(String[] args) {
		
//		Book b1 = new Book(); // 객체가 없는 상황이라면
//		Book b2 = new Book();
//		Book b3 = new Book();
		System.out.println("갯수 : " + Book.getCount()); // static 은 이미 올라와있어서 클래스 명 접근이 가능하다 
														//	(Book)클래스명.getCount()캡슐화된메소드 입력받아옴 
	
		
	}

}
