package main_view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controllers.Server_Thread;
import controllers.UserThread;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.User_Account_Information;

public class Server_View_Controller implements Initializable {
	@FXML
	private Button startServerBtn, stopServerBtn, sendMessageBtn, logoutUsersBtn;
	@FXML
	private TextArea consoleTxt;
	@FXML
	private TextField sendMessageTxt;
	@FXML
	private TableView<User_Account_Information> currentUserTable;
	@FXML
	private TableColumn<User_Account_Information, String> ipAddyCol, userCol;

	private ArrayList<User_Account_Information> userThreads;	
	private Stage stage;
	private Thread t1;
	private Server_Thread serverThread;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		userThreads = new ArrayList<>();
		setCurrentUserTable();
		startServerBtn.setOnAction(e -> startServer());
		stopServerBtn.setOnAction(e -> stopServer());
		logoutUsersBtn.setOnAction(e -> logoutUsers());
		startServer();
	}
	/*
	 * ========================================================== 
	 * 					SERVER CONTROLS METHODS 
	 * ==========================================================
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
	
	private void logoutUsers() {
		serverThread.broadCastLogout();
	}

	/*
	 * ========================================================== 
	 * 					GUI SETUP METHODS
	 * ==========================================================
	 */

	private void setCurrentUserTable() {
		ipAddyCol.setCellValueFactory(new PropertyValueFactory<User_Account_Information, String>("id"));
		userCol.setCellValueFactory(new PropertyValueFactory<User_Account_Information, String>("username"));
	}

	public void appendToTextField(String s) {
		consoleTxt.appendText(s + "\n");
	}

	/*
	 * ========================================================== 
	 * 					GETTERS / SETTERS
	 * ==========================================================
	 */

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void updateUserAccountList(ArrayList<UserThread> userThreads2) {
		userThreads.clear();
		
		for(int i=0; i< userThreads2.size(); i++) {
			userThreads.add(userThreads2.get(i).getUserAccountInformation());
		}
		
		
	}


}
