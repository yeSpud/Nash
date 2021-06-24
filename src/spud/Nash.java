package spud;

import javafx.application.Application;
import javafx.collections.ObservableList;
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
	private static final Calculate calculate = new Calculate();

	/**
	 * TODO Documentation
	 */
	protected static final Reset reset = new Reset();

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
					Nash.button.setOnAction(Nash.calculate);
				}

				case "LeftUpA" -> Nash.LeftUpA = (TextField) element;
				case "LeftUpB" -> Nash.LeftUpB = (TextField) element;
				case "RightUpA" -> Nash.RightUpA = (TextField) element;
				case "RightUpB" -> Nash.RightUpB = (TextField) element;
				case "LeftDownA" -> Nash.LeftDownA = (TextField) element;
				case "LeftDownB" -> Nash.LeftDownB = (TextField) element;
				case "RightDownA" -> Nash.RightDownA = (TextField) element;
				case "RightDownB" -> Nash.RightDownB = (TextField) element;
			}

		}

		Scene scene = new Scene(parent);

		primaryStage.setTitle("Nash");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
