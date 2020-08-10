package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controllers.Server_Data_Controller;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import model_trucking.Search_Store_Event_Object;
import model_trucking.Store_Model;
import model_trucking.Store_Search_Result_Model;

public class Search_Store_Request {

	private ArrayList<Store_Model> storeResultsList;

	public Search_Store_Request(ObjectOutputStream outputToClient, Object object,
			Server_Data_Controller server_Data_Controller) {
		Search_Store_Event_Object searchObject = (Search_Store_Event_Object) object;
		storeResultsList = new ArrayList<>();
		Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
		dbConnection.connectToDataBase();

		try {
			Statement statement = dbConnection.getConnection().createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM store_information WHERE lower(store_name) LIKE '%"
							+ searchObject.getStoreName() + "%'");

			while (resultSet.next()) {
				storeResultsList.add(new Store_Model(resultSet.getInt(1), resultSet.getString(2), null));
			}
			
			// Get Email Address Next
			for(int i = 0; i < storeResultsList.size(); i++) {
				Statement statement2 = dbConnection.getConnection().createStatement();
				ResultSet resultSet2 = statement2
						.executeQuery("SELECT * FROM store_contact_information WHERE store_id ='"
								+ storeResultsList.get(i).getStoreID() + "'");
				ArrayList<String> emailList = new ArrayList<>();
				while (resultSet2.next()) {
					emailList.add(resultSet2.getString(2));
				}
				storeResultsList.get(i).setEmailList(emailList);
				resultSet2.close();
				statement2.close();
			}
			
			statement.close();
			resultSet.close();
			dbConnection.closeConnection();

			server_Data_Controller.writeObjectToClient(outputToClient, new Store_Search_Result_Model(storeResultsList));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
