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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Nash extends Application {

	public static void main(String[] args) {
		Nash.launch(args);
	}

	public Button button;

	public TextField LeftUpA, LeftUpB, RightUpA, RightUpB, LeftDownA, LeftDownB, RightDownA, RightDownB;

	public TextField[] AllFields;

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
					LeftUpA.textProperty().addListener(new InputValidation());//.setOnAction(new InputValidation());
					/*
					LeftUpA.setTextFormatter(new TextFormatter<>(changed -> {

						if (changed.isContentChange()) {
							if (!changed.getText().matches("\\d*")) {
								changed.setText(changed.getControlText().substring(changed.getRangeStart(), changed.getRangeEnd()));
							}
						}
						return changed;
					}));*/
					//LeftUpA.setTextFormatter(new TextFormatter<>(new InputCheck()));
				}
				case "LeftUpB" -> {
					LeftUpB = (TextField) element;
					LeftUpB.textProperty().addListener(new InputValidation());
					//LeftUpB.setTextFormatter(new TextFormatter<>(new InputCheck()));
				}
				case "RightUpA" -> {
					RightUpA = (TextField) element;
					RightUpA.textProperty().addListener(new InputValidation());
					//RightUpA.setTextFormatter(new TextFormatter<>(new InputCheck()));
				}
				case "RightUpB" -> {
					RightUpB = (TextField) element;
					RightUpB.textProperty().addListener(new InputValidation());
					//RightUpB.setTextFormatter(new TextFormatter<>(new InputCheck()));
				}
				case "LeftDownA" -> {
					LeftDownA = (TextField) element;
					LeftDownA.textProperty().addListener(new InputValidation());
					//LeftDownA.setTextFormatter(new TextFormatter<>(new InputCheck()));
				}
				case "LeftDownB" -> {
					LeftDownB = (TextField) element;
					LeftDownB.textProperty().addListener(new InputValidation());
					//LeftDownB.setTextFormatter(new TextFormatter<>(new InputCheck()));
				}
				case "RightDownA" -> {
					RightDownA = (TextField) element;
					RightDownA.textProperty().addListener(new InputValidation());
					//RightDownA.setTextFormatter(new TextFormatter<>(new InputCheck()));
				}
				case "RightDownB" -> {
					RightDownB = (TextField) element;
					RightDownB.textProperty().addListener(new InputValidation());
					//RightDownB.setTextFormatter(new TextFormatter<>(new InputCheck()));
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

		@Override
		public void handle(ActionEvent event) {

			findCorrect(LeftUpA, LeftDownA);
			findCorrect(RightUpA, RightDownA);
			findCorrect(RightUpB, LeftUpB);
			findCorrect(RightDownB, LeftDownB);


			for (TextField textField : AllFields) {
				textField.setDisable(true);
			}

			button.setText("Reset");
			button.setOnAction(ResetOperation);
		}

		private void findCorrect(TextField a, TextField b) {

			String aInput = a.getText(), bInput = b.getText();
			if (aInput.isEmpty() || bInput.isEmpty()) {
				return;
			}

			try {
				if (Double.parseDouble(aInput) > Double.parseDouble(bInput)) {
					a.setStyle(CORRECT);
					b.setStyle(INCORRECT);
				} else if (Double.parseDouble(aInput) < Double.parseDouble(bInput)) {
					a.setStyle(INCORRECT);
					b.setStyle(CORRECT);
				} else {
					a.setStyle(CORRECT);
					b.setStyle(CORRECT);
				}
			} catch (NumberFormatException notNumber) {
				a.clear();
				b.clear();
			}
		}

	}

	private class Reset implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			for (TextField textField : AllFields) {
				textField.clear();
				textField.setStyle("");
				textField.setDisable(false);
			}

			initButton();
		}
	}
}
