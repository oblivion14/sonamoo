package com.namoo.chat.client.handler;

import com.namoo.chat.client.room.ClientChatRoom;
import com.namoo.chat.core.handler.MessageHandler;
import com.namoo.chat.core.message.Message;

public class RemoveParticipantHandler implements MessageHandler {

    private ClientChatRoom chatRoom;
    
    public RemoveParticipantHandler(ClientChatRoom chatRoom) {
        //
        this.chatRoom = chatRoom;
    }

    @Override
    public void handle(Message message) {
        // 
        String participant = message.getContents();
        this.chatRoom.removeParticipant(participant);
    }

}
