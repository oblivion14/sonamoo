package edu.java.network.basic;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class BasicClient {
	//
	public void launch() throws UnknownHostException, IOException {
		//
		InetAddress address = InetAddress.getByName("localhost");
		Socket socket = new Socket(address, 9999);
		
		String requestMessage = "Hello Java Network Programming";
		DataOutputStream os = 
				new DataOutputStream(socket.getOutputStream());
		os.writeUTF(requestMessage);
		
		os.close();
		socket.close();
	}
	
	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		//
		new BasicClient().launch();
	}
}




