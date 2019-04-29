package l_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class HashSetLotto {

	public static void main(String[] args) {

		HashSet<Integer> lotto = new HashSet<Integer>();			  // 순서를 저장하지않아서 중복값을 지운다

		while(lotto.size()<6)  {          		  // 로또 개수가 6개 될때까지 
			int su= (int)(Math.random()*45)+1;
			lotto.add(su);
		}
		System.out.println(lotto);

		ArrayList<Integer> list = new ArrayList<Integer>(lotto);   // int 형은 <Integer> 제너릭스 
		Collections.sort(list);
		System.out.println(list);

	}

}
