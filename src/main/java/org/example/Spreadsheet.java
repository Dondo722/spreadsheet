package org.example;

import org.example.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.Model.Teachers;
import org.example.View.SpreadsheetView;

import java.time.Period;


/**
 * JavaFX App
 */


public class Spreadsheet extends Application {
    private final int sceneWidth = 1400;
    private final SpreadsheetView model = new SpreadsheetView(sceneWidth);


    @Override
    public void start(Stage stage) {
        MainMenu mainMenu = new MainMenu(this);
        BorderPane root = new BorderPane();
        root.setTop(mainMenu);
        root.setCenter(model.getTable());
        testAddTeachers();



        var scene = new Scene(root, sceneWidth, 900);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

    public void testAddTeachers(){
        Teachers.addTeacher("Slitherin","dik","AAAAAAA","BACA", "MASTER", Period.ZERO);
        Teachers.addTeacher("X2","HUk","BBBBBBBBB","BACA", "MASTER", Period.ZERO);
        Teachers.addTeacher("Slitherin","dik","CCCCCCCCC","BACA", "MASTER", Period.ZERO);
        Teachers.addTeacher("Slitherin","dik","DDDDDDDDDDD","BACA", "MASTER", Period.ZERO);
        Teachers.addTeacher("Slitherin","dik","EEEEEEEEEE","BACA", "MASTER", Period.ZERO);
        Teachers.addTeacher("Slitherin","dik","KKKKKKKKKK","BACA", "MASTER", Period.ZERO);
        Teachers.addTeacher("Slitherin","dik","LLLLLLLL","BACA", "MASTER", Period.ZERO);
        Teachers.addTeacher("Slitherin","dik","MMMMMMMMM","BACA", "MASTER", Period.ZERO);
        Teachers.addTeacher("Slitherin","dik","NNNNNNNNNN","BACA", "MASTER", Period.ZERO);
        Teachers.addTeacher("Slitherin","dik","FFFFFFFF","BACA", "MASTER", Period.ZERO);
        Teachers.addTeacher("Slitherin","dik","IIIIIIIIII","BACA", "MASTER", Period.ZERO);
        Teachers.addTeacher("Slitherin","dik","JJJJJJJJJJJJJJ","BACA", "MASTER", Period.ZERO);
        Teachers.addTeacher("Slitherin","dik","GGGGGGGGGGGGG","BACA", "MASTER", Period.ZERO);
    }
}