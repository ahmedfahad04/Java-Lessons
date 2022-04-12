package SocketPractice;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class ClientHandler extends Thread{

    ObjectInputStream ois;
    ObjectOutputStream oos;
    Socket sc;

    public ClientHandler(Socket sc){
        this.sc = sc;
    }

    public void run(){

        String fromClient = "",  toClient = "";
        try {
            ois = new ObjectInputStream(sc.getInputStream());
            oos = new ObjectOutputStream(sc.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

        while(!fromClient.equals("DONE")) {

            try {

                fromClient = (String) ois.readObject();
                System.out.println("Client: " + fromClient);

                toClient = fromClient + " ==> OK.";
                oos.writeObject(toClient);

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}


public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(5012);
        System.out.println("Server Waiting...");



        while (true) {

            Socket sc = socket.accept();
            //System.out.println( socket.getInetAddress() + " Connected...");

            Thread t = new ClientHandler(sc);
            t.start();

        }


    }


}
