package edu.java.network.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by melvin on 2016. 4. 29..
 * NOTE : NioEventLoopGroup 은 이벤트를 처리하는 Event Loop 멀티 스레드 방식으로 동작
 * NOTE : EventLoopGroup은 master, servant 두 가지가 있는데, 연결요청 수신과 연결요청 처리로 구분
 * NOTE : Connection을 맺으면, NioServerSocketChannel 타입의 새로운 Channel이 생성
 * NOTE : Channel이 생성시 Handler(ServerHandler)를 등록하기 위해 ChannelInitializer를 사용
 */
public class NettyServer {
    //
    static final int PORT = 8009;

    public void run() throws Exception{
        /** EventLoop - 이벤트 처리
        NioEventLoopGroup -  EventLoop 를 멅티스레드방식으로 동작
         master, servant 형식으로 나눠서 연결요청 수신과 연결 요청 처리 */
        EventLoopGroup masterGroup = new NioEventLoopGroup();
        EventLoopGroup servantGroup = new NioEventLoopGroup();

        /** Server Bootstrap을 이용하여 서버쪽의 채널을 생성하고 들어오는 연결을 받아들이는 ServerSocketChannel를 생성
         * Connection을 맺으면, NioServerSocketChannel 타입의 새로운 Channel이 생성됨
         * Channel이 생성시 Handler(ServerHandler)를 등록하기 위해 ChannelInitializer를 사용*/
        try{
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(masterGroup, servantGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            /**
             * I/O Operation이 시작되었을 때 새로운 ChannelFuture 객체 시작.
             */
            ChannelFuture future = bootstrap.bind(PORT).sync();

            // server socket이 종료될 때 까지 대기함

            // shut down server
            future.channel().closeFuture().sync();
        } finally {
            servantGroup.shutdownGracefully();
            masterGroup.shutdownGracefully();;
        }
    }

    public static void main(String[] args) throws Exception {
        new NettyServer().run();
    }
}
