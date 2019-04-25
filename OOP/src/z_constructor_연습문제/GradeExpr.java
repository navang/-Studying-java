package z_constructor_연습문제;

public class GradeExpr {// 생성자

	static int[] jumsu ; 
	int sum;
	int max;
	int min;
	double avg;

	public  GradeExpr(int[] score){ 
		this.jumsu =score;
	}
	// 멤버 메소드 
	public int getTotal() {
		int sum=0;

		for( int i = 0; i<jumsu.length; i++)	{
			sum +=jumsu[i];
		}
		//System.out.println("합산 점수는: " + sum);
		return sum;

	}
	public double getAverage() {
		int sum=0;
		double avg=0;
		for(int i= 0; i<jumsu.length; i++)	{
			sum +=jumsu[i];
			avg=(double)sum/(jumsu.length);
		}
		//System.out.println("평균 점수는 : " + avg);
		return avg;
	}

	public int getGoodScore() {
		int max = jumsu[0]; // max 가 arr의 0번째 값으로 초기화 

		for (int i =0; i< jumsu.length; i++){ 
			if(max < jumsu[i]) { //max 가 옆에있는 애가 더 크면 
				max = jumsu[i]; // max를 걔로 바꿔라 
			}
		}
		return max;
	}
	public int getBadScore() {
		int min = jumsu[0]; // max 가 arr의 0번째 값으로 초기화 

		for (int i =0; i< jumsu.length; i++){ 
			if(min > jumsu[i]) { //min 가 옆에있는 애가 더 작으면
				min = jumsu[i]; // min 를 걔로 바꿔라 
			}
		}
		return min;
		}
	//-------------------------------------------

}