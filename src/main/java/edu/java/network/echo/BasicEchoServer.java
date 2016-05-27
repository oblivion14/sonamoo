package edu.java.network.echo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicEchoServer {
	//
	public void launch() throws IOException {
		//
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("Server started.");
		Socket socket = serverSocket.accept(); //������ ��û�� �ö����� wait.
		
		System.out.println("Connection accepted.");
		DataInputStream is = new DataInputStream(socket.getInputStream());
		String requestMessage = is.readUTF();
		
		DataOutputStream os =
				new DataOutputStream(socket.getOutputStream());
		os.writeUTF(requestMessage);
		
		System.out.println("[Server] " + requestMessage);
		
		os.close();
		is.close();
		socket.close();
		serverSocket.close();
	}
	
	public static void main(String[] args) throws IOException {
		//
		new BasicEchoServer().launch();
	}
}









