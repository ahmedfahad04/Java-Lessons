module railwayticketmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens Main to javafx.fxml;
    exports Main;
    exports Login;
    exports Registration;
    exports Reservation;
    opens Login to javafx.fxml;
    opens Registration to javafx.fxml;
    opens Reservation to javafx.fxml;

}