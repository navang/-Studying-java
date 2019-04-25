package a_basic;
// OOP Object Oriented Programming 

import c_array.Student;

public class Main {

	public static void main(String[] args) {
		
		Student s = new Student();  // 클래스는  무조건 new
		s.name="홍길동";
		s.kor=100;
		s.eng=88;
		s.math=77;
		System.out.println("총점 " +s.calTotal());
		
		System.out.println("평균 " +s.calAverage());
	}

}
