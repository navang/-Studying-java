package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import vo.Schedule;

public class ScheduleModel{
	
	String url = "jdbc:oracle:thin:@192.168.0.116:1521:orcl";
	String user = "heroes";
	String pass = "1004";
	Connection con = null;
	PreparedStatement st = null;
	PreparedStatement st2 = null;
	ResultSet rs = null;
	
	public ScheduleModel() throws Exception{
		// 1. 드라이버로딩
		OracleCon.getInstance();
	}
	
	// 만들기 버튼을 눌렀을 때 스케줄 정보를 만드는 메소드
	public void madeSchedule(Schedule vo, ArrayList<String> ttime) throws Exception{
		//기존 스케줄들을 가져오기 (새로만든 스케줄과 비교하기 위해서 시간대 겹치면 새로만든 스케줄 안들어감)
		con = DriverManager.getConnection(url, user, pass);
		ArrayList<Integer> timeList = new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<String> result = new ArrayList<String>();
		String sql2 = "SELECT stime FROM schedule WHERE sthn = ? AND sdate = TO_DATE(?) ORDER BY sno";
		st = con.prepareStatement(sql2);
		st.setInt(1, vo.getSthn());
		st.setString(2, vo.getSdate());
		rs = st.executeQuery();
		while(rs.next()) {
			String time = rs.getString("stime");
			StringTokenizer st = new StringTokenizer(time, ":");
			int min = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
			timeList.add(min);
		}
		
		st.close();
		rs.close();
		
		//새로만든 스케줄 시간비교를 위해서 분으로 바꾼다 ex) 아침 10시 = 600분
		if(timeList.size() != 0) {
			for(int i = 0; i < ttime.size(); i++) {
				String time = ttime.get(i);
				StringTokenizer st = new StringTokenizer(time, ":");
				int min = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
				list.add(min);
			}

			//시간 비교확인 겹치는 스케줄은 제거됨
			for(int i = 0; i < ttime.size(); i++) {
				if((list.get(i) < timeList.get(0)) && (list.get(i) + 150 < timeList.get(0))) {
					result.add(ttime.get(i));
				}else if(list.get(i) > timeList.get(timeList.size() - 1) && list.get(i) - 150 > timeList.get(timeList.size() - 1)) {
					result.add(ttime.get(i));
				}else {
					for(int j = 1; j < timeList.size(); j++) {
						if((list.get(i) < timeList.get(j) && list.get(i) > timeList.get(j-1)) && (list.get(i) +150 < timeList.get(j) && list.get(i) -150 > timeList.get(j-1))) {
							result.add(ttime.get(i));
						}	
					}
				}
			}
		}else if(timeList.size() == 0) {
			result = ttime;
		}
		
		
		
		// 3. sql 문장 만들기
		String sql = "INSERT INTO schedule(sno, mtitle, sthn, stime, sdate, eyn) "
				+ "VALUES (sch_se.nextval, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), 'N')";
		
		// 4. sql 전송객체 (PreparedStatement)
		st = con.prepareStatement(sql);
		for (int i = 0; i < result.size(); i++) {
			st.setString(1, vo.getMtitle());
			st.setInt(2, vo.getSthn());
			st.setString(3, result.get(i));
			st.setString(4, vo.getSdate());
			// 5. sql 전송
			st.executeUpdate();
		}
		
		// 6. 닫기
		st.close();
		
		//스케줄 테이블에 넣기
		String sql3 = "SELECT sno FROM schedule WHERE sthn = ? AND mtitle = ? AND TO_CHAR(sdate, 'YYYY-MM-DD') = ? ORDER BY sno";
		st = con.prepareStatement(sql3);
		st.setInt(1, vo.getSthn());
		st.setString(2, vo.getMtitle());
		st.setString(3, vo.getSdate());
		rs = st.executeQuery();
		while(rs.next()) {
			String sql4 = "INSERT INTO TH"+ vo.getSthn() + "(sno) VALUES (?)";
			st2 = con.prepareStatement(sql4);
			st2.setInt(1, rs.getInt("sno"));
			st2.executeUpdate();
		}
		st2.close();
		rs.close();
		st.close();		
		con.close();
	}
	
	// 만들기 버튼을 눌렀을 때 스케줄 정보를 확인하는 메소드
	public ArrayList searchSchedule(String date, int num) throws Exception{
		try {
		// 2. Connection 연결객체 얻어오기
		con = DriverManager.getConnection(url, user, pass);

		// 3. sql 문장 만들기
		String sql2 = "SELECT sno, mtitle, sthn, stime, TO_CHAR(sdate, 'YYYY-MM-DD') sdate, eyn "
				+ "FROM schedule WHERE sdate = TO_DATE(?) AND sthn = ? ORDER BY sno";
		ArrayList list = new ArrayList();

		// 4. sql 전송객체 (PreparedStatement)
		st2 = con.prepareStatement(sql2);
		st2.setString(1, date);
		st2.setInt(2, num);

		// 5. sql 전송
		rs = st2.executeQuery();
		while(rs.next()) {
			ArrayList data = new ArrayList();
			// data에 각 컬럼에서 얻어온 값을 추가
			data.add(rs.getInt("sno"));
			data.add(rs.getString("mtitle"));
			data.add(Integer.toString(rs.getInt("sthn"))+"관");
			data.add(rs.getString("stime"));
			data.add(rs.getString("sdate"));
			data.add(rs.getString("eyn"));
			list.add(data);
		}
		return list;
		} finally {
			rs.close();
			st2.close();
			con.close();
		}
	}
	
	//영화제목 정보 가져오는 메소드
	public Vector<String> inputMovie() throws Exception{
		try {
			// 2. Connection 연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			Vector<String> list = new Vector<String>();

			// 3. sql 문장 만들기
			String sql = "SELECT mtitle FROM movie ORDER BY mtitle";

			// 4. 전송 객체
			st = con.prepareStatement(sql);

			// 5. 전송
			rs = st.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("mtitle"));
			}

			return list;
		} finally {
			rs.close();
			st.close();
			con.close();
		}

	}

	//선택한 영화의 상영시간을 가져오는 메소드
	public int getTime(String title) throws Exception{
		try {
			// 2. Connection 연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);

			// 3. sql 문장 만들기
			String sql = "SELECT runtime FROM movie WHERE mtitle = ?";
			
			// 4. 전송 객체
			st = con.prepareStatement(sql);
			st.setString(1, title);
			
			// 5. 전송
			rs = st.executeQuery();
			int time = 0;
			if(rs.next()) {
				time = rs.getInt("runtime");
			}
			return time;
			
		} finally {
			rs.close();
			st.close();
			con.close();
		}
		
	}
	
	//날짜 가져오는 메소드
	public Vector<String> getCald() throws Exception{
		Vector<String> cal = new Vector<String>();
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
	
	//상영여부 Y로 바꿔주는 메소드
	public void changeSchedule() throws Exception {
		con = DriverManager.getConnection(url, user, pass);
		String sql1 = "SELECT TO_CHAR(sysdate, 'HH24:MI') standard FROM dual";
		st = con.prepareStatement(sql1);
		rs = st.executeQuery();
		int standard = 0;
		if(rs.next()) {
			StringTokenizer st = new StringTokenizer(rs.getString("standard"), ":");
			standard = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
		}
		rs.close();
		st.close();

		
		String sql2 = "SELECT sno, stime FROM schedule WHERE TO_CHAR(sdate, 'YYYY-MM-DD') = TO_CHAR(sysdate, 'YYYY-MM-DD') AND eyn = 'N' ORDER BY sno";
		st = con.prepareStatement(sql2);
		rs = st.executeQuery();
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(rs.next()) {
			String time = rs.getString("stime");
			StringTokenizer st = new StringTokenizer(time, ":");
			int min = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
			if(min <= standard) {
				list.add(rs.getInt("sno"));
			}
		}
		rs.close();
		st.close();
		
		if(list.size() != 0) {
			String sql3 = "UPDATE schedule SET eyn = 'Y' WHERE sno = ?";
			st = con.prepareStatement(sql3);
			for(int i = 0; i < list.size(); i++) {
				st.setInt(1, list.get(i));
				st.executeUpdate();
			}
		}
		
		st.close();
		con.close();
	}
}
