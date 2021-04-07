package bullsandcows2;

import java.util.Scanner;

public class BullsAndCowsRun {

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
				System.out.println("다시 입력하세요.");
				i++;
				continue;
			}
			target.checkNum(insert);
			if (target.getStrike() == 4) {
				System.out.print("정답입니다. (");
				//System.out.print(target.getTarget());
				System.out.print(getta);
				System.out.print(")");
				System.exit(0);
			}
			System.out.println(target.getStrike()+"S "+target.getBall()+"B "+target.getOut()+"O (남은 기회:"+(i-1)+"번)");
		}
		System.out.println("게임 오버");
		sc.close();
	}

}
