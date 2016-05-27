package edu.java.network.multiecho;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiEchoServer {
	//
	public void launch() throws IOException {
		//
		ServerSocket serverSocket = new ServerSocket(9999);
		
		while(true) {
			Socket socket = serverSocket.accept();
			System.out.println("������ �����߽��ϴ�.");
			new WorkerThread(socket).start();
		}
		
		//serverSocket.close();
	}
	
	public static void main(String[] args) throws IOException {
		//
		new MultiEchoServer().launch();
	}
}








