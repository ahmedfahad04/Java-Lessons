module NewTableView {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;
    requires javafx.graphics;
    requires javafx.base;

    opens sample;
    opens FXML;
}