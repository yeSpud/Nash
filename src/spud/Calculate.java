package spud;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.NotNull;

public class Calculate implements EventHandler<ActionEvent> {

	private static final String CORRECT = "-fx-text-fill: green", INCORRECT = "-fx-text-fill: red;";

	@Override
	public void handle(ActionEvent event) {

		this.findCorrect(Nash.LeftUpA, Nash.LeftDownA);
		this.findCorrect(Nash.RightUpA, Nash.RightDownA);
		this.findCorrect(Nash.RightUpB, Nash.LeftUpB);
		this.findCorrect(Nash.RightDownB, Nash.LeftDownB);

		TextField[] textFields = new TextField[]{Nash.LeftUpA, Nash.LeftUpB, Nash.RightUpA, Nash.RightUpB, Nash.LeftDownA,
				Nash.LeftDownB, Nash.RightDownA, Nash.RightDownB};
		for (TextField textField : textFields) {
			textField.setDisable(true);
		}

		Nash.button.setText("Reset");
		Nash.button.setOnAction(Nash.RESET);
	}

	/**
	 * TODO Documentation
	 * @param a
	 * @param b
	 */
	private void findCorrect(@NotNull TextField a, @NotNull TextField b) {

		String aInput = a.getText(), bInput = b.getText();
		if (aInput.isEmpty() || bInput.isEmpty()) {
			return;
		}

		if (Double.parseDouble(aInput) > Double.parseDouble(bInput)) {
			a.setStyle(Calculate.CORRECT);
			b.setStyle(Calculate.INCORRECT);
		} else if (Double.parseDouble(aInput) < Double.parseDouble(bInput)) {
			a.setStyle(Calculate.INCORRECT);
			b.setStyle(Calculate.CORRECT);
		} else {
			a.setStyle(Calculate.CORRECT);
			b.setStyle(Calculate.CORRECT);
		}
	}
}
