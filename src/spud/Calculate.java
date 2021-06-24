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

		Nash.LeftUpA.setDisable(true);
		Nash.LeftDownA.setDisable(true);
		Nash.RightUpA.setDisable(true);
		Nash.RightDownA.setDisable(true);
		Nash.LeftUpB.setDisable(true);
		Nash.LeftDownB.setDisable(true);
		Nash.RightUpB.setDisable(true);
		Nash.RightDownB.setDisable(true);

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
			a.setStyle(CORRECT);
			b.setStyle(INCORRECT);
		} else if (Double.parseDouble(a.getText()) < Double.parseDouble(b.getText())) {
			a.setStyle(INCORRECT);
			b.setStyle(CORRECT);
		} else {
			a.setStyle(CORRECT);
			b.setStyle(CORRECT);
		}
	}
}
