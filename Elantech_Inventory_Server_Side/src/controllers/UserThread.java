package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class UserThread extends Thread {

	private Socket socket;
	private Server_Thread server;

	private boolean runThread = true;

	private ObjectInputStream input;
	private ObjectOutputStream output;

	private Object object;
	private Server_Data_Controller serverDataController;
	
	public UserThread(Socket socket, Server_Data_Controller serverDataController, Server_Thread server) {
		this.socket = socket;
		this.server = server;
		this.serverDataController = serverDataController;
	}

	public void run() {
		try {
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
			
			while (runThread) {
				object = input.readObject();
				if (object != null) {
					serverDataController.controlData(object, output, this, server, socket);
				}
			}
		} catch (IOException | ClassNotFoundException ex) {
			//ex.printStackTrace();
			server.removeUser(this);
			runThread = false;
			//server.appendToTextArea("User Logged Out!");
		}
	}
	/*
	 * ==========================================================
	 * 					 GETTERS / SETTERS
	 * ==========================================================
	 */

	public Socket getSocket() {
		return socket;
	}
	
	public boolean isActive() {
		return Thread.interrupted();
	}

	/*
	 * ==========================================================
	 * 			Sends a message to the client. 
	 * ==========================================================
	 */
	public void sendMessage(Object object) {
		try {
			if (output != null) {
				if (!socket.isClosed()) {
					output.writeObject(object);
					output.flush();
				} else {
					System.out.println("SOCKET NOT WORKING CONNECTION..." + socket.getInetAddress());
					runThread = false;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/* Use this to log out all clients */
	public void stopThread() {
		runThread = false;
		try {
			input.close();
			output.close();
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
}
