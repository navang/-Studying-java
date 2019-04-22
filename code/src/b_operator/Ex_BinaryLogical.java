package b_operator;

public class Ex_BinaryLogical {

	public static void main(String[] args) {


		int a = 15 , b =10;
		
		int and = a & b; 
		int or = a | b;
		int xor = a ^ b;
		
		System.out.println(and); // 1111 1010 1010 = 10   
		System.out.println(or); // 1111 = 15
		System.out.println(xor); // 0101 = 5
	}

}
