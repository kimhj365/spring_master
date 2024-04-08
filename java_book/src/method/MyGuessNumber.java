package method;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyGuessNumber {

	int rNum;				// 랜덤 숫자
	int turn = 1;			// 시도 횟수
	int maxTurn = 5; 		// 기회 수
	boolean check = false;	// 정답체크
	List<Integer> numLog = new ArrayList<>();  // 입력 기록
	
	Scanner scanner = new Scanner(System.in);
	
	// 게임 시작
	public void start() {
		
		System.out.println("숫자 맞추기 게임 시작! \n");
		
		makeRNum();
		while(true) {		
			userInput();
			getAnswer();
			if(check || turn > 5) {
				System.out.println("게임종료!(정답 : " + rNum + ")");
				break;
			}
		}
	}
	
	// 임의의 수 생성(1~100)
	public void makeRNum() {
		rNum = (int)(Math.random()*99)+1;
	}
	
	// 숫자 입력
	public void userInput() { 
		System.out.print(turn + "회 숫자 입력(1~100) : ");
		int num = scanner.nextInt();
		numLog.add(num);
	}
	
	// 정답 확인
	void getAnswer() {
		for(int i = 0; i < numLog.size(); i++) {
			System.out.print(numLog.get(i) + " ");
		}
		System.out.println();
		
		if(numLog.get(numLog.size()-1) > rNum) {
			System.out.println("Too High!");
		}
		else if(numLog.get(numLog.size()-1) < rNum) {
			System.out.println("Too Low!");
		}
		else {
			System.out.println("Correct!");
			check = true;
			return;
		}
		
		System.out.println();
		turn++;
	}
}
