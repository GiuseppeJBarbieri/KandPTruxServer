package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controllers.Server_Data_Controller;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import event_objects.Search_TimeFrame_Event_Object;
import model_trucking.Search_TimeFrame_Model;
import model_trucking.TimeFrame_Model;

public class Search_TimeFrame_Request {

	private ArrayList<TimeFrame_Model> timeFrameResultsList;

	public Search_TimeFrame_Request(ObjectOutputStream outputToClient, Object object,
			Server_Data_Controller server_Data_Controller) {
		Search_TimeFrame_Event_Object searchObject = (Search_TimeFrame_Event_Object) object;
		timeFrameResultsList = new ArrayList<>();
		Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
		dbConnection.connectToDataBase();

		try {
			Statement statement = dbConnection.getConnection().createStatement();

			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM timeframe_information WHERE store_id = '" + searchObject.getStoreID() + "' ");

			while (resultSet.next()) {
				timeFrameResultsList.add(new TimeFrame_Model(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
						resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getDouble(10)));
			}
			
			statement.close();
			resultSet.close();
			dbConnection.closeConnection();
			server_Data_Controller.writeObjectToClient(outputToClient, new Search_TimeFrame_Model(timeFrameResultsList));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
