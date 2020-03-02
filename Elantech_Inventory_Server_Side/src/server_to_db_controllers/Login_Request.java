package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controllers.Server_Data_Controller;
import controllers.Server_Thread;
import controllers.UserThread;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import event_objects.Login_Event_Object;
import models.Login_Message_Model;
import models.Server_To_Client_Message_Model;
import models.User_Account_Information;

public class Login_Request {

	private User_Account_Information userInfo;

	public Login_Request(Object object, ObjectOutputStream output, Server_Data_Controller serverController,
			UserThread userThread, Server_Thread server, Socket socket) {

		Login_Event_Object loginObject = (Login_Event_Object) object;
		Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
		dbConnection.connectToDataBase();

		boolean found = false;

		try {
			Statement statement = dbConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user_accounts where username = '"
					+ loginObject.getUsername() + "' and password = '" + loginObject.getPassword() + "'");

			while (resultSet.next()) {
				if (resultSet.getString(3).equals(loginObject.getPassword())) {
					found = true;
					userInfo = new User_Account_Information(resultSet.getInt(1), resultSet.getString(2),
							resultSet.getString(6), resultSet.getString(4), resultSet.getString(5),
							resultSet.getString(7));
				}
			}
			if (found == true) {
				userThread.setUserAccountInformation(userInfo);
				server.updateServerViewList();

				serverController
						.writeObjectToClient(output,
								new Login_Message_Model(
										new Server_To_Client_Message_Model(0, "Logged In!",
												"You have successfully been logged in!", "Click ok to continue.."),
										userInfo));

			} else {
				serverController.writeObjectToClient(output,
						new Login_Message_Model(new Server_To_Client_Message_Model(1, "Wrong password!",
								"You have entered in the wrong password please try again!", "Click ok to continue.."),
								null));
			}
			
			statement.close();
			resultSet.close();
			dbConnection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
