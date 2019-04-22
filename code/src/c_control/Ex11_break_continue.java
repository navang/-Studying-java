package c_control;

/*
 * 			break -  블럭을 벗어나는 명령
 * 			continue - 블럭의 끝으로 가라는 명령 
 */
public class Ex11_break_continue {

	public static void main(String[] args) {

			END:
			for (int i=0; i <9; i++) {
				for( int j=0; j<3; j++) {
					if(j==1)  break END;	 //continue; (  break; 블럭 밖으로  // continue; 블럭 안쪽 맨끝으로 
					
					System.out.println("<" + i + "," + j + ">");
				}
				
				System.out.println("데이터");
			}
										
	}

}
