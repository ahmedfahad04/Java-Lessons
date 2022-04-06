import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket socket = new Socket("127.0.0.1", 5012);
        System.out.println("Client Started...");

        // this serial of declaring input and output stream is very, very important
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        String msg = "";
        while(!msg.equals("exit")) {

            // send to Server
            Scanner sc = new Scanner(System.in);
            msg = sc.nextLine();
            out.writeObject(msg);

            // read from Server
            Object ob = in.readObject();
            System.out.println((String) ob);
        }

    }
}
