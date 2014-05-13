package pennapps.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static ObjectInputStream objInput;

    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(14444);  //Server socket

        } catch (IOException e) {
            System.out.println("Could not listen on port: 14444");
        }

        System.out.println("Server started. Listening to the port 14444");

        while (true) {
            try {

                clientSocket = serverSocket.accept();   //accept the client connection
                objInput = new ObjectInputStream(clientSocket.getInputStream());
                Object event = objInput.readObject();
                System.out.println(event);

                objInput.close();
                clientSocket.close();

            } catch (IOException ex) {
                System.out.println("Problem in message reading");
            } catch (ClassNotFoundException cx) {
                cx.printStackTrace();
            }
        }
    }
}
