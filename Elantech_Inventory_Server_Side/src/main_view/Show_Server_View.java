package main_view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Show_Server_View {

	public Show_Server_View(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view/Server_Skin.fxml"));
			AnchorPane root = loader.load();
			Server_View_Controller controller = loader.getController();
			controller.setStage(stage);
			Scene scene = new Scene(root, 648, 466);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
