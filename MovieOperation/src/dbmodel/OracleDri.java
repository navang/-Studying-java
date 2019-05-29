package dbmodel;

public class OracleDri {

	static OracleDri dir;
	String driver = "oracle.jdbc.driver.OracleDriver";
	
	private OracleDri() throws Exception {
		Class.forName(driver);
	}
	
	static public void getInstance() throws Exception {
		if(dir == null) {
			dir = new OracleDri();
		}
	}
}
