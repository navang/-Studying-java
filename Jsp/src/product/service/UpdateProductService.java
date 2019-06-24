package product.service;

import board.model.BoardDao;
import product.model.ProductDao;
import product.model.ProductException;
import product.model.ProductRec;

public class UpdateProductService {

	private static UpdateProductService instance;
	
	public static UpdateProductService	getInstance() throws ProductException
	{
		if( instance == null )
		{
			instance = new UpdateProductService();
		}
		return instance;
	}
	
	private UpdateProductService()
	{
		
	}
	
	public int update( ProductRec rec ) throws ProductException
	{
		ProductDao pDao = ProductDao.getInstance();
		int result = Integer.parseUnsignedInt().pDao.update(rec);
		
		return result;
	
	}
}
