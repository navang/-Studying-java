package j_useful;

public class EnumTest {
	
	enum Size{					// 상수들의 모음 ( 클래스와 유사사용)
		SMALL, MEDIUM, LARGE   // 값을 지정하지않은 상수를 만들어줄수있다 . 
	}

	public static void main(String[] args) {
		Size size = Size.SMALL; // 추후에 화면에서 넘어오는 값
		
		switch(size) {
		case SMALL : System.out.println("작은거"); break;
		case MEDIUM : System.out.println("중"); break;
		case LARGE : System.out.println("대"); break;
		}

	}

}
