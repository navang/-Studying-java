package j_useful;

public enum Names { //  클래스와 유사사용)
	
	GILDON("개발"){
		String salary() {return "add 급여";}
	},

	GDON("디잔"),

	GON("기획");
	//-------------------------------
	String job;
	Names(String job) { this.job = job;	}
	String salary() {return "고정급여";}
	
}
