package z_etc;

public class Test {  //여러 자료형의 변수를 클래스 생성하지않고 (최상위)Object class를 활용하여 넘기기 

	public static void main(String[] args) {
		Object [] data =method();
		for(int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
	}
	static Object[] method() {
		String a = "헬로";
		int b = 100;
		double d = 26.4;
		Object [] data = new Object[3];
		data[0] =a ;
		data[1] =new Integer(b); // 기본형  
		data[2] =new Double(d);
		return data;
	}

}
