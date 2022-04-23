package Reservation;


import Main.newTicketBookingController;
import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reservation {

    private String userName;
    private String userPhone;
    private String userMail;
    private String Destination;
    private String startingPoint;
    private String Date;
    private int numberOfSeats;
    private double cost;
    String[] info = null;

    public Reservation(){

    }

    public void reserveNewSeats(){  // only for admins

    }

    public String checkBookingRecords(String data) throws IOException {

        info = data.split(",");

        // search for reservation availability
        FileReader fr;
        BufferedReader br;

        fr = new FileReader("reservation.csv");

        br = new BufferedReader(fr);
        String line;
        int flag = 0;

        while ((line = br.readLine()) != null) { // read a line

            String[] scheduleInfo = line.split(",");
            if (info[2].equalsIgnoreCase(scheduleInfo[0]) && info[3].equalsIgnoreCase(scheduleInfo[1]) && info[4].equalsIgnoreCase(scheduleInfo[2])) {
                // ticket available
                return "OK";
            }
        }

//        if(flag == 1) {
//            System.out.println("YES! Ticket Available");
//        } else {
//            System.out.println("NO TICKET AVAILABLE...SORRY!");
//            LoadErrorMessage();
//        }
        return "ERROR";

    }

    public void LoadErrorMessage() throws IOException {
    }

}
