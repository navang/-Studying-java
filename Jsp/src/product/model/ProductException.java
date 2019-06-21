package product.model;

public class ProductException extends Exception
{
  public ProductException(){
  		super();
  	}
  	
  public ProductException(String error){
  		super( error );
  	}
 		
}