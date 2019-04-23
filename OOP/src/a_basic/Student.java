package a_basic;

public class Student {  // 변수선언 서로다른 자료형 
	String name;
	int kor, eng, math;
	int total;
	double avg;
	
	int calTotal() {
		total = kor+eng+math;
		return total;
	}
	
	double calAverage() {
		avg =(double)total/3;
		return avg;
	}

}
