package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.Server_Data_Controller;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import event_objects.Create_Account_Event_Object;
import models.Create_Account_Model;
import models.Server_To_Client_Message_Model;

public class Create_Account_Request {

	public Create_Account_Request(ObjectOutputStream outputToClient, Object object, Server_Data_Controller server_Data_Controller) {
		Create_Account_Event_Object user = (Create_Account_Event_Object) object;
		Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
		dbConnection.connectToDataBase();
		try {
			PreparedStatement prepStatement = dbConnection.getConnection().prepareStatement("select * from user_accounts");
			ResultSet resultSet = prepStatement.executeQuery();

			int key = 0;
			while (resultSet.next()) {
				key = resultSet.getInt(1);
			}
			key++;

			PreparedStatement statement = dbConnection.getConnection().prepareStatement(
					"insert into user_accounts (id, username, password, email_address, first_name, last_name, privilege_level)"
							+ " values (?, ?, ?, ?, ? ,? ,?)");

			statement.setInt(1, key);
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getFirstName());
			statement.setString(6, user.getLastName());
			statement.setString(7, user.getAccountPrivilege());

			statement.execute();
			prepStatement.close();
			resultSet.close();
			statement.close();
			dbConnection.closeConnection();
			Create_Account_Model object2 = new Create_Account_Model(new Server_To_Client_Message_Model(0,
					"Account Created!",
					"Account was successfully Created!",
					"Click ok to continue.."));
			server_Data_Controller.writeObjectToClient(outputToClient, object2);
		} catch (SQLException e) {
			e.printStackTrace();
			Create_Account_Model object2 = new Create_Account_Model(new Server_To_Client_Message_Model(1,
					"Error!",("Account wasn't created! Error..." + e.getMessage()), "Click ok to continue.."));
			server_Data_Controller.writeObjectToClient(outputToClient, object2);
		}
	}

}
