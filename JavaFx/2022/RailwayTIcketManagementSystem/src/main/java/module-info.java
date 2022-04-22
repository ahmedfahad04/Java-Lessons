module railwayticketmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens Main to javafx.fxml;
    exports Main;
    exports Login;
    exports Registration;
    opens Login to javafx.fxml;
    opens Registration to javafx.fxml;

}