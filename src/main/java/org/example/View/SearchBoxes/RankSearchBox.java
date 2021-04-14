package org.example.View.SearchBoxes;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class RankSearchBox extends HBox {

    Label rankLabel = new Label("Academic rank: ");
    ChoiceBox<String> rankBox = new ChoiceBox<>();
    Label facultyLabel = new Label("Faculty: ");
    ChoiceBox<String> facultyBox = new ChoiceBox<>();

    public RankSearchBox(){
        super();
        this.setPadding(new Insets(5));
        this.setSpacing(10);
        rankBox.setPrefWidth(50);
        facultyBox.setPrefWidth(50);

        this.getChildren().addAll(rankLabel,rankBox,facultyLabel,facultyBox);
    }
    public void addRanks(String[] items){
        rankBox.getItems().addAll(items);
    }
    public void addFaculties(String[] items){
        facultyBox.getItems().addAll(items);
    }
}
