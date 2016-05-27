package edu.java.network.echo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class BasicEchoClient {
	//
	public void launch() throws UnknownHostException, IOException {
		//
		InetAddress address = InetAddress.getByName("localhost");
		Socket socket = new Socket(address, 9999);
		
		String requestMessage = "Hello Java Network Programming";
		DataOutputStream os = 
				new DataOutputStream(socket.getOutputStream());
		os.writeUTF(requestMessage);
		
		DataInputStream is = 
				new DataInputStream(socket.getInputStream());
		String responseMessage = is.readUTF();
		System.out.println("[Client] from Server : " + responseMessage);
		
		is.close();
		os.close();
		socket.close();
	}
	
	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		//
		new BasicEchoClient().launch();
	}
}




