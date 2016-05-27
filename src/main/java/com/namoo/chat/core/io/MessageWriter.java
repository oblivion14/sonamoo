package com.namoo.chat.core.io;

import java.io.IOException;
import java.io.OutputStream;

import com.namoo.chat.core.message.Message;

public class MessageWriter {

    private OutputStream outputStream;
    
    public MessageWriter(OutputStream outputStream) {
        //
        this.outputStream = outputStream;
    }
    
    public void writeMessage(Message message) throws IOException {
        //
        byte[] fullBytes = message.toBytes();
        
        outputStream.write(fullBytes);
        outputStream.flush();
    }
}
