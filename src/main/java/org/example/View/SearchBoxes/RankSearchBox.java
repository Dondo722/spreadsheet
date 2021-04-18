package org.example.View.SearchBoxes;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class RankSearchBox extends HBox {
    private final ChoiceBox<String> rankBox = new ChoiceBox<>();
    private final ChoiceBox<String> facultyBox = new ChoiceBox<>();

    public RankSearchBox(){
        super();
        int inputElWidth = 115;
        this.setSpacing(10);
        Label rankLabel = new Label("Academic rank: ");
        Label facultyLabel = new Label("Faculty: ");

        rankBox.setPrefWidth(inputElWidth);
        facultyBox.setPrefWidth(inputElWidth);

        this.getChildren().addAll(rankLabel,rankBox,facultyLabel,facultyBox);
    }
    public void addRanks(String[] items){
        rankBox.getItems().addAll(items);
    }
    public void addFaculties(String[] items){
        facultyBox.getItems().addAll(items);
    }

    public String getRankBoxVal() {
        return rankBox.getValue();
    }

    public String getFacultyBoxVal() {
        return facultyBox.getValue();
    }
}
