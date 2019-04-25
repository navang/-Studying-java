package b_encapsulation;

	/*
	 *  클래스 = 서로다른 자료형의 변수들
	 *  *캡슐화 = 권한 관련 부여 
	 *  멤버면수 = private (다른 클래스에서 접근 ㄴㄴ )
	 *  멤버메소드 public (모든 접근허용 ) 
	 */

public class Student {  // 변수선언 서로다른 자료형 
	private String name;		// private  는 입력 외 접근불가 
	private int kor, eng, math;
	private int total;
	private double avg;
	
	 public int calTotal() {
		total = kor+eng+math;
		return total;
	}
	
	public double calAverage() {
		avg =(double)total/3;
		return avg;
	}
//-----------------------	// setter  / getter  private 묶어준걸  접근하기위함-------------------
	public void setName(String name) { //  String name를 받아와서 name에 저장 
		this.name = name;				//  this. 전역변수(멤버)를 지정
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}
//---------------------------------------getter
	public String getName() {
		
		return name;
	}

	public int getKor() {
		
		return kor;
	}

	public int getEng() {
		
		return eng;
	}

	public int getMath() {
		
		return math;
	}
	



}
