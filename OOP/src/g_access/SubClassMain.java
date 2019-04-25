package g_access;

import g_access.sub.Access;

public class SubClassMain extends Access {  // 상속관계  자식 extends 부모 

	public static void main(String[] args) {
		SubClassMain me = new SubClassMain();			
//		me.a = "프라이빗 변경";				// 다른  패키지 안에서는 접근 불가 
		me.b = "퍼블릭 변경";				// 다른  패키지 안에서는 접근 가능
//		me.c = "디폴트 변경";				// 다른  패키지 안에서는 접근  불가 
		me.d = "프로텍티드변경";			// 다른  패키지 안에서는 접근  가능 
		me.output();

	}
}
