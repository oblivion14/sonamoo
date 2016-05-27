package edu.java.network.multiecho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WorkerThread extends Thread {
	//
	private Socket socket;
	private long id;
	private BufferedReader reader;
	private PrintWriter writer;
	
	public WorkerThread(Socket socket) {
		//
		this.socket = socket;
	}
	
	@Override
	public void run() {
		//
		System.out.println("Connected : " + socket.getRemoteSocketAddress());
		
		try {
			InputStreamReader streamReader = 
					new InputStreamReader(socket.getInputStream());
			reader = new BufferedReader(streamReader);
			
			writer = new PrintWriter(socket.getOutputStream());
			
			while(true) {
				String requestMessage = reader.readLine();
				if(requestMessage == null) {
					break;
				}
				System.out.println("[Server] " + requestMessage);
				writer.println(requestMessage);
				writer.flush();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			//release resources.
		}
		
	}
}






