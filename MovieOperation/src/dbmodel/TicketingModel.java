package dbmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import model.vo.Movie;

public class TicketingModel {

	String url = "jdbc:oracle:thin:@192.168.0.116:1521:orcl";
	String user = "heroes";
	String pass = "1004";
	
	public TicketingModel() throws Exception {
		OracleDri.getInstance();
	}
	//예약번호 넘겨주고 결재내역 저장하자
	public void insertTicket(Movie vo) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		
		try {
		con = DriverManager.getConnection(url, user, pass);
		String sql = "INSERT INTO ticket(tno, sno, tseatno) VALUES (tic_se.nextval, ?, ?) ";
		st = con.prepareStatement(sql);
		st.setInt(1, vo.getSchno());
		st.setString(2, vo.getSeatNum());
		
		}finally {
			st.close();
			con.close();
		}
	}
	//영화목록 띄우기
	public Vector<String> movieList() throws Exception {
		Vector<String> list = new Vector<String>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT mtitle FROM movie ORDER BY rownum";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("mtitle"));
			}
		}finally {
			rs.close();
			st.close();
			con.close();
		}
		return list;
	}

	//날짜 가져오기
	public Vector<String> getCald() throws Exception{
		Vector<String> cal = new Vector<String>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			for(int i = 0; i < 7; i++) {
				String sql = "SELECT TO_CHAR(sysdate + ?,'YYYY-MM-DD') cal FROM dual";
				st = con.prepareStatement(sql);
				st.setInt(1, i);
				rs = st.executeQuery();
				if(rs.next()) {
					cal.add(rs.getString("cal"));
				}
				rs.close();
				st.close();
			}
		}finally {
			con.close();
		}
		
		return cal;
	}

	//사장이 스케줄만든거 받아와서 만들기
	public ArrayList<String> showSchedule(String mtitle, String day, int thnum) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs= null;
		ArrayList<String> result = null;
		try {
			result = new ArrayList<String>();
			con = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT stime FROM schedule WHERE TO_CHAR(sdate, 'MM/DD') = ? AND mtitle = ? AND eyn = 'N' AND sthn = ? ORDER BY sno";
			st = con.prepareStatement(sql);
			st.setString(1, day);
			st.setString(2, mtitle);
			st.setInt(3, thnum);
			rs = st.executeQuery();
			while(rs.next()) {
				result.add(rs.getString("stime"));
			}
			if(result.size() == 0) {
				return null;
			}else {
				return result;
			}
			
		}finally {
			rs.close();
			st.close();
			con.close();
		}
		
	}

	//좌석 예매현황 가져오기
	public char [] ticketingSeat(Movie vo) throws Exception{
		char [] result = new char [40];
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql1 = "SELECT sno FROM schedule WHERE TO_CHAR(sdate, 'MM/DD') = ? AND stime = ? AND sthn = ?";
			st = con.prepareStatement(sql1);
			st.setString(1, vo.getModate());
			st.setString(2, vo.getTime());
			st.setInt(3, vo.getThNum());
			rs = st.executeQuery();
			if(rs.next()) {
				vo.setSchno(rs.getInt("sno"));
			}
			rs.close();
			st.close();
			
			String sql2 = "SELECT * FROM th" + vo.getThNum() + "  WHERE sno = ?";
			st = con.prepareStatement(sql2);
			st.setInt(1, vo.getSchno());
			rs = st.executeQuery();
			if(rs.next()) {
				for(int i = 2; i <= 41; i++) {
					result[i-2] = rs.getString(i).charAt(0);
				}
			}
				
		}finally {
			rs.close();
			st.close();
			con.close();
		}
		return result;
	}

	//좌석 가격 가져오기
	public int setPrice(int thNum, String seatNum) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int price = 0;
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT thprice FROM th WHERE thno = ? AND seatno = ?";
			st = con.prepareStatement(sql);
			StringTokenizer stn = new StringTokenizer(seatNum, ",");
			while(stn.hasMoreTokens()) {
				st.setInt(1, thNum);
				st.setString(2, stn.nextToken());
				rs = st.executeQuery();
				if(rs.next()) {
					price += rs.getInt("thprice");
				}
			}
			
			
		}finally {
			rs.close();
			st.close();
			con.close();
		}
		
		return price;
	}
}
