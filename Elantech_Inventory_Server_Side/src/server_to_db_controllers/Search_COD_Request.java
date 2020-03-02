package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controllers.Server_Data_Controller;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import event_objects.COD_Search_Result_Model;
import event_objects.Search_COD_Event_Object;
import model_trucking.COD_Model;

public class Search_COD_Request {

	private ArrayList<COD_Model> codList;
	public Search_COD_Request(ObjectOutputStream output, Object object, Server_Data_Controller server_Data_Controller) {
	
		Search_COD_Event_Object obj = (Search_COD_Event_Object) object;
		
		codList = new ArrayList<>();
		Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
		dbConnection.connectToDataBase();

		try {
			Statement statement = dbConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM cods");
			
			while (resultSet.next()) {
				codList.add(new COD_Model(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getDouble(7)));
			}
			statement.close();
			resultSet.close();
			dbConnection.closeConnection();
			
			server_Data_Controller.writeObjectToClient(output, new COD_Search_Result_Model(codList));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
