package g_access.sub;

public class Access {
	private   String a = "private data";
	public    String b = "public data";
			  String c = "default data";
	protected String d = "protected data";
	
	public void output() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
	
}

/*
 * 	접근 지정자
 * 	- private : 해당클래스에만 허용  
 *  - public  :	모든 허용
 *  - default : ( 아무것도 지정하지 않은 상태) : 해당 패키지에만 허용  
 *  - protected : 다른 패키지인 경우 상속관계에만 허용 
 *  			( 동일패키지 허용 ) 
 *  
 *  점근 범위 
 *  private < default  <  protected  < public
 *  
 *  0. 같은 클래스 안에서는 private도 가능 
 *  1. 같은 패키지 안에서  퍼블릭, 디폴트, 프로텍티드 가능
 *  2. 다른 패키지 		 퍼블릭 만 가능 
 *  3. 다른 패키지, 부모자식관계 	퍼블릭과 프로텍티드 가능 
 */
