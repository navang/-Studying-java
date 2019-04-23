package b_encapsulation;

public class Main {

	public static void main(String[] args) {
		
		Student s = new Student();  // 클래스는  무조건 new
		s.setName("홍길동");
		s.setKor(100);
		s.setEng(88);
		s.setMath(77);
		
		System.out.println("이름 :" + s.getName()); // setter 에서 가져온걸 getter로 풀어줌
		System.out.println("국어 :" + s.getKor()); 
		System.out.println("영어 :" + s.getEng()); 
		System.out.println("수학 :" + s.getMath()); 
		System.out.println("총점 " +s.calTotal());
		
		System.out.println("평균 " +s.calAverage());
	}

}
