package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server(int port) throws IOException {

        System.out.println("Waiting for Clients...");
        ServerSocket ss = new ServerSocket(port);

        while(true) {

            Socket socket = ss.accept();
            System.out.println("Client Connected..");
            System.out.println(socket.getRemoteSocketAddress().toString());

            try{
                // JUST Change the Reading and Writing Scheme with Threads to deal with multiple clients
                Thread clients = new ClientHandler(socket);
                clients.start();

            } catch (Exception e){
                return;
            }

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server s1 = new Server(5555);
    }
}