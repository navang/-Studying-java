package product.service;

import java.util.List;

import product.model.ProductRec;
import product.model.ProductDao;
import product.model.ProductException;


public class ViewProductService {

	//-------------------------------------------------------------------
	private int totalRecCount;		// 전체 레코드 수	
	private int pageTotalCount;		// 전체 페이지 수
	private int countPerPage = 3;	// 한페이지당 레코드 수
	
	private static ViewProductService instance;
	
	public static ViewProductService	getInstance() throws ProductException
	{
		if( instance == null )
		{
			instance = new ViewProductService();
		}
		return instance;
	}
	
	private ViewProductService()
	{
		
	}
	
		public List <ProductRec> getProductList(String pNum) throws ProductException
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
			ProductDao dao = ProductDao.getInstance();		
			List <ProductRec> pRec = ProductDao.getInstance().productList(startRow, endRow);			
			return pRec;
		}
		
		
	
	public int getTotalPage() throws ProductException{
		// 전체 레코드를 검색해 온다면
				ProductDao dao = ProductDao.getInstance();
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
