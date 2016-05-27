package server.multiecho;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by melvin on 2016. 4. 27..
 */
public class MultiEchoServer {

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1734);

        try {
            System.out.println("***** Waiting for Connection of Client *****");
            while(true){
                // 클라이언트 접속 대기
                Socket socket = serverSocket.accept();

                //클라이언트 연결 후 메시지 처리
                System.out.println("***** Connected --> " + socket.getRemoteSocketAddress());
                // TODO: echoToClient(socket);
            }
        } finally {
            serverSocket.close();
        }
    }
}
