package c_control;

public class Ex06_중첩for {

	public static void main(String[] args) {
		
		// ***** // ***** *5
		/*
		 * c
			
			for( int  c=4;  c>=i; c-- ) { // 1개씩 감소 
			//for( int c=0; c<=5; c++ ) { 1개씩 증가 	
			System.out.print('*');
		}
			System.out.println();
		} */
		
		// 알파벳 a ~ z 한줄 
//		for( int  c=0;  c<26; c++ ) {
//			
//			for( char  i='A';  i<='A'+ c; i++ ) {
//			System.out.print(" " + i);
//			
//		}
//			
//		System.out.println();
//		
//		}
		// 문제 2 --------------------------------------------------------
		/*
		for( int  c=0;  c<26; c++ ) {
			
			for( char  i='A';  i<='Z'- c; i++ ) {  // 문제 2 번 
			System.out.print(" " + i);
			
		}
			
		System.out.println();
		
		}
		*/
		//-----문제 3----------------------------------------------------------
		/*
		for( int  c=0;  c<=26; c++ ) {
			
			
			for( char  i=(char)('A'+c) ;  i<='Z'; i++ ) {  
			
			System.out.print(" " + i);
			}
		System.out.println();
		*/
		/* 문제 4 --------------------
		 
		 
		for( int  c=0;  c<26; c++ ) {
				
				for( char  i='Z';  i>='A'+ c; i-- ) {
				System.out.print(" " + i);
				
			}
				
			System.out.println();
			
			}
			*/
			/* 문제 4 두번째 
		for( int  c=0;  c<26; c++ ) {
				
				for( char  i='Z';  i>='Z'- c; i-- ) {    
				System.out.print(" " + i);
				
			}
				
			System.out.println();
			
			}
			*/// 문제 5 ----------------------------------------------------------
			
		for( int  c=0;  c<26; c++ ) {
			for( int  s=0;  s<c; s++ )  // 공간을 1씩 증가하는 c로 넣어주자! 
				System.out.print(" ");  
			for( char  i=(char)('A'+c) ;  i<='Z'; i++ ) {   // 'A' 에서부터 다음거로 시작하고 'Z'에서 끝나기 
				System.out.print(i);
		}
		
		System.out.println( );
		
		 
		}
	}

}
