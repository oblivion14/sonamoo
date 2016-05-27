package edu.java.network.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * Created by melvin on 2016. 4. 29..
 * NOTE : 클라이언트는 서버를 구성하는 코드와 비슷하지만 클라이언트이므로 EventGroup을 두 개로 나누지 않음
 * NOTE : 클라이언트는 NioSocketChannel 타입의 Channel을 사용 (서버는 NioServerSocketChannel)을 사용
 * NOTE : ChannelInitializer로 Handler(ClientHandler)를 등록
 */
public class NettyClient {
    static final String HOST = "127.0.0.1";
    static final int PORT = 8009;

    public static void main(String[] args) throws Exception{
        /** EventLoop - 이벤트 처리
         NioEventLoopGroup -  EventLoop 를 멅티스레드방식으로 동작
         */
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ClientHandler());
                        }
                    });
            /**
             * I/O Operation이 시작되었을 때 새로운 ChannelFuture 객체 시작.
             */
            ChannelFuture future = bootstrap.connect(HOST, PORT).sync();

            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
