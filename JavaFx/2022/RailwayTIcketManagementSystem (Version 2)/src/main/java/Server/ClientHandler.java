package Server;

import Reservation.Reservation;

import java.io.*;
import java.net.Socket;
import java.util.Objects;


class ClientHandler extends Thread {

    public final Socket socket;
    public final ObjectOutputStream writer;
    public final ObjectInputStream reader;


    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        this.writer = new ObjectOutputStream(socket.getOutputStream());
    }

    public void run() {
        try {
            Objects received;    // from clients
            received = (Objects) reader.readObject();
            System.out.println(received);


//            System.out.println("WITHIN CLIENT HANDLER");
//
//            received = reader.readUTF();
//            System.out.println(received);
//
//            // * searchForTicket()/Check-availability()
//            Reservation reservation = new Reservation();
//            String status = reservation.checkBookingRecords(received);
//
//            if(status.equalsIgnoreCase("OK")){
//                //fillTicketInfoWindow(reservation);
//            } else {
//                writer.writeUTF(status);
//            }

            /*
            * searchForTicket()/Check-availability()
            -- if yes then go for Purchase()
            -- then show total cost and availableSeats and another option to get in the main ticket booking window
            * if no then give an option to get back in ticket booking window
            and do the same
             */


        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                this.reader.close();
                this.writer.close();
                this.socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}

