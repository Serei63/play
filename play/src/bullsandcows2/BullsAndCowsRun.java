package bullsandcows2;

import java.util.Scanner;

public class BullsAndCowsRun {

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
		Scanner sc = new Scanner(System.in);
		BullsAndCows target = new BullsAndCows();
		target.setTarget();
		String getta = target.getTarget();
		System.out.println(getta);
		// System.out.println(target.getTarget());

		for (int i = 9; i > 0; i--) {
			System.out.print(">");
			String insert = sc.nextLine();
			if (insert.length() != 4) {
				System.out.println("�ٽ� �Է��ϼ���.");
				i++;
				continue;
			}
			target.checkNum(insert);
			if (target.getStrike() == 4) {
				System.out.print("�����Դϴ�. (");
				//System.out.print(target.getTarget());
				System.out.print(getta);
				System.out.print(")");
				System.exit(0);
			}
			System.out.println(target.getStrike()+"S "+target.getBall()+"B "+target.getOut()+"O (���� ��ȸ:"+(i-1)+"��)");
		}
		System.out.println("���� ����");
		sc.close();
	}

}
