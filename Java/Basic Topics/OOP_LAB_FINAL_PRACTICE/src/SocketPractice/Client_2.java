package SocketPractice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Client_2 {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 5012);
        System.out.println("Client Connected!!");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        Scanner sc = new Scanner(System.in);
        String message = "";

        while(!Objects.equals(message, "DONE")){

            message = sc.nextLine();
            oos.writeObject(message);

            try {
                String fromServer = (String) ois.readObject();
                System.out.println("Server: " + fromServer);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        oos.close();
        ois.close();
        socket.close();

    }
}
