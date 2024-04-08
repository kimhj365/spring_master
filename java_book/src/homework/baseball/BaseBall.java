package homework.baseball;

import java.util.Scanner;

public class BaseBall {

	static int num[] = { 0, 0, 0 };

	public static void main(String[] args) {
		int num1 = 0, num2 = 0, num3 = 0;
		int strike = 0;
		int ball = 0;
		int i = 0;
		int j = 0;
		// 턴 횟수 저장 변수
		int turn = 1;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 3개를 맞추면 끝나는 게임입니다");
		
		for (i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 9) + 1;
		}

		for (i = 0; i < num.length; i++) {
			for (j = 0; j < num.length; j++) {
				if (i == j)
					continue;
				else if (num[i] == num[j])
					num[j] = (int) (Math.random() * 9) + 1;
			}
		}
		
//		System.out.println(num[0] + " " + num[1] + " " + num[2]);

		while (true) {
			System.out.print(turn + "회 숫자 3개를 입력 하세요 : ");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			num3 = sc.nextInt();
			if (num[0] == num1 && num[1] == num2 && num[2] == num3)
				break;

			if (num[0] == num1) {
				strike++;
			} 
			if (num[1] == num2) {
				strike++;
			}
			if (num[2] == num3) {
				strike++;
			}
			if (num[0] == num2 || num[0] == num3) {
				ball++;
			}
			if (num[1] == num1 || num[1] == num3) {
				ball++;
			}
			if (num[2] == num1 || num[2] == num2) {
				ball++;
			}
			System.out.println(strike + "스트라이크, " + ball + "볼");
			strike = 0;
			ball = 0;
			
			// 턴 횟수 5회 이상이면 중단
			if(turn >= 5) {
				System.out.println("턴 횟수 5회 이상\n종료!");
				break;
			}
			// 턴 횟수 증가
			turn++;
		}

		System.out.println("게임 끝");
		System.out.println("정답 : " + num[0] + " " + num[1] + " " + num[2]);
		sc.close();
	}
}
