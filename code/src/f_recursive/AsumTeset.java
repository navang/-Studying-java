package f_recursive;

public class AsumTeset {
/*
	public static void main(String[] args) {

		int sum = 0;
		for(int i=0; i<=10; i++) {
			sum+=i;
			
			int exsum = sum;
			sum =exsum +i ;
			System.out.println(sum+ "=" + exsum + "+" + i);
			
		}
		System.out.println("합:" + sum);
		
	}
*/
	public static void main(String[] args) {
		int sum=0;
		sum= sumFunc(10);
		System.out.println("총합 " + sum);
	}
	
	static int sumFunc(int i ) { 
		if(i==1) return 1;
		return i + sumFunc(i-1);
		
	}
}
