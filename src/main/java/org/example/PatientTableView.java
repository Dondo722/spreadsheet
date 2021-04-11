package org.example;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.time.LocalDate;

public class PatientTableView extends TableView<Patient> {
    PatientTableView(int sceneWidth){
        super();
        int tableWidth = sceneWidth/6;
        // Patient Name column
        TableColumn<Patient,String> nameColumn = new TableColumn<>("Name");
        nameColumn.setPrefWidth(tableWidth);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        nameColumn.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());
        this.getColumns().add(nameColumn);

        // Patient Address column
        TableColumn<Patient,String> addressColumn = new TableColumn<>("Address");
        addressColumn.setMinWidth(tableWidth);
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        this.getColumns().add(addressColumn);

        // Patient Born Date column
        TableColumn<Patient, LocalDate> bornDateColumn = new TableColumn<>("Born Date");
        bornDateColumn.setPrefWidth(tableWidth);
        bornDateColumn.setCellValueFactory(new PropertyValueFactory<>("bornDate"));
        this.getColumns().add(bornDateColumn);

        // Patient Reception Date column
        TableColumn<Patient,LocalDate> receptionDateColumn = new TableColumn<>("Reception Date");
        receptionDateColumn.setPrefWidth(tableWidth);
        receptionDateColumn.setCellValueFactory(new PropertyValueFactory<>("receptionDate"));
        this.getColumns().add(receptionDateColumn);

        // Doctor Name column
        TableColumn<Patient,String> doctorNameColumn = new TableColumn<>("Doctor");
        doctorNameColumn.setPrefWidth(tableWidth);
        doctorNameColumn.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        this.getColumns().add(doctorNameColumn);

        //  Conclusion column
        TableColumn<Patient,String> conclusionColumn = new TableColumn<>("Conclusion");
        conclusionColumn.setPrefWidth(tableWidth);
        conclusionColumn.setCellValueFactory(new PropertyValueFactory<>("conclusion"));
        this.getColumns().add(conclusionColumn);
    }
}
