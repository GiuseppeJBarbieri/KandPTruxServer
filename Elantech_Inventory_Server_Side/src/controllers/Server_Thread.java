package controllers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import event_objects.Logout_All_Users_Event_Object;
import main_view.Server_View_Controller;

public class Server_Thread implements Runnable {

	private Server_View_Controller viewController;

	private ArrayList<UserThread> userThreads;

	private boolean runServer = true;
	private Socket socket;
	private Server_Data_Controller serverDataController;

	public Server_Thread(Server_View_Controller viewController) {
		this.viewController = viewController;
		userThreads = new ArrayList<>();
	}
/* 
 * (non-Javadoc)
 * @see java.lang.Runnable#run()
 * 
 * 
 * Important to run "XX:+UseG1GC -XX:+UseStringDeduplication" For JVM Options in Run -> Run Configuration -> Arguments -> JVM
 */ 
	@Override
	public void run() {
		try {
			serverDataController = new Server_Data_Controller();
			ServerSocket serverSocket = new ServerSocket(8000);
			viewController.appendToTextField("Server Started");
			while (runServer) {
				socket = serverSocket.accept();
				//viewController.appendToTextField("New User Connected ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\nSocket Info~~~~ \nIP Addy: " + socket.getInetAddress() + "\nLocal Addy: "
					//	+ socket.getLocalAddress());

				if (userThreads.size() > 0) {
					for (int i = 0; i < userThreads.size(); i++) {
						//viewController.appendToTextField("UserThread Active?: " + userThreads.get(i).isActive() + "\nSocket Connected?: " + userThreads.get(i).getSocket().isConnected());
					}
				}

				UserThread newUser = new UserThread(socket, serverDataController, this);
				newUser.start();
				userThreads.add(newUser);
				updateServerViewList();
				//viewController.appendToTextField("Number Of Active Threads: " + Thread.activeCount());
				//viewController.appendToTextField("Users in list: " + userThreads.size());
				//viewController.appendToTextField("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * User opens client Send Login Request Method If login = allowed save user
	 * account information update user thread update server view
	 */

	public void broadcast(Object obj) {
		// for (int i = 0; i < userThreads.size(); i++) {
		// userThreads.get(i).sendMessage(obj);
		// }
	}

	public void broadCastLogout() {
		for (int i = 0; i < userThreads.size(); i++) {
			userThreads.get(i).sendMessage(new Logout_All_Users_Event_Object(this));
		}
	}

	/**
	 * When a client is disconnected, removes the associated username and UserThread
	 */
	public void removeUser(UserThread aUser) {
		for (int i = 0; i < userThreads.size(); i++) {
			if (userThreads.get(i) == aUser) {
				userThreads.get(i).stopThread();
				userThreads.remove(i);
			}
		}
		
		viewController.updateUserAccountList(userThreads);
		// TODO
		/* Remove User from front end */
	}

	public void updateServerViewList() {
		viewController.updateUserAccountList(userThreads);
	}

	public void appendToTextArea(String s) {
		viewController.appendToTextField(s);
	}

}
