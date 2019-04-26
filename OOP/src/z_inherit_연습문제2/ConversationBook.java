package z_inherit_연습문제2;

public class ConversationBook extends Book {
	String language;

	ConversationBook() {
		super();
		//System.out.println("기본 생성자");
	}
	ConversationBook(String productID, 
			String description, 
			String producer, 
			int price,
			int ISBN,
			String author,
			String title,
			String language){
		super(productID, description, producer, price, ISBN, author, title); 
		this.language = language;
	}
	


	public void showinfo() {
		System.out.println("제품 :" + productID);
		
		System.out.println("상품설명 :" + description);
		System.out.println("생산자:" + producer);
		System.out.println("가격:" + price);
		System.out.println("책제목:" + title);
		System.out.println("저자:" + author);
		System.out.println("언어:" + language);
		System.out.println("ISBN:" + ISBN);
	}

}

