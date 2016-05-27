package edu.java.network.chat.worker;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receiver extends Thread {
	//
	private Socket socket;
	private DataInputStream in;
	
	public Receiver(Socket socket) {
		//
		this.socket = socket;
	}
	
	@Override
	public void run() {
		//
		try {
			in = new DataInputStream(socket.getInputStream());
			
			while(true) {
				String message = in.readUTF();
				System.out.println(message);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				socket.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}










