package org.example.View.Page;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Pages extends HBox {
    private final Label labelRaws = new Label("Raws:");
    private final TextField rawsField = new TextField();
    private final Button buttonFirst = new Button("First");
    private final Button buttonPrevious = new Button("<");
    private final Label labelCurrentPage = new Label();
    private final Button buttonNext = new Button(">");
    private final Button buttonLast = new Button("Last");
    private final Label labelCount = new Label("");



    public Pages(){
        super();
        this.setPrefHeight(50);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(5);


        this.getChildren().addAll(labelRaws,rawsField,buttonFirst,buttonPrevious,labelCurrentPage,buttonNext,buttonLast,labelCount);
    }

    public Label getLabelRaws() {
        return labelRaws;
    }

    public TextField getRawsField() {
        return rawsField;
    }

    public Button getButtonFirst() {
        return buttonFirst;
    }

    public Button getButtonPrevious() {
        return buttonPrevious;
    }

    public Label getLabelCurrentPage() {
        return labelCurrentPage;
    }

    public Button getButtonNext() {
        return buttonNext;
    }

    public Button getButtonLast() {
        return buttonLast;
    }

    public Label getLabelCount() {
        return labelCount;
    }

}
