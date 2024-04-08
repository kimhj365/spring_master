package method;

public class MyCalculator {
	
	// 필드
	private int num1;
	private int num2;
	private int result;
	
	// 생성자
//	public MyCalculator() {}
	
	public MyCalculator(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
		sum();
	}
	
	// 메서드
	private void sum() {
		result = num1 + num2;
	}

	public int getResult() {
		return result;
	}

}
