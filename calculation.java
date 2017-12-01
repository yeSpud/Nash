
public class calculation {
	public static String Nash(double aUL, double bUL, double aDL, double bDL, double aUR, double bUR, double aDR,
			double bDR) {
		String answer = null;
		String aAnswer = null;
		String bAnswer = null;

		double aL = aUL - aDL;
		double aR = aUR - aDR;
		double bL = bUL - bDL;
		double bR = bUR - bDR;

		boolean run = true;

		while (run) {
			if (Math.abs(aL) == Math.abs(aR)) {
				aAnswer = "No answer";
			} else if (Math.abs(aL) > Math.abs(aR)) {
				if (aL > 0) {
					aAnswer = "Up, Left";
				} else if (aL < 0) {
					aAnswer = "Down, Left";
				} else {
					aAnswer = "No answer";
				}
			} else if (Math.abs(aL) < Math.abs(aR)) {
				if (aR > 0) {
					aAnswer = "Up, Right";
				} else if (aR < 0) {
					aAnswer = "Down, Right";
				} else {
					aAnswer = "No answer";
				}
			}
			System.out.println("A: " + aAnswer);

			if (Math.abs(bL) == Math.abs(bR)) {
				bAnswer = "No answer";
			} else if (Math.abs(bL) > Math.abs(bR)) {
				if (bL > 0) {
					bAnswer = "Up, Left";
				} else if (bL < 0) {
					bAnswer = "Down, Left";
				} else {
					bAnswer = "No answer";
				}
			} else if (Math.abs(bL) < Math.abs(bR)) {
				if (bR > 0) {
					bAnswer = "Up, Right";
				} else if (bR < 0) {
					bAnswer = "Down, Right";
				} else {
					bAnswer = "No answer";
				}
			}
			System.out.println("B: " + bAnswer);

			//if (bAnswer.equals(aAnswer) || (aAnswer != "No answer" && bAnswer == "No answer") || (bAnswer != "No answer" && aAnswer == "No answer")) {
			if (bAnswer.equals(aAnswer) || (aAnswer != "No answer" && bAnswer == "No answer") ) {
				answer = bAnswer;
				System.out.println("Equal? True\n");
				run = false;
			} else {
				System.out.println("Equal? False\n");
				if (bAnswer == "Up, Left" || bAnswer == "Down, Left") {
					bL = 0;
				} else if (bAnswer == "Up, Right" || bAnswer == "Down, Right") {
					bR = 0;
				}
			}
		}

		return answer;
	}
}
