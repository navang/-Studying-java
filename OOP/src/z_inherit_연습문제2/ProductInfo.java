package z_inherit_연습문제2;


import java.util.Scanner;

public class ProductInfo {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Product p =null;
		Product[] pArray= new Product[5]; 
		END:
		for(int numberOfProduct = 0; numberOfProduct<5; numberOfProduct++) { // 5개상품

			System.out.println(" 항목을 선택하세요 1:상품추가 2:모든상품 3:끝내기");
			int a =scan.nextInt();
			if(a == 3) {
				System.out.println("종료합니다");				//꺼라 		
				break END;	
			}
			if(a == 2) {
				for(int i=0; i<5; i++) {
					if(i==0) 
					pArray[i].showinfo();					// 모든상품 보여줘 
				}
			}
			if(a == 1) { 									// 고르자! 
				System.out.println("_________ 선택하세요 __1:책 2:음악 3:회화");
				int j =scan.nextInt();		//위의 선택지 1,2,3			
				System.out.println(j);
				
				//pArray[i]= new Product((String)scan.nextLine(),(String)scan.nextLine(),(String)scan.nextLine(),(int)scan.nextInt());
				if(j == 1) {
					System.out.println("상품ID: 설명: 생산자: 가격:int ISBN:int 저자: 제목:");
					pArray[numberOfProduct]= new Book(
							(String)scan.next(), 
							(String)scan.next(),
							(String)scan.next(), 
							(int)scan.nextInt(),
							(int)scan.nextInt(),
							(String)scan.next(),
							(String)scan.next());
				}if(j == 2) {
					System.out.println("상품ID: 설명: 생산자: 가격:int 앨범제목: 가수:");
					pArray[numberOfProduct]= new CompactDisc(
							(String)scan.next(),
							(String)scan.next(),
							(String)scan.next(),
							(int)scan.nextInt(), 
							(String)scan.next(),
							(String)scan.next());
				}if(j == 3) {
					System.out.println("상품ID: 설명: 생산자: 가격:int ISBN:int 저자: 제목: 언어");
					pArray[numberOfProduct]= new ConversationBook(
							(String)scan.next(),
							(String)scan.next(),
							(String)scan.next(),
							(int)scan.nextInt(),
							(int)scan.nextInt(),
							(String)scan.next(),
							(String)scan.next(),
							(String)scan.next());
				}
				if(numberOfProduct == 4) {
					System.out.println("선택된 상품 " + (numberOfProduct+1) +"개, 더 이상 추가할 수 없습니다");break; //5개만 골라라 
				}
			}
		}
	}
}

