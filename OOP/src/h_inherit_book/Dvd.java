package h_inherit_book;

import h_inherit_book.sub.Item;

public class Dvd extends Item {
	
	String actor;
	String director;
	
	Dvd() {
		super();
		//System.out.println("기본 생성자");
	}
	Dvd(String no, String title, String actor, String directer){
		super(no,title); // 자동으로 들어옴 또는 부모의인자를넣어서
		//super.no =no;  // super 부모 멤버 접근 //  this 내 멤버접근
		//this.title= title;
		this.actor= actor;
		this.director= director;
		
		//System.out.println("인자 생성자");
		
	}
	public void output() {
		System.out.println("번호 :" + no);
		System.out.println("제목 :" + title);
		System.out.println("배우 :" + actor);
		System.out.println("감독 :" + director);
	
		
	}
}
