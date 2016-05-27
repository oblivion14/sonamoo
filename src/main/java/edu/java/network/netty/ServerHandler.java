package edu.java.network.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by melvin on 2016. 4. 29..
 * NOTE : Handler는 서버로 들어오는  메시지를 처리하는 것으로 ChannelInboundHandlerAdapter 를 상속
 * NOTE : 클라이언트가 메시지를 전송하면 서버의 channelRead() 메소드가 호출되어 메시지를 처리
 * NOTE : 전달된 메시지 객체(msg)는 사용 후 반드시 release
 * NOTE : 메시지 전송 시 예외가 발생하면 exceptionCaught() 메소드가 호출됨
 */
public class ServerHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception{
        try{
            //메시지를 처리한다

            ByteBuf in = (ByteBuf) msg;
            while (in.isReadable()){
                System.out.println((char) in.readByte());
                System.out.flush();
            }
        }   finally {
            /**
             * 전달된 메시지 객체 msg는 사용후 반드시 release
             */
            ReferenceCountUtil.release(msg);
        }
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception{
        //예외가 발생하면 Connection을 종료
        cause.printStackTrace();
        ctx.close();

    }



}
