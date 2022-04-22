import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class ClientHandler extends Thread{

    public final Socket s;
    public final ObjectOutputStream oos;
    public final ObjectInputStream ois;

    public ClientHandler(Socket s1, ObjectOutputStream oos, ObjectInputStream ois){
        this.s = s1;
        this.oos = oos;
        this.ois = ois;
    }

    public void run(){

        String received = "";

        while(!received.equals("Stop")) {

            try {

                received = (String) ois.readObject();
                System.out.println("Client: " + received);

                String sent = "Server: " + received + " --> OK!";
                oos.writeObject(sent);

            } catch (IOException | ClassNotFoundException e) {
                //e.printStackTrace();
                return;
            }

        }


        try {
            this.oos.close();
            this.ois.close();
            this.s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

public class Server {

    public Server(int port) throws IOException, ClassNotFoundException {

        System.out.println("Waiting for Clients...");
        ServerSocket ss = new ServerSocket(port);

        while(true) {

            Socket socket = ss.accept();
            System.out.println("Client Connected..");
            System.out.println(socket.getRemoteSocketAddress().toString());

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            // JUST Change the Reading and Writing Scheme with Threads to deal with multiple clients
            Thread t = new ClientHandler(socket, oos, ois);
            t.start();

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server s1 = new Server(5555);
    }
}
