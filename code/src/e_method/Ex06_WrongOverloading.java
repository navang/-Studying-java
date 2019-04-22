package e_method;

public class Ex06_WrongOverloading {

	public static void main(String[] args) {
		String msg = "안녕";						//
		output2(msg);							// static void output2로 넘겨줌 
		
		String result = output1(msg);			// statc String output1 에서 받음 
		System.out.println(result);
	}

	static void output2(String msg) {			// string msg를 받는다 
		System.out.println(msg);
	}
	static String output1(String msg) {			// string msg를 받아서  
		String result = "맛점"+msg;				// 처리후
		return result;							// result로 반환 
	}
}
