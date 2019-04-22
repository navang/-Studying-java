package e_method;

public class Ex07_CallByReference {

	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("행복하자");
		StringBuffer b = new StringBuffer("짝궁님");
		add(a,b);
		System.out.println("2. A= " + a + ", B =" + b );
		
	}
	static void add(StringBuffer a, StringBuffer b) {			// int char double long shot ...  기본형은 원본데이터 변경 없음 // 참조형은 원본 데이터를 건드림 
		a.append(b);											// a에다가 b를 합성 a+=b ( 원본데이터를 건드림 (참조형)) 
		System.out.println("1. A = " + a + ", B=" + b);
	}
}
