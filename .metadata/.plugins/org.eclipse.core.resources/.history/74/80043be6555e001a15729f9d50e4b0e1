package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controllers.Server_Data_Controller;
import controllers.Server_Thread;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import model_trucking.Remove_Store_Model;
import model_trucking.Remove_TimeFrame_Event_Object;
import models.Server_To_Client_Message_Model;

public class Remove_TimeFrame_Request {

	public Remove_TimeFrame_Request(ObjectOutputStream outputToClient, Object object,
			Server_Data_Controller server_Data_Controller, Server_Thread server) {

		Remove_TimeFrame_Event_Object item = (Remove_TimeFrame_Event_Object) object;
		
		Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
		dbConnection.connectToDataBase();
		
		try {
			PreparedStatement prepStatement = dbConnection.getConnection()
					.prepareStatement("DELETE FROM timeframe_information WHERE Order_ID= ?");

			prepStatement.setString(1, item.getOrderID());
			prepStatement.executeUpdate();
			prepStatement.close();
			dbConnection.closeConnection();
			server_Data_Controller.writeObjectToClient(outputToClient,
					new Remove_Store_Model(new Server_To_Client_Message_Model(0, "Time Frame Removed!",
							"Time Frame was successfully removed from the database!", "Click ok to continue..")));
		} catch (SQLException e1) {
			e1.printStackTrace();
			server_Data_Controller.writeObjectToClient(outputToClient, new Remove_Store_Model(new Server_To_Client_Message_Model(1, "Error!",
					("Time Frame wasn't removed! Error..." + e1.getMessage()), "Click ok to continue..")));
		}
	}

}
