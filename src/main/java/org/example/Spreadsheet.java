package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.Controller.SpreadsheetController;
import org.example.Model.SpreadsheetModel;
import org.example.View.SpreadsheetView;


/**
 * JavaFX App
 */


public class Spreadsheet extends Application {

    @Override
    public void start(Stage stage) {
        SpreadsheetView view = new SpreadsheetView();
        SpreadsheetModel model = new SpreadsheetModel();
        SpreadsheetController controller = new SpreadsheetController(view, model);
    }
    public static void main(String[] args) {
        launch();
    }

}