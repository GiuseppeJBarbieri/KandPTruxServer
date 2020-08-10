package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controllers.Server_Data_Controller;
import controllers.Server_Thread;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import event_objects.Add_TimeFrame_Event_Object;
import model_trucking.Add_TimeFrame_Model;
import models.Server_To_Client_Message_Model;

public class Add_TimeFrame_Request {

	public Add_TimeFrame_Request(ObjectOutputStream outputToClient, Object object,
			Server_Data_Controller server_Data_Controller, Server_Thread server) {
		Add_TimeFrame_Event_Object ev = (Add_TimeFrame_Event_Object) object;

		try {
			Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
			dbConnection.connectToDataBase();
			PreparedStatement statement = dbConnection.getConnection().prepareStatement(
					"insert into timeframe_information (store_id, customer_name, town, order_number, driver, timeframe, order_date)"
							+ " values (?, ?, ?, ?, ?, ?, ?)");

			statement.setInt(1, ev.getStoreId());
			statement.setString(2, ev.getCustomerName());
			statement.setString(3, ev.getTown());
			statement.setString(4, ev.getOrderNumber());
			statement.setString(5, ev.getDriver());
			statement.setString(6, ev.getTimeFrame());
			statement.setDate(7, ev.getOrderDate());
			statement.execute();

			dbConnection.closeConnection();
			Add_TimeFrame_Model object2 = new Add_TimeFrame_Model (new Server_To_Client_Message_Model(0,
					"Time Frame Added!", "Time Frame  was successfully added to the database!", "Click ok to continue.."));

			server_Data_Controller.writeObjectToClient(outputToClient, object2);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			Add_TimeFrame_Model object2 = new Add_TimeFrame_Model(new Server_To_Client_Message_Model(1,
					"Error!", ("Time Frame wasn't added! Error..." + e.getMessage()), "Click ok to continue.."));
			server_Data_Controller.writeObjectToClient(outputToClient, object2);

		}
	}

}
