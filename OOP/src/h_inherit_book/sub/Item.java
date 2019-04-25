package h_inherit_book.sub; // 하위 패키지로 이동 

public class Item {
	
	protected String no; // 자식한테만 허용 
	protected String title;
	
	public Item(){
		
		//System.out.println("Item 기본생성자");
	}
	
	public Item(String no, String title){
		this.no = no;
		this.title = title;
		//System.out.println("Item 인자 생성자");
		
	}
	public void output() {
		System.out.println("번호 :" + no);
		System.out.println("제목 :" + title);
	}

}
