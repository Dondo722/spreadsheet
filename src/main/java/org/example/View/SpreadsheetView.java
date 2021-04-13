package org.example.View;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class SpreadsheetView extends BorderPane{
    private final int  sceneWidth = 1400;
    private final int sceneHeight = 900;
    private final MainMenu mainMenu = new MainMenu();

    public SpreadsheetView(){

        super();

        Stage stage = new Stage();
        this.setTop(mainMenu);
        var scene = new Scene(this, sceneWidth, sceneHeight);
        stage.setScene(scene);
        stage.show();
    }

    public<T> void addTable(int columnCount, String[] columnNames, String[] columnValNames, ObservableList<T> list){
        Table<T> table = new Table<>(sceneWidth, columnCount,columnNames,columnValNames);
        table.setItems(list);
        this.setCenter(table);
    }

    public int getSceneWidth() {
        return sceneWidth;
    }

    public int getSceneHeight() {
        return sceneHeight;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }
}
