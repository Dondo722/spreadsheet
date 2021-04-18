package org.example.View;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.example.View.SearchBoxes.NameSearchBox;
import org.example.View.SearchBoxes.RankSearchBox;
import org.example.View.SearchBoxes.WorkExpSearchBox;


public class SearchBox  {
    private final int  sceneWidth = 650;
    private final int sceneHeight = 425;
    private final BorderPane borderPane = new BorderPane();
    private final HBox botHBox = new HBox();
    private final HBox botStatic = new HBox();
    private final Button buttonFind = new Button("Find");
    private final MenuBar menuBar = new MenuBar();
    private final Menu menu = new Menu("Find by");
    private final MenuItem itemName = new MenuItem("Name");
    private final MenuItem itemRank = new MenuItem("Rank");
    private final MenuItem itemExperience = new MenuItem("Experience");
    private  NameSearchBox nameSearchBox = new NameSearchBox();
    private  RankSearchBox rankSearchBox = new RankSearchBox();
    private  WorkExpSearchBox workExpSearchBox = new WorkExpSearchBox();

    public void display(){
        Stage window = new Stage();
        Scene scene = new Scene(borderPane, sceneWidth,sceneHeight);

        menu.getItems().addAll(itemName,itemRank,itemExperience);
        menuBar.getMenus().addAll(menu);
        botHBox.setSpacing(12);
        botHBox.setPadding(new Insets(10));

        botStatic.getChildren().addAll(buttonFind,menuBar);
        botStatic.setSpacing(1);
        botHBox.getChildren().addAll(botStatic);

        borderPane.setBottom(botHBox);

        window.setScene(scene);
        window.showAndWait();
    }

    public int getSceneWidth() {
        return sceneWidth;
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

    public Button getButtonFind(){
        return buttonFind;
    }

    public NameSearchBox getNameSearchBox() {
        return nameSearchBox;
    }

    public RankSearchBox getRankSearchBox() {
        return rankSearchBox;
    }

    public WorkExpSearchBox getWorkExpSearchBox() {
        return workExpSearchBox;
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void addBotStatic(Node node){
        botStatic.getChildren().add(node);
    }
    private void addBot(Node node){
        botHBox.getChildren().clear();
        botHBox.getChildren().addAll(botStatic,node);
    }
    public void nameSearchBoxCase(String[] departments){
        update();
        NameSearchBox tempNameSearchBox = new NameSearchBox();
        tempNameSearchBox.addDepartments(departments);
        nameSearchBox = tempNameSearchBox;
        addBot(nameSearchBox);
    }
    public void rankSearchBoxCase(String[] ranks,String[] faculties){
        update();
        RankSearchBox tempRankSearchBox = new RankSearchBox();
        tempRankSearchBox.addRanks(ranks);
        tempRankSearchBox.addFaculties(faculties);
        rankSearchBox = tempRankSearchBox;
        addBot(rankSearchBox);
    }
    public void workExpSearchBoxCase(String[] periods){
        update();
        WorkExpSearchBox expSearchBox = new WorkExpSearchBox();
        expSearchBox.addPeriodFrom(periods);
        expSearchBox.addPeriodTo(periods);
        workExpSearchBox = expSearchBox;
        addBot(workExpSearchBox);
    }


    public <T>  void addTable(Table<T> table){
        borderPane.setCenter(table);
    }

    public void setTopLabel(String string){
        Label label = new Label(string);
        label.setPadding(new Insets(4));
        borderPane.setTop(label);
    }

    private void update(){
        borderPane.getChildren().remove(borderPane.getCenter());
        setTopLabel("Input data ...");
    }

}
