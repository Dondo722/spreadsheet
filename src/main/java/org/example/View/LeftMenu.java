package org.example.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftMenu extends VBox {
    private final Button openButton = new Button("Open");
    private final Button saveButton = new Button("Save");
    private final Button addButton = new Button("Add");
    private final Button findButton = new Button("Find");
    private final Button deleteButton = new Button("Delete");
    private int width = 70;
    public LeftMenu(){
        super();
        openButton.setPrefWidth(width);
        saveButton.setPrefWidth(width);
        addButton.setPrefWidth(width);
        findButton.setPrefWidth(width);
        deleteButton.setPrefWidth(width);
        this.setAlignment(Pos.BOTTOM_CENTER);
        this.setPadding(new Insets(6));
        this.setSpacing(2);
        this.getChildren().addAll(openButton,saveButton,addButton,findButton,deleteButton);
    }
    public int getMenuWidth() {
        return width;
    }

    public Button getOpenButton() {
        return openButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getFindButton() {
        return findButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}
