package edu.java.network.dictionary;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class KostaDicClient {
	//
	public void launch() {
		//
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			socket = new Socket("127.0.0.1", 9999);
			
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			while(true) {
				System.out.print("Input word : ");
				String requestMessage = scanner.nextLine();
				
				if("quit".equals(requestMessage)) {
					System.out.println("[Client] 종료합니다.");
					break;
				}
				
				out.writeUTF(requestMessage);
				
				String responseMessage = in.readUTF();
				System.out.println("[Client] " + responseMessage);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(scanner != null) { scanner.close(); }
				if(out != null) { out.close(); }
				if(in != null) { in.close(); }
				if(socket != null) { socket.close(); }
			} catch(IOException e) {
				System.out.println("오류입니다.");
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		//
		new KostaDicClient().launch();
	}
}





