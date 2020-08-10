package server_to_db_controllers;

import java.io.ObjectOutputStream;
import java.sql.Date;
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
import model_trucking.Email_Sent_Model;
import model_trucking.Store_Model;
import model_trucking.TimeFrame_Model;
import models.Server_To_Client_Message_Model;

public class Email_All_Time_Frames_Request {

	private ArrayList<TimeFrame_Model> timeFrameResultsList;
	private ArrayList<Store_Model> storeResultsList;

	public Email_All_Time_Frames_Request(ObjectOutputStream output, Object object,
			Server_Data_Controller server_Data_Controller) {
		
		timeFrameResultsList = new ArrayList<>();
		storeResultsList = new ArrayList<>();
		Data_Base_Connectivity_Controller dbConnection = new Data_Base_Connectivity_Controller();
		dbConnection.connectToDataBase();

		try {
			Statement statement = dbConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM timeframe_information where order_date='" + Date.valueOf(LocalDate.now()) + "'");

			while (resultSet.next()) {
				timeFrameResultsList.add(new TimeFrame_Model(resultSet.getInt(2), resultSet.getInt(1),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
						resultSet.getString(7), resultSet.getDate(8)));
			}
			
			statement.close();
			resultSet.close();

			Statement statement2 = dbConnection.getConnection().createStatement();
			ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM store_information");

			while (resultSet2.next()) {
				storeResultsList
						.add(new Store_Model(resultSet2.getInt(1), resultSet2.getString(2), null));
			}
			statement2.close();
			resultSet2.close();
			
			for(int i = 0; i < storeResultsList.size(); i++) {
				Statement statement3 = dbConnection.getConnection().createStatement();
				ResultSet resultSet3 = statement3.executeQuery("SELECT * FROM store_contact_information WHERE store_id = '" + storeResultsList.get(i).getStoreID() + "'");
				ArrayList<String> emailList = new ArrayList<>();
				while (resultSet3.next()) {
					emailList.add(resultSet3.getString(2));
				}
				storeResultsList.get(i).setEmailList(emailList);
				statement3.close();
				resultSet3.close();
			}
			
			dbConnection.closeConnection();
			
			for(int i = 0; i < storeResultsList.size(); i++) {
				emailList(timeFrameResultsList, storeResultsList.get(i));
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
	
	private void emailList(ArrayList<TimeFrame_Model> time_frame_list, Store_Model store_model) {

		// Add recipient
		for (int i = 0; i < store_model.getEmailList().size(); i++) {
			String to = store_model.getEmailList().get(i);
			String from = "kandptruxtimeframes@gmail.com";
			// Add sender
			final String username = "kandptruxtimeframes@gmail.com";// your Gmail username
			final String password = "Barbieri1995";// your Gmail password

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
				for (int j = 0; j < time_frame_list.size(); j++) {
					if(time_frame_list.get(j).getStoreID() == store_model.getStoreID()) {
						String s = "Customer Name:\t" + time_frame_list.get(j).getCustomerName() + "\nTown:\t"
								+ time_frame_list.get(j).getTown() + "\nOrder Number:\t"
								+ time_frame_list.get(j).getOrderNumber() + "\nDriver:\t"
								+ time_frame_list.get(j).getDriver() + "\nTimeFrame:\t"
								+ time_frame_list.get(j).getTimeFrame() + "\nOrder Date:\t"
								+ time_frame_list.get(j).getOrderDate() + "\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
						messageString += s;
					}
					
				}
				// Put the content of your message
				message.setText(messageString);

				// Send message
				Transport.send(message);

			} catch (MessagingException e) {
				throw new RuntimeException(e);

			}

		}

	}
	
	private void sendFinalEmail() {
		String to = "kandptrux@optonline.net";

		// Add sender
		String from = "kandptruxtimeframes@gmail.com";
		final String username = "kandptruxtimeframes@gmail.com";// your Gmail username
		final String password = "Barbieri1995";// your Gmail password

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
	
	
	
}
