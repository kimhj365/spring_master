package method;

public class MyConsole {
	
	// 메서드 오버로딩
	public static void printLine() {
		for (int i = 0; i < 50; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	public static void printLine(int num) {
		for (int i = 0; i < num; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	public static void printLine(int num, String str) {
		for (int i = 0; i < num; i++) {
			System.out.print(str);
		}
		System.out.println();
	}

}
