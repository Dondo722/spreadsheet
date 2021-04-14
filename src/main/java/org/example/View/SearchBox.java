package org.example.View;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class SearchBox  {
    BorderPane borderPane = new BorderPane();
    HBox botHBox = new HBox();
    private final MenuBar menuBar = new MenuBar();
    private final Menu menu = new Menu("Find by");
    private final MenuItem itemName = new MenuItem("Name");
    private final MenuItem itemRank = new MenuItem("Rank");
    private final MenuItem itemExperience = new MenuItem("Experience");

    public void display(){
        Stage window = new Stage();
        Scene scene = new Scene(borderPane, 650,425);

        menu.getItems().addAll(itemName,itemRank,itemExperience);
        menuBar.getMenus().addAll(menu);
        botHBox.getChildren().addAll(menuBar);
        botHBox.setSpacing(12);
        botHBox.setPadding(new Insets(5));
        borderPane.setBottom(botHBox);
        window.setScene(scene);

        window.showAndWait();
    }

    public MenuItem getItemName() {
        return itemName;
    }

    public MenuItem getItemRank() {
        return itemRank;
    }

    public MenuItem getItemExperience() {
        return itemExperience;
    }

    public void setTop(Node node){
        borderPane.setTop(node);
    }
    public void addBot(Node node){
        botHBox.getChildren().clear();
        botHBox.getChildren().addAll(menuBar,node);
    }


}
