package org.example.View.Alerts;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static void display(String waring){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Alert!");

        VBox vBox = new VBox();
        Label warning = new Label(waring);
        Button okButton = new Button("OK");
        okButton.setOnAction(e -> window.close());
        vBox.getChildren().addAll(warning,okButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        Scene scene = new Scene(vBox,250,150);
        window.setScene(scene);
        window.showAndWait();
    }
}
