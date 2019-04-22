package z_useful;

/*
 * 자바에서 문자열 처리하는 클래스
 * 1. String 
 * 2. StiingBuffer 
 * 3. StringBuilder = StingBuffer ( 99% 동일 - 1%다른점 ) 
 */

public class StringStringBuffer {

	public static void main(String[] args) {

		String s = "안녕";
		s +="하세요";
		System.out.println(s);   // String은 아무도 참조하지않는 쓰레기를 생성하면 쓰레기 처리반이 자동으로 처리하면서 버벅거린다 
		
		StringBuffer sb = new StringBuffer("반갑");
		sb.append("습니다");
		System.out.println(sb); // 때문에 자주 갱신되는 데이터는 StringBuffer를 통해 갱신해주자 
	}

}
