package org.example.View.AddBoxItems;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class AddItem extends HBox{
    private final TextField textField = new TextField();

    public AddItem(int spacing, int labelWidth, String labelText,int fieldWidth, String promptText){
        super();
        super.setSpacing(spacing);
        Label label = new Label(labelText);
        label.setPrefWidth(labelWidth);
        textField.promptTextProperty().set(promptText);
        textField.setPrefWidth(fieldWidth);
        this.getChildren().addAll(label,textField);
    }
    public String getText(){
        return textField.getText();
    }
}
