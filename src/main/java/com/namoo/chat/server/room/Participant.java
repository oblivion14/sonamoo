package com.namoo.chat.server.room;

import java.io.IOException;

import com.namoo.chat.core.io.MessageWriter;
import com.namoo.chat.core.message.Message;

public class Participant {
	
	private String name;
	private MessageWriter messageWriter;

	public Participant(String name, MessageWriter messageWriter) {
		this.name = name;
		this.messageWriter = messageWriter;
	}
	
	public String getName() {
		return this.name;
	}

	public void sendMessage(Message message) {
		//
		try {
			messageWriter.writeMessage(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
