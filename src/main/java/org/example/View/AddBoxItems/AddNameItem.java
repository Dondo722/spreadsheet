package org.example.View.AddBoxItems;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class AddNameItem extends HBox{

    private final TextField nameField = new TextField();
    private final TextField surnameField = new TextField();
    private final TextField patronymicField = new TextField();

    public AddNameItem(int spacing, int labelWidth, String labelText,int fieldWidth){
        super();
        int width = fieldWidth/3;
        super.setSpacing(spacing);
        Label label = new Label(labelText);
        label.setPrefWidth(labelWidth);
        nameField.setPrefWidth(width);
        surnameField.setPrefWidth(width);
        patronymicField.setPrefWidth(width);


        nameField.promptTextProperty().set("name");
        surnameField.promptTextProperty().set("surname");
        patronymicField.promptTextProperty().set("patronymic");
        this.getChildren().addAll(label,nameField,surnameField,patronymicField);
    }
    public String getText(){
        return nameField.getText() +" " + surnameField.getText() + " " + patronymicField.getText();
    }
}
