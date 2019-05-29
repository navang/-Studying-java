package model.vo;

public class Movie {
	
	private String title, modate, time, seatNum, tel;
	private int schno, thNum;
	
	public Movie(){
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getThNum() {
		return thNum;
	}

	public void setThNum(int thNum) {
		this.thNum = thNum;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public String getModate() {
		return modate;
	}

	public void setModate(String modate) {
		this.modate = modate;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getSchno() {
		return schno;
	}

	public void setSchno(int schno) {
		this.schno = schno;
	}
	
	
}
