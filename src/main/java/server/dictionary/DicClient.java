package server.dictionary;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by melvin on 2016. 4. 26..
 */
public class DicClient {
    public static void main(String[] args) throws IOException {
        new DicClient().launch();
    }

    private void launch() throws IOException {
        /**
         * 서버 주소 객체 생성
         */
        InetAddress serverAddress = InetAddress.getByName("localhost");

        /**
         * 클라이언트 소켓 생성 (서버 연결)
         */
        Socket socket = new Socket(serverAddress, 1732);
        System.out.println("***** 서버에 연결되었습니다 *****");

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        Scanner scanner = new Scanner(System.in);

        while(true){
            /**
             * 요청 메시지 입력
             */
            String requestMessage = scanner.nextLine();

            if ("quit".equals(requestMessage)){
                break;
            }

            /**
             * 요청 메시지 전송
             */
            outputStream.writeUTF(requestMessage);
            outputStream.flush();

            /**
             * 응답 메시지 수신
             */

            String responseMessage = inputStream.readUTF();
            System.out.println("[Client] 요청메시지 : " + requestMessage);
            System.out.println("[Client] 응답메시지 : " + responseMessage);
        }

        /**
         * 클라이언트 소켓 종료
         */
        socket.close();
    }

}
