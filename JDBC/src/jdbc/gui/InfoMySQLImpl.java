package jdbc.gui;

import java.sql.SQLException;
import java.util.ArrayList;

public class InfoMySQLImpl implements InfoModel{

			public InfoMySQLImpl() {
				// mysql driver 로딩
			}

			@Override
			public void insert(InfoVO vo) throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void update(InfoVO vo) throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public InfoVO deleteData(String tel) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ArrayList<InfoVO> selectAll() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public InfoVO selectByTel(String tel) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public InfoVO selectById(String id) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
			
			
			
}
