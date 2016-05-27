package com.namoo.chat.client.handler;

import com.namoo.chat.client.room.ClientChatRoom;
import com.namoo.chat.core.handler.MessageHandler;
import com.namoo.chat.core.message.Message;

public class ParticipantListHandler implements MessageHandler {

    private ClientChatRoom chatRoom;

    public ParticipantListHandler(ClientChatRoom chatRoom) {
        //
        this.chatRoom = chatRoom;
    }

    @Override
    public void handle(Message message) {
        // 
        String participantList = message.getContents();
        if (participantList != null) {
            String[] participantNames = participantList.split(",");
            
            for (String participantName : participantNames) {
                chatRoom.addParticipant(participantName, false);
            }
        }
    }

}
