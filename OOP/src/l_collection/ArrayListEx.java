package l_collection;
/*
 *  1. List 구조 
 *  	- 순서를 저장 
 */




import java.util.*;
public class ArrayListEx {

	public static void main(String[] args) {


		ArrayList<String> list = new ArrayList<String>(4); // 동적 배열  vector list = new vector(4);
		list.add("cat");
		list.add("dog");
		list.add("mouce");
		list.add("croc");
		list.add("lion");
		list.add("penguin");
		
		for (String str : list) { // str :  (집단형 자료) 
			System.out.println(str);
		}
		System.out.println(list.toString());
		
		list.set(1, "zebra");			// 바꾸기
		System.out.println(list);
			
		list.remove(4);					// 지우기
		System.out.println(list);
		
		Collections.sort(list);			// 문자열따라 재정렬 return
		System.out.println(list);
		
	/*	for(int i=0; i<list.size(); i++) {
			String str = (String)list.get(i);
			System.out.println(str);
		}*/
	}

}
