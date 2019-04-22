package a_datatype;

public class Ex04_String {

	public static void main(String[] args) {
		String a = new String("홍길동"); 
		String b = new String("홍길동");
		
		if( a == b) {
			System.out.println("같다");
		}
		else{
			System.out.println("다르다");
		}
		
		if(a.equals(b)) {
			System.out.println("이름이 같다");
		}else {
			System.out.println("이름이 다르다");
		}
	}

}
