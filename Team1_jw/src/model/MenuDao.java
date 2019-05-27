package model;

import java.util.ArrayList;

public interface MenuDao {
	public ArrayList selectAllFood() throws Exception;
	public void deleteCntFood(ArrayList aMenu, ArrayList aCnt) throws Exception;
}
