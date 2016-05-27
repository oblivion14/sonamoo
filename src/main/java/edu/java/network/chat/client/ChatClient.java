package edu.java.network.chat.client;

import edu.java.network.chat.worker.Receiver;
import edu.java.network.chat.worker.Sender;

import java.io.IOException;
import java.net.Socket;


public class ChatClient {
	//
	public void launch() {
		//
		try {
			Socket socket = new Socket("127.0.0.1", 9999);
			new Sender("LEE", socket).start();
			new Receiver(socket).start();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//
		new ChatClient().launch();
	}
}







