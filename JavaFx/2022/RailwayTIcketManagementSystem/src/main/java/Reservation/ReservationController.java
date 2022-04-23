package Reservation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import static Main.FXMLManager.LoadFXML;

public class ReservationController {

    @FXML
    private Button returnToBookingPage;

    @FXML
    static void onClickBookingPage(MouseEvent event) throws IOException {
        LoadFXML(event.getSource(), "/Main/ticketBooking.fxml"); // this will be changed
    }


}
