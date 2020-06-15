package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import controllers.Server_Data_Controller;
import database_connectivity_controller.Data_Base_Connectivity_Controller;
import event_objects.Search_All_TimeFrame_Event_Object;
import event_objects.Search_All_TimeFrame_Model;
import model_trucking.Add_TimeFrame_Model;
import model_trucking.Email_Sent_Model;
import model_trucking.Store_Model;
import model_trucking.TimeFrame_Model;
import models.Server_To_Client_Message_Model;

public class Email_All_Time_Frames_Request {

	private ArrayList<TimeFrame_Model> timeFrameResultsList;
	private ArrayList<Store_Model> storeResultsList;

	public Email_All_Time_Frames_Request(ObjectOutputStream output, Object object,
			Server_Data_Controller server_Data_Controller) {
		Search_All_TimeFrame_Event_Object searchObject = (Search_All_TimeFrame_Event_Object) object;
		timeFrameResultsList = new ArrayList<>();
		storeResultsList = new ArrayList<>();
		Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
		dbConnection.connectToDataBase();

		try {
			Statement statement = dbConnection.getConnection().createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM timeframe_information");

			while (resultSet.next()) {
				timeFrameResultsList.add(new TimeFrame_Model(resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
						resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
						resultSet.getDouble(10)));
			}
			statement.close();
			resultSet.close();

			Statement statement2 = dbConnection.getConnection().createStatement();
			ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM store_information");

			while (resultSet2.next()) {
				storeResultsList
						.add(new Store_Model(resultSet2.getString(2), resultSet2.getString(3), resultSet2.getString(4),
								resultSet2.getString(5), resultSet2.getString(6), resultSet2.getString(1)));
			}
			statement2.close();
			resultSet2.close();
			dbConnection.closeConnection();

			LocalDate today = LocalDate.now();

			for (int i = 0; i < storeResultsList.size(); i++) {
				ArrayList<TimeFrame_Model> emailList = new ArrayList<>();

				for (int j = 0; j < timeFrameResultsList.size(); j++) {
					if (today.toString().equals(timeFrameResultsList.get(j).getOrderDate())
							&& storeResultsList.get(i).getStoreID().equalsIgnoreCase(timeFrameResultsList.get(j).getStore_ID())) {
						emailList.add(timeFrameResultsList.get(j));
					}

				}

				if(emailList.size() > 0) {
					emailList(emailList, storeResultsList.get(i), server_Data_Controller, output);
				}
			}
			sendFinalEmail();
			Email_Sent_Model object2 = new Email_Sent_Model(new Server_To_Client_Message_Model(0,
					"Email's Sent!", "Email's were successfully Sent!", "Click ok to continue.."));
			server_Data_Controller.writeObjectToClient(output, object2);
		} catch (SQLException e) {
			e.printStackTrace();
			Email_Sent_Model object2 = new Email_Sent_Model(new Server_To_Client_Message_Model(0,
					"ERROR!", "An error has occurred, Email's didn't send!", "Click ok to continue.."));
			server_Data_Controller.writeObjectToClient(output, object2);
		}

	}
	
	private void sendFinalEmail() {
		String to = "kandptrux@optonline.net";

		// Add sender
		String from = "kandptruxtimeframes@gmail.com";
		final String username = "kandptruxtimeframes@gmail.com";// your Gmail username
		final String password = "Dravenmeng47";// your Gmail password

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		// Get the Session object
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject
			message.setSubject("Timeframes Confirmation For " + LocalDate.now().toString());
			String messageString = "Emails Successfully Sent...";

			// Put the content of your message
			message.setText(messageString);

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);

		}

	}
	
	private void emailList(ArrayList<TimeFrame_Model> emailList, Store_Model store_Model, Server_Data_Controller server_Data_Controller, ObjectOutputStream output) {

		// Add recipient
		String to = store_Model.getEmail();

		// Add sender
		String from = "kandptruxtimeframes@gmail.com";
		final String username = "kandptruxtimeframes@gmail.com";// your Gmail username
		final String password = "Dravenmeng47";// your Gmail password

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject
			message.setSubject("Timeframes For " + LocalDate.now().toString());
			String messageString = "";

			for (int i = 0; i < emailList.size(); i++) {
				//System.out.println("HERE");
				String s = "Customer Name:\t" + emailList.get(i).getName() +
						"\nTown:\t" + emailList.get(i).getTown() +
						"\nPhone Number:\t" + emailList.get(i).getPhoneNumber() +
						"\nDriver:\t"  + emailList.get(i).getDriver() +
						"\nTimeFrame:\t" + emailList.get(i).getTimeFrameStart() + " - " + emailList.get(i).getTimeFrameEnd() +
						"\nOrder Date:\t" + emailList.get(i).getOrderDate() + "\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
				
			
				//System.out.println(s);
				messageString += s;
			}
			// Put the content of your message
			message.setText(messageString);

			// Send message
			Transport.send(message);

			//System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
			
		}
	}
	
	private void testEmailList() {

		// Add recipient
		String to = "giuseppejbarbieri@gmail.com";

		// Add sender
		String from = "kandptruxtimeframes@gmail.com";
		final String username = "kandptruxtimeframes@gmail.com";// your Gmail username
		final String password = "Dravenmeng47";// your Gmail password

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject
			message.setSubject("Timeframes For " + LocalDate.now().toString());
//			String messageString = "Hello " + store_Model.getStoreName() + ",\n"
//					+ "Customer Name \t\t\t Town \t\t\t Phone Number \t\t\t Driver \t\t\t TimeFrame \t\t\t Order Date\n";
//
//			for (int i = 0; i < emailList.size(); i++) {
//				//System.out.println("HERE");
//				String s = emailList.get(i).getName() + " \t\t\t" + emailList.get(i).getTown() + " \t\t\t "
//						+ emailList.get(i).getPhoneNumber() + " \t\t\t " + emailList.get(i).getDriver() + " \t\t\t "
//						+ emailList.get(i).getTimeFrameStart() + " - " + emailList.get(i).getTimeFrameEnd() + " \t\t\t "
//						+ emailList.get(i).getOrderDate() + " \n ";
//				//System.out.println(s);
//				messageString += s;
//			}
//			// Put the content of your message
			message.setText("TEST");

			// Send message
			Transport.send(message);

			//System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
			
		}
	}
}
