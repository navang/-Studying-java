package e_method;

public class Z_Ex_예제02 {

	public static void main(String[] args) {
		
	}
}
/*1. 다음 프로그램의 결과는?

 

class Test {

public static void method( int i, int j) {

  i <<= j;

}

public static void main ( String  [] args ) {

  int i = 4, j = 2;

  method( i, j );						 // 상관없다 위에서 넘겨주지않기때문! 

  System.out.println(“i = “ + i );		// i= 4 4

}

}

 

2. 다음 아래의 method 메소드를오버로딩 한 메소드들은?

long  method ( int a , int b ) {   return  a+b;   }

 

           (1)  void method ( int x, int y )     {  return x+y;   }

           (2)  long method ( long a, long b ) {  return a+b;   }

           (3)  long Method ( long a, long b ) {  return a+b;   }

           (4)  long method ( int a, long b )  {  return a+b; }

 

3. 다음 프로그램의 결과는?

 

class Test {

static void method( int i, int j) {

     i += j;

     System.out.println(“i = “ + i + “ , j = “ + j );

}

public static void main ( String  [] args ) {

     int i = 4, j = 2;

     method( i, j );

     System.out.println(“i = “ + i + “ , j = “ + j );

}

}

 

4. 다음 프로그램의 결과는?

 

class Test {

static void method( String i, String j) {

     i += j;

     System.out.println(“i = “ + i + “ , j = “ + j );

}

public static void main ( String  [] args ) {

     String i = “안녕”, j = “자바”;

     method( i, j );

     System.out.println(“i = “ + i + “ , j = “ + j );

}

}

 

5. 다음 프로그램의 결과는?

 

class Test {

static int method( int i, int j) {

     int sum = i + j;

     System.out.println(“sum = “ +  sum );

     return sum;

}

public static void main ( String  [] args ) {

     int i = 4,  j = 2;

     int sum = 0;

     method( i, j );

     System.out.println(“sum = “ +  sum );

}

}

 

 

6. 이 프로그램에서 출력 결과가third = 2라고 출력하기 위해 콘솔창에서 자바를 실행했을 때 맞는 것은?  

class Test {

public static void main ( String  [] args ) {

  String first = args[1];

  String second = args[2];

  String third = args[3];

  System.out.println(“third = “ + third );

}

}

 

           (1)java Test 1 2 3 4

           (2)java Test 1432

           (3)java Test 4 3 2 1

           (4)java Test 1 4 3 2

 
*/