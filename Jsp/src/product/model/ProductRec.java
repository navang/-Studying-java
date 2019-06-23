package product.model;

public class ProductRec
{
	// member field
	private	String	pNo;
	private	String	pName;
	private	int	    pPrice;
	private	int		pEach;
	private	String	pPath;
	
	// constructor method 
	public ProductRec()
	{
		
	}
	public ProductRec( String	pNo, String	pName, int pPrice, int	pEach, String pPath)
	{
		this.pNo		= pNo;
		this.pName		= pName;
		this.pPrice		= pEach;
		this.pPath		= pPath;
	}
	

	public String getpNo() {
		return pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public int getpEach() {
		return pEach;
	}
	public void setpEach(int pEach) {
		this.pEach = pEach;
	}
	public String getpPath() {
		return pPath;
	}
	public void setpPath(String pPath) {
		this.pPath = pPath;
	}
}
	/*
	[ 참고 ]
	
	@ postingDate 가 실제 DB에서는 Date 형이지만, 날짜 값을 출력만 하기에 
	 Date 형이 아닌 String  형으로 받아도 된다.
	 나중에 날짜값을 사용할 일이 있으면 Date 형으로 변경 
 
*/