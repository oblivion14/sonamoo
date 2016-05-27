package com.namoo.chat.server.handler;

import com.namoo.chat.core.handler.HandlerDelegator;
import com.namoo.chat.core.handler.MessageHandler;
import com.namoo.chat.core.message.Message;
import com.namoo.chat.core.message.MessageType;
import com.namoo.chat.server.room.ServerChatRoom;

public class ClientMessageDelegator implements HandlerDelegator {

    private ServerChatRoom chatRoom;
    
    public ClientMessageDelegator(ServerChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public void delegate(Message message) {
        //
        MessageType messageType = message.getMessageType();
        
        MessageHandler handler = null;
        
        switch (messageType) {
        
        case SimpleMessage:
            handler = new SimpleMessageHandler(chatRoom);
            break;
        case ExitRoom:
            handler = new ExitRoomHandler(chatRoom);
            break;
        case ParticipantList:
            handler = new ParticipantListHandler(chatRoom);
            break;
        case SecretMessage:
            handler = new SecretMessageHandler(chatRoom);
            break;            
        default:
            // Nothing to do.
            break;
        }
        
        if (handler != null) {
            System.out.printf("[%s] execute.\n", handler.getClass().getSimpleName());
            handler.handle(message);
        }
    }
}
