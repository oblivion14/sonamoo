package com.namoo.chat.client.gui;

import com.namoo.chat.client.room.ClientChatRoom;

public interface ChatClientView {

    void bindEventAndShow(ClientChatRoom chatRoom);
    void refreshParticipants(String[] participants);
    void addParticipant(String name);
    void removeParticipant(String name);
    void appendMessage(String contents);
    void showMessagePopup(String title, String message);
}
