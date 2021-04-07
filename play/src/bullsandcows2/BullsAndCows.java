package bullsandcows2;

public class BullsAndCows {
	private int[] target = new int[4];
	private String gt = new String();
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
		for (int i = 0; i < 4; i++) {
			gt += target[i] + "";
			}
		return gt;
	}

	public void checkNum(String checkNum) {
		strike = 0;
		ball = 0;
		out = 0;
		for(int k = 0; k<4; k++) {
			int check = Integer.parseInt(checkNum.substring(k, k+1));
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
			}
		}
		out -= 12;
	}
	
	public int getStrike() {
		return strike;
	}
	
	public int getBall() {
		return ball;
	}
	
	public int getOut() {
		return out;
	}
	
}
