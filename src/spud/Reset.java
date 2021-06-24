package spud;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.NotNull;

public class Reset implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {

		TextField[] textFields = new TextField[]{Nash.LeftUpA, Nash.LeftUpB, Nash.RightUpA, Nash.RightUpB, Nash.LeftDownA,
				Nash.LeftDownB, Nash.RightDownA, Nash.RightDownB};
		for (TextField textField : textFields) {
			this.resetTextField(textField);
		}

		Nash.button.setOnAction(Nash.CALCULATE);
	}

	/**
	 * TODO Documentation
	 * @param textField
	 */
	private void resetTextField(@NotNull TextField textField) {

		textField.clear();
		textField.setStyle("");
		textField.setDisable(false);
	}
}
