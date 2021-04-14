package org.example.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.Model.SpreadsheetModel;
import org.example.Model.Teacher;


public class SpreadsheetView extends BorderPane {
    private final int  sceneWidth = 1400;
    private final int sceneHeight = 900;
    private final MainMenu mainMenu = new MainMenu();
    private final Pages pages = new Pages();
    int rowsPerPage = 5;
    int pageIndex = 0;


    public SpreadsheetView(){
        Stage stage = new Stage();
        var scene = new Scene(this, sceneWidth, sceneHeight);
        this.setTop(mainMenu);
        this.setBottom(pages);
        pages.requestFocus();
        stage.setScene(scene);
        stage.show();
    }


    public <T>  void addTable(int columnCount, String[] columnNames, String[] columnValNames, ObservableList<T> list){
        Table<T> table = new Table<>(sceneWidth, columnCount,columnNames,columnValNames);
        table.setItems(list);
        this.setCenter(table);
    }

    public Pages getPages() {
        return pages;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public int getPageIndex() {
        return pageIndex;
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
