package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controllers.Server_Data_Controller;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import event_objects.Reset_Account_Password_Event_Object;
import models.Reset_Account_Password_Model;
import models.Server_To_Client_Message_Model;

public class Reset_Account_Password_Request {

	public Reset_Account_Password_Request(ObjectOutputStream outputToClient, Object object,
			Server_Data_Controller server_Data_Controller) {

		Reset_Account_Password_Event_Object obj = (Reset_Account_Password_Event_Object) object;

		Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
		dbConnection.connectToDataBase();

		try {
			PreparedStatement prepStatement = dbConnection.getConnection().prepareStatement(
					"UPDATE user_accounts SET password= ? WHERE username= ?");

			prepStatement.setString(1, obj.getPassword());
			prepStatement.setString(2, obj.getUsername());
			prepStatement.executeUpdate();
			prepStatement.close();
			server_Data_Controller.writeObjectToClient(outputToClient, new Reset_Account_Password_Model(new Server_To_Client_Message_Model(0,
					"Password Reset!", "Your password was successfully reset!", "Click ok to continue..")));
			dbConnection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			server_Data_Controller.writeObjectToClient(outputToClient, new Reset_Account_Password_Model(new Server_To_Client_Message_Model(1, "Error!",
					("Password wasn't Updated! Error..." + e.getMessage()), "Click ok to continue..")));

		}
	}

}
