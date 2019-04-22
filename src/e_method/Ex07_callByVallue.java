package e_method;

public class Ex07_callByVallue {

	public static void main(String[] args) {
		int a = 10, b =20;
		add(a,b);
		System.out.println("A= " +a + ", B=" + b);
		System.out.println("2.A= " + a + ", B= " + b);
	}
	static void add(int a, int b) {
		a+=b;
	}
}
// 30 20 // 10 20 