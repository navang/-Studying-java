package z_inherit_연습문제;

public class Kor extends Mal {

	Kor() {
		super();
		//System.out.println("기본 생성자");
	}
	Kor(String in, String ja, String ha, int j){
		super(in,ja,ha,j); 
	}


	public void output() {
		if(j == 1) {
		System.out.println("인사말 :" + in);
		}
		if(j == 2) {
		System.out.println("자기소개 :" + ja);
		}
		if(j == 3) {
		System.out.println("하고싶은 말:" + ha);
		}


	}

}
