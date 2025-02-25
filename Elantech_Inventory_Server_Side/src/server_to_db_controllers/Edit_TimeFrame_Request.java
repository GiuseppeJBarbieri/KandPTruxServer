package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controllers.Server_Data_Controller;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import event_objects.Edit_TimeFrame_Event_Object;
import model_trucking.Edit_TimeFrame_Model;
import models.Server_To_Client_Message_Model;

public class Edit_TimeFrame_Request {

	public Edit_TimeFrame_Request(ObjectOutputStream outputToClient, Object object,
			Server_Data_Controller server_Data_Controller) {
		Edit_TimeFrame_Event_Object obj = (Edit_TimeFrame_Event_Object) object;

		Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
		dbConnection.connectToDataBase();

		try {
			PreparedStatement prepStatement = dbConnection.getConnection().prepareStatement(
					"UPDATE timeframe_information SET customer_name=?, town=?, order_number=?, driver=?, timeframe=?, order_date=? WHERE order_id = ?");

			prepStatement.setString(1, obj.getCustomerName());
			prepStatement.setString(2, obj.getTown());
			prepStatement.setString(3, obj.getOrderNumber());
			prepStatement.setString(4, obj.getDriver());
			prepStatement.setString(5, obj.getTimeFrame());
			prepStatement.setDate(6, obj.getOrderDate());
			prepStatement.setInt(7, obj.getOrderID());
			prepStatement.executeUpdate();
			prepStatement.close();
			
			Edit_TimeFrame_Model object2 = new Edit_TimeFrame_Model(new Server_To_Client_Message_Model(0,
					"Time Frame Updated!", "Time Frame was successfully updated!", "Click ok to continue.."));
			server_Data_Controller.writeObjectToClient(outputToClient, object2);

		} catch (SQLException e) {
			e.printStackTrace();
			Edit_TimeFrame_Model object2 = new Edit_TimeFrame_Model(new Server_To_Client_Message_Model(1, "Error!",
					("Time Frame wasn't Updated! Error..." + e.getMessage()), "Click ok to continue.."));
			server_Data_Controller.writeObjectToClient(outputToClient, object2);
		}

	}

}
