package z_inherit_연습문제;

public class Mal {
	
	String in;
	String ja;
	String ha;
	int j;
	
	Mal(){
		//System.out.println("Item 기본생성자");
	}
	
	Mal(String in, String ja, String ha, int j){
		this.in = in;
		this.ja = ja;
		this.ha = ha;
		this.j = j;
		}
	
//	클래스 변수 = new 클래스
//	pritn(클래스 변수)
	
	public void output() {
		System.out.println("인사말 :" + in);
		System.out.println("자기소개 :" + ja);
		System.out.println("하고싶은 말:" + ha);
	}

}
