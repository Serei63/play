package bullsandcows;

import java.util.Scanner;

public class BullsAndCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		/*
		for(int i = 0; i<taget.length; i++) {
		System.out.print(taget[i]);
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
					if(check == taget[n]) {
						ball ++;
						if(k==n) {
							ball --;
							strike ++;								
						}
					} else {
						out++;
					}
					if(strike == 4) {
						System.out.print("�����Դϴ�. (");
						for(int m = 0;m<taget.length;m++) {
							System.out.print(taget[m]);
						}
						System.out.print(")");
						System.exit(0);
					}
				}
			}
			out -= 12;
			System.out.println(strike+"S "+ball+"B "+ out + "O (���� ��ȸ "+(i-1)+"��)");
			
		}
		
		System.out.print("�����߽��ϴ�. (���� : ");
		for(int m = 0;m<taget.length;m++) {
			System.out.print(taget[m]);
		}
		System.out.print(")");
		
	}


}