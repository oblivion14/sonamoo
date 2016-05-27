package edu.java.network.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by melvin on 2016. 4. 29..
 * NOTE : 클라이언트 Handler는 SimpleChannelInboundHandler를 상속하여 구현
 * NOTE : 이 Handler는 ChannelInboundHandlerAdapter와는 달리 특정 타입의 메시지를 다룰 수 있음 (ex : String)
 * NOTE : channelActive() 메소드는 Channel 컨넥션이 맺어지면 호출됨. 메시지 전송 가능
 * NOTE : ChannelRead0() 메소드는 서버에서 보낸 메시지를 수신
 *
 */
public class ClientHandler extends SimpleChannelInboundHandler<String>{
    //
    static final int SIZE = 256;

    private ByteBuf content;
    private ChannelHandlerContext ctx;

    private final ChannelFutureListener channelFutureListener = new ChannelFutureListener() {
        public void operationComplete(ChannelFuture future) throws Exception {
            if(future.isSuccess()){
                sendMessage();
            } else {
                future.cause().printStackTrace();
                future.channel().close();
            }
        }
    };

    private void sendMessage(){
        //
        ctx.writeAndFlush(content.duplicate().retain()).addListener(channelFutureListener);
        System.out.println("Send Message...");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception{
        this.ctx = ctx;

        // 메시지 초기화 (사이즈 만큼의 버퍼러를 0x00 으로 채운다)
        // content = ctx.alloc().directBuffer(SIZE).writeZero(SIZE)

        content = ctx.alloc().buffer(10).writeBytes("Hello~".getBytes());

        //메시지 전송
        sendMessage();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception{
        content.release();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //서버에서 아무것도 보내지 않으므로 생략
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception{
        cause.printStackTrace();
        ctx.close();
    }
}
