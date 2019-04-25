package d_constructor;

public class Student {  // 변수선언 서로다른 자료형 
	//멤버변수
	public String setName;
	String name;
	private int kor, eng, math;
	private int total;
	private double avg;

	// 생성자 함수가 하나도 없는경우 // 값이 나중에 바뀌는 경우 값을 지정해주는 수 밖에 없다 
	// Java Compiler가 자동으로 생성
	// -> 기본 생성자는 만든다
	public Student() {
		// this : 멤버를 지칭하기위한 레퍼런스
		// this() : 다른 생성자 함수를 호출
		//		  : 반드시! 첫 줄에 호출 (초기화이기 때문에 ) 
		this("익jhkjhk",8670,50,50);  //  생성자를 호출하기때문에  "인자있는~" 다음에 "기본~
		/*	
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math =math;
		 */
		System.out.println("기본 생성자 호출");


	}
	// 생성자 - 멤버변수 초기화
	// - 클래스명과 동일한 이름의 함수 
	// - 리턴형이 없음 (void 안됨 ) 
	// - overloading 가능  클래스(의 인자의 자료형과 갯수가 다른경우 ) 
	public Student(String name, int kor, int eng, int math){ // 
		this.name =name;
		this.kor  =kor;
		this.eng =eng;
		this.math =math;
		System.out.println(" 인자 있는 생성자 호출 ");

	}
	//멤버 메소드 
	public int calTotal() {
		total = kor+eng+math;
		return total;
	}

	public double calAverage() {
		avg =(double)total/3;
		return avg;
	}
	//---- set get 

	public void setName(String name) {
		this.name = name;

	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	// 멤버변수 출력하기 위한 메소드

	public String toString() {
		return name + " 학생의 총점 : " +total +" / 평균 : " + avg;
	}

}
