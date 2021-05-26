package org.example.View;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.example.Model.Teacher;
import org.example.View.Page.Pageable;
import org.example.View.Page.Pages;
import org.example.View.SearchBoxes.NameSearchBox;
import org.example.View.SearchBoxes.RankSearchBox;
import org.example.View.SearchBoxes.WorkExpSearchBox;


public class SearchBox implements Pageable {
    private final int  sceneWidth = 650;
    private final int sceneHeight = 480;
    private final BorderPane borderPane = new BorderPane();
    private final HBox topHBox = new HBox();
    private final HBox topStatic = new HBox();
    private final Button buttonFind = new Button("Find");
    private final MenuBar menuBar = new MenuBar();
    private final Menu menu = new Menu("Find by");
    private final MenuItem itemName = new MenuItem("Name");
    private final MenuItem itemRank = new MenuItem("Rank");
    private final MenuItem itemExperience = new MenuItem("Experience");
    private  NameSearchBox nameSearchBox = new NameSearchBox();
    private  RankSearchBox rankSearchBox = new RankSearchBox();
    private  WorkExpSearchBox workExpSearchBox = new WorkExpSearchBox();
    private final Table<Teacher> table = new Table<>(sceneWidth, Teacher.getNames().length,Teacher.getNames(),Teacher.getNamesVal());
    private final Pages pages = new Pages();

    public void display(){
        Stage window = new Stage();
        Scene scene = new Scene(borderPane, sceneWidth,sceneHeight);

        menu.getItems().addAll(itemName,itemRank,itemExperience);
        menuBar.getMenus().addAll(menu);
        topHBox.setSpacing(12);
        topHBox.setPadding(new Insets(10));

        topStatic.getChildren().addAll(buttonFind,menuBar);
        topStatic.setSpacing(1);
        topHBox.getChildren().addAll(topStatic);

        borderPane.setCenter(table);
        borderPane.setTop(topHBox);
        borderPane.setBottom(pages);

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

    @Override
    public Pages getPages() {
        return pages;
    }

    @Override
    public Table<Teacher> getTable() {
        return table;
    }

    public void addTopStatic(Node node){
        topStatic.getChildren().add(node);
    }
    private void addTop(Node node){
        topHBox.getChildren().clear();
        topHBox.getChildren().addAll(topStatic,node);
    }
    public void nameSearchBoxCase(String[] departments){
        update();
        NameSearchBox tempNameSearchBox = new NameSearchBox();
        tempNameSearchBox.addDepartments(departments);
        nameSearchBox = tempNameSearchBox;
        addTop(nameSearchBox);
    }
    public void rankSearchBoxCase(String[] ranks,String[] faculties){
        update();
        RankSearchBox tempRankSearchBox = new RankSearchBox();
        tempRankSearchBox.addRanks(ranks);
        tempRankSearchBox.addFaculties(faculties);
        rankSearchBox = tempRankSearchBox;
        addTop(rankSearchBox);
    }
    public void workExpSearchBoxCase(String[] periods){
        update();
        WorkExpSearchBox expSearchBox = new WorkExpSearchBox();
        expSearchBox.addPeriodFrom(periods);
        expSearchBox.addPeriodTo(periods);
        workExpSearchBox = expSearchBox;
        addTop(workExpSearchBox);
    }

//    public void setTopLabel(String string){
//        Label label = new Label(string);
//        label.setPadding(new Insets(4));
//        borderPane.setTop(label);
//    }



    private void update(){
        table.getItems().clear();
        //setTopLabel("Input data ...");
    }

}
