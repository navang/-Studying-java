package crowling;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Hanbit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		try {
		String url ="http://www.hanbit.co.kr/store/books/new_book_list.html";
		Document doc = Jsoup.connect(url).get();
		/// System.out.println(doc);
		
		Elements body = doc.select("div.sub_book_list_area .book_tit > a");
		for(Element title : body ) {
			System.out.println(title.text());
			
		}
		System.out.println(body);
		
		}catch(Exception ex) {
			System.out.println("예외발생");
			ex.printStackTrace();
		}
	}

}
