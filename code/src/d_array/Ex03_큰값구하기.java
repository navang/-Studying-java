package d_array;

public class Ex03_큰값구하기 {

	public static void main(String[] args) {
		
			
			// 이중에서 가장 큰 값을 추출해서 출력 
			/*
			 * 우선 임의이 변수를 정의하고 예를 들어 max 라 하자 . 
			 * 
				1. 이 변수에 배열의 첫번째 값을 입력
				2. 이 값이 가장 크다고 가정하고 다음 방의 데이터와 크기비교를 한다
				3. 이 변수의 값고 다 큰값이 들어오면  더 큰 값으로 바꾼다 
				4. 반복한다. 		
			 */
		int []arr = {33,44,23,5,1,42,4};
			int max = arr[0]; // max 가 arr의 0번째 값으로 초기화 
			
			for (int i =0; i< arr.length; i++){ 
				if(max < arr[i]) { //max 가 옆에있는 애가 더 크면 
					max = arr[i]; // max를 걔로 바꿔라 
				}
					
				}System.out.println(max);
			
	}

}
