package vo;

public class Schedule {
	private int sno;	//스케줄번호
	private String sdate;	//상영날짜
	private String stime;	//상영시간
	private int sthn; //관 번호
	private String mtitle; //영화제목
	private String empno; //직원id
	private String eyn; //상영여부
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public int getSthn() {
		return sthn;
	}
	public void setSthn(int sthn) {
		this.sthn = sthn;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEyn() {
		return eyn;
	}
	public void setEyn(String eyn) {
		this.eyn = eyn;
	}

}
