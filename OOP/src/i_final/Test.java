package i_final;

/*
 *  final  - 변경불가 
 *  		final field - 값 변경 불가 
 *  		final method - overrinding 불가
 *  		final class - 상속불가 
 */
final class Parent {
	final String field = "부모님"; //final 붙으면 오버라이딩 x 한번 정해진대로 쭉 ~ 상수 
	final public void job() {
		System.out.println(" 부모님께서 장만");
	}
}

class Child /*extends Parent*/ {    // final 로 상속받을수 없게됨 
	Child () {
//10		field = "내꺼임" ;
	}
//11 	public void job () {
//		System.out.println("물려받아 탕진");
//	}
}

public class Test {
	
		public static void main(String[] args) {
			Parent p = new Parent();
			System.out.println(p.field);
			p.job();
		}

}
