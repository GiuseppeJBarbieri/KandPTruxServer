package controllers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
				UserThread newUser = new UserThread(socket, serverDataController, this);
				newUser.start();
				userThreads.add(newUser);

			}
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
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
	}

	public void appendToTextArea(String s) {
		viewController.appendToTextField(s);
	}

}
