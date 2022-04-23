package Reservation;


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
    private String ticketDetails;
    private int numberOfSeats;
    private double cost;

    public Reservation() {

    }

    public void reserveNewSeats() {  // only for admins

    }

    public String checkBookingRecords(String data) throws IOException {

        String[] info = data.split(",");

        // search for reservation availability
        FileReader fr;
        BufferedReader br;

        fr = new FileReader("reservation.csv");

        br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) { // read a line

            String[] scheduleInfo = line.split(",");

            System.out.println("SEATS: " + Integer.parseInt(scheduleInfo[4]));

            if (info[2].equalsIgnoreCase(scheduleInfo[0]) && info[3].equalsIgnoreCase(scheduleInfo[1]) && info[4].equalsIgnoreCase(scheduleInfo[2]) && Integer.parseInt(scheduleInfo[4]) != 0) {
                // ticket available
                ticketDetails = line;
                return "OK";
            }
        }

        return "ERROR";

    }

    public String getInfo() {
        return ticketDetails;
    }
}
