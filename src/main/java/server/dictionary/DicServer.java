package server.dictionary;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by melvin on 2016. 4. 26..
 */
public class DicServer {
    public static void main(String[] args) throws IOException {
        new DicServer().launch();
    }

    public void launch() throws IOException {
        /**
         * 서버 소켓 개설
         */
        ServerSocket serverSocket = new ServerSocket(1732);
        System.out.println("***** 서버가 구동되었습니다 *****");

        /**
         * 클라이언트 연결대기
         */
        Socket socket = serverSocket.accept();
        System.out.println("***** 클라이언트가 연결되었습니다 ******");

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        while(true){
            try{
                /**
                 * 클라이언트 요청 수신
                 */
                String requestMessage = inputStream.readUTF();

                /**
                 * 클라이언트 요청 처리 및 결과 전송
                 */
                handleRequest(requestMessage, outputStream);
            } catch (IOException e){
                System.out.println(("]]]]]]]]]] Client Maybe Disconnected."));
            }

            /**
             * 클라이언트 소켓과 입출력 스트림 종료
             */

        try{
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException ex2){

        }
        break;

        }
        /**
         * 서버 소켓 종료
         */

        serverSocket.close();
    }

    /**
     * 요청 처리 및 결과 전송
     * @param requestMessage
     * @param out
     */
    private void handleRequest(String requestMessage, DataOutputStream out) throws IOException {

        String responseMessage = null;

        if("apple".equals(requestMessage)){
            responseMessage = "사과";
        } else if("banana".equals(requestMessage)){
            responseMessage = "바나나";
        } else {
            responseMessage = "요청하신 단어는 사전에 없는 단어입니다.";
        }

        System.out.println("[Server] 요청 메시지 : " + requestMessage);
        System.out.println("[Server] 응답 메시지 : " + responseMessage);

        out.writeUTF(responseMessage);
        out.flush();
    }
}
