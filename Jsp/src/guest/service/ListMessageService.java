package guest.service;

import guest.model.Message;
import guest.model.MessageDao;
import guest.model.MessageException;

import java.util.List;

public class ListMessageService {

	//-------------------------------------------------------------------
	private int totalRecCount;		// 전체 레코드 수	
	private int pageTotalCount;		// 전체 페이지 수
	private int countPerPage = 3;	// 한페이지당 레코드 수
	
	private static ListMessageService instance;
	
	public static ListMessageService	getInstance() throws MessageException
	{
		if( instance == null )
		{
			instance = new ListMessageService();
		}
		return instance;
	}
	
	private ListMessageService()
	{
		
	}
	
	public List <Message> getMessageList(String pNum) throws MessageException
	{
		
		// 페이지 번호에 따른 레코드 번호 추출 / startRow=시작 ~ 끝=endRow 
		/* 전체 레코드 수가 9 
		 * 
		 * 1. 페이지 : 1~3 
		 * 2. 페이지 4~6
		 * 3. 페이지 7~9
		 * 
		 */
		pageTotalCount = totalRecCount /countPerPage;
		if(totalRecCount%countPerPage >0) {
			pageTotalCount++;
		}
		int pageNo =1; 
		if(pNum != null) pageNo = Integer.parseInt(pNum);
		
		int endRow = pageNo * countPerPage; // 형변환 주의!! 
		int startRow = endRow-(countPerPage-1);  // 변수를 이용해서 규칙을 찾아주자 
		
		//전체레코드 검색해 온다면
		MessageDao dao = MessageDao.getInstance();		
		List <Message> mList = MessageDao.getInstance().selectList(startRow, endRow);			
		return mList;
	}
	public int getTotalPage() throws MessageException{
		// 전체 레코드를 검색해 온다면
				MessageDao dao = MessageDao.getInstance();
				totalRecCount = dao.getTotalCount();
				
				// 전체 페이지 수 (pageTotalCount) 를 구함 
				/*
				 * 레코드 수 		페이지수
				 * 	9				3
				 *  10				4
				 */
				// 나머지 연산자 이용 
				pageTotalCount = totalRecCount /countPerPage;
				if(totalRecCount%countPerPage >0) {
					pageTotalCount++;
				}
				return pageTotalCount;
	}
	
}
