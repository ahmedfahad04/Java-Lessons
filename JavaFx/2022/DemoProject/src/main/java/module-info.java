module com.example.demoproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demoproject to javafx.fxml;
    exports com.example.demoproject;
}