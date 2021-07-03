package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Database.DbOperations;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        HBox vb = new HBox(); // side by side
        vb.setMinSize(500,300);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);
        vb.setStyle("-fx-background-color: #73a3f0");

        VBox tf = new VBox(); // up and down
        tf.setAlignment(Pos.CENTER);

        VBox bt = new VBox(); // up and down
        bt.setAlignment(Pos.CENTER);

        VBox lb = new VBox();
        lb.setAlignment(Pos.CENTER);
        lb.setSpacing(8);

        TextField name = new TextField();
        Label setName = new Label("Name");
        //setName.setStyle("-fx-background-color: red");
        TextField roll = new TextField();
        Label setRoll = new Label("Roll");
        //setRoll.setStyle("-fx-background-color: blue");
        TextField address = new TextField();
        Label setAddress = new Label("Address");
        //setAddress.setStyle("-fx-background-color: green");

        Button btn = new Button("Insert");
        //btn.setLayoutY(10);

        tf.getChildren().addAll(name, roll, address, btn);
        lb.getChildren().addAll(setName, setRoll, setAddress);
        bt.getChildren().add(btn);
        vb.getChildren().addAll(lb,tf,bt);

        Scene sc = new Scene(vb);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               DbOperations db = new DbOperations();
               String Name = name.getText();
               String Roll = roll.getText();
               String Address = address.getText();
               db.insert(Name, Roll, Address);
               System.out.println("Inserted Successfully!!");
            }
        });


        primaryStage.setScene(sc);
        primaryStage.setTitle("DataFetch");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
