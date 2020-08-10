package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controllers.Server_Data_Controller;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import event_objects.Remove_Store_Event_Object;
import model_trucking.Remove_Store_Model;
import models.Server_To_Client_Message_Model;

public class Remove_Store_Request {

	public Remove_Store_Request(ObjectOutputStream outputToClient, Object object,
			Server_Data_Controller server_Data_Controller) {

		Remove_Store_Event_Object product = (Remove_Store_Event_Object) object;
		Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
		dbConnection.connectToDataBase();
		
		try {
			PreparedStatement prepStatement = dbConnection.getConnection()
					.prepareStatement("DELETE FROM store_information WHERE store_id= ?");

			prepStatement.setInt(1, product.getStoreID());
			prepStatement.executeUpdate();
			prepStatement.close();
			dbConnection.closeConnection();
			server_Data_Controller.writeObjectToClient(outputToClient,
					new Remove_Store_Model(new Server_To_Client_Message_Model(0, "Product Removed!",
							"Store was successfully removed from the database!", "Click ok to continue..")));
		} catch (SQLException e1) {
			e1.printStackTrace();
			server_Data_Controller.writeObjectToClient(outputToClient, new Remove_Store_Model(new Server_To_Client_Message_Model(1, "Error!",
					("Store wasn't removed! Error..." + e1.getMessage()), "Click ok to continue..")));
		}
	}

}
