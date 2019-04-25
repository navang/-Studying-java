package h_inherit_book;

import java.util.Scanner;

import h_inherit_book.sub.Item;

public class Main {

	public static void main(String[] args) {
		
//		Book b = new Book();
//		b.output();
		Item i =null;
		
		System.out.println(" 항목을 선택하세요 1:Book 2:Dvd 3:Cd");
		Scanner scan = new Scanner(System.in);
		int sel =scan.nextInt();
		
		switch(sel) {
		case 1: i= new Book("0002", "java", "아무개","한빛미디어"); break;
		case 2: i= new Dvd("0003", "GBH", "구스타브","웨스앤더슨");break;
		case 3: i= new Cd("0004", "사랑의빳데리", "홍진영");break;
		}
		i.output();

	}

}
