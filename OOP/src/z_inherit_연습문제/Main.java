package z_inherit_연습문제;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Mal i =null;
		char result ='0';
		do {
			System.out.println(" 항목을 선택하세요 1:Korean 2:English 3:Japaness");
			Scanner scan = new Scanner(System.in);
			int lang =scan.nextInt();

			System.out.println(" 항목을 선택하세요 1:인사말 2:자기소개 3:하고싶은말");
			int j =scan.nextInt();		// 인자

			switch(lang) {
			case 1: i= new Kor("안녕하세요", "재우라고 합니다", "빨리끝내주세요", j); break;
			case 2: i= new Eng("hey", "Im", "bagopayo", j);break;
			case 3: i= new Jap("こんにちは。", "おひさしぶり", "頑張って", j);break;
			}
			i.output();
			
			System.out.println("계속하쉴? (Y/N)");
			result = scan.next().charAt(0);
			if(result == 'N'| result == 'n') { break;
			}
		}while(result == 'Y' | result == 'y');
		
	}
}
