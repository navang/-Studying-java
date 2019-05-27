package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class test {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add("허니콤보/3000/3");
		al.add("허니콤보/3000/3");
		
		
		Iterator iterator = al.iterator();
		while (iterator.hasNext()) {
		String str = (String) iterator.next();

		StringTokenizer st = new StringTokenizer(str,"/");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		}
		System.out.println(al);
		

	}

}
