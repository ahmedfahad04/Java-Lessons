import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(5012);
        System.out.println("Server Started..");

        while (true) {

            System.out.println("Waiting for Client....");
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected!!");

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            String clientMsg = "";

            while (!clientMsg.equals("exit")) {
                try {
                    // form client
                    clientMsg = (String) in.readObject();
                    System.out.println("From Client: " + clientMsg);
                } catch (IOException i) {
                    System.out.println(i);
                }

                // write to client
                clientMsg = clientMsg.toUpperCase();
                out.writeObject("Reply from Server: " + clientMsg);
            }

        }

    }
}
