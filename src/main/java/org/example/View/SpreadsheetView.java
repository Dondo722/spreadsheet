package org.example.View;


import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.Model.Teacher;


public class SpreadsheetView extends BorderPane {
    private int sceneWidth = 1400;
    private int sceneHeight = 900;
    private final Stage stage = new Stage();
    private final MainMenu mainMenu = new MainMenu();
    private final LeftMenu leftMenu = new LeftMenu();
    private final Pages pages = new Pages();
    private Table<Teacher> table = new Table<>(sceneWidth, Teacher.getNames().length,Teacher.getNames(),Teacher.getNamesVal());


    public SpreadsheetView(){
        var scene = new Scene(this, sceneWidth, sceneHeight);
        this.setTop(mainMenu);
        this.setLeft(leftMenu);
        this.setCenter(table);
        sceneWidth -= leftMenu.getMenuWidth();
        this.setBottom(pages);
        pages.requestFocus();
        stage.setScene(scene);
        stage.show();
    }


    public <T>  void addTable(Table<T> table){

        this.setCenter(table);
    }

    public Pages getPages() {
        return pages;
    }

    public Stage getStage() {
        return stage;
    }

    public int getSceneWidth() {
        return sceneWidth;
    }

    public int getSceneHeight() {
        return sceneHeight;
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public Table<Teacher> getTable() {
        return table;
    }

    public void setTable(Table<Teacher> table) {
        this.table = table;
    }

    public void setSceneWidth(int sceneWidth) {
        this.sceneWidth = sceneWidth;
    }

    public void setSceneHeight(int sceneHeight) {
        this.sceneHeight = sceneHeight;
    }
}
