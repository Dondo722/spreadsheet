package org.example;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import org.example.Controller.AddBox;

public class MainMenu extends MenuBar {
    public MainMenu(Spreadsheet spreadsheet){
        super();
        Menu fileMenu = new Menu("File");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem addItem = new MenuItem("Add");
        addItem.setOnAction(e -> new AddBox().display());
        MenuItem findItem = new MenuItem("Find");
        findItem.setOnAction(e -> new Search(spreadsheet).display());
        MenuItem deleteItem = new MenuItem("Delete");
        fileMenu.getItems().addAll(openItem,saveItem,new SeparatorMenuItem(),addItem,findItem,deleteItem);
        super.getMenus().add(fileMenu);
    }
}
