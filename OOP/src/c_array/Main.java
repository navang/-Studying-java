package c_array;

import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) {


		Scanner input = new Scanner(System.in);
		System.out.println("학생 수 입력하세요");
		int m = input.nextInt();
		input.nextLine();
		Student[] s=new Student[m];
// for (int i = 0; i<s.length; i+) 
		for (Student stu:s) {			// 추출할때는 빠름 하지만 입력x for 문 stu에는 입력 
			System.out.println("학생정보입력 : 홍길리/89/89/99");
			String info= input.nextLine();
			StringTokenizer st = new StringTokenizer(info,"/");
			String name =st.nextToken();
			int kor =Integer.parseInt(st.nextToken());
			int eng =Integer.parseInt(st.nextToken());
			int math =Integer.parseInt(st.nextToken());

			stu = new Student(name,kor,eng,math);

			stu.calTotal();
			stu.calAverage();
			System.out.println(stu);
		}
	}
}

//			s[i] = new Student();							// student 객체의 메모리 할당이 안되서 해줘야함 
//			System.out.println("학생명 입력 -");
//			s[i].setName(input.next());
//
//			System.out.println("국어 입력 -");
//			s[i].setKor(input.nextInt());
//
//			System.out.println("영어 입력 -");
//			s[i].setEng(input.nextInt());
//
//			System.out.println("수학 입력 -");
//			s[i].setMath(input.nextInt());



//	System.out.println("결과 : " +s[i].getName() + " : 총점" + s[i].calTotal() + "/ 평균" + s[i].calAverage());
//		System.out.println(s[i]);
//		}

//	}
/*
	public static void main(String[] args) {


		Student s = new Student();  // 클래스는  무조건 new
		/*
		s.setName("홍길동");
		s.setKor(55);
		s.setEng(66);
		s.setMath(98);
 */
/*
		System.out.println("이름 :" + s.getName()); // setter 에서 가져온걸 getter로 풀어줌
		System.out.println("총점 " +s.calTotal());
		System.out.println("평균 " +s.calAverage());

		//-------------------------------------------------- 
		Student s2 = new Student("아를",75,56,46);  // 클래스는  무조건 new
		/*
		s.setName("홍길동");
		s.setKor(55);
		s.setEng(66);
		s.setMath(98);
 */
/*
		System.out.println("이름 :" + s2.getName()); // setter 에서 가져온걸 getter로 풀어줌
		System.out.println("총점 " +s2.calTotal());
		System.out.println("평균 " +s2.calAverage());
	}
}


/*
		Scanner input = new Scanner(System.in);
		System.out.println("입력할 학생수는 몇명입니까?");			// 학생수
		int m = input.nextInt();
		Student[] s= new Student[m];						// m명 

		for (int i=0 ; i<s.length; i++) {
			s[i] = new Student();							// student 객체의 메모리 할당이 안되서 해줘야함 
			if(i == 0) {
				System.out.println("학생이름/국어점수/영어점수/수학점수  <-입력하세요");	// string hasMoreTokens 로 전체 정보를 받음 
			}
			for(int j=0; j<s.length; j++) {
				String info = input.next();
				StringTokenizer st = new StringTokenizer(info,"/"); 		// 입력값에서 한번에 받아오기
				s[i].setName(st.nextToken());
				s[i].setKor(Integer.parseInt(st.nextToken()));
				s[i].setEng(Integer.parseInt(st.nextToken()));
				s[i].setMath(Integer.parseInt(st.nextToken()));
			}
		s[i].calTotal();
			s[i].calAverage();
			//	System.out.println("결과 : " +s[i].getName() + " : 총점" + s[i].calTotal() + "/ 평균" + s[i].calAverage());
			// 반복프린트 
			System.out.println(s[i]);


			if(i == s.length) {
				System.out.println("완료");
			}
		}
		}

	}
 */



