import javax.crypto.Cipher;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client(int port) throws IOException, ClassNotFoundException {

        Socket socket = new Socket("127.0.0.1", port);
        System.out.println("Client 1 connected!!");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        String sent = "";

//            Scanner sc = new Scanner(System.in);
//            sent = sc.nextLine();
            oos.writeObject("Hello, I'm Client 1");

            String reply = (String) ois.readObject();
            System.out.println(reply);



        oos.close();
        ois.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client c1 = new Client(5555);
    }



}
