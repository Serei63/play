package bullsandcows2;

public class BullsAndCows {
	private int[] target = new int[4];
	private String gt;
	private int strike;
	private int ball;
	private int out;
		
	public void setTarget() {
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
	}

	public String getTarget() {
		for (int i = 0; i < target.length; i++) {
			gt = target[i] + "";
			}
		return gt;
	}

	public void checkNum(String checkNum) {
		
		
	}
}
