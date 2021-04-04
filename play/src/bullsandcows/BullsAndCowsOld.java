package bullsandcows;

import java.util.Scanner;

public class BullsAndCowsOld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 설명칸
		System.out.println("[숫자야구]");
		System.out.println("각 자리가 0부터 9까지인 4자리 숫자를 맞추는 게임입니다.");
		System.out.println("자리와 숫자가 모두 맞으면 스트라이크 (S)");
		System.out.println("숫자는 있으나 자리가 맞지 않으면 볼 (B)");
		System.out.println("없는 숫자가 입력되었을 경우 아웃(O)의 카운트가 올라갑니다.");
		System.out.println("---------------------------------------------------------------------");
		// 여기까지
		int[] target = new int[4]; 
		target[0] = (int) (Math.random() * 10);

		do {
			target[1] = (int) (Math.random() * 10);
		} while (target[1] == target[0]);

		do {
			target[2] = (int) (Math.random() * 10);
		} while (target[2] == target[0] || target[2] == target[1]);

		do {
			target[3] = (int) (Math.random() * 10);
		} while (target[3] == target[0] || target[3] == target[1] || target[3] == target[2]);
		
		/*
		for(int i = 0; i<taget.length; i++) {
		System.out.print(target[i]);
		}
		*/
		
		Scanner sc = new Scanner(System.in);
		
		int strike = 0;
		int ball = 0;
		int out = 0;
		
		for(int i = 9; i>0; i--) {
			System.out.print(">");
			String insert = sc.nextLine();
			strike = 0;
			ball = 0;
			out = 0;
			for(int k = 0; k<4; k++) {
				int check = Integer.parseInt(insert.substring(k, k+1));
				for(int n = 0; n<4; n++) {
					if(check == target[n]) {
						ball ++;
						if(k==n) {
							ball --;
							strike ++;								
						}
					} else {
						out++;
					}
					if(strike == 4) {
						System.out.print("정답입니다. (");
						for(int m = 0;m<target.length;m++) {
							System.out.print(target[m]);
						}
						System.out.print(")");
						System.exit(0);
					}
				}
			}
			out -= 12;
			System.out.println(strike+"S "+ball+"B "+ out + "O (남은 기회 "+(i-1)+"번)");
			
		}
		
		System.out.print("실패했습니다. (정답 : ");
		for(int m = 0;m<target.length;m++) {
			System.out.print(target[m]);
		}
		System.out.print(")");
		
	}


}