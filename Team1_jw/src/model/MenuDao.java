package model;

import java.util.ArrayList;

import empmodel.vo.emp.Menu;

public interface MenuDao {
	
	public ArrayList selectAllFood(String fname, int fcnt) throws Exception;
	
}
