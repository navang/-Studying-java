package e_method;

public class Ex07_CallByString {

	public static void main(String[] args) {
		String a = new String("행복하자");
		String b = new String("짝궁님");
		add(a,b);
		System.out.println("2. A= " + a + ", B =" + b );

	}
	static void add(String a, String b) {			
		a+=b;														//call by reference 임에도 string ㅋㄹ래스의 특성상 결과가 다르게 나온다 메모리변경되면 따로 잡기때문! 
		System.out.println("1. A = " + a + ", B=" + b);
	}
}