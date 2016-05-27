package server.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by melvin on 2016. 4. 26..
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        new EchoServer().launch();
    }

    public void launch() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1733);
        System.out.println("***** Waiting for Connection of Client *****");

        Socket socket = serverSocket.accept();
        System.out.println("***** Client is Connected *****");

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));

        String line = null;

        while((line = reader.readLine()) != null){
            System.out.println(line);
            writer.println(line);
            writer.flush();
        }

        writer.close();
        reader.close();
        socket.close();
        serverSocket.close();
        System.out.println("***** Server Close *****");
    }
}
