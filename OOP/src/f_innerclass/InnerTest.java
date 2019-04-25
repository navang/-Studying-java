package f_innerclass;

class Outer {
			static class Inner {						// 클래스안에 클래스가 가능 // 멤버취급을 받음 
					static void najabara ( ) {
							System.out.println("호출해주세요 ");
		}
	}
}
public class InnerTest {  						// 현재 이 클래스명 
	public static void main(String[] args) {
//			Outer o = new Outer();
//			Outer.Inner in = o.new Inner();
//	Outer.Inner in =new Outer.Inner();
//	in.najabara();
		Outer.Inner.najabara();
	
	}

}

