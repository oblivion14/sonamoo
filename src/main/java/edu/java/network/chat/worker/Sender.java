package edu.java.network.chat.worker;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread {
	//
	private String name;
	private Socket socket;
	private DataOutputStream out;
	
	public Sender(String name, Socket socket) {
		//
		this.name = name;
		this.socket = socket;
	}
	
	@Override
	public void run() {
		//
		Scanner scanner = new Scanner(System.in);
		try {
			out = new DataOutputStream(socket.getOutputStream());
			
			while(true) {
				String message = scanner.nextLine();
				if("quit".equals(message)) {
					break;
				}
				out.writeUTF(name + " : " + message);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				scanner.close();
				out.close();
				socket.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}













