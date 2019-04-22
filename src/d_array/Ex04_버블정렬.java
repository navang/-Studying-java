package d_array;

/*
 * 삽입정렬, 선택정렬 알아보기 ! 힙 퀵 머지 정렬도 알아보자 
 */

public class Ex04_버블정렬 {

	public static void main(String[] args) {




		int []arr = {22, 15, 13, 7, 35, 25 };

		for(int i = arr.length-1; i>0; i--){
			for(int j=0; j<i; j++) {
				if( arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.println( arr[i] + "/");
		}


	}

}
