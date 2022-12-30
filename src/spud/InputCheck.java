package spud;

import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class InputCheck implements UnaryOperator<TextFormatter.Change> {

	private static final String REGEX = "[^0-9]";

	/**
	 * Credit to karimsqualli96 on GitHub
	 * https://gist.github.com/karimsqualli96/f8d4c2995da8e11496ed
	 */
	@Override
	public TextFormatter.Change apply(TextFormatter.Change change) {

		if (change.isReplaced()) {
			if (change.getText().matches(InputCheck.REGEX)) {
				change.setText(change.getControlText().substring(change.getRangeStart(), change.getRangeEnd()));
			}
		}


		if (change.isAdded()) {
			if (change.getControlText().contains(".")) {
				if (change.getText().matches(InputCheck.REGEX)) {
					change.setText("");
				}
			} else if (change.getText().matches("[^0-9.]")) {
				change.setText("");
			}
		}

		return change;
	}
}
