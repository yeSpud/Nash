package spud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Nash extends Application {

	public static void main(String[] args) {
		Nash.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		GridPane parent;
		try {
			parent = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("Nash.fxml")));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		Scene scene = new Scene(parent);

		primaryStage.setTitle("Nash");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
