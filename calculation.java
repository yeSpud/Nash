
public class calculation {
	public static String Nash(double aUL, double bUL, double aDL, double bDL, double aUR, double bUR, double aDR,
			double bDR) {
		String answer = null;
		String aAnswerLeft = null;
		String aAnswerRight = null;
		String bAnswerUp = null;
		String bAnswerDown = null;
		
		if (aUL > aDL) {
			aAnswerLeft = "Left Up";
		} else if (aUL < aDL) {
			aAnswerLeft = "Left Down";
		} else {
			aAnswerLeft = "Left Up Left Down";
		}
		if (aUR > aDR) {
			aAnswerRight = "Right Up";
		} else if (aUR < aDR) {
			aAnswerRight = "Right Down";
		} else {
			aAnswerRight = "Right Up Right Down";
		}
		
		if (bUR > bUL) {
			bAnswerUp = "Right Up";
		} else if (bUR < bUL) {
			bAnswerUp = "Left Up";
		} else {
			bAnswerUp = "Left Up Right Up";
		}
		if (bDR > bDL) {
			bAnswerDown = "Right Down";
		} else if (bDR < bDL) {
			bAnswerDown = "Left Down";
		} else {
			bAnswerDown = "Left Down Right Down";
		}

		if (aAnswerLeft.contains("Up") && bAnswerUp.contains("Left")) {
			answer = "Up, Left";
		} else if (aAnswerLeft.contains("Down") && bAnswerDown.contains("Left")) {
			answer = "Down, Left";
		} else if (aAnswerRight.contains("Up") && bAnswerUp.contains("Right")) {
			answer = "Up, Right";
		} else if (aAnswerRight.contains("Down") && bAnswerDown.contains("Right")) {
			answer = "Down Right";
		} else {
			answer = "No answer";
		}
		
		return answer;
	}
}
