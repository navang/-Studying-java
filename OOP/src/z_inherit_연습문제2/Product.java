package z_inherit_연습문제2;

public class Product {
	
	String productID;
	String description;
	String producer;
	int price;
	
	public Product(){
		//System.out.println("Item 기본생성자");
	}
	
	public Product(String productID, String description, String producer, int price){
		this.productID = productID;
		this.description = description;
		this.producer = producer;
		this.price = price;
		}
	public void showinfo() {
//		System.out.println("제품 :" + productID);
//		System.out.println("소개 :" + description);
//		System.out.println("제작자:" + producer);
//		System.out.println("가격:" + price);
	}

	

	


}
