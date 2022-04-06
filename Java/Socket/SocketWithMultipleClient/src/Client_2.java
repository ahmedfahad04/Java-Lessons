import javax.crypto.Cipher;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_2 {

    public Client_2(int port) throws IOException, ClassNotFoundException {

        Socket socket = new Socket("127.0.0.1", port);
        System.out.println("Client 2 connected!!");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        String sent = "";
        while(!sent.equals("Stop")) {

            Scanner sc = new Scanner(System.in);
            sent = sc.nextLine();
            oos.writeObject(sent);

            String reply = (String) ois.readObject();
            System.out.println(reply);

        }

        oos.close();
        ois.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client_2 c1 = new Client_2(5555);
    }



}
