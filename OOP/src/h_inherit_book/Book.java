package h_inherit_book;

import h_inherit_book.sub.Item; // 패키지가 달라서 임포트 

public class Book extends Item {
	
	String writer;  // 상속 확장가능성이 있으면 private 그렇지않으면 protected
	String publisher;
	
	Book() {
		super();
		//System.out.println("기본 생성자");
	}
	Book(String no, String title, String writer, String publisher){
		super(no,title); // 자동으로 들어옴 또는 부모의인자를넣어서
		//super.no =no;  // super 부모 멤버 접근 //  this 내 멤버접근
		//this.title= title;
		this.writer= writer;
		this.publisher= publisher;
		
		//System.out.println("인자 생성자");
		
	}
	public void output() {
		System.out.println("번호 :" + no);
		System.out.println("제목 :" + title);
		System.out.println("작가 :" + writer);
		System.out.println("출판사 :" + publisher);

	}
	
}
