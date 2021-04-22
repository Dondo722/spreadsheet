package org.example.View.SearchBoxes;


import javafx.scene.control.*;
import javafx.scene.layout.HBox;


public class WorkExpSearchBox extends HBox {
    private final ChoiceBox<String> fromBox = new ChoiceBox<>();
    private final ChoiceBox<String> toBox = new ChoiceBox<>();

    public WorkExpSearchBox(){
        super();
        int inputElWidth = 100;
        this.setSpacing(10);
        Label rangeLabel = new Label("Work experience\n range");

        Label labelFrom = new Label("from:\n(include)");
        Label labelTo = new Label("to:\n(include)");

        fromBox.setPrefWidth(inputElWidth);
        toBox.setPrefWidth(inputElWidth);
        this.getChildren().addAll(rangeLabel,labelFrom,fromBox,labelTo,toBox);
    }

    public void addPeriodFrom(String[] items){
        fromBox.getItems().addAll(items);
    }
    public void addPeriodTo(String[] items){
        toBox.getItems().addAll(items);
    }

    public String getFromVal() {
        return fromBox.getValue();
    }
    public String getToVal() {
        return toBox.getValue();
    }
}
