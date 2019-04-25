package z_etc;
	import java.util.*;
public class Test2 {

	public static void main(String[] args) {
		ArrayList<String> data = method();
//		for(int i=0; i<data.size(); i++) {
//			String str = (String) data.get(i); // 반환 자료형이 object , 받는 형식으로 형변환 
//			System.out.println(str);
//		}
		for(String s:data) {			// 향상된 for문 
			System.out.println(s);
		}
		// 출력
	}

	static ArrayList<String> method () { //<자료형> generics 로 명확하게 지정 해주기 
		String a = "올라"; 
		String b = "헬로우 ";
		String c = "안녕 "; 
		
		ArrayList<String> list = new ArrayList(3);	// 자동으로 공간확보 정해진배열보다는 메모리 할당이 크다 
		list.add(a);
		list.add(b);
		list.add(c);
		list.add("to");
		return list;
		
		
		
	}
}
