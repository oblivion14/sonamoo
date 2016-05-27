package com.namoo.chat.server.handler;

import com.namoo.chat.core.handler.MessageHandler;
import com.namoo.chat.core.message.Message;
import com.namoo.chat.server.room.ServerChatRoom;

public class ExitRoomHandler implements MessageHandler {

    private ServerChatRoom chatRoom;
    
    public ExitRoomHandler(ServerChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    @Override
    public void handle(Message request) {
        //
        this.chatRoom.exitRoom(request.getSender());
    }
}
