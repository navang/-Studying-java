package z_연습문제;

import java.util.Scanner;

public class CalculatorExpr {  // CalculatorExpr 객체생성
	private int num1;   		// 표준입력으로 숫자 두개를 입력받아 각각의 멤버변수에 지정 
	private int num2;			// "
//------------set num1, num2 ---------------------------------------------	
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
//------------get num1, num2 ---------------------------------------------
	public int getNum1() {
		return num1;
	}
	public int getNum2() {
		return num2;
	}
//------------get A, S, M , D---------------------------------------------
	public int getAddition() { // 덧셈
		return num1 + num2;
	}
	public int getSubtraction() { //뺄셈
		return num1 - num2;
	}
	public int getMultiplication() {  // 곱셈
		return num1 * num2;
	}
	public double getDivision() {
		return (double)num1 / num2; // 나눗셈 // 정수/정수 는 정수에서 잘라지므로 하나를 실수값으로 캐스트 
	}
//---------------------------------------------------------
}
