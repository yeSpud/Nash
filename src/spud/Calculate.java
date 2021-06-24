package spud;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

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
		Nash.button.setOnAction(Nash.reset);
	}

	/**
	 * TODO Documentation
	 * @param a
	 * @param b
	 */
	private void findCorrect(TextField a, TextField b) {

		if (a == null | b == null) {
			return;
		}

		if (Double.parseDouble(a.getText()) > Double.parseDouble(b.getText())) {
			a.setStyle(Calculate.CORRECT);
			b.setStyle(Calculate.INCORRECT);
		} else if (Double.parseDouble(a.getText()) < Double.parseDouble(b.getText())) {
			a.setStyle(Calculate.INCORRECT);
			b.setStyle(Calculate.CORRECT);
		} else {
			a.setStyle(Calculate.CORRECT);
			b.setStyle(Calculate.CORRECT);
		}
	}
}
