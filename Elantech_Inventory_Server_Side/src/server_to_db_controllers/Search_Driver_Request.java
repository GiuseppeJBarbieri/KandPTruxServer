package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controllers.Server_Data_Controller;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import model_trucking.Drivers_Search_Result_Model;

public class Search_Driver_Request {

	private ArrayList<String> driversList;
	public Search_Driver_Request(ObjectOutputStream output, Object object,
			Server_Data_Controller server_Data_Controller) {

		driversList = new ArrayList<>();
		Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
		dbConnection.connectToDataBase();
		
		try {
			Statement statement = dbConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM drivers");

			while (resultSet.next()) {
				driversList.add(resultSet.getString(2));
			}
			statement.close();
			resultSet.close();
			dbConnection.closeConnection();

			server_Data_Controller.writeObjectToClient(output, new Drivers_Search_Result_Model(driversList));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
