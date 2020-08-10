package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controllers.Server_Data_Controller;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import event_objects.Add_Store_Event_Object;
import model_trucking.Add_Store_Request_Model;
import models.Server_To_Client_Message_Model;

public class Add_Store_Request {

	public Add_Store_Request(ObjectOutputStream outputToClient, Object object,
			Server_Data_Controller server_Data_Controller) {
		Add_Store_Event_Object storeObj = (Add_Store_Event_Object) object;

		try {
			Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
			dbConnection.connectToDataBase();
			PreparedStatement statement = dbConnection.getConnection().prepareStatement(
					"insert into store_information (store_name)"
							+ " values (?)", Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, storeObj.getStoreName());
			statement.execute();
			
			ResultSet rs = statement.getGeneratedKeys();
			int generatedID = 0;
			if(rs.next()) {
				generatedID = rs.getInt(1);
			}
			
			// GET ID THEN ADD EMAIL ADDRESSES
			for(int i = 0; i < storeObj.getEmailList().size(); i++) {
				PreparedStatement statement2 = dbConnection.getConnection().prepareStatement(
						"insert into store_contact_information (store_id, email_address)"
								+ " values (?, ?)");

				statement2.setInt(1, generatedID);
				statement2.setString(2, storeObj.getEmailList().get(i));
				statement2.execute();
				statement2.close();
			}
			dbConnection.closeConnection();
			Add_Store_Request_Model object2 = new Add_Store_Request_Model (new Server_To_Client_Message_Model(0,
					"Store Added!", "Store was successfully added to the database!", "Click ok to continue.."));

			server_Data_Controller.writeObjectToClient(outputToClient, object2);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			Add_Store_Request_Model object2 = new Add_Store_Request_Model(new Server_To_Client_Message_Model(1,
					"Error!", ("Store wasn't added! Error..." + e.getMessage()), "Click ok to continue.."));
			server_Data_Controller.writeObjectToClient(outputToClient, object2);

		}
	}

	/* USELESS */
	public boolean checkStoreExistence(Add_Store_Event_Object storeObj) {
		/*
		 * If product exist = true; - Dont Add - If it doesnt exist = false; - Add -
		 */

		try {
			Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
			dbConnection.connectToDataBase();
			Statement statement = dbConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(
					"select * from store_information where Store_Name = '" + storeObj.getStoreName() + "'");

			while (resultSet.next()) {
				if (resultSet.getString(3).equalsIgnoreCase(storeObj.getStoreName())) {

				}
			}
			resultSet.close();
			statement.close();
			dbConnection.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
