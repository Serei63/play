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
			// ����ĭ
			System.out.println("[���ھ߱�]");
			System.out.println("�� �ڸ��� 0���� 9������ 4�ڸ� ���ڸ� ���ߴ� �����Դϴ�.");
			System.out.println("�ڸ��� ���ڰ� ��� ������ ��Ʈ����ũ (S)");
			System.out.println("���ڴ� ������ �ڸ��� ���� ������ �� (B)");
			System.out.println("���� ���ڰ� �ԷµǾ��� ��� �ƿ�(O)�� ī��Ʈ�� �ö󰩴ϴ�.");
			System.out.println("---------------------------------------------------------------------");
			// �������
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
						System.out.println("�ٽ� �Է��ϼ���.");
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
								System.out.print("�����Դϴ�. (");
								for (int m = 0; m < taget.length; m++) {
									System.out.print(taget[m]);
								}
								System.out.println(")");

								System.out.println("�ٽ� �Ͻðڽ��ϱ�? (y/n)");
								System.out.print(">");
								while (run2) {
									String ctn = sc.next();
									if (ctn.equals("n") || ctn.equals("N")) {
										System.out.println("�����մϴ�.");
										System.exit(0);

									} else if (ctn.equals("y") || ctn.equals("Y")) {
										run2 = false;
										run3 = false;

									} else {
										System.out.println("�ٽ� �Է��� �ּ���");
									}
								}

							}
						}
					}
					if (strike != 4) {
						out -= 12;
						System.out.println(strike + "S " + ball + "B " + out + "O (���� ��ȸ " + (i - 1) + "��)");
					}
				}
			}

			if (strike != 4) {
				System.out.print("�����߽��ϴ�. (���� : ");
				for (int m = 0; m < taget.length; m++) {
					System.out.print(taget[m]);
				}
				System.out.print(")");

				System.out.println("�ٽ� �Ͻðڽ��ϱ�? (y/n)");
				System.out.print(">");
				while (run1) {
					String ctn = sc.next();
					if (ctn.equals("n") || ctn.equals("N")) {
						System.out.println("�����մϴ�.");
						System.exit(0);

					} else if (ctn.equals("y") || ctn.equals("Y")) {
						run1 = false;

					} else {
						System.out.println("�ٽ� �Է��� �ּ���");
					}
				}
			}
			Runtime.getRuntime().exec("clear");
		} while (true);
	}
}