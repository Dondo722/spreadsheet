package org.example.View;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class MainMenu extends MenuBar {
    private final Menu fileMenu = new Menu("File");
    private final MenuItem openItem = new MenuItem("Open");
    private final MenuItem saveItem = new MenuItem("Save");
    private final MenuItem addItem = new MenuItem("Add");
    private final MenuItem findItem = new MenuItem("Find");
    private final MenuItem deleteItem = new MenuItem("Delete");

    public MainMenu(){
        super();
        fileMenu.getItems().addAll(openItem,saveItem,new SeparatorMenuItem(),addItem,findItem,deleteItem);
        super.getMenus().add(fileMenu);
    }

    public Menu getFileMenu() {
        return fileMenu;
    }

    public MenuItem getOpenItem() {
        return openItem;
    }

    public MenuItem getSaveItem() {
        return saveItem;
    }

    public MenuItem getAddItem() {
        return addItem;
    }

    public MenuItem getFindItem() {
        return findItem;
    }

    public MenuItem getDeleteItem() {
        return deleteItem;
    }
}
