package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server(int port) throws IOException, ClassNotFoundException {

        System.out.println("Waiting for Clients...");
        ServerSocket ss = new ServerSocket(port);

        while(true) {

            Socket socket = ss.accept();
            System.out.println("Client Connected..");

            // JUST Change the Reading and Writing Scheme with Threads to deal with multiple clients
            Thread t = new ClientHandler(socket);
            t.start();

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server s1 = new Server(5555);
    }
}