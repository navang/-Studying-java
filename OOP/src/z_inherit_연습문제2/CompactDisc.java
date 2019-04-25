package z_inherit_연습문제2;

public class CompactDisc extends Product {

	String title;
	String singer;

	CompactDisc() {
		super();
		//System.out.println("기본 생성자");
	}
	CompactDisc(String productID, String description, String producer, int price, String title,
			String singer)
	{
		super(productID, description, producer, price); 
		this.title = title;
		this.singer = singer;
	}
	

	public void showinfo() {
		//2번 조회하면System.out.println("제품 :" + productID);
		System.out.println("상품설명 :" + description);
		System.out.println("생산자:" + producer);
		System.out.println("가격:" + price);
		System.out.println("앨범제목:" + title);
		System.out.println("가수:" + singer);
	}
}
