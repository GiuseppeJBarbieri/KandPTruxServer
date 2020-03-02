package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controllers.Server_Data_Controller;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import event_objects.All_Time_Frame_Request;
import event_objects.Search_All_Time_Frame_Event_Object;
import model_trucking.Store_Model;
import model_trucking.TimeFrame_Model;

public class Search_All_Times_Request {
	private ArrayList<TimeFrame_Model> timeFramesList;
	private ArrayList<Store_Model> storeList;
	public Search_All_Times_Request(ObjectOutputStream output, Object object,
			Server_Data_Controller server_Data_Controller) {
		
		Search_All_Time_Frame_Event_Object obj = (Search_All_Time_Frame_Event_Object) object;
		
		Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
		dbConnection.connectToDataBase();
		timeFramesList = new ArrayList<>();
		storeList = new ArrayList<>();
		try {
			Statement statement = dbConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM store_information");
			
			while (resultSet.next()) {
				storeList.add(new Store_Model(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),resultSet.getString(1)));
			}
			statement.close();
			resultSet.close();
			Statement statement2 = dbConnection.getConnection().createStatement();
			ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM timeframe_information");
			
			while (resultSet2.next()) {
				timeFramesList.add(new TimeFrame_Model(resultSet2.getString(1), resultSet2.getString(2), resultSet2.getString(3), resultSet2.getString(4), resultSet2.getString(5),
						resultSet2.getString(6), resultSet2.getString(7), resultSet2.getString(8), resultSet2.getString(9), resultSet2.getDouble(10)));
			}
			
			statement.close();
			statement2.close();
			resultSet.close();
			resultSet2.close();
			
			dbConnection.closeConnection();
			server_Data_Controller.writeObjectToClient(output, new All_Time_Frame_Request(timeFramesList, storeList));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
