package edu.java.network.chat.server;


import edu.java.network.chat.worker.Receiver;
import edu.java.network.chat.worker.Sender;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	//
	public void launch() throws IOException {
		//
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket socket = serverSocket.accept();
		System.out.println("Connection accepted.");
		
		//worker thread ����
		new Sender("KIM", socket).start();
		new Receiver(socket).start();
	}
	
	public static void main(String[] args) throws IOException {
		//
		new ChatServer().launch();
	}
}
