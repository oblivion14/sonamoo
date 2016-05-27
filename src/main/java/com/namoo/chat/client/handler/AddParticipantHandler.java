package com.namoo.chat.client.handler;

import com.namoo.chat.client.room.ClientChatRoom;
import com.namoo.chat.core.handler.MessageHandler;
import com.namoo.chat.core.message.Message;

public class AddParticipantHandler implements MessageHandler {

    private ClientChatRoom chatRoom;
    
    public AddParticipantHandler(ClientChatRoom chatRoom) {
        //
        this.chatRoom = chatRoom;
    }

    @Override
    public void handle(Message request) {
        //
        this.chatRoom.addParticipant(request.getContents(), true);
    }

}
