package l_collection;

import java.util.TreeSet;

public class TreeSetEx {

	public static void main(String[] args) {


		TreeSet set = new TreeSet();     // 처음부터  중위순으로 비교하여  정렬을 하고
		set.add("lion");
		set.add("dog");
		set.add("cat");
		set.add("fuma");
		set.add("penguin");
		set.add("bear");
		set.add("zebra");
		set.add("snake");
		set.add("dragon");
		set.add("ant");

		System.out.println(set);
		System.out.println(set.subSet("d", "s"));  // "d"<= , <"s" 
		System.out.println(set.headSet("d")); 		// <"d" 
		System.out.println(set.tailSet("s"));		//"s" <= 
	}

}
