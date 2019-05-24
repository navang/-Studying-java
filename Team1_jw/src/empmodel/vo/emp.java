package empmodel.vo;

public class emp {
	public class Menu {
		String food; // 메뉴 
		int fprice; // 가격 
		int fcnt;	// 재고 
		
		
		public String getFood() {
			return food;
		}
		public void setFood(String fname) {
			this.food = fname;
		}
		public int getFprice() {
			return fprice;
		}
		public void setFprice(int fprice) {
			this.fprice = fprice;
		}
		public int getFcnt() {
			return fcnt;
		}
		public void setFcnt(int fcnt) {
			this.fcnt = fcnt;
		}

	}
}