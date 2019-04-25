package z_inherit_연습문제2;

import java.util.Scanner;

public class ProductInfo {

	public static void main(String[] args) {

		Product d =null;
		Product[] f=null; // f=pArray
		System.out.println(" 항목을 선택하세요 1:상품추 2:모든상품 3:끝내기");
		Scanner scan = new Scanner(System.in);
		int a =scan.nextInt();
		if(a == 3) {
			System.out.println("종료합니다");//꺼라 			
		}
		
	/*	if(a == 2) {
			for(int i=1; i<=3; i++) {
				switch(i) {
				case 1: d= new Book("productID Book", "파우스트박사 이야기 ", "어딘가출판사", 10000, 1111, "파우스트", "괴테"); 
				case 2: d= new CompactDisc("productID CD", "라틴 얼터네이티브 락", "붕가붕가레코드", 20000, "고질적신파", "불쏘클");
				case 3: d= new ConversationBook("productID Cbook", "JavaLanguage ", "엔코아",13000, 1001, "윤성우", "열혈자바 ", "English");
				}
				d.showinfo();	
			}

		//	f.showinfo();	// 모든상품 보여줘 
		}
	*/
		if(a == 1) { 		// 고르자! 
			for(int numberOfProduct = 0; numberOfProduct<5; numberOfProduct++) { // 5개상품

				System.out.println("_________ 선택하세요 __1:책 2:음악 3:회화");
				int j =scan.nextInt();		// 인자
				System.out.println("product ID_");
				String pID =scan.nextLine();
				String des =scan.nextLine();
				String pdc =scan.nextLine();
				int pri=scan.nextInt();
				
				switch(j) {
				case 1: d= new Book("productID Book", "파우스트박사 이야기 ", "어딘가출판사", 10000, 1111, "파우스트", "괴테"); break;
				case 2: d= new CompactDisc("productID CD", "라틴 얼터네이티브 락", "붕가붕가레코드", 20000, "고질적신파", "불쏘클");break;
				case 3: d= new ConversationBook("productID Cbook", "JavaLanguage ", "엔코아",13000, 1001, "윤성우", "열혈자바 ", "English");break;
				}
				d.showinfo();
				if(numberOfProduct == 4) {
					System.out.println("선택된 상품 " + (numberOfProduct+1) +"개, 더 이상 추가할 수 없습니다");break; //5개만 골라라 
				}
			}
		}
	}
	private void  addProduct () {

	}
}
