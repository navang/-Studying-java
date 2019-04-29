package l_collection;

import java.util.HashSet;

public class HashSetEx {

	public static void main(String[] args) {

		HashSet list = new HashSet();  // 순서를 저장하지않음 순번을가지고 뭘 못함 , 중복 값 없어짐 
		list.add("cat");
		list.add("dog");
		list.add("mouce");
		list.add("lion");
		list.add("croc");
		list.add("croc");
		list.add("lion");
		list.add("penguin");
		System.out.println(list);
		
		
		
	}
		
	
}
