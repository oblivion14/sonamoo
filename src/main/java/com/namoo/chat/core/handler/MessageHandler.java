package com.namoo.chat.core.handler;

import com.namoo.chat.core.message.Message;

public interface MessageHandler {

    void handle(Message message);

}
