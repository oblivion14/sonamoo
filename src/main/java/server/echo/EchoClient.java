package server.echo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by melvin on 2016. 4. 27..
 */
public class EchoClient {

    public static void main(String[] args) throws IOException {
        new EchoClient().launch();
    }

    public void launch() throws IOException {

        Socket socket = new Socket("127.0.0.1", 1733);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        BufferedReader messageReader = new BufferedReader(new StringReader("메롱"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));

        String line = null;

        while((line = messageReader.readLine()) != null){
            writer.print(line);
            writer.flush();

            String serverMessage = reader.readLine();
            System.out.println("from server : " + serverMessage);
        }

        writer.close();
        reader.close();
        socket.close();
    }

}
