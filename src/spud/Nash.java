package spud;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Nash extends Application {

	public static void main(String[] args) {
		Nash.launch(args);
	}

	private Button button;

	private TextField LeftUpA, LeftUpB, RightUpA, RightUpB, LeftDownA, LeftDownB, RightDownA, RightDownB;

	private TextField[] AllFields;

	private final Calculate CalculateOperation = new Calculate();

	private final Reset ResetOperation = new Reset();

	private byte CompletedCells = 0;

	@Override
	public void start(Stage primaryStage) {

		GridPane parent;
		try {
			parent = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("Nash.fxml")));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		ObservableList<Node> elements = parent.getChildren();
		for (Node element : elements) {

			String id = element.getId();

			if (id == null) {
				continue;
			}

			switch (id) {

				case "Button" -> {
					button = (Button) element;
					initButton();
				}
				case "LeftUpA" -> {
					LeftUpA = (TextField) element;
					LeftUpA.textProperty().addListener(new InputValidation());
				}
				case "LeftUpB" -> {
					LeftUpB = (TextField) element;
					LeftUpB.textProperty().addListener(new InputValidation());
				}
				case "RightUpA" -> {
					RightUpA = (TextField) element;
					RightUpA.textProperty().addListener(new InputValidation());
				}
				case "RightUpB" -> {
					RightUpB = (TextField) element;
					RightUpB.textProperty().addListener(new InputValidation());
				}
				case "LeftDownA" -> {
					LeftDownA = (TextField) element;
					LeftDownA.textProperty().addListener(new InputValidation());
				}
				case "LeftDownB" -> {
					LeftDownB = (TextField) element;
					LeftDownB.textProperty().addListener(new InputValidation());
				}
				case "RightDownA" -> {
					RightDownA = (TextField) element;
					RightDownA.textProperty().addListener(new InputValidation());
				}
				case "RightDownB" -> {
					RightDownB = (TextField) element;
					RightDownB.textProperty().addListener(new InputValidation());
				}
			}
		}

		AllFields = new TextField[]{LeftUpA, LeftUpB, RightUpA, RightUpB, LeftDownA, LeftDownB, RightDownA, RightDownB};

		Scene scene = new Scene(parent);

		primaryStage.setResizable(false);
		primaryStage.setTitle("Nash");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void initButton() {
		button.setText("Calculate");
		button.setOnAction(CalculateOperation);
		button.setDisable(true);
	}

	private class InputValidation implements ChangeListener<String> {

		private int lastUpdated = 0;

		@Override
		public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {

			if (newValue.isEmpty()) {
				if (lastUpdated > -1) {
					--CompletedCells;
					lastUpdated = -1;
				}
			} else {
				if (lastUpdated < 1) {
					++CompletedCells;
					lastUpdated = 1;
				}
			}
			button.setDisable(CompletedCells != 8);

		}
	}

	private class Calculate implements EventHandler<ActionEvent> {

		private static final String CORRECT = "-fx-text-fill: green", INCORRECT = "-fx-text-fill: red;";

		private static final Font SUPER_CORRECT = Font.font("System Regular", FontWeight.EXTRA_BOLD, 13);

		@Override
		public void handle(ActionEvent event) {

			for (TextField textField : AllFields) {
				textField.setDisable(true);
			}

			colorDominant(LeftUpA, LeftDownA);
			colorDominant(RightUpA, RightDownA);
			colorDominant(RightUpB, LeftUpB);
			colorDominant(RightDownB, LeftDownB);

			colorCorrect(LeftUpA, LeftUpB);
			colorCorrect(RightUpA, RightUpB);
			colorCorrect(LeftDownA, LeftDownB);
			colorCorrect(RightDownA, RightDownB);

			button.setText("Reset");
			button.setOnAction(ResetOperation);
		}

		private void colorDominant(TextField field1, TextField field2) {

			String aInput = field1.getText(), bInput = field2.getText();
			if (aInput.isEmpty() || bInput.isEmpty()) {
				return;
			}

			try {
				if (Double.parseDouble(aInput) > Double.parseDouble(bInput)) {
					field1.setStyle(CORRECT);
					field2.setStyle(INCORRECT);
				} else if (Double.parseDouble(aInput) < Double.parseDouble(bInput)) {
					field1.setStyle(INCORRECT);
					field2.setStyle(CORRECT);
				} else {
					field1.setStyle(CORRECT);
					field2.setStyle(CORRECT);
				}
			} catch (NumberFormatException notNumber) {
				field1.clear();
				field2.clear();
			}
		}

		private void colorCorrect(TextField playerA, TextField playerB) {

			if (playerA.getStyle().equals(CORRECT) && playerB.getStyle().equals(CORRECT)) {
				playerA.setFont(SUPER_CORRECT);
				playerB.setFont(SUPER_CORRECT);
			}
		}
	}

	private class Reset implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			for (TextField textField : AllFields) {
				textField.clear();
				textField.setStyle("");
				textField.setFont(Font.getDefault());
				textField.setDisable(false);
			}

			initButton();
		}
	}
}
