package spud;

import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

@Deprecated
public class InputCheck implements UnaryOperator<TextFormatter.Change> {

	private static final String allowedChars = "^-|[\\.0-9]";

	/**
	 * Credit to <a href="https://gist.github.com/karimsqualli96/f8d4c2995da8e11496ed">karimsqualli96</a> on GitHub.
	 */
	@Override
	public TextFormatter.Change apply(TextFormatter.Change change) {

		if (change.isReplaced() || change.isAdded()) {
			if (!change.getText().matches(InputCheck.allowedChars)) {
				change.setText(change.getControlText().substring(change.getRangeStart(), change.getRangeEnd()));
			}
		}

		return change;
	}
}
