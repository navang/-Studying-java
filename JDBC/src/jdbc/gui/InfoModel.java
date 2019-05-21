package jdbc.gui;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InfoModel {
	// 다른 여러 파일들에게 표준화된 메소드를 제공 
	public void insert(InfoVO vo) throws Exception;
	public void update(InfoVO vo) throws Exception;
	public InfoVO deleteData(String tel) throws Exception;
	public ArrayList<InfoVO> selectAll () throws SQLException;
	public InfoVO selectByTel(String tel) throws Exception;
	public InfoVO selectById(String id) throws Exception;

}
