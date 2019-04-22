package b_operator;

/* 
 * 숏 서킷 로직 : 일반논리에 적용 
 * 
 */
public class Ex_08ShortcircuitLogic {
		public static void main(String[] args) {
			int a = 3;
			if( a>3 & ++a>3) { 
				// 앞의 항이 false 이기때문에 뒤의 계산을 하지않고 false로 출력
				System.out.println("조건만족"); // 출력여부 f
			}
				System.out.println("A="+ a); // a=? 3 
				
				if(a>1 | ++a>3) {
					System.out.println("조건만족2"); // true 
				}
				System.out.println("A=" + a); // 3? 4 ?  
			



}
}