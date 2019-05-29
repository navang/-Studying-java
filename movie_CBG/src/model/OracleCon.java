package model;

public class OracleCon {

	static OracleCon con = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	
	private OracleCon() throws Exception {
		// 1. 드라이버 로딩
		Class.forName(driver);
	}

	public static void getInstance() throws Exception {

		if(con == null) {
			con = new OracleCon();
		}
	}
}
