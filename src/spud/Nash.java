package spud;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Nash extends Application {

	public static void main(String[] args) {
		Nash.launch(args);
	}

	/**
	 * TODO Documentation
	 */
	public static Button button;

	/**
	 * TODO Documentation
	 */
	public static TextField LeftUpA, LeftUpB, RightUpA, RightUpB, LeftDownA, LeftDownB, RightDownA, RightDownB;

	/**
	 * TODO Documentation
	 */
	protected static final Calculate CALCULATE = new Calculate();

	/**
	 * TODO Documentation
	 */
	protected static final Reset RESET = new Reset();

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
					Nash.button = (Button) element;
					Nash.button.setText("Calculate");
					Nash.button.setOnAction(Nash.CALCULATE);
				}

				case "LeftUpA" -> {
					Nash.LeftUpA = (TextField) element;
					Nash.LeftUpA.setTextFormatter(new TextFormatter<>(new InputCheck()));
				}
				case "LeftUpB" -> {
					Nash.LeftUpB = (TextField) element;
					Nash.LeftUpB.setTextFormatter(new TextFormatter<>(new InputCheck()));
				}
				case "RightUpA" -> {
					Nash.RightUpA = (TextField) element;
					Nash.RightUpA.setTextFormatter(new TextFormatter<>(new InputCheck()));
				}
				case "RightUpB" -> {
					Nash.RightUpB = (TextField) element;
					Nash.RightUpB.setTextFormatter(new TextFormatter<>(new InputCheck()));
				}
				case "LeftDownA" -> {
					Nash.LeftDownA = (TextField) element;
					Nash.LeftDownA.setTextFormatter(new TextFormatter<>(new InputCheck()));
				}
				case "LeftDownB" -> {
					Nash.LeftDownB = (TextField) element;
					Nash.LeftDownB.setTextFormatter(new TextFormatter<>(new InputCheck()));
				}
				case "RightDownA" -> {
					Nash.RightDownA = (TextField) element;
					Nash.RightDownA.setTextFormatter(new TextFormatter<>(new InputCheck()));
				}
				case "RightDownB" -> {
					Nash.RightDownB = (TextField) element;
					Nash.RightDownB.setTextFormatter(new TextFormatter<>(new InputCheck()));
				}
			}

		}

		Scene scene = new Scene(parent);

		primaryStage.setTitle("Nash");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
