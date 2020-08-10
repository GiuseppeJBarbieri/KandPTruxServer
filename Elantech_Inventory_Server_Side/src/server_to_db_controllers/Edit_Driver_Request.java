package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controllers.Server_Data_Controller;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import event_objects.Edit_Drivers_Event_Object;
import model_trucking.Edit_Driver_Model;
import models.Server_To_Client_Message_Model;

public class Edit_Driver_Request {

	public Edit_Driver_Request(ObjectOutputStream output, Object object,
			Server_Data_Controller server_Data_Controller) {
		Edit_Drivers_Event_Object ev = (Edit_Drivers_Event_Object) object;

		try {
			Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
			dbConnection.connectToDataBase();
			
			PreparedStatement prepStatement2 = dbConnection.getConnection()
					.prepareStatement("TRUNCATE TABLE drivers");
			prepStatement2.executeUpdate();
			prepStatement2.close();
			
			
			for (int i = 0; i < ev.getDriversList().size(); i++) {
				PreparedStatement statement = dbConnection.getConnection()
						.prepareStatement("insert into drivers (driver_name)" + " values (?)");

				statement.setString(1, ev.getDriversList().get(i));
				statement.execute();
				statement.close();
			}
			
			dbConnection.closeConnection();
			Edit_Driver_Model object2 = new Edit_Driver_Model(
					new Server_To_Client_Message_Model(0, "Drivers Updated!",
							"Drivers was successfully added to the database!", "Click ok to continue.."));

			server_Data_Controller.writeObjectToClient(output, object2);
		} catch (SQLException e) {
			e.printStackTrace();
			Edit_Driver_Model object2 = new Edit_Driver_Model(new Server_To_Client_Message_Model(1, "Error!",
					("Drivers wasn't added! Error..." + e.getMessage()), "Click ok to continue.."));
			server_Data_Controller.writeObjectToClient(output, object2);

		}

	}

}
