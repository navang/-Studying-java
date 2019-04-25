package g_access;

import g_access.sub.Access;

public class Main {

	public static void main(String[] args) {
		Access me = new Access();			
//		me.a = "프라이빗 변경";				// 다른  패키지 안에서는 접근 불가 
		me.b = "퍼블릭 변경";				// 다른  패키지 안에서는 접근 가능
//		me.c = "디폴트 변경";				// 다른  패키지 안에서는 접근  불가 
//		me.d = "프로텍티드변경";			// 다른  패키지 안에서는 접근 불가 
		me.output();

	}
}
