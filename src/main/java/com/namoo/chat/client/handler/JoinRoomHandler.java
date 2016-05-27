package com.namoo.chat.client.handler;

import com.namoo.chat.client.room.ClientChatRoom;
import com.namoo.chat.core.handler.MessageHandler;
import com.namoo.chat.core.message.Message;
import com.namoo.chat.core.message.MessageType;

public class JoinRoomHandler implements MessageHandler {

    private ClientChatRoom chatRoom;
    
    public JoinRoomHandler(ClientChatRoom chatRoom) {
        //
        this.chatRoom = chatRoom;
    }

    @Override
    public void handle(Message message) {
        //
        this.chatRoom.sendMessage(MessageType.ParticipantList);
    }
}
