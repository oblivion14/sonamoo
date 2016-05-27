package edu.java.network.dictionary;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class KostaDicServer {
	//
	private Map<String, String> wordRepo;
	
	public KostaDicServer() {
		//
		this.initWordRepo();
	}
	
	private void initWordRepo() {
		//
		wordRepo = new HashMap<String, String>();
		wordRepo.put("apple", "사과");
		wordRepo.put("banana", "바나나");
		wordRepo.put("orange", "오렌지");
		wordRepo.put("grape", "포도");
	}
	
	public void launch() {
		//
		ServerSocket serverSocket = null;
		Socket socket = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("[Server] Server started.");
			
			socket = serverSocket.accept();
			System.out.println("[Server] Connection accepted.");
			
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			while(true) {
				String requestMessage = in.readUTF();
				System.out.println("[Server] " + requestMessage);
				handleMessage(requestMessage, out);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			//release resources
		}
	}
	
	private void handleMessage(String requestMessage
								, DataOutputStream out) {
		//
		if(requestMessage.indexOf(":") != -1) {
			// 새로운 과일 등록
			addWord(requestMessage, out);
			return;
		}
		
		String responseMessage = wordRepo.get(requestMessage);
		
		if(responseMessage == null) {
			responseMessage = "해당 내용이 없습니다.";
		}
		
		try {
			out.writeUTF(responseMessage);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addWord(String requestMessage, DataOutputStream out) {
		//
		String[] newWord = requestMessage.split(":");
		wordRepo.put(newWord[0], newWord[1]);
		
		try {
			out.writeUTF("등록되었습니다.");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//
		new KostaDicServer().launch();
	}
}








