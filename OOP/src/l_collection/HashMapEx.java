package l_collection;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx {

	public static void main(String[] args) {
	
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("kimjava", "1111"); // key , value
		map.put("parkjava", "2321");
		map.put("leejava", "9873");
		map.put("kimjava", "1000");
		
		Scanner input = new Scanner(System.in);
		boolean stop = false;
		while(!stop) {				// !~아니면 
			System.out.println("아이디와 패스워드 입력");
			System.out.println("아이디 입력 >> ");
			String id = input.nextLine();
			System.out.println("패스워드 입력 >> ");
			String pw = input.nextLine();
			
			if(map.containsKey(id)) {/*아이디가 map에 key에 해당되는가? 입력받은 key값이 id와 같다면*/
				if(map.get(id).equals(pw)) {/*그 아이디와 같은 key의 값과 입력받은 패스워드 같다면/가져온 id의 값과 pw가 같다면*/
					System.out.println("로그인 성공");
					stop=true;
				}else {
					System.out.println("비밀번호가  일치하지 않습니다");
					continue;
				}
				
			}else {
				System.out.println("존재하지않은 아이디입니다");
				continue;
			}
		}
		
	}

}
