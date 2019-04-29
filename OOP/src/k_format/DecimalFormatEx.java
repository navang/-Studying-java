package k_format;

import java.text.DecimalFormat;

public class DecimalFormatEx {

	public static void main(String[] args) {

		double [] data = {1231, 124.23, 955555559999.999, 323.4};
		
		DecimalFormat df = new DecimalFormat("###,###,###,###,###.###########");
		// 데이터에 형식 추가 , 위아래로 넉넉하게 범위를 설정해주자

		for (int i =0; i <data.length; i++) {
			System.out.println(df.format(data[i]));
		}

	}

}
