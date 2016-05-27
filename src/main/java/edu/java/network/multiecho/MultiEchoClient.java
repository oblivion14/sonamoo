package edu.java.network.multiecho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiEchoClient extends Thread {
	//
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;
	private long id;
	
	@Override
	public void run() {
		//
		id = Thread.currentThread().getId();
		
		try {
			socket = new Socket("127.0.0.1", 9999);
			
			InputStreamReader streamReader = 
					new InputStreamReader(socket.getInputStream());
			reader = new BufferedReader(streamReader);
			
			writer = new PrintWriter(socket.getOutputStream());
			
			for(int i=0; i<20; i++) {
				String requestMessage = 
						"Client " + id + " says : hello java " + i;
				
				writer.println(requestMessage);
				writer.flush();
				
				String responseMessage = reader.readLine();
				System.out.println("[Client] form Server : " + responseMessage);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
				reader.close();
				socket.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		//
		for(int i=0; i<10; i++) {
			new MultiEchoClient().start();
		}
	}
}















