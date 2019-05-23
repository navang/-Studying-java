package model;

import java.util.ArrayList;

public interface RentDao{
	// 대여메소드	
	public void rentVideo(String tel, int vNum) throws Exception;
	// 반납메소드
	public 	int	returnVideo(int vNum) throws Exception;
	// 미납정보 검색 메소드 
	public ArrayList selectList() throws Exception;
}	
