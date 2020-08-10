package controllers;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import event_objects.Add_Store_Event_Object;
import event_objects.Add_TimeFrame_Event_Object;
import event_objects.Edit_Drivers_Event_Object;
import event_objects.Edit_Store_Event_Object;
import event_objects.Edit_TimeFrame_Event_Object;
import event_objects.Email_One_TimeFrame_Event_Object;
import event_objects.Remove_Store_Event_Object;
import event_objects.Search_All_TimeFrame_Event_Object;
import event_objects.Search_All_Time_Frame_Event_Object;
import event_objects.Search_COD_Event_Object;
import event_objects.Search_Driver_Event_Object;
import event_objects.Search_Drivers_Event_Object;
import event_objects.Search_Store_Billing_Event_Object;
import event_objects.Search_TimeFrame_Event_Object;
import model_trucking.Remove_TimeFrame_Event_Object;
import model_trucking.Search_Store_Event_Object;
import server_to_db_controllers.Add_Store_Request;
import server_to_db_controllers.Add_TimeFrame_Request;
import server_to_db_controllers.Edit_Driver_Request;
import server_to_db_controllers.Edit_Store_Request;
import server_to_db_controllers.Edit_TimeFrame_Request;
import server_to_db_controllers.Email_All_Time_Frames_Request;
import server_to_db_controllers.Email_One_TimeFrame_Request;
import server_to_db_controllers.Remove_Store_Request;
import server_to_db_controllers.Remove_TimeFrame_Request;
import server_to_db_controllers.Search_All_Times_Request;
import server_to_db_controllers.Search_COD_Request;
import server_to_db_controllers.Search_Driver_Request;
import server_to_db_controllers.Search_Drivers_Request;
import server_to_db_controllers.Search_Store_Billing_Request;
import server_to_db_controllers.Search_Store_Request;
import server_to_db_controllers.Search_TimeFrame_Request;


public class Server_Data_Controller {

	public synchronized void controlData(Object object, ObjectOutputStream output, UserThread userThread, Server_Thread server, Socket socket) {
		if (object.getClass() == Search_Store_Event_Object.class) {
			new Search_Store_Request(output, object, this);
		} else if (object.getClass() == Search_TimeFrame_Event_Object.class) {
			new Search_TimeFrame_Request(output, object, this);
		} else if (object.getClass() == Add_Store_Event_Object.class) {
			new Add_Store_Request(output, object, this);
		} else if (object.getClass() == Edit_Store_Event_Object.class) {
			new Edit_Store_Request(output, object, this);
		} else if (object.getClass() == Add_TimeFrame_Event_Object.class) {
			new Add_TimeFrame_Request(output, object, this, server);
		} else if (object.getClass() == Remove_TimeFrame_Event_Object.class) {
			new Remove_TimeFrame_Request(output, object, this, server);
		} else if (object.getClass() == Edit_TimeFrame_Event_Object.class) {
			new Edit_TimeFrame_Request(output, object, this);
		} else if (object.getClass() == Remove_Store_Event_Object.class) {
			new Remove_Store_Request(output, object, this);
		} else if (object.getClass() == Search_All_Time_Frame_Event_Object.class) {
			new Search_All_Times_Request(output, object, this);
		} else if (object.getClass() == Search_COD_Event_Object.class) {
			new Search_COD_Request(output, object, this);
		} else if (object.getClass() == Search_All_TimeFrame_Event_Object.class) {
			new Email_All_Time_Frames_Request(output, object, this);
		} else if(object.getClass() == Search_Store_Billing_Event_Object.class) {
			new Search_Store_Billing_Request(output, object, this);
		} else if(object.getClass() == Email_One_TimeFrame_Event_Object.class) {
			new Email_One_TimeFrame_Request(output, object, this);
		} else if(object.getClass() == Search_Driver_Event_Object.class) {
			new Search_Driver_Request(output, object, this);
		} else if(object.getClass() == Edit_Drivers_Event_Object.class) {
			new Edit_Driver_Request(output, object, this);
		} else if(object.getClass() == Search_Drivers_Event_Object.class) {
			new Search_Drivers_Request(output, object, this);
		}
	}
	
	public synchronized void writeObjectToClient(ObjectOutputStream output, Object object) {
		try {
			output.writeObject(object);
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
