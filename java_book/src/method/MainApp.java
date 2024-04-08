package method;

public class MainApp {
	public static void main(String[] args) {
		
//		consoleTest();	// MyConsole
//		calcTest();		// MyCalculator
//		myClacTest();	// MyCalc
		
		MyGuessNumber myGuessNumber = new MyGuessNumber();
		myGuessNumber.start();
		
	}
	
	// MyConsole 클래스
	public static void consoleTest() {
		MyConsole.printLine();
		MyConsole.printLine(10);
		MyConsole.printLine(20, "*");
	}
	
	// MyCalculator 클래스
	public static void calcTest() {
		MyCalculator myCalc = new MyCalculator(10, 20);
		System.out.println(myCalc.getResult());
		
		myCalc = new MyCalculator(100, 200);
		System.out.println(myCalc.getResult());
	}
	
	// MyCalc 클래스
	public static void myClacTest() {
		// 덧셈 테스트
		int res = MyCalc.sum(40, 50);
		System.out.println(res);
		
		// 뺄셈 테스트
		res = MyCalc.minus(50, 40);
		System.out.println(res);
	}
}
