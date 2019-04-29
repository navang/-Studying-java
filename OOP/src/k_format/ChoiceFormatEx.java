package k_format;

import java.text.ChoiceFormat;

public class ChoiceFormatEx {

	public static void main(String[] args) {

		int []scores = {99,4,34,12,32,400,5,123,42,223,55};

		double []limits = {50,60,70,80};
		String []grades = {"d","c","b","a"};

		ChoiceFormat cf = new ChoiceFormat(limits,grades);
		
		for(int k:scores) {
			System.out.println(k + ":" + cf.format(k));
		}
	}

}
