package model;

import java.util.ArrayList;

import model.vo.Video;

public interface VideoDao {
	public void insertVideo(Video vo, int count) throws Exception;
	public ArrayList searchVideo(int sel, String word) throws Exception;

}
