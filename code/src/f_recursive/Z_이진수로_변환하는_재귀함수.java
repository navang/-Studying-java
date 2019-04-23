package f_recursive;

public class Z_이진수로_변환하는_재귀함수 {

	public static void main(String[] args) {
		
		

	}
	public static void t ( int N ) {
		
		if(N > 0) t (N/2);
		System.out.println(N%2);
	}
}
