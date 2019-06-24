package board.service;

import java.util.List;

import board.model.BoardDao;
import board.model.BoardException;
import board.model.BoardRec;
import guest.model.Message;
import guest.model.MessageDao;
import guest.model.MessageException;

public class ViewArticleService {
	private static ViewArticleService instance;
	public static ViewArticleService getInstance()  throws BoardException{
		if( instance == null )
		{
			instance = new ViewArticleService();
		}
		return instance;
	}

	
	public BoardRec getArticleById(String id) throws BoardException
	{
		int article_id = 0; //article_id 초기화
		if( id != null ) article_id = Integer.parseInt(id); //인자가 null이 아니면 article_id에 int형으로 저장
		BoardDao dao = BoardDao.getInstance(); // Dao객체 생성
		dao.increaseReadCount(article_id);		
		BoardRec rec = dao.selectById(article_id);		// dao에서 selectById(id에따른 모든 인자값을구함)함수를 이용하여 
		// 결과값을 리턴 
		return rec;
	}
		
}

