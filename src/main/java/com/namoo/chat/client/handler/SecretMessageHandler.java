package com.namoo.chat.client.handler;

import com.namoo.chat.client.room.ClientChatRoom;
import com.namoo.chat.core.handler.MessageHandler;
import com.namoo.chat.core.message.Message;

public class SecretMessageHandler implements MessageHandler {

    private ClientChatRoom chatRoom;
    
    public SecretMessageHandler(ClientChatRoom chatRoom) {
        //
        this.chatRoom = chatRoom;
    }

    @Override
    public void handle(Message message) {
        //
        String popupTitle = String.format("%s님이 보낸 메시지", message.getSender());
        String popupMessage = message.getContents();
        
        chatRoom.showMessagePopup(popupTitle, popupMessage);
    }
}
