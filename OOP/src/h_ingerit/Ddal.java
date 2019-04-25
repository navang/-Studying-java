package h_ingerit;
// 상속관계
public class Ddal extends Umma{
	
	public Ddal () {
		System.out.println("자식생성자");
	}
	public void gene () {
		System.out.println("자식은 자식이다");
	}

	public void study () {
		System.out.println("딸은 학생");
	}
}
