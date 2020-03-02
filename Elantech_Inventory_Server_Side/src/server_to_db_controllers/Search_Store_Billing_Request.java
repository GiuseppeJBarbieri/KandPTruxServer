package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controllers.Server_Data_Controller;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import event_objects.Billing_Store_Search_Result_Model;
import event_objects.Search_Store_Billing_Event_Object;
import model_trucking.Store_Model;

public class Search_Store_Billing_Request {

	private ArrayList<Store_Model> storeResultsList;
	public Search_Store_Billing_Request(ObjectOutputStream output, Object object,
			Server_Data_Controller server_Data_Controller) {
	
		Search_Store_Billing_Event_Object searchObject = (Search_Store_Billing_Event_Object) object;
		storeResultsList = new ArrayList<>();
		Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
		dbConnection.connectToDataBase();

		try {
			Statement statement = dbConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM store_information");
			
			while (resultSet.next()) {
				storeResultsList.add(new Store_Model(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),resultSet.getString(1)));
			}
			statement.close();
			resultSet.close();
			dbConnection.closeConnection();
			
			server_Data_Controller.writeObjectToClient(output, new Billing_Store_Search_Result_Model(storeResultsList));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	}

}
