package Server;

import java.io.*;
import java.net.Socket;

class ClientHandler extends Thread {

    public final Socket socket;
    public final PrintWriter writer;
    public final BufferedReader reader;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream(), true);
    }

    public void run() {

        String received = "";


        while (!received.equals("Stop")) {

            try {
                received = reader.readLine();
                System.out.println("Client: " + received);

                String sent = "Server: " + received + " --> OK!";
                writer.println(sent);

            } catch (IOException e) {
                //e.printStackTrace();
                return;
            }

        }


        try {
            this.reader.close();
            this.writer.close();
            this.socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

