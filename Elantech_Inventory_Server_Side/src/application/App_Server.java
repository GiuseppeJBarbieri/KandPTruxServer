package application;

import javafx.application.Application;
import javafx.stage.Stage;
import main_view.Show_Server_View;

public class App_Server extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		new Show_Server_View(stage);
	}

}
