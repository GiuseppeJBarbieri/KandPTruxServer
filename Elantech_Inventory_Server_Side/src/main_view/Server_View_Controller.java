package main_view;

import java.net.URL;
import java.util.ResourceBundle;

import controllers.Server_Thread;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Server_View_Controller implements Initializable {
	@FXML
	private Button startServerBtn, stopServerBtn, sendMessageBtn, logoutUsersBtn;
	@FXML
	private TextArea consoleTxt;
	@FXML
	private TextField sendMessageTxt;

	private Stage stage;
	private Thread t1;
	private Server_Thread serverThread;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		startServerBtn.setOnAction(e -> startServer());
		stopServerBtn.setOnAction(e -> stopServer());
		startServer();
	}

	/*
	 * ========================================================== SERVER CONTROLS
	 * METHODS ==========================================================
	 */
	private void startServer() {
		serverThread = new Server_Thread(this);
		t1 = new Thread(serverThread);
		t1.setDaemon(true);
		t1.start();
	}

	private void stopServer() {
		stage.close();
	}

	/*
	 * ========================================================== GUI SETUP METHODS
	 * ==========================================================
	 */

	public void appendToTextField(String s) {
		consoleTxt.appendText(s + "\n");
	}

	/*
	 * ========================================================== GETTERS / SETTERS
	 * ==========================================================
	 */

	public void setStage(Stage stage) {
		this.stage = stage;
	}

}
