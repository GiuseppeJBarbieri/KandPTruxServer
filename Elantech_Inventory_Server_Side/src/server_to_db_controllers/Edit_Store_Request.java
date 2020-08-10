package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controllers.Server_Data_Controller;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import event_objects.Edit_Store_Event_Object;
import model_trucking.Edit_Store_Model;
import models.Server_To_Client_Message_Model;

public class Edit_Store_Request {

	public Edit_Store_Request(ObjectOutputStream outputToClient, Object object,
			Server_Data_Controller server_Data_Controller) {
		Edit_Store_Event_Object obj = (Edit_Store_Event_Object) object;

		Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
		dbConnection.connectToDataBase();

		try {
			PreparedStatement prepStatement = dbConnection.getConnection()
					.prepareStatement("UPDATE store_information SET store_name=? WHERE store_id = ?");

			prepStatement.setString(1, obj.getStoreName());
			prepStatement.setInt(2, obj.getId());
			prepStatement.executeUpdate();
			prepStatement.close();

			
			for (int i = 0; i < obj.getEmailList().size(); i++) {
				PreparedStatement statement2 = dbConnection.getConnection().prepareStatement(
						"insert into store_contact_information (store_id, email_address)" + " values (?, ?)");

				statement2.setInt(1, obj.getId());
				statement2.setString(2, obj.getEmailList().get(i));
				statement2.execute();
				statement2.close();
			}

			Edit_Store_Model object2 = new Edit_Store_Model(new Server_To_Client_Message_Model(0, "Store Updated!",
					"Store was successfully updated!", "Click ok to continue.."));
			dbConnection.closeConnection();
			server_Data_Controller.writeObjectToClient(outputToClient, object2);

		} catch (SQLException e) {
			e.printStackTrace();
			Edit_Store_Model object2 = new Edit_Store_Model(new Server_To_Client_Message_Model(1, "Error!",
					("Store wasn't Updated! Error..." + e.getMessage()), "Click ok to continue.."));
			server_Data_Controller.writeObjectToClient(outputToClient, object2);

		}

	}

}
