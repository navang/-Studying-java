package b_operator;

/*
 *  비교연산자 : >  <  >=  <= == !=
 */
public class Ex04_comp {

	public static void main(String[] args) {
		
		int k=79, e=30, m=77;
		double avg = (double)(k+e+m)/3;
		System.out.println("평균:" + avg);
		String score = ""; 
		
		switch((int)(avg/10)) {
		case 10:  								// 10인경우부터 A학점 부여 
		case  9:  score= "A학점" ; break;
		case  8:  score= "B학점" ; break;
		case  7:  score= "C학점" ; break;
		default : score= "F" ;
		
		}
		System.out.println("당신은 " + score + " 입니다 ");
		
		
//		if(avg>=90) {
//			System.out.println("A학점");
//		}else if(avg>=80) 
//			System.out.println("B학점");
//		else  
//			System.out.println("C학점");
//			
		
	}

}
