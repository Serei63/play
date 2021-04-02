package bullsandcows;

import java.io.IOException;
import java.util.Scanner;

public class BullsAndCows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		do {
			boolean run1 = true;
			boolean run2 = true;
			boolean run3 = true;
			// 설명칸
			System.out.println("[숫자야구]");
			System.out.println("각 자리가 0부터 9까지인 4자리 숫자를 맞추는 게임입니다.");
			System.out.println("자리와 숫자가 모두 맞으면 스트라이크 (S)");
			System.out.println("숫자는 있으나 자리가 맞지 않으면 볼 (B)");
			System.out.println("없는 숫자가 입력되었을 경우 아웃(O)의 카운트가 올라갑니다.");
			System.out.println("---------------------------------------------------------------------");
			// 여기까지
			int[] taget = new int[4];
			taget[0] = (int) (Math.random() * 10);

			do {
				taget[1] = (int) (Math.random() * 10);
			} while (taget[1] == taget[0]);

			do {
				taget[2] = (int) (Math.random() * 10);
			} while (taget[2] == taget[0] || taget[2] == taget[1]);

			do {
				taget[3] = (int) (Math.random() * 10);
			} while (taget[3] == taget[0] || taget[3] == taget[1] || taget[3] == taget[2]);

			for (int i = 0; i < taget.length; i++) {
				System.out.print(taget[i]);
			}

			Scanner sc = new Scanner(System.in);

			int strike = 0;
			int ball = 0;
			int out = 0;

			while (run3) {
				for (int i = 9; i > 0; i--) {
					System.out.print(">");
					String insert = sc.nextLine();
					if (insert.length() != 4) {
						System.out.println("다시 입력하세요.");
						i++;
						continue;
					}
					strike = 0;
					ball = 0;
					out = 0;
					for (int k = 0; k < 4; k++) {
						int check = Integer.parseInt(insert.substring(k, k + 1));
						for (int n = 0; n < 4; n++) {
							if (check == taget[n]) {
								ball++;
								if (k == n) {
									ball--;
									strike++;
								}
							} else {
								out++;
							}
							if (strike == 4) {
								System.out.print("정답입니다. (");
								for (int m = 0; m < taget.length; m++) {
									System.out.print(taget[m]);
								}
								System.out.println(")");

								System.out.println("다시 하시겠습니까? (y/n)");
								System.out.print(">");
								while (run2) {
									String ctn = sc.next();
									if (ctn.equals("n") || ctn.equals("N")) {
										System.out.println("종료합니다.");
										System.exit(0);

									} else if (ctn.equals("y") || ctn.equals("Y")) {
										run2 = false;
										run3 = false;

									} else {
										System.out.println("다시 입력해 주세요");
									}
								}

							}
						}
					}
					if (strike != 4) {
						out -= 12;
						System.out.println(strike + "S " + ball + "B " + out + "O (남은 기회 " + (i - 1) + "번)");
					}
				}
			}

			if (strike != 4) {
				System.out.print("실패했습니다. (정답 : ");
				for (int m = 0; m < taget.length; m++) {
					System.out.print(taget[m]);
				}
				System.out.print(")");

				System.out.println("다시 하시겠습니까? (y/n)");
				System.out.print(">");
				while (run1) {
					String ctn = sc.next();
					if (ctn.equals("n") || ctn.equals("N")) {
						System.out.println("종료합니다.");
						System.exit(0);

					} else if (ctn.equals("y") || ctn.equals("Y")) {
						run1 = false;

					} else {
						System.out.println("다시 입력해 주세요");
					}
				}
			}
			Runtime.getRuntime().exec("clear");
		} while (true);
	}
}