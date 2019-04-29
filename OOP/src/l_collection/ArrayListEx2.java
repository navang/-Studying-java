package l_collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx2 {

	public static void main(String[] args) {
		ArrayList<Student> data =method();   // <> 제너릭스  자료형태로 

		// 여기서 출력
		// 표준화 출력 
		// Enumeration -> Iterator 
		Iterator it = data.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//		for(Student s : data)				 // 자료형태 로 Student
		//			System.out.println(s);
		//		for(int i=0; i<data.size(); i++) {
		//			Student s =(Student)data.get(i);
		//			System.out.println(s);
		//		}


	}
	static ArrayList<Student> method() {
		Student a = new Student("홍길수", 20);
		Student b = new Student("홍길우", 30);
		Student c = new Student("홍길라", 40);

		ArrayList<Student> list = new ArrayList<Student>(3);
		list.add(a);
		list.add(b);
		list.add(c);
		return list;
		//System.out.println(list);

	}

}

class Student {
	String name;
	int age;
	Student(String name, int age){
		this.name = name;
		this.age = age;

	}
	public String toString() {
		return name + " 학생은 " + age + "세 입니다";
	}
}