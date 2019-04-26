package h_inherit_book.sub; // 하위 패키지로 이동 

public abstract class Item {
	
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
	public abstract void output();  // { }   함수 표시는 아무일도 하지않지만 완벽한 함수 구현
								    // (추상) 미완성 메소드를 가졌다면 클래스도 (추상)미완성이다				
									// overriding 이 필수
									// 모든 상속 클래스가 overriding 을 해야함 ! 

}
