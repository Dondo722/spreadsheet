package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Calendar;

public class Search {
    private final Spreadsheet spreadsheet;

    public Search(Spreadsheet spreadsheet){
        this.spreadsheet = spreadsheet;
    }
    public void display(){
        Stage window = new Stage();
        window.setTitle("Search");

        Label searchLabel = new Label("Input Name: ");
        TextField searchField = new TextField();
        searchField.promptTextProperty().set("write name");
        HBox hBox = new HBox(searchLabel,searchField);
        Button searchButton = new Button("Search");
        VBox vBox = new VBox();
        PatientTableView table = new PatientTableView(650);
        searchButton.setOnAction(e -> searchNow(searchField.getText(),table));

        vBox.getChildren().addAll(table,hBox,searchButton);
        Scene scene = new Scene(vBox,650,320);
        window.setScene(scene);
        window.showAndWait();
    }
    public void searchNow(String name, PatientTableView table){
//        ObservableList<Patient> patient = FXCollections.observableArrayList();
//        for (int i = 0; i < spreadsheet.getPatients().size(); i++){
//            if(spreadsheet.getPatients().get(i).getFullName().equals(name))
//                patient.add(spreadsheet.getPatients().get(i));
//        }
//        table.setItems(patient);
    }
}
